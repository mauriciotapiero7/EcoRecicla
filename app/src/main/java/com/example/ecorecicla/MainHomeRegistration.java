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



public class MainHomeRegistration extends AppCompatActivity {

    private EditText usuario;
    private EditText password;
    private EditText repeatpassword;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registration_home);

        initializeViews();
        setupListeners();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main4), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void initializeViews() {
        usuario = findViewById(R.id.editTextTextEmail);
        password = findViewById(R.id.editTextTextPassword6);
        repeatpassword = findViewById(R.id.editTextTextPassword7);
        register = findViewById(R.id.register);
    }

    private void setupListeners() {
        register.setOnClickListener(view -> {
            Intent next = new Intent(MainHomeRegistration.this, MainActivity.class);
            startActivity(next);
        });
    }

}
