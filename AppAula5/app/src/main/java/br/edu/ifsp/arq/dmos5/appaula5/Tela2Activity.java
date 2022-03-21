package br.edu.ifsp.arq.dmos5.appaula5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Tela2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        //String nome = intent.getStringExtra("nome");
        //int idade = intent.getIntExtra("idade", -1);

        Pessoa pessoa = (Pessoa)intent.getSerializableExtra("pessoa");
        String msg = String.format("Nome: %s\nIdade:%d", pessoa.getNome(), pessoa.getIdade());
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}