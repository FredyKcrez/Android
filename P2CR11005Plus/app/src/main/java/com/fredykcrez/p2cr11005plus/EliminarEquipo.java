package com.fredykcrez.p2cr11005plus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarEquipo extends Activity {
    EditText CodEq;
    BDControl controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_equipo);
        controlhelper = new BDControl(this);
        CodEq=(EditText)findViewById(R.id.editCodEquipo);
    }

    public void eliminarEquipo(View v) {
        //verificar que no haya campo vacio
        if (TextUtils.isEmpty(CodEq.getText().toString())) {
            Toast.makeText(this, "Por favor llene el campo vacio", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setCancelable(false);
            dialog.setTitle("Eliminar");
            dialog.setMessage("Realmente desea eliminar este Registro?");
            dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    aceptar();
                }
            });
            dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            dialog.show();
        }
    }

    public void aceptar() {
        String regEliminadas;
        Equipo eq = new Equipo();
        eq.setCodEquipo(CodEq.getText().toString());
        controlhelper.abrir();
        regEliminadas = controlhelper.eliminar(eq);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}