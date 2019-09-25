package com.example.s185120_62550_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nameText = null;
    private EditText nameField = null;
    private Button nameButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.nameText);
        nameField = findViewById(R.id.nameField);
        nameButton = findViewById(R.id.nameButton);



    }

    @Override
    public void onClick(View v) {
        if (v == nameText) {
            System.out.println("[INFO] User pressed textview: " + nameText.getId());
            nameText.setText("Hi, this is the textview");
        } else if (v == nameField) {
            System.out.println("[INFO] User pressed exittext: " + nameText.getId());
        } else if (v == nameButton) {
            System.out.println("[INFO] User pressed button: " + nameText.getId());
            if (!nameField.isEnabled()) {
                nameText.setText("Sure, '" + nameField.getText().toString() + "'");
                nameField.setEnabled(true);
                System.out.println("[INFO] Program state: sassy");
            } else if (nameField.getText().toString().equals("")) {
                nameText.setText("Please enter your name");
                System.out.println("[INFO] Program state: impatient");
            } else {
                nameText.setText("Is your name really " + nameField.getText().toString() + "?");
                nameField.setText("");
                nameField.setEnabled(false);
                nameButton.setText("Just accept it");
                System.out.println("[INFO] Program state: doubtful");
            }
        }

    }
}
