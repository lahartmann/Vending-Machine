package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class VendingMachine {

	private BigDecimal customerMoneyEntered = new BigDecimal(0.00);

	private BigDecimal machineBalance = new BigDecimal(0.00);

	private final int QUARTER = 25;

	private final int NICKEL = 5;

	private final int DIME = 10;

	private int helper = 100;
	
	private BigDecimal helperDec = new BigDecimal (100);

	private int numOfQuarters = 0;

	private int numOfNickels = 0;

	private int numOfDimes = 0;

	// instantiating inventory class using the source file
	Inventory newInventory = new Inventory();

	File sourceFile = newInventory.getInputFile();

	Map<String, StockedItems> itemMap = newInventory.stockInventory(sourceFile);

	// Methods

	// displays the Main Menu
	public void runMainMenu() {

		System.out.println("\n(1) Display Vending Machine Menu\n(2) Purchase\n(3) Exit\n");

	}

	// displays the inventory
	public void displayMenuItems() {

		System.out.println("Slot \t\t Product\t Price\t Quanity");

		for (String key : itemMap.keySet()) {
			if (itemMap.get(key).isInStock()) {

				System.out.printf("%-12s %-20s %.2f %4d %n", key, itemMap.get(key).getName(),
						itemMap.get(key).getPrice(), itemMap.get(key).getQuantity());
			} else {
				System.out.printf("%-12s %-20s %2s %n", key, itemMap.get(key).getName(), "SOLD OUT");
			}
		}
	}

	// Displays purchase menu
	public void displayPurchaseMenu() {

		System.out.println("(1) Feed Money\n(2) Select Product\n(3) Finish Transaction\n\n"
				+ "Current money provided: $" + machineBalance.setScale(2, RoundingMode.CEILING) + "\n");

	}

	// Asking to feed money
	public void feedMoney() {
		System.out.println("Please enter the amount: ");
	}

	// Money entered
	public BigDecimal getCustomerMoneyEntered() {
		return customerMoneyEntered;
	}

	// Selecting the product if product is in stock and credit is valid
	public void purchaseMethod(String key) throws NumberFormatException {

		 if (!itemMap.get(key).isInStock()) {
			System.out.println("SOLD OUT");

		} else if (machineBalance.compareTo(itemMap.get(key).getPrice()) == -1) { // if balance is less than purchase
																					// price
			System.out.println("Please, add more money!");
		} else if (machineBalance.compareTo(itemMap.get(key).getPrice()) >= 0) {
			
			System.out.println("Enjoy your " + itemMap.get(key).getName() + "! " + itemMap.get(key).getSound());

			itemMap.get(key).itemPurchased();
		}

	}

	// vending machine balance after the application is open. Has a $0.00 balance by
	// default
	public BigDecimal getBalance() {
		return machineBalance.setScale(2, RoundingMode.CEILING);
	}

	// UPDATED BALANCE AFTER CUSTOMER'S MONEY INPUT
	public void setBalance(BigDecimal customerMoneyEntered) {
		this.machineBalance = machineBalance.add(customerMoneyEntered);
	}

	// Updated balance after purchase
	public void balanceAfterPurchase(BigDecimal itemPrice) {
		this.machineBalance = machineBalance.subtract(itemPrice);
	}

	// dispense the change
	public void dispenseTheChange() {
		BigDecimal balanceInPennies = new BigDecimal(0);
		balanceInPennies = this.machineBalance.multiply(helperDec);
		
		numOfQuarters = balanceInPennies.intValue() / QUARTER; // amount of quarters for
																								// change
		int newBalance = balanceInPennies.intValue() % QUARTER; // remainder in pennies

		numOfDimes = (int) (newBalance / DIME); // amount of dimes for change
		int newBalance1 = newBalance % DIME; // remainder in pennies

		numOfNickels = (int) (newBalance1 / NICKEL); // amount of nickels for change

		System.out.println("Your change is: $" + this.machineBalance + "\n\nQuarters: " + numOfQuarters + "\nDimes: "
				+ numOfDimes + "\nNickels: " + numOfNickels);

		this.machineBalance = new BigDecimal(0);

	}

	// printing to log on a new line
	public void logAudit(String message) {
		
		String fileName = "Log.txt";
		File newFile = new File(fileName);

		try (FileWriter fileWriter = new FileWriter(newFile, true)) {
			PrintWriter writer = new PrintWriter(fileWriter);

			writer.println(message);

		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

	// printing to log on the same line
	public void logAuditSameLine(String message) {
		String fileName = "Log.txt";
		File newFile = new File(fileName);

		try (FileWriter fileWriter = new FileWriter(newFile, true)) {
			PrintWriter writer = new PrintWriter(fileWriter);

			writer.print(message);

		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

}
