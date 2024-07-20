package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText usuario;
    private EditText password;
    private Button login;
    private Button register;
    private TextView textResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.editTextTextEmail);
        password = findViewById(R.id.editTextTextPassword6);
        login = findViewById(R.id.buttonLogin);
        textResetPassword = findViewById(R.id.textResetPassword);
        register = findViewById(R.id.register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        login.setOnClickListener(view -> {
            Intent next = new Intent(MainActivity.this, MainHome.class);
            startActivity(next);
        });

        register.setOnClickListener(view -> {
            Intent next = new Intent(MainActivity.this, MainHomeRegistration.class);
            startActivity(next);
        });
    }
}
