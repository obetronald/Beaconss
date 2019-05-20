package com.example.obet.beacons;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class Beaconexion extends AppCompatActivity {

    Button b_on, b_of, b_dis, b_list;
    ListView list;

    private static final int REQUEST_ENABLED = 0;
    private static final int REQUEST_DISCOVERABLE = 0;

    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beaconexion);

        b_on =(Button)findViewById(R.id.b_on);
        b_of =(Button)findViewById(R.id.b_of);
        b_dis =(Button)findViewById(R.id.b_dis);
        b_list =(Button)findViewById(R.id.b_list);

        list = (ListView) findViewById(R.id.list);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothAdapter == null){
            Toast.makeText(this, "bluetooth no soport", Toast.LENGTH_SHORT).show();
        }
        b_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, REQUEST_ENABLED);

            }
        });
        b_of.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bluetoothAdapter.disable();

            }
        });
        b_dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bluetoothAdapter.isDiscovering()){
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent, REQUEST_DISCOVERABLE);
                }

            }
        });
        b_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

                ArrayList<String> devices = new ArrayList<>();

                for(BluetoothDevice bt : pairedDevices){
                    devices.add(bt.getName());
                }

                ArrayAdapter arrayAdapter = new ArrayAdapter(Beaconexion.this, android.R.layout.simple_list_item_1, devices);
                list.setAdapter(arrayAdapter);

            }
        });
    }
}
