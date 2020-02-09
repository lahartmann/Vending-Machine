package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipsTest {
	
	Chips newChips;
	
	@Before
	public void setUp() {
		newChips = new Chips("Stackers", new BigDecimal(2.75));
	}

	@Test
	public void check_that_name_exists() {
		Assert.assertEquals("Stackers", newChips.getName());
	}

	@Test
	public void check_that_price_exists() {
		Assert.assertEquals(new BigDecimal(2.75), newChips.getPrice());
	}
	
	@Test
	public void check_if_the_sound_is_right() {
		Assert.assertEquals("Crunch Crunch, Yum!", newChips.getSound());
	}
	
	@Test
	public void check_for_quantity() {
		Assert.assertEquals(5, newChips.getQuantity());
	}
	
	@Test
	public void check_if_is_in_stock() {
		Assert.assertEquals(true, newChips.isInStock());
	}
	
	@Test
	public void check_if_out_of_stock() {
		newChips.itemPurchased();
		newChips.itemPurchased();
		newChips.itemPurchased();
		newChips.itemPurchased();
		newChips.itemPurchased();
		Assert.assertEquals(false, newChips.isInStock());
	}
	
	@Test
	public void check_if_item_purchased() {
		newChips.itemPurchased();
		Assert.assertEquals(4, newChips.getQuantity());
	}
	

}
