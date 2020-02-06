package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {

	@Test
	public void check_that_name_exists() {
		Candy newCan = new Candy("MoonPie", new BigDecimal(1.80));
		Assert.assertEquals("MoonPie", newCan.getName());
	}

	@Test
	public void check_that_price_exists() {
		Candy newCan = new Candy("MoonPie", new BigDecimal(1.80));
		Assert.assertEquals(new BigDecimal(1.80), newCan.getPrice());
	}
	
	@Test
	public void check_if_the_sound_is_right() {
		Candy newCan = new Candy("MoonPie", new BigDecimal(1.80));
		Assert.assertEquals("Munch Munch, Yum!", newCan.getSound());
	}
}
