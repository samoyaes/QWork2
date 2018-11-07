package com.example.gary.qwork;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button loginbtn2;
    private TextView matricula;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn2 = (Button) findViewById(R.id.loginbtn2);

        loginbtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        final RegistroDbHelper registroHelper = new RegistroDbHelper(getApplicationContext());
        SQLiteDatabase db = registroHelper.getReadableDatabase();

        matricula = (TextView) findViewById(R.id.matriculaLogin);
        password = (TextView) findViewById(R.id.passwordLogin);

        String[] select =
                {
                        RegistroContract.RegistroEntry.matricula,
                        RegistroContract.RegistroEntry.password,
                        RegistroContract.RegistroEntry.nombre,
                        RegistroContract.RegistroEntry.email,
                        RegistroContract.RegistroEntry.rol
                };

        String[] args =
                {
                        matricula.getText().toString(),
                        password.getText().toString()
                };

        Cursor c = db.query("Registro",select,"matricula=? and password=?",args,null,null,null);

        if(c.getCount() > 0)
        {
            c.moveToFirst();
            String rol = c.getString(c.getColumnIndex("rol"));

            switch (rol){
            case "Alumno":
                Intent i = new Intent(getApplicationContext(),AlumnoActivity.class);

                startActivity(i);
                break;
            case "Profesor":
                Intent i2 = new Intent(getApplicationContext(),ProfesorActivity.class);
                startActivity(i2);
                break;
            }

            //Toast.makeText(LoginActivity.this, "Se encontro el registro " + mat, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(LoginActivity.this, "Matricula o Password equivocada", Toast.LENGTH_SHORT).show();
        }

    }
}
