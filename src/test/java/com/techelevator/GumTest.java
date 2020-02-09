package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

	Gum newGum;

	@Before
	public void setUp() {
		newGum = new Gum("U-Chews", new BigDecimal(0.85));
	}

	@Test
	public void check_that_name_exists() {

		Assert.assertEquals("U-Chews", newGum.getName());
	}

	@Test
	public void check_that_price_exists() {

		Assert.assertEquals(new BigDecimal(0.85), newGum.getPrice());
	}

	@Test
	public void check_if_the_sound_is_right() {

		Assert.assertEquals("Chew Chew, Yum!", newGum.getSound());
	}

	@Test
	public void check_for_quantity() {

		Assert.assertEquals(5, newGum.getQuantity());
	}

	@Test
	public void check_if_is_in_stock() {

		Assert.assertEquals(true, newGum.isInStock());
	}
	
	@Test
	public void check_if_out_of_stock() {
		newGum.itemPurchased();
		newGum.itemPurchased();
		newGum.itemPurchased();
		newGum.itemPurchased();
		newGum.itemPurchased();
		Assert.assertEquals(false, newGum.isInStock());
	}
	
	@Test
	public void check_if_item_purchased() {
		newGum.itemPurchased();
		Assert.assertEquals(4, newGum.getQuantity());
	}
	

}
