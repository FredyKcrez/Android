package com.example.fredykcrez.basededatoscr11005;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaEliminarActivity extends Activity {
    EditText editCodm;
    ControlBDCR11005 controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_eliminar);
        controlhelper=new ControlBDCR11005 (this);
        editCodm=(EditText)findViewById(R.id.editCodmat);
    }

    public void eliminarMateria(View v){
        String regEliminadas;
        Materia mat=new Materia();
        mat.setCodmateria(editCodm.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(mat);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}