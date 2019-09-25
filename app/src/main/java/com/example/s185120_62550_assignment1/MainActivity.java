package com.example.s185120_62550_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nameText = null;
    private TextView statusText = null;
    private EditText nameField = null;
    private Button nameButton = null;
    private Button settingsButton = null;
    private Button guidanceButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.nameText);
        nameField = findViewById(R.id.nameField);
        nameButton = findViewById(R.id.nameButton);
        nameText.setOnClickListener(this);
        nameField.setOnClickListener(this);
        nameButton.setOnClickListener(this);

        statusText = findViewById(R.id.textStatus);
        settingsButton = findViewById(R.id.buttonSettings);
        guidanceButton = findViewById(R.id.buttonGuidance);
        settingsButton.setOnClickListener(this);
        guidanceButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == nameText) {
            System.out.println("[INFO] User pressed textview: " + nameText.getResources().getResourceName(nameText.getId()));
            nameText.setText("Hi, this is the textview");
        } else if (v == nameField) {
            System.out.println("[INFO] User pressed exittext: " + nameField.getResources().getResourceName(nameField.getId()));
        } else if (v == nameButton) {
            System.out.println("[INFO] User pressed button: " + nameButton.getResources().getResourceName(nameButton.getId()));
            statusText.setText("Status: user pressed 'send name' button");
            if (!nameField.isEnabled()) {
                nameText.setText("Sure, '" + nameField.getText().toString() + "'");
                nameField.setEnabled(true);
                System.out.println("[INFO] Program state: sassy");
            } else if (nameField.getText().toString().isEmpty()) {
                nameText.setText("Please enter your name ...");
                System.out.println("[INFO] Program state: impatient");
            } else {
                nameText.setText("Really? Your name is " + nameField.getText().toString() + "?");
                nameField.setEnabled(false);
                nameButton.setText("Just accept it");
                System.out.println("[INFO] Program state: doubtful");
            }
        } else if (v == guidanceButton) {
            System.out.println("[INFO] User pressed button: " + guidanceButton.getResources().getResourceName(guidanceButton.getId()));
            statusText.setText("Status: user pressed 'guidance' button");
        } else if (v == settingsButton) {
            System.out.println("[INFO] User pressed button: " + settingsButton.getResources().getResourceName(settingsButton.getId()));
            statusText.setText("Status: user pressed 'settings' button");
        }

    }
}
