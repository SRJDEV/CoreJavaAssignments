package com.zensar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App implements Runnable {

	Thread buyPriceThread, sellPriceThread, matcherThread;

	LinkedHashMap<String, Integer> buyPricesMap = new LinkedHashMap<String, Integer>(5);

	LinkedHashMap<String, Integer> sellPricesMap = new LinkedHashMap<String, Integer>(5);

	LinkedHashMap<String, Integer> orderPriceMap = new LinkedHashMap<String, Integer>(5);

	boolean isTableInitialized = false;

	ArrayList<Integer> lastFiveBuyPriceList = new ArrayList<Integer>(5);

	ArrayList<Integer> lastFiveSellPriceList = new ArrayList<Integer>(5);

	ArrayList<String> companyNames = new ArrayList<String>(5);

	HashMap<String, ArrayList<Integer>> lastFiveBuyPriceMap = new HashMap<String, ArrayList<Integer>>();
	HashMap<String, ArrayList<Integer>> lastFiveSellPriceMap = new HashMap<String, ArrayList<Integer>>();

	LinkedHashMap<String, Integer> orderMatchCount = new LinkedHashMap<String, Integer>(5);

	public String[][] stockData = { { "IBM", "12", "11" }, { "Reliance", "55", "53" }, { "TCS", "23", "23" },
			{ "Wipro", "17", "15" }, { "Zensar", "74", "70" } };

	public String[][] orderMatchData = { { "IBM", "12", "520" }, { "Reliance", "55", "1250" }, { "TCS", "23", "487" },
			{ "Wipro", "17", "110" }, { "Zensar", "74", "2350" } };

	public App() {

		buyPriceThread = new Thread(this, "BuyPriceThead");
		sellPriceThread = new Thread(this, "SellPriceThead");
		matcherThread = new Thread(this, "MatcherThread");

		buyPriceThread.start();
		sellPriceThread.start();
		matcherThread.start();

		// updaterThread.start();

		companyNames.add("IBM");
		companyNames.add("Reliance");
		companyNames.add("TCS");
		companyNames.add("Wipro");
		companyNames.add("Zensar");

		for (int i = 0; i < companyNames.size(); i++) {

			orderMatchCount.put(companyNames.get(i), 0);
			lastFiveBuyPriceMap.put(companyNames.get(i), new ArrayList<Integer>(12));
			lastFiveSellPriceMap.put(companyNames.get(i), new ArrayList<Integer>(12));

		}

	}

	public void run() {

		while (true) {

			if (Thread.currentThread().getName().equals("BuyPriceThead")) {
				for (int i = 0; i < 5; i++) {

					System.out.println("Inside Buy Thread");
					switch (i) {
					case 0:
						generateBuyPrice(i, 12);

						break;
					case 1:
						generateBuyPrice(i, 30);

						break;
					case 2:
						generateBuyPrice(i, 90);
						break;
					case 3:
						generateBuyPrice(i, 45);
						break;
					case 4:
						generateBuyPrice(i, 200);
						break;

					default:
						break;
					}

				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			if (Thread.currentThread().getName().equals("SellPriceThead")) {
				for (int i = 0; i < 5; i++) {

					switch (i) {
					case 0:
						generateSellPrice(i, 15);
						break;
					case 1:
						generateSellPrice(i, 35);
						break;
					case 2:
						generateSellPrice(i, 95);
						break;
					case 3:
						generateSellPrice(i, 40);
						break;
					case 4:
						generateSellPrice(i, 200);
						break;

					default:
						break;
					}

				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (Thread.currentThread().getName().equals("MatcherThread")) {

				if (lastFiveBuyPriceMap.size() > 4 && lastFiveSellPriceMap.size() > 4) {

					for (int i = 0; i < companyNames.size(); i++) {

						if (lastFiveBuyPriceMap.get(companyNames.get(i)).size() > 4
								&& lastFiveSellPriceMap.get(companyNames.get(i)).size() > 4) {

							int averageBuyPrice = calculateAveragePrice(lastFiveBuyPriceMap.get(companyNames.get(i)));
							int averageSellPrice = calculateAveragePrice(lastFiveSellPriceMap.get(companyNames.get(i)));

							if (averageBuyPrice >= averageSellPrice) {

								orderPriceMap.put(companyNames.get(i), averageBuyPrice);

							} else {
								orderPriceMap.put(companyNames.get(i), averageSellPrice);

							}
						}

					}
					calculateMatchCount();
					updateMatcherTable();

				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			updateBuySellTable();

		}

	}

	public void generateBuyPrice(int stockId, int range) {

		Random random = new Random();
		int price = random.nextInt(range) + 1;

		switch (stockId) {
		case 0: {
			buyPricesMap.put("IBM", price);

			ArrayList<Integer> list = lastFiveBuyPriceMap.get("IBM");

			if (list.size() >= 10) {
				list.clear();
			}
			list.add(price);
			lastFiveBuyPriceMap.put("IBM", list);
		}
			break;
		case 1: {
			buyPricesMap.put("Reliance", price);

			ArrayList<Integer> list = lastFiveBuyPriceMap.get("Reliance");
			if (list.size() >= 5) {
				list.clear();
			}
			list.add(price);
			lastFiveBuyPriceMap.put("Reliance", list);
			break;
		}

		case 2: {
			buyPricesMap.put("TCS", price);

			ArrayList<Integer> list = lastFiveBuyPriceMap.get("TCS");
			if (list.size() >= 10) {
				list.clear();
			}
			list.add(price);
			lastFiveBuyPriceMap.put("TCS", list);
			break;
		}

		case 3: {
			buyPricesMap.put("Wipro", price);

			lastFiveBuyPriceMap.put("Wipro", lastFiveBuyPriceList);
			ArrayList<Integer> list = lastFiveBuyPriceMap.get("Wipro");
			if (list.size() >= 10) {
				list.clear();
			}
			list.add(price);
			lastFiveBuyPriceMap.put("Wipro", list);

			break;
		}
		case 4: {
			buyPricesMap.put("Zensar", price);

			lastFiveBuyPriceMap.put("Zensar", lastFiveBuyPriceList);
			ArrayList<Integer> list = lastFiveBuyPriceMap.get("Zensar");
			if (list.size() >= 10) {
				list.clear();
			}
			list.add(price);
			lastFiveBuyPriceMap.put("Zensar", list);

			break;
		}

		default:
			break;
		}

	}

	public void generateSellPrice(int stockId, int range) {

		Random random = new Random();
		int price = random.nextInt(range) + 1;

		switch (stockId) {
		case 0: {
			sellPricesMap.put("IBM", price);

			ArrayList<Integer> list = lastFiveSellPriceMap.get("IBM");

			if (list.size() >= 10) {
				list.clear();
			}
			list.add(price);
			lastFiveSellPriceMap.put("IBM", list);

			break;
		}
		case 1: {
			sellPricesMap.put("Reliance", price);

			ArrayList<Integer> list = lastFiveSellPriceMap.get("Reliance");

			if (list.size() >= 10) {
				list.clear();
			}
			list.add(price);
			lastFiveSellPriceMap.put("Reliance", list);

			break;
		}
		case 2: {
			sellPricesMap.put("TCS", price);
			ArrayList<Integer> list = lastFiveSellPriceMap.get("TCS");

			if (list.size() >= 10) {
				list.clear();
			}
			list.add(price);
			lastFiveSellPriceMap.put("TCS", list);

			break;
		}
		case 3: {
			sellPricesMap.put("Wipro", price);

			ArrayList<Integer> list = lastFiveSellPriceMap.get("Wipro");

			if (list.size() >= 10) {
				list.clear();
			}
			list.add(price);
			lastFiveSellPriceMap.put("Wipro", list);

			break;

		}
		case 4: {
			sellPricesMap.put("Zensar", price);

			ArrayList<Integer> list = lastFiveSellPriceMap.get("Zensar");

			if (list.size() >= 10) {
				list.clear();
			}
			list.add(price);
			lastFiveSellPriceMap.put("Zensar", list);
			break;
		}

		default:
			break;
		}

	}

	public void updateBuySellTable() {

		String[][] stockDataUpdated = {
				{ "IBM", String.valueOf(buyPricesMap.get("IBM")), String.valueOf(sellPricesMap.get("IBM")) },
				{ "Reliance", String.valueOf(buyPricesMap.get("Reliance")),
						String.valueOf(sellPricesMap.get("Reliance")) },
				{ "TCS", String.valueOf(buyPricesMap.get("TCS")), String.valueOf(sellPricesMap.get("TCS")) },
				{ "Wipro", String.valueOf(buyPricesMap.get("Wipro")), String.valueOf(sellPricesMap.get("Wipro")) },
				{ "Zensar", String.valueOf(buyPricesMap.get("Zensar")),
						String.valueOf(sellPricesMap.get("Zensar")) }, };

		StockMatcherApp.updateBuySellTable(stockDataUpdated);
	}

	public void updateMatcherTable() {

		String[][] matcherDataUpdated = {
				{ "IBM", String.valueOf(orderPriceMap.get("IBM")), String.valueOf(orderMatchCount.get("IBM")) },
				{ "Reliance", String.valueOf(orderPriceMap.get("Reliance")),
						String.valueOf(orderMatchCount.get("Reliance")) },
				{ "TCS", String.valueOf(orderPriceMap.get("TCS")), String.valueOf(orderMatchCount.get("TCS")) },
				{ "Wipro", String.valueOf(orderPriceMap.get("Wipro")), String.valueOf(orderMatchCount.get("Wipro")) },
				{ "Zensar", String.valueOf(orderPriceMap.get("Zensar")),
						String.valueOf(orderMatchCount.get("Zensar")) }, };

		StockMatcherApp.updateMatcherTable(matcherDataUpdated);

	}

	public void calculateMatchCount() {

		// store match count
		for (int i = 0; i < companyNames.size(); i++) {

			if (buyPricesMap.size() > 4 && sellPricesMap.size() > 4) {

				if (buyPricesMap.get(companyNames.get(i)) >= sellPricesMap.get(companyNames.get(i))) {

					orderMatchCount.put(companyNames.get(i), orderMatchCount.get(companyNames.get(i)) + 1);

				}
			}

		}
	}

	public int calculateAveragePrice(ArrayList<Integer> list) {

		int average = 0;
		if (list.size() > 4) {

			for (int i = 0; i < 5; i++) {

				average += list.get(i);
			}

		}
		return average / 5;
	}

}
