package com.tutorial.xdroid051.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anis.sharedpreferences.R;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button signup, signin;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        username = (EditText) findViewById(R.id.EnUser);
        password = (EditText) findViewById(R.id.EnPass);
        signin= (Button) findViewById(R.id.signin);
        signup= (Button) findViewById(R.id.signup);
        sp = getSharedPreferences("login ", MODE_PRIVATE);
        if(sp.contains("username") && sp.contains("password")){
            startActivity(new Intent(getApplicationContext(), HomePage.class));
            finish();
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().length() <= 0 || password.getText().length() <=0 )
                {
                    Toast.makeText(getApplicationContext(), "Enter Username And Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String user=username.getText().toString() ;
                    String pass=password.getText().toString();
                    SharedPreferences.Editor e = sp.edit();
                    e.putString("username", user);
                    e.putString("password", pass);
                    e.commit();
                    Toast.makeText(MainActivity.this, "Signup successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                    finish();



                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
            }
        });

    }
}
