package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
	
		public File getInputFile() {
		
		String path = "vendingmachine.csv";
		File sourceFile = new File(path);
		
		if(!sourceFile.exists()) {
			System.out.println(path + " does not exist");
			System.exit(1);
		} else if (sourceFile.isDirectory()) {
			System.out.println(path + " is not a file");
			System.exit(1);
		} 
			return sourceFile;
		
	}
	
	
	public Map<String, StockedItems> stockInventory(File sourceFile){
		Map<String, StockedItems> itemMap = new LinkedHashMap<String, StockedItems>();
		try(Scanner fileScanner = new Scanner(sourceFile)){
			
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] splitLine = line.split("[|]");
				if (splitLine[3].equals("Chip")){
					StockedItems newItem = new Chips(splitLine[1], new BigDecimal(splitLine[2]));
					itemMap.put(splitLine[0], newItem);
				} else if (splitLine[3].equals("Candy")) {
					StockedItems newItem = new Candy(splitLine[1], new BigDecimal(splitLine[2]));
					itemMap.put(splitLine[0], newItem);
				} else if (splitLine[3].equals("Drink")) {
					StockedItems newItem = new Beverage(splitLine[1], new BigDecimal(splitLine[2]));
					itemMap.put(splitLine[0], newItem);
				} else if (splitLine[3].equals("Gum")) {
					StockedItems newItem = new Gum(splitLine[1], new BigDecimal(splitLine[2]));
					itemMap.put(splitLine[0], newItem);
				} 
			} 
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return itemMap;
		
	} 
	

}
