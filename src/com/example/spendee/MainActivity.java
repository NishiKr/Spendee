package com.example.spendee;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	PurchaseHistory purchaseHistory = new PurchaseHistory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = (Button) findViewById(R.id.addButton);
        final TextView dollarTextView = (TextView) findViewById(R.id.dollarTextView);
        final EditText amountText = (EditText) findViewById(R.id.amountEditText);
        
        //initialize purchase history from file
        
        final IOManager io = new IOManager(getApplicationContext());
        purchaseHistory = io.load();
        
        //set initial dollar value
		dollarTextView.setText(String.format("%.2f" ,purchaseHistory.getCurrentSum().getAmount()));
        
        add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					String amount = amountText.getText().toString();
					purchaseHistory.add(Float.parseFloat(amount));
					io.save(purchaseHistory);
					dollarTextView.setText(String.format("%.2f" ,purchaseHistory.getCurrentSum().getAmount()));
					amountText.setText("");
				}
				catch (NumberFormatException e) {
					Toast.makeText(getBaseContext(), "Invalid Entry", Toast.LENGTH_SHORT).show();
					amountText.setText("");
				}
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
