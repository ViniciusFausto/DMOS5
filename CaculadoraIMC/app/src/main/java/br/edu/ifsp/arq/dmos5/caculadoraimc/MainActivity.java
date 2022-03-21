package br.edu.ifsp.arq.dmos5.caculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtAltura;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = findViewById(R.id.peso);
        edtAltura = findViewById(R.id.altura);
        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Double peso = Double.parseDouble(edtPeso.getText().toString());
                Double altura = Double.parseDouble(edtAltura.getText().toString());

                Double imc = peso/(altura*altura);

                if (imc <= 18.5) {
                    Toast.makeText(MainActivity.this,  "ABAIXO DO PESO",
                            Toast.LENGTH_SHORT).show();
                } else if (imc > 18.4 && imc < 25) {
                    Toast.makeText(MainActivity.this,  "PESO NORMAL",
                            Toast.LENGTH_SHORT).show();
                } if (imc > 24.9 && imc < 30) {
                    Toast.makeText(MainActivity.this,  "ACIMA DO PESO",
                            Toast.LENGTH_SHORT).show();
                } else if (imc > 30) {
                    Toast.makeText(MainActivity.this,  "OBESO",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}