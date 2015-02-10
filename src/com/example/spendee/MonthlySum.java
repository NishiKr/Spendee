package com.example.spendee;

import java.io.Serializable;
import java.util.Calendar;

public class MonthlySum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6396729886588557034L;
	private int month = Calendar.MONTH;
	private int year = Calendar.YEAR;
	private float amount = 0;
	
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
	}
}
