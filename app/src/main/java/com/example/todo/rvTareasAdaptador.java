package com.example.todo;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class rvTareasAdaptador extends RecyclerView.Adapter<rvTareasAdaptador.ViewHolder> {

    private List<Tarea> itemList;
    private OnTareaActionListener listener;

    public rvTareasAdaptador(List<Tarea> itemList, OnTareaActionListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    public interface OnTareaActionListener {
        void editar(int position);
        void borrar(int position);
        void realizada (int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTarea;
        Button btnEditar;
        Button btnBorrar;
        CheckBox cbRealizada;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTarea = itemView.findViewById(R.id.tvTarea);
            btnEditar = itemView.findViewById(R.id.btnEditar);
            btnBorrar = itemView.findViewById(R.id.btnBorrar);
            cbRealizada = itemView.findViewById(R.id.cbRealizada);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tarea, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Tarea tarea = itemList.get(position);
        holder.tvTarea.setText(tarea.getNombre());

        if (tarea.isRealizada()) {
            holder.tvTarea.setPaintFlags(holder.tvTarea.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.tvTarea.setPaintFlags(holder.tvTarea.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }

        holder.cbRealizada.setOnCheckedChangeListener(null);
        holder.cbRealizada.setChecked(tarea.isRealizada());
        holder.cbRealizada.setOnCheckedChangeListener((buttonView, isChecked) -> {
            int pos = holder.getAdapterPosition();
            if (pos != RecyclerView.NO_POSITION && listener != null) {
                listener.realizada(pos);
            }
        });

        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if(pos != RecyclerView.NO_POSITION && listener != null){
                    listener.editar(pos);
                }
            }
        });

        holder.btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION && listener != null) {
                    listener.borrar(pos);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }
}