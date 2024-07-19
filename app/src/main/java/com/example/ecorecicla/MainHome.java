package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainHome extends AppCompatActivity {

    private Button returnButton;
    private Button statisticsButton;
    private Button tipsButton;
    private Button categoriesButton;
    private Button registrationButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_main);

        initializeViews();
        setupListeners();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void initializeViews() {
        returnButton = findViewById(R.id.button3);
        statisticsButton = findViewById(R.id.button21);
        tipsButton = findViewById(R.id.button22);
        categoriesButton = findViewById(R.id.button19);
        registrationButton = findViewById(R.id.button20);
    }

    private void setupListeners() {
        returnButton.setOnClickListener(view -> navigateToMainActivity());
        categoriesButton.setOnClickListener(view -> navigateToCategoriesActivity());
        registrationButton.setOnClickListener(view -> navigateToRegistrationActivity());
        statisticsButton.setOnClickListener(view -> navigateToStatisticsActivity());
        tipsButton.setOnClickListener(view -> navigateToTipsActivity());
    }
    private void navigateToMainActivity() {
        Intent intent = new Intent(MainHome.this, MainActivity.class);
        startActivity(intent);
    }

    private void navigateToCategoriesActivity() {
        Intent intent = new Intent(MainHome.this, MainCategories.class);
        startActivity(intent);
    }

    private void navigateToRegistrationActivity() {
        Intent intent = new Intent(MainHome.this, MainRegistration.class);
        startActivity(intent);
    }

    private void navigateToStatisticsActivity() {
        Intent intent = new Intent(MainHome.this, MainStatistics.class);
        startActivity(intent);
    }

    private void navigateToTipsActivity() {
        Intent intent = new Intent(MainHome.this, MainTips.class);
        startActivity(intent);
    }
}
