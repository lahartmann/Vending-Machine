package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends StockedItems implements Yumable{
	
	private String sound = "Glug Glug, Yum!";
	

	public Beverage(String name, BigDecimal price) {
		super(name, price);

	}
	
	public String getSound() {
		return sound;
	}

}
