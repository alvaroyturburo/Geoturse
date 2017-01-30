package es.codigoandroid.geoturse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.codigoandroid.pojos.Recurso;

/**
 * Created by Alvaro on 22/12/2016.
 */

public class ListaRecursoAdapter extends RecyclerView.Adapter<ListaRecursoAdapter.ListaRecursoViewHolder>{
    public List<Recurso> items;
    ListaRecursoViewHolder holder;

    public ListaRecursoAdapter(List<Recurso> items) {
        this.items = items;
    }

    public static class ListaRecursoViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;
        public CardView cadrViewRecurso;

        public ListaRecursoViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            visitas = (TextView) v.findViewById(R.id.visitas);
            cadrViewRecurso = (CardView) v.findViewById(R.id.cardViewRecurso);

        }

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ListaRecursoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_recurso, viewGroup, false);
         holder = new ListaRecursoViewHolder(v);
        return holder;
        //return new ListaRecursoViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ListaRecursoViewHolder viewHolder, final int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.visitas.setText(" Visitas:"+String.valueOf(items.get(i).getVisitas()));
        final Recurso recursoEnviar = items.get(i);
        holder.cadrViewRecurso.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RecursoDetalle.class);
                intent.putExtra("recurso", recursoEnviar.getNombre());
                intent.putExtra("recurso2", recursoEnviar.getImagen());
                intent.putExtra("recurso3", recursoEnviar.getVisitas());
                view.getContext().startActivity(intent);
            }

        });
    }
}