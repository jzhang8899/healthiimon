package myweb.csuchico.edu;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class InputView extends Activity implements OnClickListener {
 
	String names,attr1,attr2; ///Initializing variables for the textview
	int exerciseNo=0;
	

	
    
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.input_view);
	        
	      //create shared preference object
	         prefs = this.getSharedPreferences("myweb.csuchico.edu", Context.MODE_PRIVATE);
	        
	        ///Getting Extras from Intent passed in the previous activity
	        Bundle extras = getIntent().getExtras();
	        if (extras != null) {
	            names = extras.getString("exercisename");
	            attr1=extras.getString("exerciseAttr1");
	            attr2=extras.getString("exerciseAttr2");
	            exerciseNo=extras.getInt("exerciseNo");
	        }
	       
	        //Submit Button Object Setup
	        submit=(Button)findViewById(R.id.submit);
	        submit.setOnClickListener(this);
	        
	        //Cancle Button Object Setup
	        cancel=(Button)findViewById(R.id.cancel);
	        cancel.setOnClickListener(this);
	        
	        //Display Parameter 1
	        exerciseName=(TextView)findViewById(R.id.exerciseName);
	        exerciseName.setText(names);
	        
	        //Display Parameter 2
	        exerciseAttribute1=(TextView)findViewById(R.id.exerciseAttribute1);
	        exerciseAttribute1.setText(attr1);
	        
	        //Dispaly Parameter 3
	        exerciseAttribute2=(TextView)findViewById(R.id.exerciseAttribute2);
	        exerciseAttribute2.setText(attr2);
	        
	        parameter1=(EditText)findViewById(R.id.parameter1);
	        parameter2=(EditText)findViewById(R.id.parameter2);
	    }

	    public void onClick(View v) {
	    	

			// find out which button was pushed based on its ID
			if (v.getId()== R.id.submit) {
				
				///get the two values input by the user
				int x=Integer.parseInt(parameter1.getText().toString());
			  //  exerciseName.setText(parameter1.getText());
			    
			    int y =Integer.parseInt(parameter2.getText().toString());
			    
			    calculateEnergy(x,y);
			    finish();
			}
			
			if (v.getId()== R.id.cancel) {
				finish();
			}
			
		}   
	    
	    /*Note Pass parameters in this order to the saveStats function
	     * 	   1)Strength(Arms)
	           2)Strength(Legs)
	           3)Agility
	           4)Defence
	           5)Stamina
	           6)Health */
	    private void calculateEnergy(int param1,int param2)
	    {
	      
	      
	      //Initializing variables to zero
	      int strengtha=0;
	      int strengthl =0;
	      int agility=0;
	      int defense=0;
	      //int stamina=0;
	      int health=0;
	      
	      switch(exerciseNo)
	      {
	      case 1:
    			int  m= param1+param2;
    			exerciseName.setText(Integer.toString(m));
    			break;

    		case 2:
    			
    			int bicepCurl_Level=prefs.getInt("myweb.csuchico.edu.bicepCurl_Level", 0);
    			int bicepCurl_Exp=prefs.getInt("myweb.csuchico.edu.bicepCurl_Exp", 0);
    			strengtha = (param1 * param2) / (bicepCurl_Level * 3 + 20);
    			defense = strengtha/20;

    			bicepCurl_Exp = bicepCurl_Exp + strengtha + defense;

    			while(bicepCurl_Exp >= 100){
	  	    		bicepCurl_Exp = bicepCurl_Exp - 100;
	  	    		bicepCurl_Level++;
	  	    	}
    			
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.bicepCurl_Level", bicepCurl_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.bicepCurl_Exp", bicepCurl_Exp).commit();
    		    break;   

    		case 3:
    			int tricepExtension_Level=prefs.getInt("myweb.csuchico.edu.tricepExtension_Level", 0);
    			int tricepExtension_Exp=prefs.getInt("myweb.csuchico.edu.tricepExtension_Exp", 0);
    			strengtha = (param1 * param2) / (tricepExtension_Level * 2 + 15);
    			defense = strengtha/20;

    			tricepExtension_Exp = tricepExtension_Exp + strengtha + defense;

    			while(tricepExtension_Exp >= 100){
  	    		tricepExtension_Exp = tricepExtension_Exp - 100;
  	    		tricepExtension_Level++;
  	    	}
    			prefs.edit().putInt("myweb.csuchico.edu.tricepExtension_Level", tricepExtension_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.tricepExtension_Exp", tricepExtension_Exp).commit();
    			break;   

    		case 4:
    			int shoulderPress_Level=prefs.getInt("myweb.csuchico.edu.shoulderPress_Level", 0);
    			int shoulderPress_Exp=prefs.getInt("myweb.csuchico.edu.shoulderPress_Exp", 0);
    			strengtha = (param1 * param2) / (shoulderPress_Level * 4 + 30);
    			defense = strengtha/10;
    			agility = strengtha/20;

    			shoulderPress_Exp = shoulderPress_Exp + strengtha + defense + agility;

    			while(shoulderPress_Exp >= 100){
  	    		shoulderPress_Exp = shoulderPress_Exp - 100;
  	    		shoulderPress_Level++;
  	    	}
    			prefs.edit().putInt("myweb.csuchico.edu.shoulderPress_Level", shoulderPress_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.shoulderPress_Exp", shoulderPress_Exp).commit();
    			break;

    		case 5:
    			int tricepDips_Level=prefs.getInt("myweb.csuchico.edu.tricepDips_Level", 0);
    			int tricepDips_Exp=prefs.getInt("myweb.csuchico.edu.tricepDips_Exp", 0);
    			strengtha = (param1 * param2) / (tricepDips_Level * 5 + 100);
    			defense = strengtha/10;
    			agility = strengtha/20;

    			tricepDips_Exp = tricepDips_Exp + strengtha + defense + agility;

    			while(tricepDips_Exp >= 100){
  	    		tricepDips_Exp = tricepDips_Exp - 100;
  	    		tricepDips_Level++;
  	    	}
    			
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.tricepDips_Level", tricepDips_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.tricepDips_Exp", tricepDips_Exp).commit();
    			break;

    		case 6:
    			int shoulderExtend_Level=prefs.getInt("myweb.csuchico.edu.shoulderExtend_Level", 0);
    			int shoulderExtend_Exp=prefs.getInt("myweb.csuchico.edu.shoulderExtend_Exp", 0);
    			strengtha = (param1 * param2) / (shoulderExtend_Level * 2 + 20);
    			defense = strengtha/20;
    			agility = strengtha/10;

    			shoulderExtend_Exp = shoulderExtend_Exp + strengtha + defense + agility;

    			while(shoulderExtend_Exp >= 100){
  	    		shoulderExtend_Exp = shoulderExtend_Exp - 100;
  	    		shoulderExtend_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.shoulderExtend_Level", shoulderExtend_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.shoulderExtend_Exp", shoulderExtend_Exp).commit();
    			break;

    		case 7:
    			int pushUp_Level=prefs.getInt("myweb.csuchico.edu.pushUp_Level", 0);
    			int pushUp_Exp=prefs.getInt("myweb.csuchico.edu.pushUp_Exp", 0);
    			strengtha = (sqrt(param1) * param2) / (pushUp_Level * 2 + 15);
    			defense = strengtha/10;
    			agility = strengtha/20;

    			pushUp_Exp = pushUp_Exp + strengtha + defense + agility;

    			while(pushUp_Exp >= 100){
  	    		pushUp_Exp = pushUp_Exp - 100;
  	    		pushUp_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.pushUp_Level", pushUp_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.pushUp_Exp",pushUp_Exp).commit();
    			break;

    		case 8:
    			int bench_Level = prefs.getInt("myweb.csuchico.edu.bench_Level", 0);
    			int bench_Exp = prefs.getInt("myweb.csuchico.edu.bench_Exp", 0);
    			strengtha = (param1 * param2) / (bench_Level * 4 + 40);
    			defense = strengtha/10;
    			agility = strengtha/20;

    			bench_Exp = bench_Exp + strengtha + defense + agility;

    			while(bench_Exp >= 100){
  	    		bench_Exp = bench_Exp - 100;
  	    		bench_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.bench_Level", bench_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.bench_Exp", bench_Exp).commit();
    			break;

    		case 9:
    			int dumbbellFlys_Level = prefs.getInt("myweb.csuchico.edu.dumbbellFlys_Level", 0);
    			int dumbbellFlys_Exp = prefs.getInt("myweb.csuchico.edu.dumbbellFlys_Exp", 0);
    			strengtha = (param1 * param2) / (dumbbellFlys_Level * 2 + 10);
    			defense = strengtha/20;
    			agility = strengtha/10;

    			dumbbellFlys_Exp = dumbbellFlys_Exp + strengtha + defense + agility;

    			while(dumbbellFlys_Exp >= 100){
  	    		dumbbellFlys_Exp = dumbbellFlys_Exp - 100;
  	    		dumbbellFlys_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.dumbbellFlys_Level", dumbbellFlys_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.dumbbellFlys_Exp", dumbbellFlys_Exp).commit();
    			break;
   
    		case 10:
    			int pullUp_Level = prefs.getInt("myweb.csuchico.edu.pullUp_Level", 0);
    			int pullUp_Exp = prefs.getInt("myweb.csuchico.edu.pullUp_Exp", 0);
    			defense = (param1 * param2) / (pullUp_Level * 4 + 30);
    			agility = defense/20;

    			pullUp_Exp = pullUp_Exp + defense + agility;

    			while(pullUp_Exp >= 100){
  	    		pullUp_Exp = pullUp_Exp - 100;
  	    		pullUp_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.pullUp_Level", pullUp_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.pullUp_Exp", pullUp_Exp).commit();
    			break;

    		case 11:
    			int chinUp_Level = prefs.getInt("myweb.csuchico.edu.chinUp_Level", 0);
    			int chinUp_Exp = prefs.getInt("myweb.csuchico.edu.chinUp_Exp", 0);
    			defense = (param1 * param2) / (chinUp_Level * 5 + 100);
    			agility = defense/15;

    			chinUp_Exp = chinUp_Exp + defense + agility;

    			while(chinUp_Exp >= 100){
  	    		chinUp_Exp = chinUp_Exp - 100;
  	    		chinUp_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.chinUp_Level", chinUp_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.chinUp_Exp", chinUp_Exp).commit();
    			break;

    		case 12:
    			int seatedRows_Level=prefs.getInt("myweb.csuchico.edu.seatedRows_Level", 0);
    			int seatedRows_Exp=prefs.getInt("myweb.csuchico.edu.seatedRows_Exp", 0);
    			defense = (param1 * param2) / (seatedRows_Level * 3 + 50);
    			agility = defense/10;

    			seatedRows_Exp = seatedRows_Exp + defense + agility;

    			while(seatedRows_Exp >= 100){
  	    		seatedRows_Exp = seatedRows_Exp - 100;
  	    		seatedRows_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.seatedRows_Level", seatedRows_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.seatedRows_Exp", seatedRows_Exp).commit();
    			break;

    		case 13:
    			int shrugs_Level=prefs.getInt("myweb.csuchico.edu.shrugs_Level", 0);
    			int shrugs_Exp=prefs.getInt("myweb.csuchico.edu.shrugs_Exp", 0);
    			defense = (param1 * param2) / (shrugs_Level * 5 + 100);
    			agility = defense/10;

    			shrugs_Exp = shrugs_Exp + defense + agility;

    			while(shrugs_Exp >= 100){
  	    		shrugs_Exp = shrugs_Exp - 100;
  	    		shrugs_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.shrugs_Level", shrugs_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.shrugs_Exp", shrugs_Exp).commit();
    			break;

    		case 14:
    			int sitUp_Level=prefs.getInt("myweb.csuchico.edu.sitUp_Level", 0);
    			int sitUp_Exp=prefs.getInt("myweb.csuchico.edu.sitUp_Level", 0);
    			defense = (sqrt(param1) * param2) / (sitUp_Level * 2 + 10);
    			agility = defense/10;

    			sitUp_Exp = sitUp_Exp + defense + agility;

    			while(sitUp_Exp >= 100){
  	    		sitUp_Exp = sitUp_Exp - 100;
  	    		sitUp_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.sitUp_Level", sitUp_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.sitUp_Exp", sitUp_Exp).commit();
    			break;

    		case 15:
    			int crunches_Level=prefs.getInt("myweb.csuchico.edu.crunches_Level", 0);
    			int crunches_Exp=prefs.getInt("myweb.csuchico.edu.crunches_Exp", 0);
    			defense = (sqrt(param1) * param2) / (crunches_Level * 5 + 10);
    			agility = defense/10;

    			crunches_Exp = crunches_Exp + defense + agility;

    			while(crunches_Exp >= 100){
  	    		crunches_Exp = crunches_Exp - 100;
  	    		crunches_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.crunches_Level", crunches_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.crunches_Exp", crunches_Exp).commit();
    			break;

    		case 16:
    			int squats_Level=prefs.getInt("myweb.csuchico.edu.squats_Level", 0);
    			int squats_Exp=prefs.getInt("myweb.csuchico.edu.squats_Exp", 0);
    			strengthl = (param1 * param2) / (squats_Level * 3 + 50);
    			defense = strengthl/10;

    			squats_Exp = squats_Exp + strengthl + defense;

    			while(squats_Exp >= 100){
  	    		squats_Exp = squats_Exp - 100;
  	    		squats_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.squats_Level", squats_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.squats_Exp", squats_Exp).commit();
    			break;

    		case 17:
    			int legExtension_Level=prefs.getInt("myweb.csuchico.edu.legExtension_Level", 0);
    			int legExtension_Exp=prefs.getInt("myweb.csuchico.edu.legExtension_Level", 0);
    			strengthl = (param1 * param2) / (legExtension_Level * 5 + 30);
    			defense = strengthl/20;
    			agility = strengthl/20;

    			legExtension_Exp = legExtension_Exp + strengthl + defense + agility;

    			while(legExtension_Exp >= 100){
  	    		legExtension_Exp = legExtension_Exp - 100;
  	    		legExtension_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.legExtension_Level", legExtension_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.legExtension_Exp", legExtension_Exp).commit();
    			break;

    		case 18:
    			int legCurls_Level=prefs.getInt("myweb.csuchico.edu.legCurls_Level", 0);
    			int legCurls_Exp=prefs.getInt("myweb.csuchico.edu.legCurls_Exp", 0);
    			strengthl = (param1 * param2) / (legCurls_Level * 5 + 30);
    			defense = strengthl/20;
    			agility = strengthl/20;

    			legCurls_Exp = legCurls_Exp + strengthl + defense + agility;

    			while(legCurls_Exp >= 100){
  	    		legCurls_Exp = legCurls_Exp - 100;
  	    		legCurls_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.legCurls_Level", legCurls_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.legCurls_Exp", legCurls_Exp).commit();
    			break;

    		case 19:
    			int running_Level=prefs.getInt("myweb.csuchico.edu.running_Level", 0);
    			int running_Exp=prefs.getInt("myweb.csuchico.edu.running_Exp", 0);
    			agility = param1 * 1000 / param2 / running_Level;
    			health = agility/10;
    			strengthl = agility/10;

    			running_Exp = running_Exp + agility + health + strengthl;

    			while(running_Exp >= 100){
  	    		running_Exp = running_Exp - 100;
  	    		running_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.running_Level", running_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.runing_Exp", running_Exp).commit();
    			break;

    		case 20:
    			int swimming_Level=prefs.getInt("myweb.csuchico.edu.swimming_Level", 0);
    			int swimming_Exp=prefs.getInt("myweb.csuchico.edu.swimming_Exp", 0);
    			agility = param2 * 10 / swimming_Level;
    			health = agility/10;
    			defense = agility/10;

    			swimming_Exp = swimming_Exp + agility + health + defense;

    			while(swimming_Exp >= 100){
  	    		swimming_Exp = swimming_Exp - 100;
  	    		swimming_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.swimming_Level", swimming_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.swimming_Exp", swimming_Exp).commit();
    			break;

    		case 21:
    			int biking_Level=prefs.getInt("myweb.csuchico.edu.biking_Level", 0);
    			int biking_Exp=prefs.getInt("myweb.csuchico.edu.biking_Exp", 0);
    			agility = (param1 * 500 / param2) /biking_Level;
    			health = agility/20;
    			strengthl = agility/20;

    			biking_Exp = biking_Exp + agility + health + strengthl;

    			while(biking_Exp >= 100){
  	    		biking_Exp = biking_Exp - 100;
  	    		biking_Level++;
  	    	}
    			//save exercise values to preferences
    			prefs.edit().putInt("myweb.csuchico.edu.biking_Level", biking_Level).commit();
    			prefs.edit().putInt("myweb.csuchico.edu.biking_Exp", biking_Exp).commit();
    			break;

    		default:break;					   

    	} 	       
    saveStats(strengtha,strengthl,agility, defense,health);
  }


  private int sqrt(int param1) {
		// TODO Auto-generated method stub
		return 0;
	}

	///Saves stats to file for further use
  private void saveStats(int strengtha,int strengthl,int agility,int defense,int health)
  {
  	// Temp variable for user level to see if they leveled up
  	int tmp_userLevel = 0;
  	int users_Exp=prefs.getInt("myweb.csuchico.edu.users_Exp", 0);
  	int users_Agility=prefs.getInt("myweb.csuchico.edu.agility_Level", 0);
  	int users_ArmStrength=prefs.getInt("myweb.csuchico.edu.strengtha_Level", 0);
  	int users_LegStrength=prefs.getInt("myweb.csuchico.edu.strengthl_Level", 0);
  	int users_Health=prefs.getInt("myweb.csuchico.edu.health_Level", 0);
  	int users_Defense=prefs.getInt("myweb.csuchico.edu.defense_Level", 0);
    int userLevel=prefs.getInt("myweb.csuchico.edu.users_Level", 0);

  	// Let user know what exp they received for exercise
  	// Pop up alert that looks like so:

  	//-------------------------------------
  	// 				Exp Awarded
  	//-------------------------------------
  	// Arm Strength: strengtha
  	// Leg Strength: strengthl
  	// Agility:		 agility
  	// Defense:		 defense
  	// Health: 		 health
  	//-------------------------------------
  	//					OK
  	//-------------------------------------



  	// Set new exp = left_over_exp + new exp so you can add correct exp
  	strengtha += prefs.getInt("myweb.csuchico.edu.strengtha", 0);
  	strengthl +=prefs.getInt("myweb.csuchico.edu.strengthl", 0);
  	agility   +=prefs.getInt("myweb.csuchico.edu.agility", 0);
  	defense +=prefs.getInt("myweb.csuchico.edu.defense", 0);
  	health +=prefs.getInt("myweb.csuchico.edu.health", 0);

  	// Increase Statistic Level for every 100 points
  	while(strengtha >= 100){
  		strengtha = strengtha - 100;
  		users_ArmStrength++;
  		users_Exp++;
  	}
  	while(strengthl >= 100){
  		strengthl = strengthl - 100;
  		users_LegStrength++;
  		users_Exp++;
  	}
  	while(agility >= 100){
  		agility = agility - 100;
  		users_Agility++;
  		users_Exp++;
  	}
  	while(defense >= 100){
  		defense = defense - 100;
  		users_Defense++;
  		users_Exp++;
  	}
  	while(health >= 100){
  		health = health - 100;
  		users_Health ++;
  		users_Exp++;
  	}

  
  	// Save left over exercise exp in corresponding extra_variable
  	prefs.edit().putInt("myweb.csuchico.edu.strengtha", strengtha).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.strengthl", strengthl).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.agility", agility).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.defense", defense).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.health", health).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.health_Level", users_Health).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.defense_Level", users_Defense).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.agility_Level", users_Agility).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.strengtha_Level", users_ArmStrength).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.strengthl_Level", users_LegStrength).commit();
  	prefs.edit().putInt("myweb.csuchico.edu.users_Exp", users_Exp).commit();
  	// Upgrade user level if need be
  	
  		if (users_Exp<4) tmp_userLevel = 1;
  		else if(users_Exp>3 && users_Exp<9) tmp_userLevel = 2;
  			
  		else if(users_Exp>8 && users_Exp<16) tmp_userLevel = 3;
  			
  		else if(users_Exp>15 && users_Exp<25) tmp_userLevel = 4;
  			
  		else if (users_Exp>24 && users_Exp<36) tmp_userLevel = 5;
  			
  		else if (users_Exp>35 && users_Exp<49) tmp_userLevel = 6;
  			
  		else if (users_Exp>48 && users_Exp<64) tmp_userLevel = 7;
  		
  		else if  (users_Exp>63 && users_Exp<81) tmp_userLevel = 8;
  			
  		else if  (users_Exp>80 && users_Exp<100) tmp_userLevel = 9;
  			
  		else if (users_Exp>99 && users_Exp<121) tmp_userLevel = 10;
  			
  		else if (users_Exp>120 && users_Exp<144) tmp_userLevel = 11;
  			
  		else if  (users_Exp>143 && users_Exp<168) tmp_userLevel = 12;
  			
  		else if  (users_Exp>167 && users_Exp<196) tmp_userLevel = 13;
  			
  		else if  (users_Exp>195 && users_Exp<225) tmp_userLevel = 14;
  			
  		else if  (users_Exp>224 && users_Exp<256) tmp_userLevel = 15;
  			
  		else if (users_Exp>255 && users_Exp<289) tmp_userLevel = 16;
  			
  		else if  (users_Exp>288 && users_Exp<324) tmp_userLevel = 17;
  			
  		else if ( users_Exp>323 && users_Exp<361) tmp_userLevel = 18;
  		
  		else if  (users_Exp>360 && users_Exp<400) tmp_userLevel = 19;
  			
  		else   tmp_userLevel = 20;
  		
  		
  		//else  break;/* User is higher level than 20 or an error occurred*/
  	
  	// Congratulate user on leveling up if need be
  	if (tmp_userLevel != userLevel)
  	{
  		// Then user must have leveled up
  		// Set user level equal to new level
  		userLevel = tmp_userLevel;
  		prefs.edit().putInt("myweb.csuchico.edu.users_Level", userLevel).commit();
  		

  		// Let user know what level reached
  		// Pop up alert that looks like so:

	    	//-------------------------------------
	    	// 			Congratulations!
	    	//-------------------------------------
	    	// 		You Have Reached Level...
	    	// 
	    	// 
	    	// 				userLevel
	    	// 
	    	//-------------------------------------
	    	//					OK
	    	//-------------------------------------
  	}
  }
  private SharedPreferences prefs;
  private Button submit,cancel;
  private TextView exerciseName,exerciseAttribute1,exerciseAttribute2;
  private EditText parameter1,parameter2;
}