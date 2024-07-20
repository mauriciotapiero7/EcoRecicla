package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainPrice extends AppCompatActivity {

    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.price);

        initializeViews();
        setupListeners();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pricepage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void initializeViews() {
        returnButton = findViewById(R.id.button18);
    }

    private void setupListeners() {
        returnButton.setOnClickListener(view -> navigateToReturn());
    }
    private void navigateToReturn() {
        Intent intent = new Intent(MainPrice.this, MainTips.class);
        startActivity(intent);
    }
}
