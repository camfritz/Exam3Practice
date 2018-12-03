package edu.fritzcamoregonstate.exampractice3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MangleNiceActivity extends AppCompatActivity {

    private static final String EXTRA_FIRST_NAME = "edu.fritzcamoregonstate.mangle_nice_activity.first_name";

    private TextView mNameNice;
    private String mName;
    private String mFirstName;

    private String[] mNiceWords = {
            "Awesome",
            "Amazing",
            "Radical",
            "Wholesome",
    };

    private Button mRemangleButton, mResetButton, mSendButton, mPhotoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangle_nice);

        //Set button views
        mRemangleButton = findViewById(R.id.remangle_button_nice);
        mResetButton = findViewById(R.id.reset_button_nice);
        mSendButton = findViewById(R.id.reset_button_nice);
        mPhotoButton = findViewById(R.id.add_photo_nice);

        mNameNice = findViewById(R.id.name_nice);

        mFirstName = getIntent().getStringExtra(EXTRA_FIRST_NAME);

        mangleName();

        mRemangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mangleName();
            }
        });
    }

    public static Intent newIntent(Context packageContext, String firstName) {
        Intent i = new Intent(packageContext, MangleNiceActivity.class);
        i.putExtra(EXTRA_FIRST_NAME, firstName);
        return i;
    }

    private void mangleName() {
        Random randomGen = new Random();

        mName = mFirstName + " " + mNiceWords[randomGen.nextInt(mNiceWords.length)];
        mNameNice.setText(mName);
    }
}
