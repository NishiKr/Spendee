package com.example.spendee;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

public class MonthlySum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6396729886588557034L;
	Calendar c;
	private String month;
	private int year;
	private float amount = 0;
	
	MonthlySum() {
		c = Calendar.getInstance();
		month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		year = c.get(Calendar.YEAR);
	}
	
	public String getMonth () {
		return month;
	}
	
	public int getYear () {
		return year;
	}
	public float getAmount () {
		return amount;
	}
	public void add(float theAmount) {
		amount += theAmount;
		amount += 0.0;
	}
	public String toString() {
		return String.format(Locale.US, "%s: %.2f",getMonth(), getAmount());
	}
}
