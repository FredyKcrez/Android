package com.example.fredykcrez.basededatoscr11005;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaInsertarActivity extends Activity {
    ControlBDCR11005 helper;
    EditText editCodmateria, editNommateria, editUnidadesval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_insertar);
        helper = new ControlBDCR11005(this);
        editCodmateria = (EditText) findViewById(R.id.editCodmat);
        editNommateria = (EditText) findViewById(R.id.editNommateria);
        editUnidadesval = (EditText) findViewById(R.id.editUnidadesval);
    }

    public void insertarMateria(View v) {
        String regInsertados;
        Materia mat=new Materia();
        mat.setCodmateria(editCodmateria.getText().toString());
        mat.setNommateria(editNommateria.getText().toString());
        mat.setUnidadesval(editUnidadesval.getText().toString());

        helper.abrir();
        regInsertados=helper.insertar(mat);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
}