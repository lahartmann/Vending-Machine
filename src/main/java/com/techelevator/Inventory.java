package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Inventory {

	public static void main(String[] args) {

		File sourceFile = new File("vendingmachine.csv");

		String[] lineArray = null;
		List<String> slots = new ArrayList<String>();
		List<String> items = new ArrayList<String>();
		List<String> price = new ArrayList<String>();
		List<String> type = new ArrayList<String>();
		try {

			Scanner fileScanner = new Scanner(sourceFile);
			while (fileScanner.hasNextLine()) {

				String sentence = fileScanner.nextLine();
				lineArray = sentence.split("[|]");

				slots.add(lineArray[0]);
				items.add(lineArray[1]);
				price.add(lineArray[2]);
				type.add(lineArray[3]);

			}

			System.out.println(slots);
			System.out.println(items);
			System.out.println(price);
			System.out.println(type);

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		Chips newChips = null;
		
		for (String t : type) {
			for (int i = 0; i < items.size(); i++) {
				if (t.contains("Chip")) {
					newChips = new Chips(items.get(i), new BigDecimal(price.get(i)));
				if (t.equals("Candy")) {
					Candy newCandy = new Candy(items.get(i), new BigDecimal(price.get(i)));
					
				}
				}
			} System.out.println(newChips.getPrice());
//		if (t.equals("Chip")) {
//			Chips newChips = new Chips(items.get(t), price.get(t));
//		}
		} 

	}
}