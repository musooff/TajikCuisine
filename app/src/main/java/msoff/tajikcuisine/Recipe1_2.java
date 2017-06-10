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
 * Created by moses on 9/16/16.
 * Tokkabob
 */
public class Recipe1_2 extends Activity{

    Button[] timerButtons;
    Vibrator vibrator;
    MediaPlayer mp;
    RatingBar ratingBar;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor ratingEditor;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.recipe1_2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        timerButtons = new Button[]{(Button)findViewById(R.id.recipe1_2_but_1),
                (Button)findViewById(R.id.recipe1_2_but_2)};


        // Ads
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8967799784519571~5412961645");
        AdView mAdView = (AdView) findViewById(R.id.adView1_2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mp = MediaPlayer.create(Recipe1_2.this,R.raw.beep);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //loadRating(sharedPreferences,"recipe1_1_rat");
        ratingBar = (RatingBar)findViewById(R.id.recipe1_2_rating);


        float rating = sharedPreferences.getFloat("recipe1_2_rat",0);
        ratingBar.setRating(rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                saveRating(sharedPreferences,"recipe1_2_rat",rating);
                Toast.makeText(Recipe1_2.this, "Бахои Шумо барои Токкабоб " + rating + " мебошад.", Toast.LENGTH_SHORT).show();
            }
        });

        for(int j = 0; j< 2; j++) {
            final int finalJ = j;
            timerButtons[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalJ == 0) {
                        Toast.makeText(Recipe1_2.this, "5 дар оби гарм гузоред. Мо низ бади 5 дак хотиррасон мекунем.", Toast.LENGTH_LONG).show();
                        new CountDownTimer(300000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                mp.start();
                                vibrator.vibrate(400);
                                Toast.makeText(Recipe1_2.this, "5 дак хамт шуд, ба даври навбати гузаред.", Toast.LENGTH_LONG).show();
                            }
                        }.start();
                    } else {
                        Toast.makeText(Recipe1_2.this, "40 дак дар оташи нисбатан пасттар дам дихед, мо низ бади 40 дак хотиррасон мекунем.", Toast.LENGTH_LONG).show();
                        new CountDownTimer(2400000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                mp.start();
                                vibrator.vibrate(400);
                                Toast.makeText(Recipe1_2.this, "40 дак хамт шуд, ба даври навбати гузаред.", Toast.LENGTH_LONG).show();
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
