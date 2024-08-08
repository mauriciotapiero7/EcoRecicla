package com.example.ecorecicla.helper;


import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ecorecicla.MainHomeRegistration;

import java.util.ArrayList;

public class Validation {

    public ArrayList<String> errorMessages;

    public Validation(){
        errorMessages = new ArrayList<>();
    }


    public void validateEmail(EditText editText, MainHomeRegistration mainHomeRegistration) {
        String text = editText.getText().toString();
        String msg = "";

        if (text.isEmpty()) {
            msg = "El campo email no puede estar vacío";
            errorMessages.add(msg);
            return;
        }

        if (!text.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            msg = "El campo email no contiene una dirección de correo válida";
            errorMessages.add(msg);
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
