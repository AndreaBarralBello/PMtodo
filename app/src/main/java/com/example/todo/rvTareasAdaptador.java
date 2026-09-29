package com.example.todo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class rvTareasAdaptador extends RecyclerView.Adapter <rvTareasAdaptador.ViewHolder> {

    private List<Tareas> itemList;

    public rvTareasAdaptador(List<Tareas> itemList) {
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public rvTareasAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull rvTareasAdaptador.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvMitarea;
        Button btnRealizada;
        Button btnBorrar;


            super (itemView);
            tvMitarea = itemView.findViewById(R.id.tvMiTarea);
            btnRealizada = itemView.findViewById(R.id.btnRealizada);
            btnAcceder = itemView.findViewById(R.id.btnBorrar);

    }

}
