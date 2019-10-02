package com.example.cuamatzi.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1,et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.ET1);
        et2 = (EditText)findViewById(R.id.ET2);
        tv1 = (TextView)findViewById(R.id.TV1);
        spinner1 = (Spinner)findViewById(R.id.spinner);

        String [] opciones = {"sumar","restar","multiplicar","dividir"};

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        spinner1.setAdapter(adapter);
    }
    //mrtodo del boton
    public void calcular(View View){
        String VS1 = et1.getText().toString();
        String VS2 = et2.getText().toString();

        int V1 = Integer.parseInt(VS1);
        int V2 = Integer.parseInt(VS2);

        String seleccion = spinner1.getSelectedItem().toString();
        if(seleccion.equals("sumar")){

            int suma = V1 + V2;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);

        }else if (seleccion.equals("restar")){

            int resta = V1 - V2;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);

        }else  if(seleccion.equals("multiplicar")){

            int multiplicar = V1 * V2;
            String resultado = String.valueOf(multiplicar);
            tv1.setText(resultado);

        }else if(seleccion.equals("dividir")){

                if ( V1 != 0 && V2 != 0){
                    int div = V1 / V2;
                    String resultado = String.valueOf(div);
                    tv1.setText(resultado);
                 }else {
                    Toast.makeText(this,"NO ES POSIBLE LA DIVISION ENTRE 0",Toast.LENGTH_LONG).show();
                }
        }

    }
}
