package com.fredykcrez.p2cr11005plus;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultaPartidosClausura extends Activity {
    BDControl helper;
    EditText codEq, response;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_partidos_clausura);
        helper = new BDControl(this);
        codEq = (EditText) findViewById(R.id.editCodEquipo);
    }
    public void consultarPC(View v) {
        //verificar que no haya campo vacio
        if (TextUtils.isEmpty(codEq.getText().toString())) {
            Toast.makeText(this, "Por favor llene el campo vacio", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            helper.abrir();
            int eq = helper.consultarPC(codEq.getText().toString());
            helper.cerrar();
            if (eq == 0)
                Toast.makeText(this, "El equipo no esta registrado", Toast.LENGTH_LONG).show();
            else {
                response.setText(String.valueOf(eq));
            }
        }
    }

    public void limpiarTexto(View v) {
        codEq.setText("");
        response.setText("");
    }
}