package myweb.csuchico.edu;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class CharacterView extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_layout);
        
      //create shared preference object
        prefs = this.getSharedPreferences("myweb.csuchico.edu", Context.MODE_PRIVATE);
       
        
        
         strengthaView=(TextView)findViewById (R.id.strengthaView);
         strengthaView.setText("Arms Strength ---" + prefs.getInt("myweb.csuchico.edu.strengtha_Level", 0));
         
         strengthlView=(TextView)findViewById (R.id.strengthlView);
         strengthlView.setText("Legs Strength ---" + prefs.getInt("myweb.csuchico.edu.strengthl_Level", 0));
         
         agilityView=(TextView)findViewById (R.id.agilityView);
         agilityView.setText("Agility ---" + prefs.getInt("myweb.csuchico.edu.agility_Level", 0));
         
         defenseView=(TextView)findViewById (R.id.defenseView);
         defenseView.setText("Defense ---" + prefs.getInt("myweb.csuchico.edu.defense_Level", 0));
         
         healthView=(TextView)findViewById (R.id.healthView);
         healthView.setText("health ---" + prefs.getInt("myweb.csuchico.edu.health_Level", 0));
         
         userLevel=(TextView)findViewById (R.id.userLevel);
         userLevel.setText("userLevel ---" + prefs.getInt("myweb.csuchico.edu.users_Level", 0));
         
         userExp=(TextView)findViewById (R.id.userExp);
         userExp.setText("userExp ---" + prefs.getInt("myweb.csuchico.edu.users_Exp", 0));
    
    
    }
    
    private TextView strengthaView,strengthlView,agilityView,defenseView,healthView,userLevel,userExp;
    private SharedPreferences prefs;
}
