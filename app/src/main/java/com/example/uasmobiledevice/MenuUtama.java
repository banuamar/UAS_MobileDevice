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
    Spinner pilihanMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {okDiklik();}
        });
        pilihanMenu = (Spinner) findViewById(R.id.pilihanMenu);

    }
    public void okDiklik() {
        String menuyangdipilih = pilihanMenu.getSelectedItem().toString();
        if (menuyangdipilih .equals("Jelajahi")) {
            Toast.makeText(this.getBaseContext(),"Jelajahi", Toast.LENGTH_LONG).show();
            return;
        }else if (menuyangdipilih .equals("Hubungi")){
            Toast.makeText(this.getBaseContext(),"Hubungi", Toast.LENGTH_LONG).show();
            return;
        }else if (menuyangdipilih .equals("Baca Data")){
            Toast.makeText(this.getBaseContext(),"Baca Data", Toast.LENGTH_LONG).show();
            return;
        }else if (menuyangdipilih .equals("Cek Lokasi")){
            Toast.makeText(this.getBaseContext(),"Cek Lokasi", Toast.LENGTH_LONG).show();
            return;
        }
    }
}