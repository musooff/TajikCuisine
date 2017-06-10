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
 * Created by moses on 22/09/2016.
 *
 * Translation was done by Abdulvosit Ismoilov
 */
public class Recipe2_0 extends Activity {
    Button[] timerButtons;
    Vibrator vibrator;
    MediaPlayer mp;
    RatingBar ratingBar;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor ratingEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe2_0);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // Ads
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8967799784519571~5412961645");
        AdView mAdView = (AdView) findViewById(R.id.adView2_0);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        timerButtons = new Button[]{(Button)findViewById(R.id.recipe2_0_but_1)};


        mp = MediaPlayer.create(Recipe2_0.this,R.raw.beep);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //loadRating(sharedPreferences,"recipe1_1_rat");
        ratingBar = (RatingBar)findViewById(R.id.recipe2_0_rating);


        float rating = sharedPreferences.getFloat("recipe2_0_rat",0);
        ratingBar.setRating(rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                saveRating(sharedPreferences,"recipe2_0_rat",rating);
                Toast.makeText(Recipe2_0.this, "Бахои Шумо барои Шурбо " + rating + " мебошад.", Toast.LENGTH_SHORT).show();
            }
        });

        for(int j = 0; j< 1; j++) {
            timerButtons[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Toast.makeText(Recipe2_0.this, "40 дак дар оташи нисбатан пасттар дам дихед, мо низ бади 40 дак хотиррасон мекунем.", Toast.LENGTH_LONG).show();
                        new CountDownTimer(2400000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                mp.start();
                                vibrator.vibrate(400);
                                Toast.makeText(Recipe2_0.this, "40 дак хамт шуд, ба даври навбати гузаред.", Toast.LENGTH_LONG).show();
                            }
                        }.start();

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
