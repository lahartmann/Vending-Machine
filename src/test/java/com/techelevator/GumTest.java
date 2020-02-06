package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {
	
	@Test
	public void check_that_name_exists() {
		Gum newGum = new Gum("U-Chews", new BigDecimal(0.85));
		Assert.assertEquals("U-Chews", newGum.getName());
	}

	@Test
	public void check_that_price_exists() {
		Gum newGum = new Gum("U-Chews", new BigDecimal(0.85));
		Assert.assertEquals(new BigDecimal(0.85), newGum.getPrice());
	}
	
	@Test
	public void check_if_the_sound_is_right() {
		Gum newGum = new Gum("U-Chews", new BigDecimal(0.85));
		Assert.assertEquals("Chew Chew, Yum!", newGum.getSound());
	}

}
