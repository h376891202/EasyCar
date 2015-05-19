package com.gred.easy_car.car_owner.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.gred.easy_car.car_owner.R;

public abstract class ActivityWithBackActionBar extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onStart() {
		super.onStart();
		setupActionBar();
	}

	private void setupActionBar() {
		findViewById(R.id.btn_action_back).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityWithBackActionBar.this.finish();
			}
		});
		((TextView)findViewById(R.id.actionbar_textview)).setText(getActionBarTitle());
	}

	protected abstract String getActionBarTitle(); 

}
