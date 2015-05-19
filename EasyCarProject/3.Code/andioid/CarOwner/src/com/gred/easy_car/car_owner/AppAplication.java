package com.gred.easy_car.car_owner;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.SDKInitializer;

import android.app.Application;

public class AppAplication extends Application {
	public volatile BDLocation lastBDLocation = null;
	public static RequestQueue sRequestQueue;

	@Override
	public void onCreate() {
		super.onCreate();
		// initialize baidu map API.
		SDKInitializer.initialize(getApplicationContext());
		// create volley request queue.
		sRequestQueue = Volley.newRequestQueue(this);
	}

	public static RequestQueue getRequestQueue() {
		return sRequestQueue;
	}

	public void setLastBDLocation(BDLocation bdLocation) {
		this.lastBDLocation = bdLocation;
	}

	public BDLocation getLastBDLocation() {
		return lastBDLocation;
	}
}
