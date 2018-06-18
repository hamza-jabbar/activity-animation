package com.eg.ahzam.activityanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mListLayout;

    private ImageView mProfileImage;

    private TextView mNameText, mDescText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListLayout = findViewById(R.id.main_relout);
        mProfileImage = findViewById(R.id.main_ivProfile);
        mNameText = findViewById(R.id.main_tvName);
        mDescText = findViewById(R.id.main_tvDescription);

        mListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharedIntent = new Intent(MainActivity.this, SharedActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(mProfileImage, "imageTransition");
                pairs[1] = new Pair<View, String>(mNameText, "nameTransition");
                pairs[2] = new Pair<View, String>(mDescText, "descTransition");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(sharedIntent, options.toBundle());
            }
        });


    }
}
