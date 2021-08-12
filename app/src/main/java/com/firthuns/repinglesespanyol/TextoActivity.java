package com.firthuns.repinglesespanyol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TextoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

        TextView txtInfo = findViewById(R.id.txtTexto);
        Toast.makeText(getApplicationContext(),getIntent().getExtras().getInt("TEXTO"), Toast.LENGTH_SHORT ).show();
        int idTexto = getIntent().getExtras().getInt("TEXTO");
        txtInfo.setText(idTexto);
    }
}