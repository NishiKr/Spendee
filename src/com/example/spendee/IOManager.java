package com.example.spendee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.util.Log;

public class IOManager {
	
	String filename = "spendee.sav";
	Context context;
	
	IOManager(Context theContext) {
		context = theContext;
	}
	public void save(PurchaseHistory purchaseHistory) {
		try {
			File f = new File(context.getFilesDir(), filename);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(purchaseHistory);
			oos.flush();
			oos.close();
		}
		catch (Exception ex) {
			Log.v("File Error", ex.getMessage());
		}
	}
	public PurchaseHistory load() {
		File f = new File(context.getFilesDir(), filename);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			Object o = ois.readObject();
			ois.close();
			return (PurchaseHistory) o;
		}
		catch (Exception ex) {
			PurchaseHistory purchaseHistory = new PurchaseHistory();
			save(purchaseHistory);
			return purchaseHistory;
		}
	}

}
