/**
 * 
 */
package com.scu.msis.capstone.eztravel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Patterns;

/**
 * @author Brunda
 *
 */
public class RegisterActivity extends Activity {

	EditText fNameEdit;
	EditText lNameEdit;
	EditText email; 
	EditText password;
	EditText confirmPassword;
	EditText phoneNumber;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.e("RegisterActivity.onCreate", "Start");
		setContentView(R.layout.register);
		
		
		// fields on the UI
				// Retrieve First Name
				fNameEdit = (EditText)findViewById(R.id.firstName);
				// Retrieve Last Name
				lNameEdit = (EditText)findViewById(R.id.lastName);
				// Retrieve Email
				email = (EditText)findViewById(R.id.emailUserName);
				// Retrieve Password
				password = (EditText)findViewById(R.id.createPassword);
				// Retrieve Confirm Password
				confirmPassword = (EditText)findViewById(R.id.confirmPassword);
				// Retrieve Phone Number
				phoneNumber = (EditText)findViewById(R.id.phoneNumber);
		
		
		// Registration 
		Button regButton = (Button) findViewById(R.id.registrationSave);
		
		regButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				boolean goToHomeScreen = false;
				if(!(fNameEdit.getText()!=null && fNameEdit.getText().length() > 0)){
					fNameEdit.setError("First Name is required");
				}else if(!(lNameEdit.getText()!=null && lNameEdit.getText().length() > 0)){
					lNameEdit.setError("Last Name is required");
				}else if(!(email.getText()!=null && email.getText().length() > 0)){
					email.setError("Email is required");
				}else if(!isValidEmail(email.getText().toString())){
					email.setError("Invalid Email");
				}
				else if(!(password.getText()!=null && password.getText().length() >= 6)){
					password.setError("Password is required && should be 6 or more characters ");
				}else if(!(confirmPassword.getText()!=null && confirmPassword.getText().length() >=6)){
					confirmPassword.setError("Confirm Password is required && should be 6 or more characters ");
				}else if(!(password.getText().toString().equals(confirmPassword.getText().toString()))){
					confirmPassword.setError(" Password && Confirm Password are not same");
				}else if(!(phoneNumber.getText()!=null && phoneNumber.getText().length() > 0)){
					phoneNumber.setError("Phone Number is required");
				}else if(!isValidPhoneNumber(phoneNumber.toString())){
					phoneNumber.setError(" Invalid Phone Number");	
				}else{
					goToHomeScreen = true;
				}
				
				if(goToHomeScreen){
					Intent homeScreen = new Intent(RegisterActivity.this, HomeActivity.class);
					Log.e("In onCLickView method of RegisterActivity","RegisterActivity");
					startActivity(homeScreen);
				}
			}
		});	
	}
	
	public boolean isValidEmail(String emailString){
		return Patterns.EMAIL_ADDRESS.matcher(emailString).matches();
	}
	
	public boolean isValidPhoneNumber(String phoneNumberString){
		return PhoneNumberUtils.isGlobalPhoneNumber(phoneNumberString);
		
	}
	
	
}
