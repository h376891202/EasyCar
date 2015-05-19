package com.gred.easy_car.car_owner.activity;

import com.gred.easy_car.car_owner.R;
import com.gred.easy_car.car_owner.view.AmazingListView;
import com.gred.easy_car.car_owner.view.AzView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ChooseCarBrandActivity extends Activity {
	private AmazingListView mCarBrandListView;
	private AzView mAzView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_car_brand_activity);
		mCarBrandListView = (AmazingListView) findViewById(R.id.choose_car_brand_list);
		mAzView = (AzView) findViewById(R.id.choose_car_az_view);
		mCarBrandListView.setVisibility(View.VISIBLE);
		mCarBrandListView.setVisibility(View.GONE);
	}

}
