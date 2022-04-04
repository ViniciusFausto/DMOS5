package br.edu.ifsp.arq.dmos5.appaula6;

import android.Manifest;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends ListActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.acoes));
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Uri uri = null;
        switch (position){
            case 0: // abrir uma URL
                uri = Uri.parse("http://www.ifsp.edu.br");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                dispararIntent(intent);
                break;
            case 1: // discar um número de telefone
                uri = Uri.parse("tel:(16)99999-1111");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                dispararIntent(intent);
                break;
            case 2: // realizar uma chamada telefônica
                uri = Uri.parse("tel:+55(16)99999-1111");
                intent = new Intent(Intent.ACTION_CALL, uri);
                solicitarPermissao();
                break;
            case 3: // localizar uma posição no mapa
                uri = Uri.parse("geo:0,0");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                dispararIntent(intent);
                break;
            case 4: // visualizar a lista de contatos
                uri = Uri.parse("content://com.android.contacts/contacts/");
                intent = new Intent(Intent.ACTION_PICK, uri);
                dispararIntent(intent);
                break;
            case 5: // editar um SMS
                uri = Uri.parse("sms:12345");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.putExtra("sms_body", "Corpo do SMS");
                dispararIntent(intent);
                break;
            case 6: // compartilhar um conteúdo
                intent = new Intent().setAction(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_TEXT, "Compartilhamento via Intent")
                        .setType("text/plain");
                dispararIntent(intent);
                break;
            case 7: // configurar um alarme
                ArrayList<Integer> dias = new ArrayList<>();
                dias.add(Calendar.MONDAY);
                dias.add(Calendar.WEDNESDAY);
                dias.add(Calendar.FRIDAY);
                intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Estudar DMOS5")
                        .putExtra(AlarmClock.EXTRA_HOUR, 8)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 30)
                        .putExtra(AlarmClock.EXTRA_DAYS, dias)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                dispararIntent(intent);
                break;
            case 8: // buscar na web
                intent = new Intent(Intent.ACTION_WEB_SEARCH)
                        .putExtra(SearchManager.QUERY, "IFSP Araraquara");
                dispararIntent(intent);
                break;
            case 9: // abrir configurações do aparelho
                intent = new Intent(Settings.ACTION_SETTINGS);
                dispararIntent(intent);
                break;
            default:
                finish();
        }
    }

    private void solicitarPermissao() {
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        }else{
            dispararIntent(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_CALL_PHONE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    dispararIntent(intent);
                }else{
                    Toast.makeText(this, R.string.acao_nao_permitida,
                            Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void dispararIntent(Intent intent) {
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this, R.string.acao_nao_suportada,
                    Toast.LENGTH_SHORT).show();
        }
    }
}







