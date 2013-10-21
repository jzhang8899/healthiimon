package myweb.csuchico.edu;

// Resource Library from 3 pillar global
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import android.graphics.Color;

public class SocialView extends Activity 
{
    // SocialAuth Component
    SocialAuthAdapter receiver;
    //private Button cancel;
    
    // Android Components
    Button update;
    EditText edit;
    public void cancelText (View view)
    {
    	edit = (EditText) findViewById(R.id.editTxt);
        edit.setText("");
    }
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_layout);
        
        // Introduction message
        TextView textview = (TextView) findViewById(R.id.text);
        textview.setText("Connect any provider and then press Update button to Share Update.");

        // Create Share Button
        Button share = (Button) findViewById(R.id.sharebutton);
        
        // Add it to Library
        receiver = new SocialAuthAdapter(new ResponseListener());
        
        // Add providers
        receiver.addProvider(Provider.FACEBOOK, R.drawable.facebook);
        receiver.addProvider(Provider.TWITTER, R.drawable.twitter);
        receiver.addProvider(Provider.LINKEDIN, R.drawable.linkedin);

        // Providers require setting user call Back url
        receiver.addCallBack(Provider.TWITTER, "http://dummysite.com");

        // Enable Provider
        receiver.enable(share);
    }
    private final class ResponseListener implements DialogListener
    {
       
    	public void onComplete(Bundle values) 
        {
            Log.d("ShareButton", "Authentication Successful");
            
            // Get name of provider after authentication
            final String providerName = values.getString(SocialAuthAdapter.PROVIDER);
            Log.d("ShareButton", "Provider Name = " + providerName);
            
            // Toast.Length_Long = Ox00000001 second by default
            Toast.makeText(SocialView.this, providerName + " connected", Toast.LENGTH_LONG).show();
            
            update = (Button) findViewById(R.id.update);
            edit = (EditText) findViewById(R.id.editTxt);
            
            update.setOnClickListener(new OnClickListener() 
            {
				public void onClick(View v) 
                {
                    receiver.updateStatus(edit.getText().toString(), new MessageListener(), false);
                }
            });
            

        }
        
        public void onError(SocialAuthError error) 
        {
            Log.d("ShareButton", "Authentication Error: " + error.getMessage());
        }
        public void onCancel() 
        {
            Log.d("ShareButton", "Authentication Cancelled");
        }
        public void onBack() 
        {
            Log.d("ShareButton", "Dialog Closed by pressing Back Key");
        }
    }

    // To get status of message after authentication
    private final class MessageListener implements SocialAuthListener<Integer> 
    {
        //Wait the ack from providers
    	public void onExecute(String provider, Integer t) 
        {
            Integer status = t;
            // server/port socket return 200,201,204
            if (status.intValue() == 200 || status.intValue() == 201 || status.intValue() == 204)
            {
                Toast.makeText(SocialView.this, "Message posted on " + provider, Toast.LENGTH_LONG).show();
                edit = (EditText) findViewById(R.id.editTxt);
                edit.setText("");
            }
             else
                Toast.makeText(SocialView.this, "Message not posted on " + provider, Toast.LENGTH_LONG).show();
        }
        public void onError(SocialAuthError error) 
        {
        	Log.d("ShareButton", "Authentication Error: " + error.getMessage());
        }
    }


}


