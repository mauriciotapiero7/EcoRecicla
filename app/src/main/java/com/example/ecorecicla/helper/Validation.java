package com.example.ecorecicla.helper;


import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecorecicla.MainHomeRegistration.TipoCampo;

import java.util.ArrayList;

public class Validation {

    public ArrayList<String> errorMessages;

    public Validation(){
        errorMessages = new ArrayList<>();
    }


    public static void validateEmail(TextView email, Context context) {
        String text = email.getText().toString();
        String msg = "";

        if (text.isEmpty()) {
            msg = "El campo email no puede estar vacío";
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            return;
        }

        if (!text.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            msg = "El campo email no contiene una dirección de correo válida";
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            return;
        }
    }

    public void validatePassword(EditText password, EditText passwordConfirm, int min, int max){

        String pass         = password.getText().toString();
        String passConfirm  = passwordConfirm.getText().toString();

        if(pass.isEmpty()){
            errorMessages.add("La contraseña no puede estar vacía");
            return;
        }

        if(pass.length() < min){
            errorMessages.add("La contraseña debe tener al menos " + min + " caracteres");
            return;
        }

        if(pass.length() > max){
            errorMessages.add("La contraseña debe tener máximo " + max + " caracteres");
            return;
        }

        if(!pass.equals(passConfirm)){
            errorMessages.add("Las contraseñas no coinciden");
            return;
        }
    }

    public boolean showErrorMessages(TextView errors){

        String msg = "";

        for(String error : errorMessages) {
            msg += "*" + error + "\n";
        }

        if(!msg.isEmpty()){
            errors.setText(msg);
            errors.setVisibility(View.VISIBLE);
            return true;
        }
        else {
            errors.setText("");
            errors.setVisibility(View.GONE);
            return false;
        }
    }
}
