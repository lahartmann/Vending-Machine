package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class BeverageTest {

	@Test
	public void check_that_name_exists() {
		Beverage newBev = new Beverage("Coke", new BigDecimal(2.50));
		Assert.assertEquals("Coke", newBev.getName());
	}

	@Test
	public void check_that_price_exists() {
		Beverage newBev = new Beverage("Coke", new BigDecimal(2.50));
		Assert.assertEquals(new BigDecimal(2.50), newBev.getPrice());
	}
	
	@Test
	public void check_if_the_sound_is_right() {
		Beverage newBev = new Beverage("Coke", new BigDecimal(2.50));
		Assert.assertEquals("Glug Glug, Yum!", newBev.getSound());
	}
	
	@Test
	public void check_for_quantity() {
		Beverage newBev = new Beverage("Coke", new BigDecimal(2.50));
		Assert.assertEquals(5, newBev.getQuantity());
	}
	
	@Test
	public void check_if_is_in_stock() {
		Beverage newBev = new Beverage("Coke", new BigDecimal(2.50));
		Assert.assertEquals(true, newBev.isInStock());
	}
	
//	@Test
//	public void check_if_is_out_of__stock() {
//		Beverage newBev = new Beverage();
//		boolean result = newBev.isInStock();
//		Assert.assertEquals(false, newBev.isInStock());
//	}
	
	
}
