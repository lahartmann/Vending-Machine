package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;

public class VendingMachine {

	private BigDecimal customerBalance = new BigDecimal(0);

	private BigDecimal customerMoneyEntered = new BigDecimal(0);

	private BigDecimal machineBalance = new BigDecimal(0);

	private final double QUARTER = .25;

	private final double NICKEL = .05;

	private final double DIME = .10;

	private int numOfQuarters = 0;

	private int numOfNickels = 0;

	private int numOfDimes = 0;

	private BigDecimal change = new BigDecimal(0);

//	private String changeSplit = "";

	Inventory newInventory = new Inventory();

	File sourceFile = newInventory.getInputFile();

	Map<String, StockedItems> itemMap = newInventory.stockInventory(sourceFile);

	public void runMainMenu() {

		System.out.println("(1) Display Vending Machine Menu, (2) Purchase, (3) Exit");

	}

	public void displayMenuItems() {

		for (String key : itemMap.keySet()) {
			if (itemMap.get(key).getQuantity() > 0) {
				System.out.printf("%-12s %-20s %.2f %2d %n", key, itemMap.get(key).getName(),
						itemMap.get(key).getPrice(), itemMap.get(key).getQuantity());
			} else {
				System.out.printf("%-12s %-20s %2s %n", key, itemMap.get(key).getName(), "SOLD OUT");
			}
		}
	}

	public void purchaseMethod(String key) {
		if (!itemMap.containsKey(key)) {
			System.out.println("Sorry, that slot doesn't exist!");
		} else if (itemMap.get(key).getQuantity() == 0) {
			System.out.println("SOLD OUT");
		} else if (machineBalance.compareTo(itemMap.get(key).getPrice()) == -1) { // if balance is less than purchase
																					// price
			System.out.println("Please, add more money!");
		} else if (machineBalance.compareTo(itemMap.get(key).getPrice()) >= 0) {
			System.out.println("Enjoy your " + itemMap.get(key).getName() + "! " + itemMap.get(key).getSound());
			machineBalance = machineBalance.subtract(itemMap.get(key).getPrice());
			itemMap.get(key).itemPurchased();
		}

	}

	public void displayPurchaseMenu() {

		System.out.println("(1) Feed Money, (2) Select Product, (3) Finish Transaction, " + "$" + machineBalance);

	}

	public void feedMoney() {
		System.out.println("Please enter the amount: ");
	}

	public BigDecimal getCustomerMoneyEntered() {
		return customerMoneyEntered;
	}

	// vending machine balance after the application is open. Has a $0.00 balance by
	// default
	public BigDecimal getBalance() {
		return machineBalance;
	}

	// UPDATED BALANCE AFTER CUSTOMER'S MONEY INPUT
	public void setBalance(BigDecimal customerMoneyEntered) {
		this.machineBalance = machineBalance.add(customerMoneyEntered);
	}

	// Updated balance after purchase
	public void balanceAfterPurchase(BigDecimal itemPrice) {
		this.machineBalance = customerBalance.subtract(itemPrice);
	}

	// dispense the change
	public BigDecimal dispenseTheChange() {
		numOfQuarters = (int) (this.machineBalance.doubleValue() / QUARTER);
		double newBalance = this.machineBalance.doubleValue() % QUARTER;
		numOfDimes = (int) (newBalance / DIME);
		double newBalance1 = newBalance % DIME;
		numOfNickels = (int) (newBalance1 / NICKEL);
		
		System.out.println("Your change is: $" + this.machineBalance + "\n" + numOfQuarters + ": Quarters\n" + numOfDimes
				+ ": Dimes\n" + numOfNickels + ": Nickels");
		
		return this.machineBalance = new BigDecimal(0);
		
		
	}

//	public void logFeedMoney() {
//		String fileName = "Log.txt";
//		File newFile = new File(fileName);
//
//		try (FileWriter fileWriter = new FileWriter(newFile, true)) {
//			PrintWriter writer = new PrintWriter(fileWriter);
//
//			writer.println("FEED MONEY: $" + customerMoneyEntered + machineBalance);
//
//		} catch (IOException e) {
//			System.out.println("File not found");
//		}
//
//	}
//
//	public void logPurchaseProduct() {
//		String fileName = "Log.txt";
//		File newFile = new File(fileName);
//
//		try (FileWriter fileWriter = new FileWriter(newFile, true)) {
//			PrintWriter writer = new PrintWriter(fileWriter);
//
//			writer.println("GIVE CHANGE: $" + machineBalance + " $" + /*itemMap.get(key).getPrice());*/
//
//		} catch (IOException e) {
//			System.out.println("File not found");
//		}
//
//	}

}
