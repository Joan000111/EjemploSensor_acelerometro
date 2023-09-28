package com.example.ejemplosensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Acelerometro extends AppCompatActivity implements SensorEventListener {
    //se le añade lo de implementar > alt enter y se implementan los dos métodos primeros
    //que deberian estar marcados

    private SensorManager sensormanager;
    private Sensor acelerometro;
    TextView x,y,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

        x = findViewById(R.id.tejex);
        y = findViewById(R.id.tejey);
        z = findViewById(R.id.tejez);
        sensormanager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);

        acelerometro = sensormanager.getDefaultSensor(
                Sensor.TYPE_ACCELEROMETER);

    }

    //se crea el siguiente metodo > para registrar el funcionamiento del sensor
    //lee el estado de los sensores y registra el evento
    @Override
    protected void onResume(){
        super.onResume();
        sensormanager.registerListener(this,acelerometro,SensorManager.SENSOR_DELAY_NORMAL);
    }

    //el evento se pausa
    @Override
    protected void onPause(){
        super.onPause();
        sensormanager.unregisterListener(this);
    }

    @Override //metodo1 > aqui se producen los cambios
    public void onSensorChanged(SensorEvent sensorEvent) {
        float tejex = sensorEvent.values[0];
        x.setText(String.valueOf(tejex));
        float tejey = sensorEvent.values[1];
        y.setText(String.valueOf(tejey));
        float tejez = sensorEvent.values[2];
        z.setText(String.valueOf(tejez));
    }

    @Override //metodo2
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}