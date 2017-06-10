package msoff.tajikcuisine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by moshe on 02/04/2017.
 */

public class BoziFragment  extends Fragment {


    // newInstance constructor for creating fragment with arguments
    public static BoziFragment newInstance(int page) {
        BoziFragment boziFragment = new BoziFragment();
        Bundle args = new Bundle();
        args.putInt("position", page);
        boziFragment.setArguments(args);
        return boziFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.bozi_fragment, container, false);
        if (getArguments().getInt("position")==0)
            rootView.setBackgroundResource(R.drawable.bozi_image_1);
        else if (getArguments().getInt("position")==1)
            rootView.setBackgroundResource(R.drawable.bozi_image_2);
        else if (getArguments().getInt("position")==2)
            rootView.setBackgroundResource(R.drawable.bozi_image_3);
        else if (getArguments().getInt("position")==3)
            rootView.setBackgroundResource(R.drawable.bozi_image_4);
        else if (getArguments().getInt("position")==4)
            rootView.setBackgroundResource(R.drawable.bozi_image_5);


        LinearLayout get_game = (LinearLayout)rootView.findViewById(R.id.get_game);
        get_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=attor.shoiron"));
                startActivity(in);
            }
        });
        return rootView;
    }
}
