package msoff.tajikcuisine;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends AppCompatActivity {


    EditText title,time,mahsulot,step_1;
    LinearLayout relativeLayout;
    NestedScrollView nestedScrollView;
    CardView cardView;
    ImageView imageView;
    TextView im_text;
    int steps = 1;
    DisplayMetrics metrics;

    String[] strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Таоми Шумо");


        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        cardView = (CardView)findViewById(R.id.add_submit);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Test.this,"Дар муддати наздик меояд, Мунтазир бошед!",Toast.LENGTH_SHORT).show();

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                steps++;
                relativeLayout.addView(stepAdder(steps));
                //relativeLayout.addView(stepAdder2(steps));
            }
        });


        imageView = (ImageView)findViewById(R.id.iv_1);
        im_text = (TextView)findViewById(R.id.tv_im_1);
        relativeLayout = (LinearLayout)findViewById(R.id.mylayout);
        title = (EditText)findViewById(R.id.add_title);
        time = (EditText)findViewById(R.id.add_time);
        mahsulot = (EditText)findViewById(R.id.add_mahsulot);
        step_1 = (EditText)findViewById(R.id.add_step_1);
        nestedScrollView = (NestedScrollView) findViewById(R.id.add_scroll);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // camera request and desplay
                Toast.makeText(Test.this,"Дар муддати наздик меояд!",Toast.LENGTH_SHORT).show();
            }
        });


    }

    public EditText stepAdder(int step){
        EditText editText = new EditText(this);
        RelativeLayout.LayoutParams rparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        editText.setLines(5);
        editText.setGravity(Gravity.TOP | Gravity.LEFT);
        editText.setId(step);
        editText.setHint("Зинаи навбати");

        if (step == 2){
            rparams.addRule(RelativeLayout.BELOW,R.id.add_step_1);
        }
        else {
            rparams.addRule(RelativeLayout.BELOW,step-1);
        }
        editText.setLayoutParams(rparams);
        return editText;

    }
    public CardView stepAdder2(int step){
        CardView cardView = new CardView(this);
        FrameLayout.LayoutParams rparams = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rparams.setMargins(getDPI(40,metrics),getDPI(40,metrics),getDPI(40,metrics),getDPI(40,metrics));
        cardView.setLayoutParams(rparams);
        cardView.setCardElevation(getDPI(5,metrics));
        cardView.setRadius(getDPI(5,metrics));


        ImageView imageView = new ImageView(this);
        int dim = getDPI(200,metrics);
        FrameLayout.LayoutParams ivparams = new FrameLayout.LayoutParams(dim,dim);
        imageView.setImageResource(R.drawable.add_image);
        imageView.setLayoutParams(ivparams);
        cardView.addView(imageView);
        rparams.gravity = Gravity.CENTER_HORIZONTAL;

        TextView textView = new TextView(this);
        LinearLayout.LayoutParams tvparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        textView.setTextSize(20);
        textView.setText("Иловаи акс");
        textView.setTextColor(getResources().getColor(R.color.black));
        tvparams.gravity = Gravity.BOTTOM;
        tvparams.setMargins(getDPI(10,metrics),getDPI(10,metrics),getDPI(10,metrics),getDPI(10,metrics));
        textView.setLayoutParams(tvparams);
        cardView.addView(textView);

        return cardView;
    }

    public static int getDPI(int size, DisplayMetrics metrics){
        return (size * metrics.densityDpi) / DisplayMetrics.DENSITY_DEFAULT;
    }

}
