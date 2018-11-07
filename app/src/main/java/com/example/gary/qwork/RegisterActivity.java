package com.example.gary.qwork;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity{

    private EditText matricula;
    private EditText nombre;
    private EditText email;
    private EditText password;
    private EditText password2;
    private Button registrarUsuario;
    private RadioButton rol;
    private RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        matricula = (EditText) findViewById(R.id.matricula);
        nombre = (EditText) findViewById(R.id.nombre);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        password2 = (EditText) findViewById(R.id.password2);

        rg = (RadioGroup) findViewById(R.id.radioGroup);

        //isProfesor = (RadioButton) findViewById(R.id.isProfesor);

        /*if (isAlumno.isChecked())
            rol = isAlumno.getText();
        else if(isProfesor.isChecked())
            rol = isProfesor.getText();
    */
        registrarUsuario = (Button) findViewById(R.id.registrarUsuario);


            registrarUsuario.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (TextUtils.isEmpty(nombre.getText().toString()))
                    {
                        nombre.setError("No puede estar vacio");
                        return;
                    }

                    if (TextUtils.isEmpty(matricula.getText().toString()))
                    {
                        matricula.setError("No puede estar vacio");
                        return;
                    }
                    if (TextUtils.isEmpty(email.getText().toString()))
                    {
                        email.setError("No puede estar vacio");
                        return;
                    }
                    if (TextUtils.isEmpty(password.getText().toString()))
                    {
                        password.setError("No puede estar vacio");
                        return;
                    }

                    if (TextUtils.isEmpty(password2.getText().toString()))
                    {
                        password2.setError("No puede estar vacio");
                        return;
                    }

                    if(password.getText().toString().equals(password2.getText().toString())) {

                        final RegistroDbHelper registroHelper = new RegistroDbHelper(getApplicationContext());
                        SQLiteDatabase db = registroHelper.getWritableDatabase();
                        ContentValues valores = new ContentValues();

                        //rol = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).toString();
                        int selectId = rg.getCheckedRadioButtonId();

                        rol = (RadioButton) findViewById(selectId);

                        valores.put(RegistroContract.RegistroEntry.matricula, matricula.getText().toString());
                        valores.put(RegistroContract.RegistroEntry.nombre, nombre.getText().toString());
                        valores.put(RegistroContract.RegistroEntry.email, email.getText().toString());
                        valores.put(RegistroContract.RegistroEntry.password, password.getText().toString());
                        //Toast.makeText(RegisterActivity.this, isAlumno.getText(), Toast.LENGTH_SHORT).show();
                        valores.put(RegistroContract.RegistroEntry.rol, rol.getText().toString());
                        long idGuardado = db.insert(RegistroContract.RegistroEntry.TABLE_NAME, null, valores);

                        if (idGuardado != -1) {
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            i.putExtra("matricula", idGuardado);
                            startActivity(i);
                        } else {
                            Toast.makeText(RegisterActivity.this, "La matricula ya esta registrada " + rol, Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this,"Las contraseñas no son iguales", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

}
