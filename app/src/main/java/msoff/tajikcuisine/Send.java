package msoff.tajikcuisine;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by moshe on 02/04/2017.
 */

public class Send extends Activity {

    EditText email_title,email_body;
    ImageView email_icon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        email_title = (EditText)findViewById(R.id.email_title);
        email_body = (EditText)findViewById(R.id.email_body);

        email_icon = (ImageView)findViewById(R.id.email_icon);
        email_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "tajapp.taom@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, email_title.getText());
                emailIntent.putExtra(Intent.EXTRA_TEXT,email_body.getText());
                startActivity(Intent.createChooser(emailIntent, null));
            }
        });
    }
}
