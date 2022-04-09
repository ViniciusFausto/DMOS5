package br.edu.ifsp.arq.dmos5.ifitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegistroDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}