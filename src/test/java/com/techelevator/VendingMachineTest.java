package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class VendingMachineTest {

	
	VendingMachine myMachine;
	
	
	@Before
	public void setUp() {
		myMachine = new VendingMachine();
		
	}
	
	@Test
	public void test_main_menu() {
		myMachine.runMainMenu();
		
	}
	
	@Test
	public void test_menu_items_display() {
		myMachine.displayMenuItems();
		
	}
	
	@Test
	public void test_menu_items_display_when_not_in_stock() {
		myMachine.setBalance(new BigDecimal(20));
		myMachine.purchaseMethod("A1");
		myMachine.purchaseMethod("A1");
		myMachine.purchaseMethod("A1");
		myMachine.purchaseMethod("A1");
		myMachine.purchaseMethod("A1");
		myMachine.displayMenuItems();
		
	}
	@Test
	public void test_getter_for_customer_money_entered() {
		
		Assert.assertEquals(new BigDecimal(0), myMachine.getCustomerMoneyEntered());
		
	}
	
	@Test
	public void test_get_and_set_balance() {
		myMachine.setBalance(new BigDecimal(5));
		
		Assert.assertEquals(new BigDecimal(5.00).setScale(2, RoundingMode.CEILING), myMachine.getBalance());
	
		myMachine.setBalance(new BigDecimal(5.25));
		
		Assert.assertEquals(new BigDecimal(10.25).setScale(2, RoundingMode.CEILING), myMachine.getBalance());
	
		myMachine.setBalance(new BigDecimal(0.50));
		
		Assert.assertEquals(new BigDecimal(10.75).setScale(2, RoundingMode.CEILING), myMachine.getBalance());
	
	}
	
	@Test
	public void displays_purchase_menu() {
		myMachine.displayPurchaseMenu();
	}
	
	@Test
	public void feed_Money() {
		myMachine.feedMoney();
	}
	
	@Test
	public void test_puchase_method() {
		String key = "A1";
		myMachine.setBalance(new BigDecimal(10));
		myMachine.purchaseMethod(key);
		Assert.assertEquals (4, myMachine.itemMap.get(key).getQuantity());
		
	}
	
	@Test
	public void test_puchase_method_with_no_money() {
		String key = "A1";
		myMachine.setBalance(new BigDecimal(1));
		myMachine.purchaseMethod(key);
		Assert.assertEquals (5, myMachine.itemMap.get(key).getQuantity());
		
	}
	
	@Test
	public void test_puchase_method_when_out_of_Stock() {
		myMachine.setBalance(new BigDecimal(20));
		myMachine.purchaseMethod("A1");
		myMachine.purchaseMethod("A1");
		myMachine.purchaseMethod("A1");
		myMachine.purchaseMethod("A1");
		myMachine.purchaseMethod("A1");
		myMachine.purchaseMethod("A1");
		
		Assert.assertEquals(0, myMachine.itemMap.get("A1").getQuantity());
		//returns Sold out and does not adjust quantity
		
		
	}

	@Test
	public void test_balance_after_purchase() {
		myMachine.setBalance(new BigDecimal(10.25));
		BigDecimal itemPrice = new BigDecimal(2.25);
		myMachine.balanceAfterPurchase(itemPrice);
		
		Assert.assertEquals(new BigDecimal(8).setScale(2, RoundingMode.CEILING), myMachine.getBalance());
		
	}
	
	@Test
	public void test_change_dispensing() {
		myMachine.setBalance(new BigDecimal(10.35).setScale(2, RoundingMode.CEILING));
		
		myMachine.dispenseTheChange();
		
		Assert.assertEquals(new BigDecimal(0).setScale(2, RoundingMode.CEILING), myMachine.getBalance());
		
	}
	
	@Test
	public void  test_logAudit_method() {
		String fileName = "Log.txt";
		File newFile = new File(fileName);
		String message = "test";
		myMachine.logAudit(message);
		Assert.assertEquals("test", message); //check in log file
	}
	
	@Test
	public void  test_logAudit_method_on_same_line() {
		String fileName = "Log.txt";
		File newFile = new File(fileName);
		String message = "test2";
		myMachine.logAuditSameLine(message);
		Assert.assertEquals("test2", message); //check in log file
	}
}