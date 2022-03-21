package br.edu.ifsp.arq.dmos5.appaula5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ciclo", getClassName() + ".onCreate() chamado");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclo", getClassName() + ".onStart() chamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ciclo", getClassName() + ".onResume() chamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ciclo", getClassName() + ".onPause() chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ciclo", getClassName() + ".onStop() chamado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ciclo", getClassName() + ".onRestart() chamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ciclo", getClassName() + ".onDestroy() chamado");
    }

    private String getClassName() {
        String nomeClasse = getClass().getName();
        return nomeClasse.substring(nomeClasse.lastIndexOf("."));
    }

    public void onClickBtnEnviar(View view) {
        Intent intent = new Intent(getBaseContext(), Tela2Activity.class);

        //enviar dados (String, int) por meio do objeto intent
        //intent.putExtra("nome","Ana Maria");
        //intent.putExtra("idade", 25);

        //enviar um objeto por meio do objeto intent
        Pessoa pessoa = new Pessoa("Vinicius",20);
        intent.putExtra("pessoa", pessoa);
        startActivity(intent);
    }
}