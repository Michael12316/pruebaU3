package com.michael_leal.aplicacion3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {
    private Button btng;
    private DatabaseReference database;
    private EditText es1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btng = (Button)  findViewById(R.id.btng);
        es1= (EditText) findViewById(R.id.es1);
        database = FirebaseDatabase.getInstance().getReference("sensor1");

        btng.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String titulo= es1.getText().toString();

                if(!TextUtils.isEmpty(titulo)){
                    Query q=database.orderByChild(getString(R.string.es1)).equalTo(titulo);

                    q.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){

                                database.child(getString(R.string.es1)).setValue(es1.getText().toString());




                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    Toast.makeText(MainActivity4.this,"Cambios Guardados",Toast.LENGTH_LONG).show();


                }
                else{

                }




            }
        });


    }
}