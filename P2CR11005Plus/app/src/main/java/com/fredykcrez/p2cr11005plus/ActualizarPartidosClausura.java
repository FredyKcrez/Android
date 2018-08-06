package com.fredykcrez.p2cr11005plus;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActualizarPartidosClausura extends Activity {
    BDControl helper;
    EditText numFecha, codEq, golAF, golEC, rival;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_partidos_clausura);
        helper = new BDControl(this);
        numFecha = (EditText) findViewById(R.id.editNumFecha);
        codEq= (EditText) findViewById(R.id.editCodEquipo);
        golAF = (EditText) findViewById(R.id.editGolAF);
        golEC = (EditText) findViewById(R.id.editGolEC);
        rival = (EditText) findViewById(R.id.editRival);
    }

    public void actualizarPC(View v) {
        //verificar que no haya campo vacio
        if (TextUtils.isEmpty(numFecha.getText().toString())||TextUtils.isEmpty(codEq.getText().toString())||TextUtils.isEmpty(golAF.getText().toString())||TextUtils.isEmpty(golEC.getText().toString())||TextUtils.isEmpty(rival.getText().toString())) {
            Toast.makeText(this, "Por favor llene todos los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            PartidosClausura pc = new PartidosClausura();
            pc.setNumFecha(numFecha.getText().toString());
            pc.setCodEquipo(codEq.getText().toString());
            pc.setGolesAFavor(Integer.valueOf(golAF.getText().toString()));
            pc.setGolesEnContra(Integer.valueOf(golEC.getText().toString()));
            pc.setRival(rival.getText().toString());

            helper.abrir();
            String estado = helper.actualizar(pc);
            helper.cerrar();
            Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTexto(View v) {
        numFecha.setText("");
        codEq.setText("");
        golAF.setText("");
        golEC.setText("");
        rival.setText("");
    }
}