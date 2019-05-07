package com.tutorial.xdroid051.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anis.sharedpreferences.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS-PC on 5/8/2017.
 */

public class LoginPage extends AppCompatActivity {
    SharedPreferences sp;

    EditText username, password;
    Button login, signup;
    String user,pass, userId, userPass;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        username = (EditText) findViewById(R.id.usernm);
        password = (EditText) findViewById(R.id.passwd);
        login = (Button) findViewById(R.id.signinn);


        sp =getSharedPreferences("login ",MODE_PRIVATE);
        user=  sp.getString("username","");
        pass = sp.getString("password", "");




        if(sp.contains("username") && sp.contains("password")){


            startActivity(new Intent(LoginPage.this, HomePage.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (username.getText().length() <= 0 || password.getText().length() <=0 )
                {
                    Toast.makeText(getApplicationContext(), "Enter Username And Password", Toast.LENGTH_SHORT).show();

                }

               else if (username.getText().toString().equals("Admin")&& password.getText().toString().equals("1234")){
                    SharedPreferences.Editor e = sp.edit();
                    e.putString("username", "Admin");
                    e.putString("password", "1234");
                    e.commit();
                    Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();


                startActivity(new Intent(LoginPage.this, HomePage.class));
                finish();

            }

                else if (username.getText().toString().equals((String) user)&& password.getText().toString().equals( (String) pass)){
                    SharedPreferences.Editor e = sp.edit();
                    e.putString("username",(String)  user);
                    e.putString("password",(String)  pass);
                 //   e.putString("login ", "true");
                   e.commit();
                    Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();


                    startActivity(new Intent(LoginPage.this, HomePage.class));
                    finish();

                }
            else {
                Toast.makeText(getApplicationContext(), "Incorrect login detail", Toast.LENGTH_SHORT).show();
            }

            }
        });

        signup=(Button) findViewById(R.id.signupp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
