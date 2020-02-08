package com.techelevator;

import java.awt.DisplayMode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class UserMenu {

	public static void main(String[] args) throws Exception {

		Scanner userInput = new Scanner(System.in);

		VendingMachine ourMachine = new VendingMachine();
		
//		LocalDateTime currentTime = LocalDateTime.now();
//		
//		DateTimeFormatter ourCurrentTimeFormatted = new DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		
//		String formattedDate = currentTime.format(ourCurrentTimeFormatted);
		
		String ourDateFormatted = "MM/dd/yyyy hh:mm:ss a";
		SimpleDateFormat dateFormat = new SimpleDateFormat(ourDateFormatted);
		Date ourDate = new Date();
		//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		

		String option = "";

		String optionForPurchaseMenu = "";

		BigDecimal customerMoneyEntered = new BigDecimal(0.00);
		
		//BigDecimal machineBalanceAfterPurchaseBefore

		while (!option.equals("3")) { // while Exit is not chosen in the Main Menu
			ourMachine.runMainMenu(); // prints out the Main Menu
			System.out.println("Please select one of the options: "); // asks for selection
			option = userInput.nextLine(); // stores the selection
			if (option.equals("1")) { // if selection is 1
				ourMachine.displayMenuItems(); // prints out the Item Menu (Inventory)
			} else if (option.equals("2")) {

				while (true) { // while Exit is not chosen in the Item Menu
					ourMachine.displayPurchaseMenu(); // prints out purchase menu
					System.out.println("Please select one of the options: ");

					optionForPurchaseMenu = userInput.nextLine(); // stores the option
					if (optionForPurchaseMenu.equals("1")) { // if 1
						ourMachine.feedMoney();// ask for amount to input
						customerMoneyEntered = new BigDecimal(userInput.nextLine());// amount stored as BigDecima
						ourMachine.setBalance(customerMoneyEntered);// updates the machine balance
						ourMachine.logAudit("> " + dateFormat.format(ourDate) + " FEED MONEY: $" + customerMoneyEntered.setScale(2, RoundingMode.CEILING) + " $" + ourMachine.getBalance() + " "); //record the transaction in log.txt with the infp of money entered and updated balance
						

					} else if (optionForPurchaseMenu.equals("2")) {
						ourMachine.displayMenuItems();
						System.out.println("Please select an item to purchase: ");
						String optionOfItemChosen = userInput.nextLine().toUpperCase(); // slot #
						ourMachine.purchaseMethod(optionOfItemChosen);
						ourMachine.logAudit("> " + dateFormat.format(ourDate) + " " + ourMachine.itemMap.get(optionOfItemChosen).getName() + " " + optionOfItemChosen + " $" + ourMachine.getBalance() + " " + ourMachine.getBalance().subtract(ourMachine.itemMap.get(optionOfItemChosen).getPrice()));
						ourMachine.balanceAfterPurchase(ourMachine.itemMap.get(optionOfItemChosen).getPrice());
//						machineBalance = machineBalance.subtract(itemMap.get(key).getPrice());
					} else if (optionForPurchaseMenu.equals("3")){
						
						ourMachine.logAuditSameLine("> " + dateFormat.format(ourDate) + " GIVE CHANGE: $" + ourMachine.getBalance() + " $");
						ourMachine.dispenseTheChange();
						ourMachine.logAudit(ourMachine.getBalance() + " >");
						//record the transaction in log.txt
						break;

					} else {
						System.out.println("This is not an option\n");
					}

				}
			} else if (option.equals("3")){
				System.out.println("Goodbye!");
				
			} else {
				System.out.println("This is not an option\n");
			}
		}
		
		

	}
	
	

}
