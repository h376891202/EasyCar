package com.gred.easy_car.car_owner.activity;

import java.util.List;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.gred.easy_car.car_owner.R;
import com.gred.easy_car.car_owner.model.City;
import com.gred.easy_car.car_owner.view.AmazingListView;
import com.gred.easy_car.car_owner.view.SimpleAmazingAdapter;

public class ChooseCityActivity extends ActivityWithBackActionBar {
	private MySimpleAmazingAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_city_activity);
		setupCommonCity();
		AmazingListView amazingListView = (AmazingListView) findViewById(R.id.choose_city_listview);
		amazingListView.setPinnedHeaderView(getLayoutInflater().inflate(
				R.layout.list_item_city_head, amazingListView, false));
		mAdapter = new MySimpleAmazingAdapter(City.createData());
		amazingListView.setAdapter(mAdapter);
	}

	private void setupCommonCity() {
		City[] commonCitys = City.getCommonCity();
		int resName[] = new int[] { R.id.common_city_1, R.id.common_city_2,
				R.id.common_city_3, R.id.common_city_4, R.id.common_city_5,
				R.id.common_city_6, R.id.common_city_7, R.id.common_city_8,
				R.id.common_city_9, R.id.common_city_10, R.id.common_city_11,
				R.id.common_city_12, };
		for (int index = 0; index < commonCitys.length; index++) {
			TextView textView = (TextView) findViewById(resName[index]);
			textView.setTag(commonCitys[index]);
			textView.setText(commonCitys[index].getName());
		}
	}

	@Override
	protected String getActionBarTitle() {
		return getResources().getString(R.string.choose_city_title);
	}

	private class MySimpleAmazingAdapter extends SimpleAmazingAdapter<City> {

		public MySimpleAmazingAdapter(List<Pair<String, List<City>>> t) {
			super(t);
		}

		@Override
		protected View createAmaziongView() {
			View item = getLayoutInflater().inflate(R.layout.list_item_county,
					null);
			return item;
		}

		@Override
		protected void bindView(View convertView, City data) {
			((TextView) convertView.findViewById(R.id.list_item_city))
					.setText(data.getName());
			convertView.setTag(data);
		}

		@Override
		protected View getHeadView(View parent) {
			if (parent == null) {
				return null;
			}
			return parent.findViewById(R.id.list_item_city_header);
		}
	};
}
