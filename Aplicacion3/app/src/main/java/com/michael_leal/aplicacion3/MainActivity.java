package com.michael_leal.aplicacion3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        database = FirebaseDatabase.getInstance().getReference();

        database.child("sensor1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String nombre = dataSnapshot.child("Nombre sensor").getValue().toString();
                    String valor = dataSnapshot.child("Valor sensor").getValue().toString();
                    txt1.setText("Nombre: " + nombre+"   Valor: "+valor);


                    txt1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (MainActivity.this,MainActivity2.class);
                            startActivity(intent);
                        }
                    });

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        database.child("sensor2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String nombre = dataSnapshot.child("Nombre sensor").getValue().toString();
                    String valor = dataSnapshot.child("Valor sensor").getValue().toString();
                    txt2.setText("Nombre: " + nombre+"   Valor: "+valor);

                    txt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (MainActivity.this,MainActivity3.class);
                            startActivity(intent);
                        }
                    });

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        database.child("sensor3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String nombre = dataSnapshot.child("Nombre sensor").getValue().toString();
                    String valor = dataSnapshot.child("Valor sensor").getValue().toString();
                    txt3.setText("Nombre: " + nombre+"   Valor: "+valor);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}