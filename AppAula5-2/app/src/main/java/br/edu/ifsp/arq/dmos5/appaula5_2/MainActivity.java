package br.edu.ifsp.arq.dmos5.appaula5_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int REQUISICAO_ESTADO =1;

    private String estado;

    private Button btnSelecionar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSelecionar = findViewById(R.id.btn_selecionar);
        btnSelecionar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getBaseContext(),
                        TelaEstadosActivity.class);
                intent.putExtra(TelaEstadosActivity.EXTRA_ESTADO, estado);
                startActivityForResult(intent, REQUISICAO_ESTADO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUISICAO_ESTADO){
            estado = data.getStringExtra(TelaEstadosActivity.EXTRA_RESULTADO);
            if(estado!=null){
                btnSelecionar.setText(estado);
            }
        }
    }

}