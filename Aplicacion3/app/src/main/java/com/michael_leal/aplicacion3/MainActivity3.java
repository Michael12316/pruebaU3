package com.michael_leal.aplicacion3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {

    private TextView txt111;
    private TextView txt222;
    private TextView txt333;
    private TextView txt444;
    private TextView txt555;
    private TextView txt666;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txt111 = (TextView) findViewById(R.id.txt11);
        txt222 = (TextView) findViewById(R.id.txt22);
        txt333 = (TextView) findViewById(R.id.txt33);
        txt444 = (TextView) findViewById(R.id.txt44);
        txt555 = (TextView) findViewById(R.id.txt55);
        txt666 = (TextView) findViewById(R.id.txt66);
        database = FirebaseDatabase.getInstance().getReference();

        database.child("sensor2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String nombre = dataSnapshot.child("Nombre sensor").getValue().toString();
                    txt111.setText("Nombre: " + nombre);
                    String valor = dataSnapshot.child("Valor sensor").getValue().toString();
                    txt222.setText("Valor: "+valor);
                    String tipo = dataSnapshot.child("Tipo sensor").getValue().toString();
                    txt333.setText("tipo: "+tipo);
                    String ubi = dataSnapshot.child("Ubicacion").getValue().toString();
                    txt444.setText("Ubicacion: "+ubi);
                    String FYH = dataSnapshot.child("Fecha y hora").getValue().toString();
                    txt555.setText("Fecha y hora: "+FYH);
                    String obser = dataSnapshot.child("Observacion").getValue().toString();
                    txt666.setText("Observacion: "+obser);




                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

}