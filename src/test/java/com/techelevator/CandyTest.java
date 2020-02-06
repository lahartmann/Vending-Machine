package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {

	@Test
	public void check_that_name_exists() {
		Beverage newBev = new Beverage("MoonPie", new BigDecimal(1.80));
		Assert.assertEquals("MoonPie", newBev.getName());
	}

	@Test
	public void check_that_price_exists() {
		Beverage newBev = new Beverage("MoonPie", new BigDecimal(1.80));
		Assert.assertEquals(new BigDecimal(1.80), newBev.getPrice());
	}
}
