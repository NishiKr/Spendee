package com.example.spendee;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.Stack;

import android.util.Log;

public class PurchaseHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3196082723546529062L;
	private Stack<MonthlySum> purchases = new Stack<MonthlySum>();
	private Stack<Float> undoStack = new Stack<Float>(); 
	Calendar c;
	
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
		c = Calendar.getInstance();
		//if the year and month don't match then start a new monthly sum
		String month = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		int year = c.get(Calendar.YEAR);
		
		Log.v("Current date:", month + year);
		
		if(getCurrentSum().getMonth() != month || getCurrentSum().getYear() != year) {
			MonthlySum currentSum = new MonthlySum();
			currentSum.add(amount);
			purchases.push(currentSum);
			//now clear undo stack because it's a new month
			//then add this months first purchase
			undoStack = new Stack<Float>();
			undoStack.push(amount);
		}
		//else add it to the current monthly sum
		else {
			getCurrentSum().add(amount);
			undoStack.push(amount);
		}
	}
	
	public boolean undo() {
		if(!undoStack.isEmpty()) {
			getCurrentSum().add(undoStack.pop()* -1);
			return true;
		}
		else {
			return false;
		}
	}
	
}
