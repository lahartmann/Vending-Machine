package com.techelevator;

import java.awt.DisplayMode;
import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.Keymap;

public class UserMenu {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		VendingMachine ourMachine = new VendingMachine();

		String option = "";
		
		String optionForPurchaseMenu = "";
		
		BigDecimal customerMoneyEntered = new BigDecimal(0);
		

		while (!option.equals("3")) { //while Exit is not chosen in the Main Menu
			ourMachine.runMainMenu(); //prints out the Main Menu
			System.out.println("Please select one of the options: "); //asks for selection
			option = userInput.nextLine(); //stores the selection
			if (option.equals("1")) { //if selection is 1
				ourMachine.displayMenuItems(); // prints out the Item Menu (Inventory)
			} else if(option.equals("2")){
				
				while (true) { // while Exit is not chosen in the Item Menu
					ourMachine.displayPurchaseMenu(); // prints out purchase menu
					System.out.println("Please select one of the options: ");
					
					optionForPurchaseMenu = userInput.nextLine(); //stores the option
					if(optionForPurchaseMenu.equals("1")) { //if 1
						ourMachine.feedMoney();//ask for amount to input
						customerMoneyEntered = new BigDecimal(userInput.nextLine());//amount stored as BigDecimal
						ourMachine.setBalance(customerMoneyEntered);//updates the machine balance
						
						
					} else if(optionForPurchaseMenu.equals("2")) {
						ourMachine.displayMenuItems();
						System.out.println("Please select an item to purchase: ");
						String optionOfItemChosen = userInput.nextLine().toUpperCase(); //slot #
						ourMachine.purchaseMethod(optionOfItemChosen);
						
					} else {
						ourMachine.dispenseTheChange();
						break;
						
					}
						
					}
				} 
			}
		}

		// ourMachine.runMainManu();

//		System.out.println("Would you like to make a purchase? Y/N ");
//		String optionToPurchaseOrNot = userInput.nextLine();
//		
//		if(optionToPurchaseOrNot.equalsIgnoreCase("Y")) {
//			System.out.println("Please input the money");
//			ourMachine.displayPurchaseMenu();
//			String inputMoney = userInput.nextLine();
//			while(!inputMoney.equals("1")) {
//				System.out.println("Sorry, your credit balance is $0.00. Please input some money.");
//				ourMachine.displayPurchaseMenu();
//			} 

//		} else {
//			System.out.println("Have a great day!");
//			System.exit(1);
//		}

//		System.out.println("Please choose an item: ");
//		String itemSlotForPurchase = userInput.nextLine();

		// Scanner newScanner = new Scanner();

		// ourMachine.displayMenuItems();

	}


