package com.zensar.assignmnt3.dessert;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.management.relation.Role;

public class DessertApp {

	public static int OWNER_ROLE = 1;
	public static int CUSTOMER_ROLE = 2;

	public static int CANDIES_ID = 1;
	public static int COOKIES_ID = 2;
	public static int ICECREAM_ID = 3;

	public static String ENTER_VALID_INPUT = "Enter Valid Input";
	Map<String, Integer> orderList = new HashMap<String, Integer>();
	static int ROLE = 0;

	Scanner in = new Scanner(System.in);

	void getRole() {

		orderList.clear();
		System.out.println("Enter Your Role");
		System.out.println("1 - Owner");
		System.out.println("2 - Customer");

		try {
			int role = in.nextInt();

			if (role != OWNER_ROLE && role != CUSTOMER_ROLE) {

				ROLE = 0;
				System.out.println("Enter Valide Role");
				return;
			}

			ROLE = role;

			if (ROLE == OWNER_ROLE) {

				showAddDessetsMenu();
				displaytDessertToAdd();

			} else if (ROLE == CUSTOMER_ROLE) {

				showOrderMenu();
			}

		} catch (Exception e) {
			ROLE = 0;
			System.out.println("Kindly Enter Valid Role");
			return;
		}

	}

	void showAddDessetsMenu() {

		if (ROLE == OWNER_ROLE) {

			System.out.println("::::: Welcome to  Dessert Storage ::::: \n\n");

			System.out.println(" ** Details of Avaialble  Desserts in Storage**\n\n ");

			System.out.println("\t 1. Available Candies : " + DessertStorage.getAvailableCandies() + "\n");
			System.out.println("\t 2. Available Cookies : " + DessertStorage.getAvailableCookies() + "\n");
			System.out.println("\t 3. Available IceCreams : " + DessertStorage.getAvailableIceCreams() + "\n");

		} else {
			System.out.println("Unauthorized access!");
			return;
		}
	}

