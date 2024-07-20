package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainTips extends AppCompatActivity {

    private Button returnButton;
    private Button tipsoneButton;
    private Button tipstwoButton;
    private Button tipsthreeButton;
    private Button Buttonsurprise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tips_main);

        initializeViews();
        setupListeners();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tipspage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void initializeViews() {
        returnButton = findViewById(R.id.button3);
        tipsoneButton = findViewById(R.id.button7);
        tipstwoButton = findViewById(R.id.button8);
        tipsthreeButton = findViewById(R.id.button9);
    }

    private void setupListeners() {
        returnButton.setOnClickListener(view -> navigateToReturn());
        tipsoneButton.setOnClickListener(view -> navigateToTipsOneActivity());
        tipstwoButton.setOnClickListener(view -> navigateToTipsTwoActivity());
        tipsthreeButton.setOnClickListener(view -> navigateToTipsThreeActivity());
    }

    private void navigateToReturn() {
        Intent intent = new Intent(MainTips.this, MainHome.class);
        startActivity(intent);
    }

    private void navigateToTipsOneActivity() {
        Intent intent = new Intent(MainTips.this, MainTipsOne.class);
        startActivity(intent);
    }
    private void navigateToTipsTwoActivity() {
        Intent intent = new Intent(MainTips.this, MainTipsTwo.class);
        startActivity(intent);
    }

    private void navigateToTipsThreeActivity() {
        Intent intent = new Intent(MainTips.this, MainTipsThree.class);
        startActivity(intent);
    }
    private void navigateToSurpriseActivity() {
        Intent intent = new Intent(MainTips.this, MainPrice.class);
        startActivity(intent);
    }

}
