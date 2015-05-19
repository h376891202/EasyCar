package com.gred.easy_car.car_owner.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.gred.easy_car.car_owner.AppAplication;
import com.gred.easy_car.car_owner.R;

public class MainActivity extends Activity {
	private MapView mMapView;
	private BaiduMap mBaiduMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		mBaiduMap.setMyLocationEnabled(true);
		mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(
				LocationMode.NORMAL, true, null));
		//TODO test code here
		findViewById(R.id.headImage).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});
		//click to choose city
		findViewById(R.id.country_text).setOnClickListener(new OnChooseCityClickListener());
		findViewById(R.id.switch_brand).setOnClickListener(new OnChooseBrandClickListener());
		hideZoomView(mMapView);
		setupZoomInOutButton();
	}
	private class OnChooseBrandClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, ChooseCarBrandActivity.class);
			startActivity(intent);
		}
		
	}

	private class OnChooseCityClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, ChooseCityActivity.class);
			startActivity(intent);
		}
		
	}

	private void setupZoomInOutButton() {
		final Button zoomInBtn = (Button) findViewById(R.id.zoomin);
		final Button zoomOutBtn = (Button) findViewById(R.id.zoomout);
		zoomOutBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float zoomLevel = mBaiduMap.getMapStatus().zoom;
				if(zoomLevel<=18){
					setLocaltion((int)zoomLevel + 1);
					zoomOutBtn.setEnabled(true);
				}else{
					Toast.makeText(MainActivity.this, "已经放至最大！", Toast.LENGTH_SHORT).show();
					zoomInBtn.setEnabled(false);
				}
			}
		});
		zoomInBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float zoomLevel = mBaiduMap.getMapStatus().zoom;
				if(zoomLevel>4){
					setLocaltion((int)zoomLevel - 1);
					zoomInBtn.setEnabled(true);
				}else{
					zoomOutBtn.setEnabled(false);
					Toast.makeText(MainActivity.this, "已经缩至最小！", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void hideZoomView(MapView mapView) {
		int childCount = mapView.getChildCount();
		View zoom = null;
		for (int i = 0; i < childCount; i++) {
			View child = mapView.getChildAt(i);
			if (child instanceof ZoomControls) {
				zoom = child;
				break;
			}
		}
		zoom.setVisibility(View.GONE);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mMapView.onDestroy();
	}

	private void setLocaltion(int newZoom) {
		BDLocation location = ((AppAplication) getApplication())
				.getLastBDLocation();
		if (location == null) {
			return;
		}
		MyLocationData locData = new MyLocationData.Builder()
				.accuracy(location.getRadius())
				.direction(100).latitude(location.getLatitude())
				.longitude(location.getLongitude()).build();
		mBaiduMap.setMyLocationData(locData);
		LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());
		MapStatusUpdate u = null;
		if (newZoom == -1) {
			u = MapStatusUpdateFactory.newLatLng(ll);
		} else {
			u = MapStatusUpdateFactory.newLatLngZoom(ll, newZoom);
		}
		mBaiduMap.animateMapStatus(u);
	}

	@Override
	protected void onResume() {
		super.onResume();
		mMapView.onResume();
		setLocaltion(-1);
	}

	@Override
	protected void onPause() {
		super.onPause();
		mMapView.onPause();
	}
}
