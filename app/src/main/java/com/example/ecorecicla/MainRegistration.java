package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainRegistration extends AppCompatActivity {

    private Button returnButton;
    private EditText material;
    private EditText material2;
    private EditText material3;
    private EditText material4;
    private Button registrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registration_main);

        initializeViews();
        setupListeners();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.registrationpage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initializeViews() {
        returnButton = findViewById(R.id.button3);
        material = findViewById(R.id.textInputEditText);
        material2 = findViewById(R.id.textInputEditText1);
        material3 = findViewById(R.id.textInputEditText2);
        material4 = findViewById(R.id.textInputEditText3);
        registrationButton = findViewById(R.id.button6);
    }

    private void setupListeners() {
        returnButton.setOnClickListener(view -> navigateToMainActivity());
        registrationButton.setOnClickListener(view -> navigateToRegistrationActivity());
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(MainRegistration.this, MainHome.class);
        startActivity(intent);
    }

    //Información boton registro materiales en HomeRegistration
    private void navigateToRegistrationActivity() {
        Intent intent = new Intent(MainRegistration.this, MainRegistration.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


}
