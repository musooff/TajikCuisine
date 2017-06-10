package msoff.tajikcuisine;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by moses on 9/15/16.
 */
public class Recipe3_3 extends Activity{

    Button[] timerButtons;
    Vibrator vibrator;
    MediaPlayer mp;
    RatingBar ratingBar;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor ratingEditor;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.recipe3_3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // Ads
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8967799784519571~5412961645");
        AdView mAdView = (AdView) findViewById(R.id.adView3_3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mp = MediaPlayer.create(Recipe3_3.this,R.raw.beep);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //loadRating(sharedPreferences,"recipe3_3_rat");
        ratingBar = (RatingBar)findViewById(R.id.recipe3_3_rating);


        float rating = sharedPreferences.getFloat("recipe3_3_rat",0);
        ratingBar.setRating(rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                saveRating(sharedPreferences,"recipe3_3_rat",rating);
                Toast.makeText(Recipe3_3.this,"Бахои Шумо барои Кабоб " + rating + " мебошад.",Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void saveRating(SharedPreferences sp, String recipe_name, float rating){
        ratingEditor = sp.edit();
        ratingEditor.putFloat(recipe_name, rating);
        ratingEditor.commit();
    }


}
