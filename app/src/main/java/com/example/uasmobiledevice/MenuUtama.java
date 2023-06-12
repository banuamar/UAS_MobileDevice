package com.example.uasmobiledevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MenuUtama extends AppCompatActivity {
    Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {okDiklik();}
        });
        Spinner Menu = (Spinner)findViewById(R.id.pilihanMenu);
//Daftar isian spninner yang tampil
        String[] pilihanMenu = {
                "Jelajahi", "Hubungi", "Baca Data", "Cek Posisi" };
//Mengubah arr mj ArrAdapter
        ArrayAdapter<String> arrayAdapterMenu = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, pilihanMenu);
//Memasukkan ArrAdapater ke spinner
        Menu.setAdapter(arrayAdapterMenu);
    }
    public void okDiklik() {

        }
    }
}