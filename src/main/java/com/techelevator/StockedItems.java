package com.techelevator;

import java.math.BigDecimal;

public abstract class StockedItems {

	private String name;
	private BigDecimal price = new BigDecimal(0);
	private int quantity = 5;

	public StockedItems(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void itemPurchased() {
		quantity--;
	}


	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public boolean isInStock() {
		if (this.quantity >= 1) {
			return true;
		}
		return false;
	}

}
