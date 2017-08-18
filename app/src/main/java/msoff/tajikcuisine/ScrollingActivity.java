package msoff.tajikcuisine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    LinearLayout l1,l2,l3,l4,l5,l6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        l1 = (LinearLayout)findViewById(R.id.level_1);
        l2 = (LinearLayout)findViewById(R.id.level_2);
        l3 = (LinearLayout)findViewById(R.id.level_3);
        l4 = (LinearLayout)findViewById(R.id.level_4);
        l5 = (LinearLayout)findViewById(R.id.level_5);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l1 = new Intent(ScrollingActivity.this,Category.class);
                l1.putExtra("cat",1);
                startActivity(l1);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l1 = new Intent(ScrollingActivity.this,Category.class);
                l1.putExtra("cat",2);
                startActivity(l1);
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l1 = new Intent(ScrollingActivity.this,Category.class);
                l1.putExtra("cat",3);
                startActivity(l1);
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l1 = new Intent(ScrollingActivity.this,Category.class);
                l1.putExtra("cat",4);
                startActivity(l1);
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l1 = new Intent(ScrollingActivity.this,Category.class);
                l1.putExtra("cat",5);
                startActivity(l1);
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_prayer) {
            Intent in  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.simurgh.prayertimes"));
            startActivity(in);

        } else if (id == R.id.nav_games) {
            Intent bozi = new Intent(ScrollingActivity.this,Bozi.class);
            startActivity(bozi);

        } else if (id == R.id.nav_share) {

            final String appPackageName = this.getPackageName();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            String text = "Таомхои Милли бо забони точики!";
            sendIntent.putExtra(Intent.EXTRA_TEXT, text + "https://play.google.com/store/apps/details?id=" + appPackageName);
            sendIntent.setType("text/plain");
            this.startActivity(sendIntent);

        }else if (id == R.id.nav_send) {
            Intent send = new Intent(ScrollingActivity.this,Send.class);
            startActivity(send);

        }else if (id == R.id.nav_about) {
            Intent about = new Intent(ScrollingActivity.this,AboutUs.class);
            startActivity(about);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
