package br.edu.ifsp.arq.dmos5.appaula5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TelaEstadosActivity extends ListActivity {

    protected static final String EXTRA_ESTADO = "estado";
    protected static final String EXTRA_RESULTADO = "resultado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] estados = getResources().getStringArray(R.array.estados);

        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_single_choice,estados));
        String estado = getIntent().getStringExtra(EXTRA_ESTADO);
        if (estado != null){
            int posicao = Arrays.asList(estados).indexOf(estado);
            getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(posicao,true);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String resultado = l.getItemAtPosition(position).toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESULTADO,resultado);
        setResult(RESULT_OK, intent);
        finish();
    }
}