package facci.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registro extends AppCompatActivity {
    public FirebaseFirestore datab;
    public EditText cedula, nombresapellidos, correo, iniactividades, tipocomercio;
    public Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        datab = FirebaseFirestore.getInstance();

        cedula = findViewById(R.id.cedula);
        nombresapellidos = findViewById(R.id.nombresapellidos);
        correo = findViewById(R.id.correo);
        iniactividades = findViewById(R.id.iniactividades);
        tipocomercio = findViewById(R.id.tipocomercio);
        guardar = findViewById(R.id.guardar);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Map<String, Object> transportista = new HashMap<>();
                transportista.put("cedula",cedula.getText().toString());
                transportista.put("nombresapellidos",nombresapellidos.getText().toString());
                transportista.put("correo",correo.getText().toString());
                transportista.put("iniactividades",iniactividades.getText().toString());
                transportista.put("tipocomercio",tipocomercio.getText().toString());

                datab.collection("representante").document().set(transportista).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d("representante",  "Creado");
                        finish();
                    }
                });
            }
        });
    }
}