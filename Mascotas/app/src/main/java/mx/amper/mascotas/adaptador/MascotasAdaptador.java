package mx.amper.mascotas.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.amper.mascotas.Mascotas;
import mx.amper.mascotas.Mascotas2;
import mx.amper.mascotas.R;

/**
 * Created by amper on 03/02/2017.
 */

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotasViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRanking;
        private ImageButton btnBonce;
        private ImageButton btnBonce_Y;

        public MascotasViewHolder(View itemView) {
            super(itemView);
            imgFoto   = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombre  = (TextView) itemView.findViewById(R.id.tvName);
            tvRanking = (TextView) itemView.findViewById(R.id.tvRanking);
            btnBonce  = (ImageButton) itemView.findViewById(R.id.ibBone_only);
            btnBonce_Y = (ImageButton) itemView.findViewById(R.id.ibBone_Y);

        }
    }

    public MascotasAdaptador (ArrayList<Mascotas> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotasAdaptador.MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotasViewHolder(V);
    }

    @Override
    public void onBindViewHolder(final MascotasAdaptador.MascotasViewHolder mascotasViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        mascotasViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotasViewHolder.tvNombre.setText(mascota.getNombre());
        mascotasViewHolder.tvRanking.setText(mascota.getRanking());

        mascotasViewHolder.btnBonce.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Click en Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascotasViewHolder.btnBonce.setImageResource(R.drawable.bone_y);
                }
        });


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }



}
