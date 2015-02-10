package com.example.spendee;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Stack;

public class PurchaseHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3196082723546529062L;
	private Stack<MonthlySum> purchases = new Stack<MonthlySum>();
	
	PurchaseHistory() {
		purchases.push(new MonthlySum());
	}
	
	public Stack<MonthlySum> getPurchases() {
		return purchases;
	}
	
	public MonthlySum getCurrentSum() {
		return purchases.peek();
	}
	
	public void add(float amount) {
		//if the year and month don't match then start a new monthly sum
		if(getCurrentSum().getMonth() != Calendar.MONTH && getCurrentSum().getYear() != Calendar.YEAR) {
			MonthlySum currentSum = new MonthlySum();
			currentSum.add(amount);
			purchases.push(currentSum);
		}
		//else add it to the current monthly sum
		else {
			getCurrentSum().add(amount);
		}
	}
	
}
