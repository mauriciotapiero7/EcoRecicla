package com.example.ecorecicla.helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.ecorecicla.models.User;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private Context context;
    public File userFile;    //File to store user data


    public FileManager(Context context) {
        this.context = context;
        userFile = loadFileOrCreate("db_user");
    }

    private File loadFileOrCreate(String fileName){

        File file = new File(context.getFilesDir(), fileName + ".txt");
        if (file.exists()) {
            Log.e("msg", "El archivo" + file.getName() + "ya existe" + file.getAbsolutePath());
            return file;
        } else {

            try {
                file.createNewFile();
                Log.e("msg", "El archivo" + file.getName() + "fue creado" + file.getAbsolutePath());
                return file;
            } catch (IOException e) {
                Log.e("msg", "Error al crear el archivo" + file.getName(), e);
                return null;
            }
        }
    }

    //Create a new user

    public boolean insertNewUser(User user){

        try {
            if(!validateUserExist(user)){

                BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true));

                writer.write(user.objectToJson());
                writer.newLine();
                writer.close();

                Toast.makeText(context, "Usuario registrado correctamente", Toast.LENGTH_LONG).show();
                Log.e("msg", "Usuario registrado en " + userFile.getName() + " correctamente");
                return true;
            }
            else {
                Toast.makeText(context, "El usuario " + user.email + " ya existe", Toast.LENGTH_LONG).show();
                Log.e("msg", "El usuario ya existe");
                return false;
            }
        } catch (IOException e) {
            Toast.makeText(context, "Error al escribir en el archivo" + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return false;
    }


    //Check if the user already exists in the database

    public boolean validateUserExist(User user){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(userFile));

            String data;
            while ((data = reader.readLine()) != null) {

                //Convert the data to a User object

                User dbUser = new Gson().fromJson(data, User.class);

                //If the user already exists, return true

                if (dbUser.email.equals(user.email)) {
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            Toast.makeText(context, "Error al leer el archivo" + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        //If the user does not exist, return false
        return false;
    }

    //Find a user in the database

    public User findUserByEmailAndPassword(User user){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(userFile));

            String data;
            while ((data = reader.readLine()) != null) {

                //Convert the data to a User object

                User dbUser = new Gson().fromJson(data, User.class);

                Log.e("msg", "Email" + dbUser.email + "Password" + dbUser.password);
                Log.e("msg", "Email" + user.email + "Password" + user.password);

                //If the credentials match, return the user

                if (dbUser.email.equals(user.email) && dbUser.password.equals(user.password)) {
                    Log.e("msg", "Email " + user.email + " Password " + user.password + " Encontrado");
                    return dbUser;
                }
            }
            reader.close();



        }  catch (IOException e) {
            Toast.makeText(context, "Error al leer el archivo" + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        //If the user does not exist, return null
        return null;
    }


}
