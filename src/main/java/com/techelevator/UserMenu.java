package com.techelevator;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.text.Keymap;

public class UserMenu {
public static void main(String[] args) {
		
		Inventory newInventory = new Inventory();
		
		File sourceFile = newInventory.getInputFile();
		
		Map<String, StockedItems> itemMap = newInventory.stockInventory(sourceFile);
		
		
		for(String key : itemMap.keySet()) {
			
		 System.out.printf("%-12s %-20s %8d %n", key , itemMap.get(key).getName() , itemMap.get(key).getQuantity());
		
		}
		}
		
		
		}
		

