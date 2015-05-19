package com.gred.easy_car.car_owner.activity;

import java.lang.ref.WeakReference;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.gred.easy_car.car_owner.AppAplication;
import com.gred.easy_car.car_owner.R;

/**
 * 首页面, 用于展示, 定位成功后跳转主页面
 * 
 * @author Administrator
 * 
 */
public class WelcomActivity extends Activity {
	private final int TIME_OUT_TO_LAUNCH = 5 * 1000;
	private final static int MSG_LAUNCH_TIME_OUT = 1;
	private LocationClient mLocationClient;
	private BDLocationListener mBDLocationListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLocationClient = new LocationClient(this);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);
		option.setCoorType("bd09ll");
		option.setScanSpan(1000);
		mLocationClient.setLocOption(option);
		mLocationClient.start();
		mBDLocationListener = new MyBDLocationListener();
		mLocationClient.registerLocationListener(mBDLocationListener);
		mHandler.sendEmptyMessageDelayed(MSG_LAUNCH_TIME_OUT,
				TIME_OUT_TO_LAUNCH);
	}

	@Override
	protected void onStop() {
		mLocationClient.stop();
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mLocationClient.unRegisterLocationListener(mBDLocationListener);
	}
	private Handler mHandler = new MyHandler(this);

	private static class MyHandler extends Handler {
		private WeakReference<Activity> mActivity;

		public MyHandler(Activity activity) {
			mActivity = new WeakReference<Activity>(activity);
		}

		public void handleMessage(android.os.Message msg) {
			if (msg.what == MSG_LAUNCH_TIME_OUT) {
				mActivity.get().startActivity(
						new Intent(mActivity.get(), MainActivity.class));
				mActivity.get().finish();
			}
		};
	};

	private class MyBDLocationListener implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			mHandler.removeMessages(MSG_LAUNCH_TIME_OUT);
			((AppAplication) getApplication()).setLastBDLocation(location);
			startMainActivity();
		}
	}

	private void startMainActivity() {
		Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
		startActivity(intent);
		this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
