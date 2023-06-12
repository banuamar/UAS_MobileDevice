package com.example.uasmobiledevice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MenuUtama extends AppCompatActivity implements SensorEventListener {
    Button btnOK;
    Spinner pilihanMenu;
    private SensorManager mSensorManager = null;
    private Sensor mLightSensor = null;
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

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    public void okDiklik() {
        String menuyangdipilih = pilihanMenu.getSelectedItem().toString();
        if (menuyangdipilih .equals("Jelajahi")) {
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ump.ac.id"));
            startActivity(in);

            Toast.makeText(this.getBaseContext(),"Loading....", Toast.LENGTH_LONG).show();
            return;
        }else if (menuyangdipilih .equals("Hubungi")){
            Intent pesan = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"));
            Uri.parse("smsto:082250493611");
            pesan.putExtra("sms_body", "Pesan dari aplikasi android");
            startActivity(pesan);
            Toast.makeText(this.getBaseContext(),"Akan megnirim pesan", Toast.LENGTH_LONG).show();
            return;
        }else if (menuyangdipilih .equals("Baca Data")){
            String kecerahan = mLightSensor.toString();
            Toast.makeText(this.getBaseContext(),"Baca Data"+ kecerahan, Toast.LENGTH_LONG).show();
            return;
        }else if (menuyangdipilih .equals("Cek Posisi")){
            keMap();
        }
    }
    public void keMap(){
        Intent maps = new Intent(MenuUtama.this, MapActivity.class);
        startActivity(maps);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if( sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT)
        {
            Log.d("SensorTest", "" + sensorEvent.values[0]);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}