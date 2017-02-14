package mx.amper.mascotas.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.amper.mascotas.Pojo.Mascotas2;
import mx.amper.mascotas.R;

/**
 * Created by amper on 03/02/2017.
 */

public class MascotasAdaptador2 extends RecyclerView.Adapter<MascotasAdaptador2.MascotasViewHolder>{

    ArrayList<Mascotas2> mascotas2;
    Activity activity;

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto2;
        private TextView tvRanking2;
        private ImageButton btnBonce_Y2;

        public MascotasViewHolder(View itemView) {
            super(itemView);
            imgFoto2   = (ImageView) itemView.findViewById(R.id.imgMascota3);
            tvRanking2 = (TextView) itemView.findViewById(R.id.tvName3);
            btnBonce_Y2 = (ImageButton) itemView.findViewById(R.id.ibBone_Y2);
        }
    }

    public MascotasAdaptador2(ArrayList<Mascotas2> mascotas2, Activity activity2) {
        this.mascotas2 = mascotas2;
        this.activity = activity2;
    }


    @Override
    public MascotasAdaptador2.MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview_mascotas, parent, false);
        return new MascotasViewHolder(V);
    }

    @Override
    public void onBindViewHolder(final MascotasAdaptador2.MascotasViewHolder mascotas2ViewHolder, int position) {
        final Mascotas2 mascota2 = mascotas2.get(position);
        mascotas2ViewHolder.imgFoto2.setImageResource(mascota2.getFoto());
        mascotas2ViewHolder.tvRanking2.setText(mascota2.getRanking());

    }

    @Override
    public int getItemCount() {
        return mascotas2.size();
    }



}
