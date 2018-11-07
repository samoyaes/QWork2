package com.example.gary.qwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfesorActivity extends AppCompatActivity {
    private ImageView qrProfesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);

        qrProfesor = (ImageView) findViewById(R.id.qrProfesor);

        qrProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CrearMateriaActivity.class);

                startActivity(i);
            }
        });
    }
}
