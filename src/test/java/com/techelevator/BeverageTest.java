package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeverageTest {

	
	Beverage newBev;
	
	@Before
	public void setUp() {
		newBev = new Beverage("Coke", new BigDecimal(2.50));

	}
	@Test
	public void check_that_name_exists() {
		Assert.assertEquals("Coke", newBev.getName());
	}

	@Test
	public void check_that_price_exists() {
		Assert.assertEquals(new BigDecimal(2.50), newBev.getPrice());
	}
	
	@Test
	public void check_if_the_sound_is_right() {
		Assert.assertEquals("Glug Glug, Yum!", newBev.getSound());
	}
	
	@Test
	public void check_for_quantity() {
		Assert.assertEquals(5, newBev.getQuantity());
	}
	
	@Test
	public void check_if_is_in_stock() {
		Assert.assertEquals(true, newBev.isInStock());
	}
	
	@Test
	public void check_if_out_of_stock() {
		newBev.itemPurchased();
		newBev.itemPurchased();
		newBev.itemPurchased();
		newBev.itemPurchased();
		newBev.itemPurchased();
		Assert.assertEquals(false, newBev.isInStock());
	}
	
	@Test
	public void check_if_item_purchased() {
		newBev.itemPurchased();
		Assert.assertEquals(4, newBev.getQuantity());
	}
	
	
}
