package com.gred.easy_car.car_owner.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AzView extends View {
	private final String AZ_TEXT[] = new String[] { "A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
			"S", "T", "U", "V", "W", "X", "Y", "Z" };
	private Paint mPaint = new Paint();
	private int mCurrentTouched = -1;
	private onTouchedLetterChangeListener mLetterChangeListener;

	public AzView(Context context) {
		super(context);
	}
	public AzView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public AzView(Context context, AttributeSet attrs, int defaultStyle) {
		super(context, attrs, defaultStyle);
	}

	public void setOnTouchedLetterChangedListener(onTouchedLetterChangeListener listener) {
		this.mLetterChangeListener = listener;
	}

	public void setCurrentTouchedLetter(String letter) {
		if (TextUtils.isEmpty(letter) || letter.length() < 1) {
			return;
		}
		if (letter.charAt(0) < 'A' || letter.charAt(0) > 'Z') {
			return;
		}
		int touched = letter.charAt(0) - 'A';
		this.mCurrentTouched = touched;
		invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		int hight = getHeight();
		int width = getWidth();
		int itemHight = hight / AZ_TEXT.length;
		for (int index = 0; index < AZ_TEXT.length; index++) {
			String letter = AZ_TEXT[index];
			//反锯齿效果s
			mPaint.setAntiAlias(true);
			//TODO 需要通过计算得出正常的字号
			mPaint.setTextSize(30);
			if (mCurrentTouched == index) {
				mPaint.setColor(Color.RED);
			}
			float xPos = width/2 - (mPaint.measureText(letter) / 2);
			float yPos = itemHight * index + itemHight;
			canvas.drawText(letter, xPos, yPos, mPaint);
			mPaint.reset();
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		float y = event.getY();
		int touchedIndex = (int)(y / getHeight() * AZ_TEXT.length);
		if (event.getAction() != MotionEvent.ACTION_UP) {
			mCurrentTouched = touchedIndex;
			if (mLetterChangeListener != null) {
				mLetterChangeListener.onTouchedLetterChange(AZ_TEXT[mCurrentTouched]);
			}
		}
		invalidate();
		return true;
	}

	public interface onTouchedLetterChangeListener {
		public void onTouchedLetterChange(String letter);
	}

}
