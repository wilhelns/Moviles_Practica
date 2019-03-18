package com.example.bepis21.practicamoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static final String MESSAGE = "com.example.bepis21.practicamoviles";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText parrafo = (EditText) findViewById(R.id.TxtParrafo);
        Button calcular = (Button)findViewById(R.id.BtnCalcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = parrafo.getText().toString();

                Intent intent =new Intent(getApplicationContext(),CalcularParrafoActivity.class);
                intent.putExtra(MESSAGE,texto);
                startActivity(intent);

            }
        });

    }
}
