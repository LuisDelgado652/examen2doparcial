package facci.myapplication.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import facci.myapplication.R;
import facci.myapplication.individual;
import facci.myapplication.modelos.representantemodelo;

public class representanteadaptador extends RecyclerView.Adapter<representanteadaptador.ViewHolder>{
    public List<representantemodelo> representantelista;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        private TextView cardcedula,cardnombres;
        private String id;
        CardView cvrepresentante;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            context=itemView.getContext();
            cardcedula= itemView.findViewById(R.id.cardcedula);
            cardnombres = itemView.findViewById(R.id.cardnombres);
            cvrepresentante = itemView.findViewById(R.id.cvrepresentante);
        }
        void setOnClickListeners(){
            cvrepresentante.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.cvrepresentante:
                    context.startActivity(new Intent(context, individual.class).putExtra("id",id));
                    break;
            }
        }
    }

    public representanteadaptador(List<representantemodelo> representantelista) {
        this.representantelista = representantelista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crepresentante,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        representantemodelo representante = representantelista.get(position);
        holder.cardcedula.setText(representante.getCedula());
        holder.cardnombres.setText(representante.getNombresapellidos());
        holder.id = representante.getId();
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return representantelista.size();
    }

}
