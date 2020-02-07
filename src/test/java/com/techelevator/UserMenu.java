package com.techelevator;

import java.io.File;
import java.util.Map;

public class UserMenu {
	public static void main(String[] args) {
		
		Inventory newInventory = new Inventory();
		
		File sourceFile = newInventory.getInputFile();
		
		Map<String, StockedItems> itemMap = newInventory.stockInventory(sourceFile);
		
		
		
		}
	}		

