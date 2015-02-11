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
	private int month;
	private int year;
	private float amount = 0;
	
	MonthlySum() {
		c = Calendar.getInstance();
		month = c.get(Calendar.MONTH);
		year = c.get(Calendar.YEAR);
	}
	
	public int getMonth () {
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
		return String.format(Locale.CANADA, "%s %.2f" ,c.getDisplayName(getMonth(), Calendar.LONG, Locale.CANADA), getAmount());
	}
}
