package com.example.ecorecicla;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

//Import classes from the helper package

import com.example.ecorecicla.helper.Encrypt;
import com.example.ecorecicla.helper.FileManager;
import com.example.ecorecicla.helper.Validation;
import com.example.ecorecicla.models.Recycling;
import com.example.ecorecicla.models.User;

import java.util.ArrayList;


public class MainHomeRegistration extends AppCompatActivity {

     User user;
     EditText email;
     EditText password;
     EditText repeatpassword;
     TextView errors;
     Button register;

    public enum TipoCampo { REQUERIDO, NO_REQUERIDO }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registration_home);

        email = findViewById(R.id.editTextTextEmail);
        password = findViewById(R.id.editTextTextPassword6);
        repeatpassword = findViewById(R.id.editTextTextPassword7);
        errors = findViewById(R.id.errors);
        register = findViewById(R.id.register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main4), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Register user

        register.setOnClickListener(view -> {
            Validation validation = new Validation();

            Validation.validateEmail(email, this);
            Validation.validatePassword(password, repeatpassword, 8, 16);

            boolean hasErrors = validation.showErrorMessages(errors);


            //If there are errors, show them register user

            if(!hasErrors){
                //Register user Database
                user = new User();
                user.setEmail(email.getText().toString());
                user.setPassword(Encrypt.encryptPassword(password.getText().toString())); //Encrypt password

                storageUserInDatabase();
            }
        });
    }


    private void setupListeners() {
        register.setOnClickListener(view -> {
            Intent next = new Intent(MainHomeRegistration.this, MainActivity.class);
            startActivity(next);
        });
    }

    private void storageUserInDatabase() {
        FileManager fileManager = new FileManager(this);

        if(fileManager.insertNewUser(user)){
            Intent intent = new Intent(MainHomeRegistration.this, MainActivity.class);
            startActivity(intent);
        }

    }

}
