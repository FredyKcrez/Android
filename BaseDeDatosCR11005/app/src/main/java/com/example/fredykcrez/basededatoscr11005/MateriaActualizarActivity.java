package com.example.fredykcrez.basededatoscr11005;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaActualizarActivity extends Activity {
    ControlBDCR11005 helper;
    EditText editCodmat, editNommat, editUnidval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_actualizar);
        helper = new ControlBDCR11005(this);
        editCodmat = (EditText) findViewById(R.id.editCodmat);
        editNommat = (EditText) findViewById(R.id.editNommat);
        editUnidval = (EditText) findViewById(R.id.editUnidval);
    }

    public void actualizarMateria(View v) {
        Materia mat = new Materia();
        mat.setCodmateria(editCodmat.getText().toString());
        mat.setNommateria(editNommat.getText().toString());
        mat.setUnidadesval(editUnidval.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(mat);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editCodmat.setText("");
        editNommat.setText("");
        editUnidval.setText("");
    }
}