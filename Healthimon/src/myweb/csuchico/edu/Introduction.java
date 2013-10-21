package myweb.csuchico.edu;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Introduction extends Activity implements OnClickListener {

	private Button start;
	MediaPlayer player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introduction);
		
		start=(Button)findViewById(R.id.start);
		start.setOnClickListener(this);
		
		// instantiate a MediaPlayer instance
		player = MediaPlayer.create(getApplicationContext(), R.raw.maya);
		player.setLooping(true);
		player.start();
		
		//Creating Shared Preferences and initializing them
		String isFirstTime = "myweb.csuchico.edu.firstTime";

		String bicepCurl_Exp = "myweb.csuchico.edu.bicepCurl_Exp";
		String bicepCurl_Level = "myweb.csuchico.edu.bicepCurl_Level";

		String tricepExtension_Exp = "myweb.csuchico.edu.tricepExtension";
		String tricepExtension_Level = "myweb.csuchico.edu.tricepExtension";

		String shoulderPress_Exp = "myweb.csuchico.edu.shoulderPress_Exp";
		String shoulderPress_Level = "myweb.csuchico.edu.shoulderPress_Level";

		String tricepDips_Exp = "myweb.csuchico.edu.tricepDips_Exp";
		String tricepDips_Level = "myweb.csuchico.edu.tricepDips_Level";

		String shoulderExtend_Exp = "myweb.csuchico.edu.shoulderExtend_Exp";
		String shoulderExtend_Level = "myweb.csuchico.edu.shoulderExtend_Level";

		String pushUp_Exp = "myweb.csuchico.edu.pushUp_Exp";
		String pushUp_Level = "myweb.csuchico.edu.pushUp_Level";

		String bench_Exp = "myweb.csuchico.edu.bench_Exp";
		String bench_Level = "myweb.csuchico.edu.bench_Level";

		String dumbbellFlys_Exp = "myweb.csuchico.edu.dumbbellFlys_Exp";
		String dumbbellFlys_Level = "myweb.csuchico.edu.dumbbellFlys_Level";

		String pullUp_Exp = "myweb.csuchico.edu.pullUp_Exp";
		String pullUp_Level = "myweb.csuchico.edu.pullUp_Level";

		String chinUp_Exp = "myweb.csuchico.edu.chinUp_Exp";
		String chinUp_Level = "myweb.csuchico.edu.chinUp_Level";

		String seatedRows_Exp = "myweb.csuchico.edu.seatedRows_Exp";
		String seatedRows_Level = "myweb.csuchico.edu.seatedRows_Level";

		String shrugs_Exp = "myweb.csuchico.edu.shrugs_Exp";
		String shrugs_Level = "myweb.csuchico.edu.shrugs_Level";

		String sitUp_Exp = "myweb.csuchico.edu.sitUp_Exp";
		String sitUp_Level = "myweb.csuchico.edu.sitUp_Level";

		String crunches_Exp = "myweb.csuchico.edu.crunches_Exp";
		String crunches_Level = "myweb.csuchico.edu.crunches_Level";

		String squats_Exp = "myweb.csuchico.edu.squats_Exp";
		String squats_Level = "myweb.csuchico.edu.squats_Level";

		String legExtension_Exp = "myweb.csuchico.edu.legExtension_Exp";
		String legExtension_Level = "myweb.csuchico.edu.legExtension_Level";

		String legCurls_Exp = "myweb.csuchico.edu.legCurls_Exp";
		String legCurls_Level = "myweb.csuchico.edu.legCurls_Level";

		String running_Exp = "myweb.csuchico.edu.running_Exp";
		String running_Level = "myweb.csuchico.edu.running_Level";

		String swimming_Exp = "myweb.csuchico.edu.swimming_Exp";
		String swimming_Level = "myweb.csuchico.edu.swimming_Level";

		String biking_Exp = "myweb.csuchico.edu.biking_Exp";
		String biking_Level = "myweb.csuchico.edu.biking_Level";

		String strengtha = "myweb.csuchico.edu.strengtha";
		String strengtha_Level = "myweb.csuchico.edu.strengtha_Level";

		String strengthl= "myweb.csuchico.edu. strengthl";
		String strengthl_Level = "myweb.csuchico.edu.strengthl_Level";

		String agility = "myweb.csuchico.edu.agility";
		String agility_Level = "myweb.csuchico.edu.agility_Level";

		String defense = "myweb.csuchico.edu.defense";
		String defense_Level = "myweb.csuchico.edu.defense_Level";

		String health = "myweb.csuchico.edu.health";
		String health_Level = "myweb.csuchico.edu.health_Level";

		String users_Exp = "myweb.csuchico.edu.users_Exp";
		String user_Level = "myweb.csuchico.edu.users_Level";

		//save preferences for the first time
		SharedPreferences prefs = this.getSharedPreferences("myweb.csuchico.edu", Context.MODE_PRIVATE);
		Boolean isFirstTimeCheck=prefs.getBoolean(isFirstTime, true);
		if (isFirstTimeCheck==true){
			int defaultLevel = 1; 
			int defaultExp = 0; 
			
			prefs.edit().putInt(bicepCurl_Level , defaultLevel).commit(); 
			prefs.edit().putInt(bicepCurl_Exp , defaultExp).commit();
			
			prefs.edit().putInt(tricepExtension_Level , defaultLevel).commit(); 
			prefs.edit().putInt(tricepExtension_Exp , defaultExp).commit();
	
			prefs.edit().putInt(shoulderPress_Level , defaultLevel).commit(); 
			prefs.edit().putInt(shoulderPress_Exp , defaultExp).commit();
	
			prefs.edit().putInt(tricepDips_Level , defaultLevel).commit(); 
			prefs.edit().putInt(tricepDips_Exp , defaultExp).commit();
	
			prefs.edit().putInt(shoulderExtend_Level , defaultLevel).commit(); 
			prefs.edit().putInt(shoulderExtend_Exp , defaultExp).commit();
	
			prefs.edit().putInt(pushUp_Level , defaultLevel).commit(); 
			prefs.edit().putInt(pushUp_Exp , defaultExp).commit();
	
			prefs.edit().putInt(pushUp_Level , defaultLevel).commit(); 
			prefs.edit().putInt(pushUp_Exp , defaultExp).commit();
	
			prefs.edit().putInt(bench_Level , defaultLevel).commit(); 
			prefs.edit().putInt(bench_Exp , defaultExp).commit();
	
			prefs.edit().putInt(dumbbellFlys_Level , defaultLevel).commit(); 
			prefs.edit().putInt(dumbbellFlys_Exp , defaultExp).commit();
	
			prefs.edit().putInt(pullUp_Level , defaultLevel).commit(); 
			prefs.edit().putInt(pullUp_Exp , defaultExp).commit();
	
			prefs.edit().putInt(chinUp_Level , defaultLevel).commit(); 
			prefs.edit().putInt(chinUp_Exp , defaultExp).commit();
	
			prefs.edit().putInt(seatedRows_Level , defaultLevel).commit(); 
			prefs.edit().putInt(seatedRows_Exp , defaultExp).commit();
	
			prefs.edit().putInt(shrugs_Level , defaultLevel).commit(); 
			prefs.edit().putInt(shrugs_Exp , defaultExp).commit();
	
			prefs.edit().putInt(sitUp_Level , defaultLevel).commit(); 
			prefs.edit().putInt(sitUp_Exp , defaultExp).commit();
	
			prefs.edit().putInt(crunches_Level , defaultLevel).commit(); 
			prefs.edit().putInt(crunches_Exp , defaultExp).commit();
	
			prefs.edit().putInt(squats_Level , defaultLevel).commit(); 
			prefs.edit().putInt(squats_Exp , defaultExp).commit();
	
			prefs.edit().putInt(legExtension_Level , defaultLevel).commit(); 
			prefs.edit().putInt(legExtension_Exp , defaultExp).commit();
	
			prefs.edit().putInt(legCurls_Level , defaultLevel).commit(); 
			prefs.edit().putInt(legCurls_Exp , defaultExp).commit();
	
			prefs.edit().putInt(running_Level , defaultLevel).commit(); 
			prefs.edit().putInt(running_Exp , defaultExp).commit();
	
			prefs.edit().putInt(swimming_Level , defaultLevel).commit(); 
			prefs.edit().putInt(swimming_Exp , defaultExp).commit();
	
			prefs.edit().putInt(biking_Level , defaultLevel).commit(); 
			prefs.edit().putInt(biking_Exp , defaultExp).commit();
	
			prefs.edit().putInt(strengtha_Level , defaultLevel).commit(); 
			prefs.edit().putInt(strengtha, defaultExp).commit();
	
			prefs.edit().putInt(strengthl_Level , defaultLevel).commit(); 
			prefs.edit().putInt(strengthl, defaultExp).commit();
	
			prefs.edit().putInt(agility_Level , defaultLevel).commit(); 
			prefs.edit().putInt(agility, defaultExp).commit();
	
			prefs.edit().putInt(defense_Level , defaultLevel).commit(); 
			prefs.edit().putInt(defense, defaultExp).commit();
	
			prefs.edit().putInt(health_Level , defaultLevel).commit(); 
			prefs.edit().putInt(health, defaultExp).commit();
	
			prefs.edit().putInt(user_Level , defaultLevel).commit(); 
			prefs.edit().putInt(users_Exp , defaultExp).commit();
			
			prefs.edit().putBoolean(isFirstTime, false).commit();
		}			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.introduction, menu);
		return true;
	}
	
	public void onClick(View v) {
	

		// find out which button was pushed based on its ID
		if (v.getId()== R.id.start) {
			
			// release the MediaPlayer resource
	    	player.release();
	    	player = null;
			
			Intent i = new Intent(this, AndroidTabLayoutActivity.class);
	    	// start the activity based on the Intent
			startActivity(i);
			finish();
			
			
			
		}

		// notify the user which button was clicked
		
	}

}