	void showOrderMenu() {

		System.out.println("\n Hey, What you would like to have today?\n");

		// show details with price

		getOrderMenu();

		try {
			int result = in.nextInt();

			if (result == 1) {

				System.out.println("Enter how many candies you want to order");
				int no_of_cadies = in.nextInt();

				if (DessertStorage.getAvailableCandies() < no_of_cadies) {
					System.out.println("Sorry!! we have only " + DessertStorage.getAvailableCandies()
							+ " candies available with us.");

					showOrderMenu();

				} else {

					orderList.put("Candies", no_of_cadies);
					System.out.println(
							" \nOrder added successfully!\n Enter 1 to display your order or to  add another dessert ");

					result = in.nextInt();
					if (result == 1) {
						displayOrders(orderList);
					}

				}

			} else if (result == 2) {
				System.out.println("Enter how many cookies you want to order");
				int no_of_cookies = in.nextInt();

				if (DessertStorage.getAvailableCookies() < no_of_cookies) {
					System.out.println("Sorry!! we have only " + DessertStorage.getAvailableCandies()
							+ " cookies available with us.");

					showOrderMenu();

				} else {

					orderList.put("Cookies", no_of_cookies);
					System.out.println(
							" \nOrder added successfully!\n Enter 1 to display your order, 2 for add another dessert & "
									+ "3 to place order. ");

					result = in.nextInt();
					if (result == 1) {
						displayOrders(orderList);
					} else if (result == 2) {
						getOrderMenu();
					} else if (result == 3) {

						displayOrders(orderList);

					}

				}

			} else if (result == 3) {
				System.out.println("Enter how many ice creams you want to order");
				int no_of_icecream = in.nextInt();

				if (DessertStorage.getAvailableIceCreams() < no_of_icecream) {
					System.out.println("Sorry!! we have only " + DessertStorage.getAvailableCandies()
							+ " ice-creams available with us.");

					showOrderMenu();

				} else {

					orderList.put("Ice-Creams", no_of_icecream);
					System.out.println(
							" \nOrder added successfully!\n Enter 1 to display your order, 2 for add another dessert & "
									+ "3 to place order. ");

					result = in.nextInt();
					if (result == 1) {
						displayOrders(orderList);
					} else if (result == 2) {
						getOrderMenu();
					} else if (result == 3) {

						displayOrders(orderList);

					}

				}

			} else if (result == 4) {
				ROLE =0;		
				getRole();
			} else {
				System.out.println(ENTER_VALID_INPUT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void displayOrders(Map<String, Integer> orderList) {

		Iterator hmIterator = orderList.entrySet().iterator();

		int total_candies = 0, total_cookies = 0, total_icecreams = 0;

		while (hmIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry) hmIterator.next();

			String name = (String) mapElement.getKey();
			int value = (Integer) mapElement.getValue();

			System.out.println("\tDessert Name :" + name + ",  Qty : " + value);

			if (name.equalsIgnoreCase("Candies")) {
				total_candies = value;
			} else if (name.equalsIgnoreCase("Cookies")) {

			} else if (name.equalsIgnoreCase("Ice-Creams")) {
				total_icecreams = value;
			}

		}

		if (orderList.size() > 0) {
			System.out.println("\nTo confirm your order press 1, to add another desserts press 2");
			int res = in.nextInt();

			if (res == 1) {

				DessertStorage.COOKIES_AVAILABLE = DessertStorage.COOKIES_AVAILABLE - total_cookies;

				DessertStorage.CANDIES_AVAILABLE = DessertStorage.CANDIES_AVAILABLE - total_candies;

				DessertStorage.ICECREAMS_AVAILABLE = DessertStorage.ICECREAMS_AVAILABLE - total_icecreams;

				System.out.println("Thank you for order!");

				orderList.clear();

				System.out.println("\nEnter 1 to order again, 2 to exit!");
				res = in.nextInt();

				if (res == 1) {
					showOrderMenu();
				} else if (res == 2) {
					ROLE =0;
					getRole();
				}

			} else if (res == 2) {
				showOrderMenu();
			}

		}

	}

	void getOrderMenu() {

		System.out.println("\t 1.  " + Candy.name + " - " + new Candy().getCost());
		System.out.println("\t 2.  " + Cookie.name + " - " + new Cookie().getCost());
		System.out.println("\t 3.  " + IceCream.name + " - " + new IceCream().getCost());

		System.out.println("\nEnter 1 To Add Candies, 2  for Cookies and 3 for Ice-Cream and 4 to exit!");
	}

	void displaytDessertToAdd() {

		if (ROLE == OWNER_ROLE) {
			System.out.println("To Add Candies Press 1");
			System.out.println("To Add Cookies Press 2");
			System.out.println("To Add Ice-Creams Press 3");

			try {
				int result = in.nextInt();

				if (result == CANDIES_ID) {
					addCandiesToStorage();
				} else if (result == COOKIES_ID) {
					addCookiesToStorage();
				} else if (result == ICECREAM_ID) {
					addIceCreamToStorage();
				}
			} catch (Exception e) {
				System.out.println(ENTER_VALID_INPUT);
				return;
			}

		} else {
			System.out.println("Unauthorized access!");
			return;
		}
	}

	void addCandiesToStorage() {

		System.out.println("\n***ADD CANDIES***\n");
		System.out.println("\nEnter number of candies to be added");

		try {
			int candies = in.nextInt();

			if (candies > 0) {

				DessertStorage.addCandies(candies);
				System.out.println("\nCandies added successfully\n");
				showAddDessetsMenu();
				changeRole();

			}

		} catch (Exception e) {

		}

	}

	void addCookiesToStorage() {

		System.out.println("\n***ADD COOKIES***\n");
		System.out.println("\nEnter number of cookies to be added");

		try {
			int cookies = in.nextInt();

			if (cookies > 0) {

				DessertStorage.addCookies(cookies);
				System.out.println("Cookies added successfully");
				showAddDessetsMenu();
				changeRole();

			}

		} catch (Exception e) {

		}

	}

	void addIceCreamToStorage() {

		System.out.println("\n***ADD ICE CREAM***\n");
		System.out.println("\nEnter number of Ice Creams to be added");

		try {
			int icecreams = in.nextInt();

			if (icecreams > 0) {

				DessertStorage.addIceCreams(icecreams);
				System.out.println("Ice Creams added successfully");
				showAddDessetsMenu();
				changeRole();

			}

		} catch (Exception e) {

		}

	}

	public void changeRole() {

		System.out.println(" \n Enter 1 to Continue adding \n Enter 2 to Exit\n");

		try {
			int result = in.nextInt();

			if (result == 1) {
				displaytDessertToAdd();
			} else if (result == 2) {
				ROLE = 0;
				getRole();
			}
		} catch (Exception e) {

			System.out.println(ENTER_VALID_INPUT);

		}

	}

	public static void main(String[] ar) {

		System.out.println(":::::::: Welcome To World OF Dessert ::::::::\n\n");

		DessertApp dessertApp = new DessertApp();

		dessertApp.getRole();

	}

}
