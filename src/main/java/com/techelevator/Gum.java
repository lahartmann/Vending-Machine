package com.techelevator;

import java.math.BigDecimal;

public class Gum extends StockedItems implements Yumable {

	private String sound = "Chew Chew, Yum!";

	public Gum(String name, BigDecimal price) {
		super(name, price);

	}

	public String getSound() {
		return sound;
	}

}
