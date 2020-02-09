package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserMenu {

	public static void main(String[] args) throws Exception {

		Scanner userInput = new Scanner(System.in);

		VendingMachine ourMachine = new VendingMachine();

		String ourDateFormatted = "MM/dd/yyyy hh:mm:ss a";

		SimpleDateFormat dateFormat = new SimpleDateFormat(ourDateFormatted);

		Date ourDate = new Date();

		String option = "";

		String optionForPurchaseMenu = "";

		BigDecimal customerMoneyEntered = new BigDecimal(0.00);

		String optionOfItemChosen = "";

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

						try {
							customerMoneyEntered = new BigDecimal(userInput.nextLine());// amount stored as BigDecimal
																						// if valid amount is entered
																						// (anything except for numbers)

						} catch (NumberFormatException e) {
							System.out.println("\n***Not a valid amount!***\n");
						}
						ourMachine.setBalance(customerMoneyEntered);// updates the machine balance
						ourMachine.logAudit("> " + dateFormat.format(ourDate) + " FEED MONEY: $"
								+ customerMoneyEntered.setScale(2, RoundingMode.CEILING) + " $"
								+ ourMachine.getBalance() + " "); // record the transaction in log.txt with the info of
																	// money entered and updated balance

					} else if (optionForPurchaseMenu.equals("2")) {
						ourMachine.displayMenuItems();// shows inventory

						System.out.println("Please select an item to purchase: ");
						
						try {

							optionOfItemChosen = userInput.nextLine().toUpperCase(); // slot # is stored in
																							// optionOfItemChosen even if
																							// invalid
	
							ourMachine.purchaseMethod(optionOfItemChosen); // updates the quantity and prints the sound
																				// from Yumable

							if (ourMachine.getBalance()
									.compareTo(ourMachine.itemMap.get(optionOfItemChosen).getPrice()) >= 0) {
								ourMachine.logAudit("> " + dateFormat.format(ourDate) + " " // prints out the
																							// transaction to the log
										+ ourMachine.itemMap.get(optionOfItemChosen).getName() + " "
										+ optionOfItemChosen + " $" + ourMachine.getBalance() + " "
										+ ourMachine.getBalance()
												.subtract(ourMachine.itemMap.get(optionOfItemChosen).getPrice()));

								ourMachine.balanceAfterPurchase(ourMachine.itemMap.get(optionOfItemChosen).getPrice());
							} // updates the balance after transaction and takes them back to the purchase
								// menu

						} catch (NullPointerException e) {
							
							System.out.println("***Sorry, that slot does not exist!***");

						}

					} else if (optionForPurchaseMenu.equals("3")) {// gives the customer the change, logs transaction,
																	// and takes them to the Main Menu for
																	// (Inventory/Purchase/Exit)

						ourMachine.logAuditSameLine(
								"> " + dateFormat.format(ourDate) + " GIVE CHANGE: $" + ourMachine.getBalance() + " $");
						ourMachine.dispenseTheChange();
						ourMachine.logAudit(ourMachine.getBalance() + " >");
						break;

					} else {
						System.out.println("***This is not an option!***\n");
					}

				}
			} else if (option.equals("3")) {

				System.out.println("Goodbye! Have a great day!");

			} else {

				System.out.println("***This is not an option!***\n");
			}

		}
		userInput.close();
	}

}
