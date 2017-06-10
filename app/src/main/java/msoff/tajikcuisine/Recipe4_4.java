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
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by moses on 23/09/2016.
 *
 * Translation was done By Rustami Ubaydullo
 */
public class Recipe4_4 extends Activity {

    Button[] timerButtons;
    Vibrator vibrator;
    MediaPlayer mp;
    RatingBar ratingBar;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor ratingEditor;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.recipe4_4);
        timerButtons = new Button[]{
                (Button)findViewById(R.id.recipe4_4_but_2)};
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // Ads
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8967799784519571~5412961645");
        AdView mAdView = (AdView) findViewById(R.id.adView4_4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mp = MediaPlayer.create(Recipe4_4.this,R.raw.beep);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //loadRating(sharedPreferences,"recipe4_4_rat");
        ratingBar = (RatingBar)findViewById(R.id.recipe4_4_rating);


        float rating = sharedPreferences.getFloat("recipe4_4_rat",0);
        ratingBar.setRating(rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                saveRating(sharedPreferences,"recipe4_4_rat",rating);
                Toast.makeText(Recipe4_4.this, "Бахои Шумо барои Самбусаи Тухми " + rating + " мебошад.", Toast.LENGTH_SHORT).show();
            }
        });

        for(int j = 0; j< 1; j++){
            final int finalJ = j;
            timerButtons[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalJ == 0){
                        Toast.makeText(Recipe4_4.this,"20 - 25 дак танур ё духогфка гузоред, Мо низ бади 20 дак хотиррасон мекунем.", Toast.LENGTH_LONG).show();
                        new CountDownTimer(1200000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                mp.start();
                                vibrator.vibrate(400);
                                Toast.makeText(Recipe4_4.this,"20 дак хамт шуд, ба даври навбати гузаред.",Toast.LENGTH_LONG).show();
                            }
                        }.start();
                    }
                }
            });
        }

    }

    private void saveRating(SharedPreferences sp, String recipe_name, float rating){
        ratingEditor = sp.edit();
        ratingEditor.putFloat(recipe_name, rating);
        ratingEditor.commit();
    }


}
