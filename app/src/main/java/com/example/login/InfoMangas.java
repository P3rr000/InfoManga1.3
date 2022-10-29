package com.example.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class InfoMangas extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomangas);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart",true);

        if (firstStart){
            segundaAlerta();
        }
    }
    public void MostrarLista(View view) {
        Intent mostrarLista = new Intent(this, CardViewUno.class);
        startActivity(mostrarLista);
    }

    private void segundaAlerta(){
        new AlertDialog.Builder(this)
                .setTitle("¿De que trata esta aplicación?")
                .setMessage("InfoManga es una aplicación en donde se mostrará información sobre mangas y juegos de interes del creador o sea JP")
                .setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .create().show();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }
}