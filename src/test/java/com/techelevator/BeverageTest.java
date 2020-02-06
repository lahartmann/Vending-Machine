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
}
