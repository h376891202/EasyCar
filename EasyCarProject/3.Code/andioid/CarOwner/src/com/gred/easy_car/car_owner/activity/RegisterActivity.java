package com.gred.easy_car.car_owner.activity;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gred.easy_car.car_owner.AppAplication;
import com.gred.easy_car.car_owner.R;
import com.gred.easy_car.car_owner.internet.JsonRequestWithKeyValueParam;
import com.gred.easy_car.car_owner.internet.URLRequest;
import com.gred.easy_car.car_owner.tools.MyLog;

public class RegisterActivity extends Activity {
	private static final String TAG = RegisterActivity.class.getSimpleName();
	private static final int MSG_SHOW_TOSAT = 1;
	private EditText mPhoneNumberEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);
		findViewById(R.id.btn_getAuthCode).setOnClickListener(
				new ButtonAuthCodeClickListener());
		mPhoneNumberEditText = (EditText) findViewById(R.id.phoneNumber);
		findViewById(R.id.btn_submit).setOnClickListener(
				new ButtonSubmitClickListener());
		configActionBar();
	}

	private void configActionBar() {
		final ActionBar abar = getActionBar();
		ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
		        ActionBar.LayoutParams.WRAP_CONTENT, 
		        ActionBar.LayoutParams.MATCH_PARENT, 
		        Gravity.CENTER);
		View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar_without_icon_center_text, null);
		TextView textviewTitle = (TextView) viewActionBar.findViewById(R.id.actionbar_textview);
		textviewTitle.setText("Test");
		abar.setCustomView(viewActionBar, params);
		abar.setDisplayShowCustomEnabled(true);
		abar.setDisplayShowTitleEnabled(false);
		abar.setDisplayHomeAsUpEnabled(true);
		abar.setIcon(android.R.color.transparent);
		abar.setHomeButtonEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
            this.finish();
        default:
            return super.onOptionsItemSelected(item);
		}
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			int what = msg.what;
			switch (what) {
			case MSG_SHOW_TOSAT:
				String message = (String) msg.obj;
				Toast.makeText(RegisterActivity.this, message,
						Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		};
	};
	
	private class ButtonSubmitClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			String authCode = ((EditText) findViewById(R.id.authCode))
					.getText().toString();
			String phoneNumber = mPhoneNumberEditText.getText().toString();
			String password = ((EditText) findViewById(R.id.password))
					.getText().toString();
			String rePassowrd = ((EditText) findViewById(R.id.verifyPassword))
					.getText().toString();
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("userMobile", phoneNumber);
				jsonObject.put("userPwd", password);
				jsonObject.put("repeatedPwd", rePassowrd);
				jsonObject.put("identifyingCode", authCode);
			} catch (JSONException e) {
				e.printStackTrace();
			}

			JsonRequestWithKeyValueParam jsonRequest = new JsonRequestWithKeyValueParam(Method.POST,
					URLRequest.REGISTER_URL, jsonObject, new Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							MyLog.logd(TAG, "onResponse :" + response);
						}
					}, new ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError error) {
							MyLog.logd(
									TAG,
									"onErrorResponse :"
											+ error.getLocalizedMessage());
						}
					});
			AppAplication.sRequestQueue.add(jsonRequest);
		}

	}

	private class ButtonAuthCodeClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			String phoneNumber = mPhoneNumberEditText.getText().toString();
			if (TextUtils.isEmpty(phoneNumber)) {
				return;
			}

			JsonObjectRequest jsonRequest = new JsonObjectRequest(Method.GET,
					URLRequest.createGetIdentifyAuthUrl(phoneNumber), null,
					new Listener<JSONObject>() {
						@Override
						public void onResponse(JSONObject response) {
							MyLog.logd(TAG, "onResponse :" + response);
							try {
								Message message = mHandler
										.obtainMessage(MSG_SHOW_TOSAT);
								message.obj = response
										.getString("statusMessage");
								message.sendToTarget();
							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
					}, new ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError error) {
							MyLog.logd(
									TAG,
									"onErrorResponse :"
											+ error.getLocalizedMessage());
						}
					});
			AppAplication.sRequestQueue.add(jsonRequest);
		}
	}
}
