package com.gred.easy_car.car_owner.tools;

import android.util.Log;

public class MyLog {
	private static final String TAG = "EsayCar-EndUser";
	public static void logd(String tag, String message) {
		Log.d(TAG, tag + ": " + message);
	}
}
