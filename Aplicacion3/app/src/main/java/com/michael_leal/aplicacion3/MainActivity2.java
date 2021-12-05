package com.michael_leal.aplicacion3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {

    private TextView txt11;
    private TextView txt22;
    private TextView txt33;
    private TextView txt44;
    private TextView txt55;
    private TextView txt66;
    private Button btn2;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt11 = (TextView) findViewById(R.id.txt11);
        txt22 = (TextView) findViewById(R.id.txt22);
        txt33 = (TextView) findViewById(R.id.txt33);
        txt44 = (TextView) findViewById(R.id.txt44);
        txt55 = (TextView) findViewById(R.id.txt55);
        txt66 = (TextView) findViewById(R.id.txt66);
        btn2 = (Button)  findViewById(R.id.btn2);
        database = FirebaseDatabase.getInstance().getReference();

        database.child("sensor1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String nombre = dataSnapshot.child("Nombre sensor").getValue().toString();
                    txt11.setText("Nombre: " + nombre);
                    String valor = dataSnapshot.child("Valor sensor").getValue().toString();
                    txt22.setText("Valor: "+valor);
                    String tipo = dataSnapshot.child("Tipo sensor").getValue().toString();
                    txt33.setText("tipo: "+tipo);
                    String ubi = dataSnapshot.child("Ubicacion").getValue().toString();
                    txt44.setText("Ubicacion: "+ubi);
                    String FYH = dataSnapshot.child("Fecha y hora").getValue().toString();
                    txt55.setText("Fecha y hora: "+FYH);
                    String obser = dataSnapshot.child("Observacion").getValue().toString();
                    txt66.setText("Observacion: "+obser);



                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (MainActivity2.this,MainActivity4.class);
                            startActivity(intent);
                        }
                    });




                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}