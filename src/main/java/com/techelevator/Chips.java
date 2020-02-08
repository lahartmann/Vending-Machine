package com.techelevator;

import java.math.BigDecimal;

public class Chips extends StockedItems implements Yumable {

	private String sound = "Crunch Crunch, Yum!";

	public Chips(String name, BigDecimal price) {
		super(name, price);

	}

	public String getSound() {
		return sound;
	}

}
