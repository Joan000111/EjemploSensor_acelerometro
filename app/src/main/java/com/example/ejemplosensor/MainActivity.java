package com.example.ejemplosensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView SalidaSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SalidaSensores = findViewById(R.id.tsensores);
        SensorManager sensormanager = (SensorManager)
                getSystemService(SENSOR_SERVICE);
        //genera un objeto que permite el acceso a todos los servicios del dispositivo (sensores)

        List<Sensor> listadoSensores = sensormanager.getSensorList(Sensor.TYPE_ALL);

        for(Sensor sensor: listadoSensores){
            //log permite ver el listado en el logcat de abajo
            log(sensor.getName()); //alt + enter y se crea la variable log de abajo
        }

    }

    private void log(String sensores) {
        SalidaSensores.append(sensores + "\n");
    }
}