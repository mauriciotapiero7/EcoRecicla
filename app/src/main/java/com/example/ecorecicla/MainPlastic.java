package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainPlastic extends AppCompatActivity {

    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plastic_category);

        initializeViews();
        setupListeners();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.plasticpage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void initializeViews() {
        returnButton = findViewById(R.id.button3);
    }

    private void setupListeners() {
        returnButton.setOnClickListener(view -> navigateToMainCategories());
    }

    private void navigateToMainCategories() {
        Intent intent = new Intent(MainPlastic.this, MainCategories.class);
        startActivity(intent);
    }

}

