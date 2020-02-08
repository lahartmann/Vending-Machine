package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ChipsTest {
	
	@Test
	public void check_that_name_exists() {
		Chips newChips = new Chips("Stackers", new BigDecimal(2.75));
		Assert.assertEquals("Stackers", newChips.getName());
	}

	@Test
	public void check_that_price_exists() {
		Chips newChips = new Chips("Stackers", new BigDecimal(2.75));
		Assert.assertEquals(new BigDecimal(2.75), newChips.getPrice());
	}
	
	@Test
	public void check_if_the_sound_is_right() {
		Chips newChips = new Chips("Stackers", new BigDecimal(2.75));
		Assert.assertEquals("Crunch Crunch, Yum!", newChips.getSound());
	}
	
	@Test
	public void check_for_quantity() {
		Chips newChips = new Chips("Stackers", new BigDecimal(2.75));
		Assert.assertEquals(5, newChips.getQuantity());
	}
	
	@Test
	public void check_if_is_in_stock() {
		Chips newChips = new Chips("Stackers", new BigDecimal(2.75));
		Assert.assertEquals(true, newChips.isInStock());
	}

}
