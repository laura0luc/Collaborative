package edu.itesm.collaborative;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashActivity extends Activity {
	private Handler h= new Handler(){
		public void handleMessage(Message m){
			switch(m.what){
			case 1:
				Intent i= new Intent(getApplicationContext(), TaskActivity.class);
				startActivity(i);
				break;
			}
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Message m= new Message();
		m.what=1;
		h.sendMessageDelayed(m, 3000);
	}

}
