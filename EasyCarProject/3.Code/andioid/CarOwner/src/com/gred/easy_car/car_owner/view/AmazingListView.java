package com.gred.easy_car.car_owner.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.gred.easy_car.car_owner.view.AmazingAdapter.HasMorePagesListener;

/**
 * A ListView that maintains a header pinned at the top of the list. The
 * pinned header can be pushed up and dissolved as needed.
 * 
 * It also supports pagination by setting a custom view as the loading
 * indicator.
 */
public class AmazingListView extends ListView implements HasMorePagesListener {
    public static final String TAG = AmazingListView.class.getSimpleName();

    View listFooter;
    boolean footerViewAttached = false;

    private View mHeaderView;
    private boolean mHeaderViewVisible;

    private int mHeaderViewWidth;
    private int mHeaderViewHeight;

    private AmazingAdapter adapter;

    public AmazingListView(Context context) {
        super(context);
    }

    public AmazingListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AmazingListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    /**
     * 用于设置HeadView的方法.
     * @param view
     */
    public void setPinnedHeaderView(View view) {
        mHeaderView = view;

        // Disable vertical fading when the pinned header is present
        // TODO change ListView to allow separate measures for top and bottom fading edge;
        // in this particular case we would like to disable the top, but not the bottom edge.
        if (mHeaderView != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    /**
     * 重写 onMeasure方法, 主要是用于获取除 heasd view的高和宽
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mHeaderView != null) {
            measureChild(mHeaderView, widthMeasureSpec, heightMeasureSpec);
            mHeaderViewWidth = mHeaderView.getMeasuredWidth();
            mHeaderViewHeight = mHeaderView.getMeasuredHeight();
        }
    }

    /**
     * 重写onLayout方法, 在layout的时候将headerview显示在最上方.
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (mHeaderView != null) {
            mHeaderView.layout(0, 0, mHeaderViewWidth, mHeaderViewHeight);
            configureHeaderView(getFirstVisiblePosition());
        }
    }

    public void configureHeaderView(int position) {
        if (mHeaderView == null) {
            return;
        }

        int state = adapter.getPinnedHeaderState(position);
        switch (state) {
            case AmazingAdapter.PINNED_HEADER_GONE: {
                mHeaderViewVisible = false;
                break;
            }

            case AmazingAdapter.PINNED_HEADER_VISIBLE: {
                adapter.configurePinnedHeader(mHeaderView, position, 255);
                if (mHeaderView.getTop() != 0) {
                    mHeaderView.layout(0, 0, mHeaderViewWidth, mHeaderViewHeight);
                }
                mHeaderViewVisible = true;
                break;
            }

            case AmazingAdapter.PINNED_HEADER_PUSHED_UP: {
                View firstView = getChildAt(0);
                if (firstView != null) {
                    int bottom = firstView.getBottom();
                    int headerHeight = mHeaderView.getHeight();
                    int y;
                    int alpha;
                    if (bottom < headerHeight) {
                        y = (bottom - headerHeight);
                        alpha = 255 * (headerHeight + y) / headerHeight;
                    } else {
                        y = 0;
                        alpha = 255;
                    }
                    adapter.configurePinnedHeader(mHeaderView, position, alpha);
                    if (mHeaderView.getTop() != y) {
                        mHeaderView.layout(0, y, mHeaderViewWidth, mHeaderViewHeight + y);
                    }
                    mHeaderViewVisible = true;
                }
                break;
            }
        }
    }

    /**
     * 这个方法在 调用子类draw方法前面调用. 如果headerview需要显示着把它画出来.
     */
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (mHeaderViewVisible) {
            drawChild(canvas, mHeaderView, getDrawingTime());
        }
    }

    public void setLoadingView(View listFooter) {
        this.listFooter = listFooter;
    }

    public View getLoadingView() {
        return listFooter;
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        if (!(adapter instanceof AmazingAdapter)) {
            throw new IllegalArgumentException(AmazingListView.class.getSimpleName() 
                    + " must use adapter of type " + AmazingAdapter.class.getSimpleName());
        }

        // previous adapter
        if (this.adapter != null) {
            this.adapter.setHasMorePagesListener(null);
            this.setOnScrollListener(null);
        }

        this.adapter = (AmazingAdapter) adapter;
        ((AmazingAdapter)adapter).setHasMorePagesListener(this);
        //设置adpter为 该listview的 scroller监听.
        this.setOnScrollListener((AmazingAdapter) adapter);

        View dummy = new View(getContext());
        //TODO, I don't know why here need to set a dummy view.
        super.addFooterView(dummy);
        super.setAdapter(adapter);
        super.removeFooterView(dummy);
    }

    @Override
    public AmazingAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void noMorePages() {
        if (listFooter != null) {
            this.removeFooterView(listFooter);
        }
        footerViewAttached = false;
    }

    @Override
    public void mayHaveMorePages() {
        if (! footerViewAttached && listFooter != null) {
            this.addFooterView(listFooter);
            footerViewAttached = true;
        }
    }
    
    public boolean isLoadingViewVisible() {
        return footerViewAttached;
    }
}
