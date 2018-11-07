package com.example.gary.qwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button register;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.loginbtn);
        Intent i = getIntent();

        if (i.hasExtra("matricula"))
        {
            String matricula = i.getExtras().getString("matricula");
            Toast.makeText(MainActivity.this,"Se ha registrado la matricula ", Toast.LENGTH_LONG).show();
        }
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent i;
        switch (v.getId())
        {
            case R.id.register:
                i = new Intent(getApplicationContext(),RegisterActivity.class);

                startActivity(i);
                break;

            case R.id.loginbtn:
                i = new Intent(getApplicationContext(),LoginActivity.class);

                startActivity(i);
                break;
        }

    }
}
