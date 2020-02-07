package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;

public class VendingMachine {
	
	
	private BigDecimal customerBalance = new BigDecimal(0);
	
	private BigDecimal customerMoneyEntered = new BigDecimal(0);
	
	private BigDecimal machineBalance = new BigDecimal(0);
	
	private final BigDecimal QUARTERS = new BigDecimal(.25);
	
	private final BigDecimal NICKEL = new BigDecimal(.05);
	
	private final BigDecimal DIME = new BigDecimal(.1);
	
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
		if(!itemMap.containsKey(key)) {
			System.out.println("Sorry, that slot doesn't exist!");
		} else if(itemMap.get(key).getQuantity() == 0) {
			System.out.println("SOLD OUT");
		} else if(machineBalance.compareTo(itemMap.get(key).getPrice()) == -1) { //if balance is less than purchase price
			System.out.println("Please, add more money!");
		} else if(machineBalance.compareTo(itemMap.get(key).getPrice()) >= 0) {
			System.out.println("Enjoy your " + itemMap.get(key).getName() + "! " + itemMap.get(key).getSound());
			machineBalance = machineBalance.subtract(itemMap.get(key).getPrice());
			itemMap.get(key).itemPurchased();
		}
	
	}

	public void displayPurchaseMenu() {

		System.out.println("(1) Feed Money, (2) Select Product, (3) Finish Transaction, " + machineBalance);

	}

	public void feedMoney() {
		System.out.println("Please enter the amount: ");
	}
	
	public BigDecimal getCustomerMoneyEntered() {
		return customerMoneyEntered;
	}

	//vending machine balance after the application is open. Has a $0.00 balance by default
	public BigDecimal getBalance() {
		return machineBalance;
	}

	//UPDATED BALANCE AFTER CUSTOMER'S MONEY INPUT
	public void setBalance(BigDecimal customerMoneyEntered) {
		this.machineBalance = machineBalance.add(customerMoneyEntered);
	}
	
	//Updated balance after purchase
	public void balanceAfterPurchase(BigDecimal itemPrice) {
		this.machineBalance = customerBalance.subtract(itemPrice);
	}
	
	//dispense the change
	public void dispenseTheChange() {
		
		
	}

}