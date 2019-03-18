package com.example.bepis21.practicamoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.StringTokenizer;

public class CalcularParrafoActivity extends AppCompatActivity {

    private List<Object> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_parrafo);

        Intent intent = getIntent();
        String parrafo =intent.getStringExtra(MainActivity.MESSAGE);
        StringTokenizer palabra = new StringTokenizer(parrafo);

        //Calcular cantidad de palabras
        String res1 = "\n"+"Cantidad de pálabras: "+palabra.countTokens()+"\n";

        //Contar palabras repetidas

        String palabras [] = parrafo.split(" ");
        String palabrasB [] = parrafo.split(" ");

        int cantidad = palabras.length;
        String res2 = "";

        for (int i = 0; i < cantidad; i++) {
            int conatdor= 0;
            res2 += palabras[i];
            String pala = palabras[i];

            for (int j = 0; j < cantidad; j++) {

                if (pala.equalsIgnoreCase(palabrasB[j])){
                    conatdor++;
                    palabras[j] = "";

                }
            }
            if (conatdor>0){
                res2 += " "+conatdor+"\n";
            }

        }

        /*
        @res3 palabras palindromas (diferenciadas en mayúsculas)
        @parrafo texto que recupera
         */
        String palindroma [] = parrafo.split(" ");
        String res3 = "";
        String frase ="";
        int cont=0;
        for (int i = 0; i < palindroma.length; i++) {
            int caso=0;
            String cadena = palindroma[i];
            int tam = palindroma[i].length();
            for (int y=0;y<tam/2;y++){

                if (cadena.charAt(y)!=cadena.charAt(tam-1-y)){
                    caso++;
                }
            }if (caso==0){
                cont++;
                frase+=palindroma[i]+"\n";
            }
        }res3="Cantidad de palindromas: "+cont+"\n"+" Palabras: "+frase;

        //Imprimir Respuesta
        TextView textView = new TextView(this);
        textView.setText(parrafo);
        textView.setTextSize(20);
        TextView textView1 = new TextView(this);
        textView1.setText(res1);
        textView1.setTextSize(20);
        TextView textView2 = new TextView(this);
        textView2.setText(res2);
        textView2.setTextSize(20);
        TextView textView3 = new TextView(this);
        textView3.setText(res3);
        textView3.setTextSize(20);




        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_calcular_parrafo);
        viewGroup.addView(textView);
        viewGroup.addView(textView1);
        viewGroup.addView(textView2);
        viewGroup.addView(textView3);

    }
}
