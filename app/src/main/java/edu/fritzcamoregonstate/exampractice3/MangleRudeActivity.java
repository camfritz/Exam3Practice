package edu.fritzcamoregonstate.exampractice3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MangleRudeActivity extends AppCompatActivity {

    private static final String EXTRA_FIRST_NAME = "edu.fritzcamoregonstate.mangle_rude_activity.first_name";
    private static final String DIALOG_RESET = "edu.fritzcamoregonstate.mangle_rude_activity.dialog_reset";

    private TextView mNameRude;
    private String mName;
    private String mFirstName;

    private String[] mRudeWords = {
            "Rediculous",
            "Uptight",
            "Gullible",
            "Pompous",
    };

    private Button mRemangleButton, mResetButton, mSendButton, mPhotoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangle_rude);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        //Set button views
        mRemangleButton = findViewById(R.id.remangle_button_rude);
        mResetButton = findViewById(R.id.reset_button_rude);
        mSendButton = findViewById(R.id.reset_button_rude);
        mPhotoButton = findViewById(R.id.add_photo_rude);

        mNameRude = findViewById(R.id.name_rude);

        mFirstName = getIntent().getStringExtra(EXTRA_FIRST_NAME);

        mangleName();

        mRemangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mangleName();
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetDialogFragment resetDialog = new ResetDialogFragment();
                resetDialog.show(fragmentManager, DIALOG_RESET);
            }
        });
    }

    public static Intent newIntent(Context packageContext, String firstName) {
        Intent i = new Intent(packageContext, MangleRudeActivity.class);
        i.putExtra(EXTRA_FIRST_NAME, firstName);
        return i;
    }

    private void mangleName() {
        Random randomGen = new Random();

        mName = mFirstName + " " + mRudeWords[randomGen.nextInt(mRudeWords.length)];
        mNameRude.setText(mName);
    }
}
