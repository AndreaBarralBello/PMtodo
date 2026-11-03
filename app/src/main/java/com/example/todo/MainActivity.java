package com.example.todo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements rvTareasAdaptador.OnTareaActionListener {

    private final List<Tarea> listaTareas = new ArrayList<>();
    private rvTareasAdaptador adaptador;
    private EditText etNuevaTarea;
    private Button btnAdd;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNuevaTarea = findViewById(R.id.etNuevaTarea);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);

        adaptador = new rvTareasAdaptador(listaTareas, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = etNuevaTarea.getText().toString().trim();
                if (!texto.isEmpty()) {
                    listaTareas.add(new Tarea(texto));
                    adaptador.notifyItemInserted(listaTareas.size() - 1);
                    etNuevaTarea.setText("");
                }
            }
        });
    }

    @Override
    public void editar(int position) {
        Tarea tarea = listaTareas.get(position);

        EditText input = new EditText(this);
        input.setText(tarea.getNombre());
        input.setSelection(tarea.getNombre().length());

        new AlertDialog.Builder(this)
                .setTitle("Editar tarea")
                .setView(input)
                .setPositiveButton("Guardar", (d, w) -> {
                    String nuevo = input.getText().toString().trim();
                    if (!nuevo.isEmpty()) {
                        tarea.setNombre(nuevo);
                        adaptador.notifyItemChanged(position);
                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }

    @Override
    public void borrar(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Eliminar tarea")
                .setMessage("¿Seguro que quieres borrar esta tarea?")
                .setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listaTareas.remove(position);
                        adaptador.notifyItemRemoved(position);
                        Toast.makeText(MainActivity.this, "Tarea eliminada", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }


    @Override
    public void realizada(int position) {
        Tarea tarea = listaTareas.get(position);
        tarea.setRealizada(!tarea.isRealizada());
        adaptador.notifyItemChanged(position);
    }

}
