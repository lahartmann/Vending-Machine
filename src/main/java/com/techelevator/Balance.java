package com.techelevator;

import java.math.BigDecimal;

public class Balance {
	
	
	private BigDecimal machineBalance = new BigDecimal(0);
	
	private BigDecimal customerBalance = new BigDecimal(0);
	
	public BigDecimal getCustomerMoneyEntered() {
		return customerMoneyEntered;
	}

	private BigDecimal customerMoneyEntered = new BigDecimal(0);
	
	private BigDecimal itemPrice = new BigDecimal(0);

	public BigDecimal getBalance() {
		return machineBalance;
	}

	public void setBalance(BigDecimal customerMoneyEntered) {
		this.customerBalance = machineBalance.add(customerMoneyEntered);
	}
	
	public void balanceAfterPurchase(BigDecimal itemPrice) {
		this.machineBalance = customerBalance.subtract(itemPrice);
	}
	

}
