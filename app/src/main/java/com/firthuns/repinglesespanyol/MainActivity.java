package com.firthuns.repinglesespanyol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //1º declaracion de elementos
    private ImageView img1, img2, img3;
    private ImageButton btn1, btn2, btn3;
    private Button btnVerMas;

    // En la siguiente variable guardaremos el id del valor del texto, ubicado en STRINGS.XML
    private int idTextoMostrar =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicializamos variables
        inicializarElementos();
        // Realizamos la ocultación de la imagenes mediante codigo
        ocultamosImagenes();


        btnVerMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* el siguiente condicionante, trata de si el valor =0, es debido
                / a que no se ha seleccinado imagen alguno, por tanto no mostraremos texto
                / alguno en la siguiente ventana */

                if(idTextoMostrar !=0){
                    Bundle bundle = new Bundle();
                    bundle.putInt("TEXTO", idTextoMostrar);

                    Intent intent = new Intent( MainActivity.this ,  TextoActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent); //utilizo este evento ya que no espero ninguna información de la siguiente ventana
                }
            }
        });


    } // fin oncreate

    /* Ojo! que una vez realizado el metodo copiamos el nombre de la función
     * y dentro del layout, en la parte de los atributos, seleccionamos los tres imageButton y buscamos
     * el evento "onclick" -> e asignamos el metodo selectImg
     Ademas , la funcion de a continuación lo que hace es que detecta la pulsación del usuario sobre
     la imagen capturandose el id del elemento pulsado, asignandose las variables gloables, el id
     seleccionado, para luego el btnVerMas -> tras ser pulsado manda la info a la siguiente ventana

     */

    public void selectImg(View btn){ //IDIOTA SE TE HA OLVIDADO METER ASOCIAR EL METODO A LOS IMGBUTTON
        ocultamosImagenes();
        switch (btn.getId()){

            case R.id.imgBtnCasa:
                img1.setVisibility(View.VISIBLE);
                idTextoMostrar = R.string.txtCasa;

                Toast.makeText(getApplicationContext(),"valor ID string1: " + idTextoMostrar, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.imgBtnFamilia:
                img2.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),R.string.txtFamilia, Toast.LENGTH_SHORT ).show();

                idTextoMostrar = R.string.txtFamilia;
                break;
            case R.id.imgBtnYo:
                img3.setVisibility(View.VISIBLE);
                idTextoMostrar = R.string.txtYo;
                break;

        }

    }

    private void ocultamosImagenes() {
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
    }

    private void inicializarElementos() {
        img1 = findViewById(R.id.imgCasa);
        img2 = findViewById(R.id.imgFamilia);
        img3 = findViewById(R.id.imgYo);

//        btn1= findViewById(R.id.imgBtnCasa);
//        btn1= findViewById(R.id.imgBtnFamilia);
//        btn1= findViewById(R.id.imgBtnYo);

        btnVerMas = findViewById(R.id.btnVerMas);
    }
}