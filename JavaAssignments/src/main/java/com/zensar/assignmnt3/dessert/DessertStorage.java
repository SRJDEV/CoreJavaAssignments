package com.zensar.assignmnt3.dessert;

public class DessertStorage {

	public static long CANDIES_AVAILABLE = 20;
	public static long COOKIES_AVAILABLE =20;
	public static long ICECREAMS_AVAILABLE = 20;

	static void addCookies(long cookies) {

		COOKIES_AVAILABLE = COOKIES_AVAILABLE + cookies;
	}

	static void addCandies(long candies) {

		CANDIES_AVAILABLE = CANDIES_AVAILABLE + candies;
	}

	static void addIceCreams(long iceCreams) {

		ICECREAMS_AVAILABLE = ICECREAMS_AVAILABLE + iceCreams;
	}

	static long getAvailableCandies() {

		return CANDIES_AVAILABLE;
	}

	static long getAvailableCookies() {

		return COOKIES_AVAILABLE;
	}

	static long getAvailableIceCreams() {

		return ICECREAMS_AVAILABLE;
	}
}
