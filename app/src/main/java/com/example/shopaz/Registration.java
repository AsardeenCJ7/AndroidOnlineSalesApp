package com.example.shopaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    // Assign the corresponding XML element IDs to the Java variables
    EditText signupName, signupUsername, signupEmail, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set an onClickListener for the signup button
        setContentView(R.layout.activity_registration);
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get an instance of the Firebase database and reference the "users" table
                database = FirebaseDatabase.getInstance("https://shopaz-31f07-default-rtdb.firebaseio.com/");
                reference = database.getReference("users");

                // Get the text input from the EditText fields
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();

                // Create a new HelperClass object with the input values and store it in the Firebase database
                HelperClass helperClass = new HelperClass(name, email, username, password);
                reference.child(username).setValue(helperClass);

                // Display a success message and redirect the user to the Login activity
                Toast.makeText(Registration.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Registration.this, LogIn.class);
                startActivity(intent);
            }
        });

        // Set an onClickListener for the login redirect TextView
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, LogIn.class);
                startActivity(intent);
            }
        });
    }
}