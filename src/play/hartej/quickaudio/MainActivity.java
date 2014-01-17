package play.hartej.quickaudio;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.util.Log;

public class MainActivity extends Activity {
	MediaPlayer superman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.e("Pickle", "at onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //superman.start();	
        superman = MediaPlayer.create(this, R.raw.superman);
    }
    
    public void startAudio(View v) {
    	Log.e("Pickle", "at startAudio");
    	if(superman.isPlaying()){
    		Log.e("Player", "Audio is playing");
    	}else{
    		superman.start();
    	}
    }
    
    public void stopAudio(View v) {
    	Log.e("Pickle", "at stopAudio");
    	if(superman.isPlaying()) {
    		superman.stop();
    		superman.prepareAsync();
    	}
    	//superman.reset();
    }
    
    
    //@Override
    //protected void onResume() {
    	//superman.start();
    	//super.onResume();
    //}

    //@Override
    //protected void onPause() {
    	//superman.stop();
    	//super.onPause();
    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void openDC(View v) {
    	String url = "http://www.dccomics.com/characters/superman";
    	Intent i = new Intent(Intent.ACTION_VIEW);
    	i.setData(Uri.parse(url));
    	startActivity(i);
    }
    
}
