/**
 * 
 */
package com.scu.msis.capstone.eztravel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * @author Brunda
 *
 */
public class LoginActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.e("LoginActivity.onCreate", "Start");
		setContentView(R.layout.login);
		
		// Login Button On Click Listener
		Button loginBtn = (Button) findViewById(R.id.loginBtn);
		loginBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent homeScreen = new Intent(LoginActivity.this, HomeActivity.class);
				Log.e("In onCLickView method of LoginActivity","LoginActivity");
				startActivity(homeScreen);
			}
		}); 
		// Register Button On Click listener
		Button registerBtn = (Button) findViewById(R.id.registerBtn);
		registerBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent registerScreen = new Intent(LoginActivity.this, RegisterActivity.class);
				Log.e("In onCLickView method of Register Activity","Register Activity");
				startActivity(registerScreen);
			}
		}); 
	}

}
