package msoff.tajikcuisine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by moshe on 01/04/2017.
 */

public class Category extends Activity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    AppBarLayout appBarLayout;
    public static int category;

    private static ArrayList<DataModel> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        appBarLayout = (AppBarLayout)findViewById(R.id.app_bar_menu);

        myOnClickListener = new MyOnClickListener(this);


        Bundle extras = getIntent().getExtras();

        category = extras.getInt("cat");
        setActionbarImage(category);
        updateData(category);


        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private void updateData(int cat) {
        data = new ArrayList<DataModel>();
        if (cat == 1){
            for (int i = 0; i < MyData.second_meals_menu.length; i++){
                data.add(new DataModel(
                        MyData.second_meals_menu[i],
                        "Хуроки Дуввум",
                        i,
                        MyData.second_meals_image_ids[i],
                        MyData.timing0[i]
                ));
            }
        }
        else if (cat == 2){
            for (int i = 0; i < MyData.first_meals_menu.length; i++){
                data.add(new DataModel(
                        MyData.first_meals_menu[i],
                        "Хуроки Аввал",
                        i,
                        MyData.first_meals_image_ids[i],
                        MyData.timing1[i]
                ));
            }
        }
        else if (cat == 3){
            for (int i = 0; i < MyData.kabob_meals_menu.length; i++){
                data.add(new DataModel(
                        MyData.kabob_meals_menu[i],
                        "Кабобхо",
                        i,
                        MyData.kabob_meals_image_ids[i],
                        MyData.timing2[i]
                ));
            }
        }

        else if (cat == 4){
            for (int i = 0; i < MyData.puxtupaz_meals_menu.length; i++){
                data.add(new DataModel(
                        MyData.puxtupaz_meals_menu[i],
                        "Пухтупазхо",
                        i,
                        MyData.puxtupaz_meals_menu_image_ids[i],
                        MyData.timing3[i]
                ));
            }
        }
        else{
            for (int i = 0; i < MyData.shiriniho_menu.length; i++){
                data.add(new DataModel(
                        MyData.shiriniho_menu[i],
                        "Кабобхо",
                        i,
                        MyData.shiriniho_images_ids[i],
                        MyData.timing4[i]
                ));
            }
        }
    }

    private void setActionbarImage(int cat) {
        if (cat == 1){
            appBarLayout.setBackgroundResource(R.drawable.duvvum);
        }
        else if (cat == 2){
            appBarLayout.setBackgroundResource(R.drawable.avval);
        }
        else if (cat == 3){
            appBarLayout.setBackgroundResource(R.drawable.kabob);
        }
        else if (cat == 4){
            appBarLayout.setBackgroundResource(R.drawable.puxtupaz);
        }
        else appBarLayout.setBackgroundResource(R.drawable.murabboi_sabzigi);
    }

    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            int position = viewHolder.getAdapterPosition();
            if(category == 1){
                if(position == 0){//jugorimakka
                    Intent i00 = new Intent(Category.this,Recipe1_1.class);
                    startActivity(i00);
                }
                else if (position == 1) {//tokkabob
                    Intent i01 = new Intent(Category.this, Recipe1_2.class);
                    startActivity(i01);
                }
                else if (position == 2) {//qurutob
                    Intent i03 = new Intent(Category.this,Recipe1_4.class);
                    startActivity(i03);
                }
                else if (position == 3) {//oshi choyxona
                    Intent i04 = new Intent(Category.this, Recipe1_5.class);
                    startActivity(i04);
                }
                else if (position == 4) {//mantui biryon
                    Intent i05 = new Intent(Category.this,Recipe1_6.class);
                    startActivity(i05);
                }
                else if (position == 5) {//xonum
                    Intent i06 = new Intent(Category.this,Recipe1_7.class);
                    startActivity(i06);
                }
                else if (position == 6) {//gulxonum
                    Intent i07 = new Intent(Category.this,Recipe1_8.class);
                    startActivity(i07);
                }
                else {//non alov
                    Intent i08 = new Intent(Category.this,Recipe1_9.class);
                    startActivity(i08);
                }
            }
            else if(category == 2){
                if(position == 0){//wurbo

                    Intent i10 = new Intent(Category.this,Recipe2_0.class);
                    startActivity(i10);
                }
                else if (position == 1){//galobci
                    Intent i01 = new Intent(Category.this,Recipe2_1.class);
                    startActivity(i01);
                }
                else if (position == 2){//plemen
                    Intent i02 = new Intent(Category.this,Recipe2_2.class);
                    startActivity(i02);
                }
                else if (position == 3){//mastova
                    Intent i03 = new Intent(Category.this,Recipe2_3.class);
                    startActivity(i03);
                }
            }
            else if(category == 3){
                if (position == 0){//wawliki farwi
                    Intent i20 = new Intent(Category.this,Recipe3_0.class);
                    startActivity(i20);

                }
                else if(position == 1){//murg kabob
                    Intent i21 = new Intent(Category.this,Recipe3_1.class);
                    startActivity(i21);
                }
                else if (position == 2){//jigar kabob
                    Intent i22 = new Intent(Category.this,Recipe3_2.class);
                    startActivity(i22);
                }
                else{//wawlik
                    Intent i32 = new Intent(Category.this, Recipe3_3.class);
                    startActivity(i32);
                }
            }
            else if(category == 4){
                if (position == 0){//xamiri sambusa
                    Intent i30 = new Intent(Category.this,Recipe4_0.class);
                    startActivity(i30);

                }
                else if (position == 1){//sambusai varaqi
                    Intent i32 = new Intent(Category.this,Recipe4_2.class);
                    startActivity(i32);
                }
                else if(position == 2){//sambusai tuxmi
                    Intent i34 = new Intent(Category.this,Recipe4_4.class);
                    startActivity(i34);
                }
            }
            else if(category == 5){
                if(position == 0){//murabboi sabzigi
                    Intent i50 = new Intent(Category.this,Recipe5_0.class);
                    startActivity(i50);
                }
            }
     

        }
    }

}
