package com.techelevator;

import java.math.BigDecimal;

public class StockedItems {

	private String name;
	private BigDecimal price = new BigDecimal(0);
	private String sound;

	public StockedItems(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getSound() {
		return sound;
		
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
