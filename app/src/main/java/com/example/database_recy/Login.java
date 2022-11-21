package com.example.database_recy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.database_recy.Preference.DataLocalManager;
import com.example.database_recy.Preference.MySharePreferences;

public class Login extends AppCompatActivity {
    EditText username , password;
    Button buttonLogin , buttonSigup;
    DatabaseHelper db;
    MySharePreferences mySharePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mySharePreferences = new MySharePreferences(getApplicationContext());
        findView();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(!user.isEmpty() || !pass.isEmpty()){
                    UsersModel usersModel = new UsersModel(user , pass);
                    Boolean check = db.checkUsernamePassword(usersModel);
                    if(check == true){
                        Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Cursor cursor = db.getData("select * from TABLE_USERS where USERNAME = " + "'" + user + "'");
                        while(cursor.moveToNext()) {
                            Toast.makeText(Login.this, cursor.getString(0), Toast.LENGTH_SHORT).show();
                            mySharePreferences.putString("userID" , cursor.getString(0));
                            mySharePreferences.putString("username" , cursor.getString(1));
                            mySharePreferences.putString("password" , cursor.getString(2));
                        }
                        Intent intent = new Intent(Login.this , MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Login.this, "Please Enter All", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonSigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this , Sigup.class);
                startActivity(intent);
                Toast.makeText(Login.this, "sigUp", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void findView() {
        username = (EditText) findViewById(R.id.usernameLogin);
        password = (EditText) findViewById(R.id.passwordLogin);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonSigup = (Button) findViewById(R.id.buttonSigup);
        db = new DatabaseHelper(this);
    }
}