package facci.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class individual extends AppCompatActivity {
    private String id;
    private FirebaseFirestore datab;
    private TextView detallecedula, detallenombresapellidos, detallecorreo, detalleiniactividades, detalletipocomercio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        id = getIntent().getStringExtra("id");
        datab = FirebaseFirestore.getInstance();
        detallecedula = findViewById(R.id.detallecedula);
        detallenombresapellidos = findViewById(R.id.detallenombresapellidos);
        detallecorreo = findViewById(R.id.detallecorreo);
        detalleiniactividades = findViewById(R.id.detalleiniactividades);
        detalletipocomercio = findViewById(R.id.detalletipocomercio);
        DocumentReference dorefe = datab.collection("representante").document(id);
        dorefe.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()){
                    DocumentSnapshot docsnap = task.getResult();
                    if (docsnap.exists()){
                        detallecedula.setText(docsnap.getString("cedula"));
                        detallenombresapellidos.setText(docsnap.getString("nombresapellidos"));
                        detallecorreo.setText(docsnap.getString("correo"));
                        detalleiniactividades.setText(docsnap.getString("iniactividades"));
                        detalletipocomercio.setText(docsnap.getString("tipocomercio"));
                    }
                }

            }
        });
    }
}