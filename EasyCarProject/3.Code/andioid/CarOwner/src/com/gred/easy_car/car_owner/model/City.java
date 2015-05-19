package com.gred.easy_car.car_owner.model;

import java.util.ArrayList;
import java.util.List;

import android.util.Pair;

public class City {
	private String name;
	private float longitude;
	private float latitude;
	private String startChar;

	public City(String name, float longitude, float latitude, String startChar) {
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.startChar = startChar;
	}

	private City() {
	}

	public String getName() {
		return name;
	}

	public float getLongitude() {
		return longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public String getStartChar() {
		return startChar;
	}

	// TODO test code here
	public static City[] getCommonCity() {
		String commonTityName[] = new String[] { "北京", "上海", "广州", "深圳", "成都",
				"杭州", "南京", "武汉", "重庆", "天津", "上海", "广州" };
		City[] citys = new City[12];
		for (int i = 0; i < citys.length; i++) {
			City city = new City();
			city.name = commonTityName[i];
			citys[i] = city;
		}
		return citys;
	}

	public static List<Pair<String, List<City>>> createData() {
		List<Pair<String, List<City>>> out = new ArrayList<Pair<String, List<City>>>();
		List<City> cities = new ArrayList<City>();
		cities.add(new City("重庆", 0, 0, "C"));
		cities.add(new City("成都", 0, 0, "C"));
		out.add(new Pair<String, List<City>>("C", cities));
		List<City> cities1 = new ArrayList<City>();
		cities1.add(new City("广州", 0, 0, "G"));
		cities1.add(new City("广西", 0, 0, "G"));
		out.add(new Pair<String, List<City>>("G", cities1));
		List<City> cities2 = new ArrayList<City>();
		cities2.add(new City("上海", 0, 0, "S"));
		cities2.add(new City("深圳", 0, 0, "S"));
		out.add(new Pair<String, List<City>>("S", cities2));
		List<City> cities3 = new ArrayList<City>();
		cities3.add(new City("上海1", 0, 0, "D"));
		cities3.add(new City("深圳1", 0, 0, "D"));
		out.add(new Pair<String, List<City>>("D", cities3));
		List<City> cities4 = new ArrayList<City>();
		cities4.add(new City("上海2", 0, 0, "F"));
		cities4.add(new City("深圳2", 0, 0, "F"));
		out.add(new Pair<String, List<City>>("F", cities4));
		return out;
	}

}
