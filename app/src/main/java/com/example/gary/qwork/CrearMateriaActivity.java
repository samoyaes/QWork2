package com.example.gary.qwork;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class CrearMateriaActivity extends AppCompatActivity {

    EditText materia,NRC;
    Button generarQR;
    ImageView imageQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_materia);

        materia = (EditText) findViewById(R.id.editTextMateria);
        NRC = (EditText) findViewById(R.id.editTextNRC);

        generarQR = (Button) findViewById(R.id.generarQR);

        imageQR = (ImageView) findViewById(R.id.imageQR);

        generarQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MultiFormatWriter multi = new MultiFormatWriter();

                try{
                    BitMatrix matrix = multi.encode(materia.getText().toString()+"_"+NRC.getText().toString(), BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder bar =  new BarcodeEncoder();
                    Bitmap map = bar.createBitmap(matrix);
                    imageQR.setImageBitmap(map);

                }catch (WriterException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
