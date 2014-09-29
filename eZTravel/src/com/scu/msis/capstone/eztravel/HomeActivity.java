
package com.scu.msis.capstone.eztravel;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * @author Brunda
 *
 */
public class HomeActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.e("HomeActivity.onCreate", "Start");
		setContentView(R.layout.home);
	}

}
