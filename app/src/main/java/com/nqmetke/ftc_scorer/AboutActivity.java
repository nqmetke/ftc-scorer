package com.nqmetke.ftc_scorer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {
    private Button website;
    private Button facebook;
    private Button twitter;
    private Button youtube;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        website = (Button)findViewById(R.id.website);
        facebook = (Button)findViewById(R.id.facebook);
        twitter = (Button)findViewById(R.id.twitter);
        youtube = (Button)findViewById(R.id.youtube);

        /*Toolbar myToolbar2 = (Toolbar) findViewById(R.id.my_toolbar2);
        setSupportActionBar(myToolbar2);*/



        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("http://www.i2robotics.org/");
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.youtube.com/channel/UCIJYmga_sx5PnGkA-OP09_Q");
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://twitter.com/i2robotics");
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://www.facebook.com/i2robotics/");
            }
        });




    }

    void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

}
