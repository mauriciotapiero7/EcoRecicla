package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecorecicla.MainHome;
import com.example.ecorecicla.MainHomeRegistration;
import com.example.ecorecicla.models.User;
import com.example.ecorecicla.helper.FileManager;
import com.example.ecorecicla.helper.Encrypt;

public class MainActivity extends AppCompatActivity {

    User user;

    EditText email;
    EditText password;
    Button botonLogin;
    Button register;
    TextView textResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextTextEmail);
        password = findViewById(R.id.editTextTextPassword6);
        botonLogin = findViewById(R.id.buttonLogin);
        textResetPassword = findViewById(R.id.textResetPassword);
        register = findViewById(R.id.register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botonLogin.setOnClickListener(v -> loginUser());

        register.setOnClickListener(view -> {
            Intent next = new Intent(MainActivity.this, MainHomeRegistration.class);
            startActivity(next);
        });
    }

    // Validate data user for login
    public void loginUser() {

        String email = this.email.getText().toString();
        String password = this.password.getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {

            user = new User(); // Crear una nueva instancia de User
            user.email = email;
            user.password = Encrypt.encryptPassword(password); // Encrypt password

            FileManager fileManager = new FileManager(this);

            // Validate user in database
            User userLogged = fileManager.findUserByEmailAndPassword(user);

            if (userLogged != null) {

                user.copyData(userLogged);

                Intent intent = new Intent(MainActivity.this, MainHome.class);
                startActivity(intent);

                Toast.makeText(this, "Bienvenido " + user.email, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Por favor ingrese su correo y contraseña", Toast.LENGTH_LONG).show();
        }
    }
}

