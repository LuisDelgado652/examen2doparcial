package facci.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;

import facci.myapplication.adaptador.representanteadaptador;
import facci.myapplication.modelos.representantemodelo;

public class general extends AppCompatActivity {
    TextView añadir;
    RecyclerView representanterecycler;
    representanteadaptador representanteadaptador;
    List<representantemodelo> representante;
    private FirebaseFirestore based;
    String id, cedula, nombresapellidos, correo, iniactividades, tipocomercio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        based = FirebaseFirestore.getInstance();

        representanterecycler = (RecyclerView)findViewById(R.id.rv);
        representanterecycler.setLayoutManager(new LinearLayoutManager(this));
        representante = new ArrayList<>();
        representanteadaptador = new representanteadaptador(representante);
        representanterecycler.setAdapter(representanteadaptador);

        based.collection("representante").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException e) {
                representante.removeAll(representante);
                for(DocumentSnapshot dsnap:value.getDocuments()){
                    id = dsnap.getId();
                    cedula = dsnap.getString("cedula");
                    nombresapellidos = dsnap.getString("nombresapellidos");
                    correo = dsnap.getString("correo");
                    iniactividades = dsnap.getString("iniactividades");
                    tipocomercio = dsnap.getString("tipocomercio");
                    representante.add(new representantemodelo(id, cedula, nombresapellidos, correo, iniactividades, tipocomercio));
                }
                representanteadaptador.notifyDataSetChanged();
            }
        });
        añadir = findViewById(R.id.anadir);
        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), registro.class));
            }
        });
    }
}