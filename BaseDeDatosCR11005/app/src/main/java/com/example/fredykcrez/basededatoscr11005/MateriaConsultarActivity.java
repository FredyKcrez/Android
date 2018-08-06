package com.example.fredykcrez.basededatoscr11005;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriaConsultarActivity extends Activity {
    ControlBDCR11005 helper;
    EditText Codmat;
    EditText Nommat;
    EditText Unidadval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_consultar);
        helper = new ControlBDCR11005(this);
        Codmat = (EditText) findViewById(R.id.editCodmat);
        Nommat = (EditText) findViewById(R.id.editNommat);
        Unidadval = (EditText) findViewById(R.id.editUnidadesval);
    }

    public void consultarMateria(View v) {
        helper.abrir();
        Materia mat = helper.consultarMateria(Codmat.getText().toString());
        helper.cerrar();
        if(mat == null)
            Toast.makeText(this, "Materia con codigo " + Codmat.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            Nommat.setText(mat.getNommateria());
            Unidadval.setText(mat.getUnidadesval());
        }
    }
    public void limpiarTexto(View v){
        Codmat.setText("");
        Nommat.setText("");
        Unidadval.setText("");
    }
}
