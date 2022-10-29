package com.example.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardViewUno extends Activity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardviewuno);

        init();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart",true);

        if (firstStart){
            tercerAlerta();
        }
    }
    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("Berserk"));
        elements.add(new ListElement("One Punch Man"));
        elements.add(new ListElement("Vagabond"));
        elements.add(new ListElement("Dragon Ball Super"));
        elements.add(new ListElement("Rikudo"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    private void tercerAlerta(){
        new AlertDialog.Builder(this)
                .setTitle("¿De que trata esta aplicación?")
                .setMessage("Aquí se mostrarán los mangas leidos por JP, en donde cada una tendrá su sinopsis y cantidad de capítulos")
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