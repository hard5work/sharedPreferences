package com.tutorial.xdroid051.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anis.sharedpreferences.R;

/**
 * Created by ASUS-PC on 5/8/2017.
 */

public class HomePage extends AppCompatActivity {

    TextView te;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        TextView so = (TextView) findViewById(R.id.text1);
        Button logOut = (Button) findViewById(R.id.logout);
        te = (TextView) findViewById(R.id.test2);
        Button t = (Button)  findViewById(R.id.test1);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("login ", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.remove("username");
                e.remove("password");
             //   e.clear();
                e.apply();
                Toast.makeText(HomePage.this, "Logout successful ", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(HomePage.this, LoginPage.class));
                finish();

            }
        });

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("login ",MODE_PRIVATE);
                String username = sp.getString("username", "");
                String password = sp.getString("password", "");
                String msg = "Saved UserName:" + username+ "\n Saved Password: " + password;
                te.setText(msg);
            }
        });
    }

}
