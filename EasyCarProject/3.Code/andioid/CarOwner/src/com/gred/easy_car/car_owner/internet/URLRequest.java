package com.gred.easy_car.car_owner.internet;

import android.net.Uri;

public class URLRequest {
	private static final String BASE_URL = "http://121.40.90.244:8080";

	private static final String GET_PHONE_IDENTIFY_AUTH_URL = BASE_URL
			+ "/easy_car/login/IdentifyingCode.do";
	public static final String REGISTER_URL = BASE_URL
			+ "/easy_car/login/register.do";
	public static final String LOGIN_URL = BASE_URL + "/easy_car/login.do";
	public static final String QUERY_CAR_URL = BASE_URL
			+ "/easy_car/carBrand/ carBrandInfo.do";

	public static String createGetIdentifyAuthUrl(String phoneNumber) {
		Uri uri = Uri.parse(GET_PHONE_IDENTIFY_AUTH_URL);
		uri = uri.buildUpon().appendQueryParameter("mobileNumber", phoneNumber).build();
		return uri.toString();
	}

}
