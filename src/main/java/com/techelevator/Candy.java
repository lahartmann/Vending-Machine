package com.techelevator;

import java.math.BigDecimal;

public class Candy extends StockedItems implements Yumable {

	private String sound = "Munch Munch, Yum!";

	public Candy(String name, BigDecimal price) {
		super(name, price);

	}

	public String getSound() {
		return sound;
	}

}
