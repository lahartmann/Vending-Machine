package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {

	Candy newCan;
	
	@Before
	public void setUp() {
	newCan = new Candy("MoonPie", new BigDecimal(1.80));
	}
	
	@Test
	public void check_that_name_exists() {
		Assert.assertEquals("MoonPie", newCan.getName());
	}

	@Test
	public void check_that_price_exists() {
		Assert.assertEquals(new BigDecimal(1.80), newCan.getPrice());
	}
	
	@Test
	public void check_if_the_sound_is_right() {
		Assert.assertEquals("Munch Munch, Yum!", newCan.getSound());
	}
	
	@Test
	public void check_for_quantity() {
		Assert.assertEquals(5, newCan.getQuantity());
	}
	
	@Test
	public void check_if_is_in_stock() {
		Assert.assertEquals(true, newCan.isInStock());
	}
	
	@Test
	public void check_if_out_of_stock() {
		newCan.itemPurchased();
		newCan.itemPurchased();
		newCan.itemPurchased();
		newCan.itemPurchased();
		newCan.itemPurchased();
		Assert.assertEquals(false, newCan.isInStock());
	}
	
	@Test
	public void check_if_item_purchased() {
		newCan.itemPurchased();
		Assert.assertEquals(4, newCan.getQuantity());
	}
}
