package com.efom.utiles_lib.Adapters;
/*
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterEventos extends RecyclerView.Adapter<RecyclerViewHolder> {
    ArrayList<String[]> eventos;

    public AdapterEventos (ArrayList<String[]> eventos){
        this.eventos = eventos;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup AdapterEventos, int viewType) {
        View view = (CardView) LayoutInflater.from(AdapterEventos.getContext()).inflate(R.layout.card_eventos, AdapterEventos, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tV_titulo.setText(eventos.get(position)[1]);
        holder.tV_descripcion.setText(eventos.get(position)[2]);
        holder.tV_hora.setText(eventos.get(position)[3]);
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

}*/