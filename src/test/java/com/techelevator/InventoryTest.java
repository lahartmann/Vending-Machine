package com.techelevator;

import java.io.File;


import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class InventoryTest {
	
	Inventory stock;
	
	@Before
	public void setUp() {
		stock = new Inventory();
	}
	
	@Test
	public void check_for_file() {
		File sourceFile = new File("vendingmachine.csv");
		Assert.assertEquals(sourceFile, stock.getInputFile());
	}
	
	
	@Test
	public void check_for_Inventory() {
		File sourceFile = new File("vendingmachine.csv");
		Assert.assertEquals("Potato Crisps", stock.stockInventory(sourceFile).get("A1").getName());
	
	}
	
	@Test
	public void check_for_Inventory_if_no_file() {
		File sourceFile = new File("restock.txt");
		stock.stockInventory(sourceFile);
	
	}
	
	
}
