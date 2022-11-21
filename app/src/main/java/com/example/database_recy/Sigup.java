package com.example.database_recy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.database_recy.Preference.DataLocalManager;
import com.example.database_recy.Preference.MySharePreferences;

public class Sigup extends AppCompatActivity {
    EditText username , password ,number , email;
    Button sigin , sigup;
    DatabaseHelper db;
    MySharePreferences mySharePreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sigup);
        findView();
        mySharePreferences = new MySharePreferences(getApplicationContext());
        sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String num = number.getText().toString();
                String em = email.getText().toString();
                if(!user.isEmpty() || !pass.isEmpty() || !num.isEmpty() || !em.isEmpty()) {
                    UsersModel usersModel = new UsersModel(0, user, pass, num, em);
                    boolean insert = db.addUser(usersModel);
                    Log.d("check", "onClick: " + insert);
                    if (insert == true) {
                        Cursor cursor = db.getData("select * from TABLE_USERS where USERNAME = " + "'" + username + "'");
                        while(cursor.moveToNext()){
                            mySharePreferences.putString("userID" , cursor.getString(0));
                            mySharePreferences.putString("username",cursor.getString(1));
                            mySharePreferences.putString("password" , cursor.getString(2));
                        }
                        Intent intent = new Intent(Sigup.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Sigup.this, "SIGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Sigup.this, "SIGIN FAILED", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Sigup.this, "SIGUP FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sigup.this , Login.class);
                startActivity(intent);
            }
        });
    }
    public void findView () {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        number = (EditText) findViewById(R.id.number);
        email = (EditText) findViewById(R.id.email);
        sigin = (Button) findViewById(R.id.sigin);
        sigup = (Button) findViewById(R.id.sigup);
        db = new DatabaseHelper(this);
    }
}