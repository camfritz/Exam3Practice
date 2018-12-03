package edu.fritzcamoregonstate.exampractice3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mNiceButton, mRudeButton;
    private EditText mFirstNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstNameField = findViewById(R.id.first_name_field);

        //set onClickListeners for both buttons
        mNiceButton = findViewById(R.id.mangle_button_nice);
        mRudeButton = findViewById(R.id.mangle_button_rude);

        mNiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameFieldisEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(), "Please Enter a First Name", Toast.LENGTH_SHORT);
                    t.show();
                }
                else {
                    Intent i = MangleNiceActivity.newIntent(MainActivity.this, mFirstNameField.getText().toString());
                    startActivity(i);
                }
            }
        });

        mRudeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameFieldisEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(), "Please Enter a First Name", Toast.LENGTH_SHORT);
                    t.show();
                }
                else {

                }
            }
        });
    }

    private boolean nameFieldisEmpty() {
        if(mFirstNameField.length() <= 0) {
            return true;
        }
        return false;
    }
}
