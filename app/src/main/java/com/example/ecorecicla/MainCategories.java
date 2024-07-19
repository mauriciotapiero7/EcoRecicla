package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainCategories extends AppCompatActivity {

    private Button returnButton;
    private Button plasticButton;
    private Button paperButton;
    private Button glassButton;
    private Button noRecycleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_main);

        initializeViews();
        setupListeners();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initializeViews() {
        returnButton = findViewById(R.id.button3);
        plasticButton = findViewById(R.id.button14);
        paperButton = findViewById(R.id.button15);
        glassButton = findViewById(R.id.button16);
        noRecycleButton = findViewById(R.id.button17);
    }

    private void setupListeners() {
        returnButton.setOnClickListener(view -> navigateToMainHome());
        plasticButton.setOnClickListener(view -> navigateToPlasticActivity());
        paperButton.setOnClickListener(view -> navigateToPaperActivity());
        glassButton.setOnClickListener(view -> navigateToGlassActivity());
        noRecycleButton.setOnClickListener(view -> navigateToNoRecycleActivity());
    }

    private void navigateToMainHome() {
        Intent intent = new Intent(MainCategories.this, MainHome.class);
        startActivity(intent);
    }

    private void navigateToPlasticActivity() {
        Intent intent = new Intent(MainCategories.this, MainPlastic.class);
        startActivity(intent);
    }

    private void navigateToPaperActivity() {
        Intent intent = new Intent(MainCategories.this, MainPaper.class);
        startActivity(intent);
    }

    private void navigateToGlassActivity() {
        Intent intent = new Intent(MainCategories.this, MainGlass.class);
        startActivity(intent);
    }

    private void navigateToNoRecycleActivity() {
        Intent intent = new Intent(MainCategories.this, MainNoRecyclable.class);
        startActivity(intent);
    }
}

