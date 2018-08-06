package com.example.fredykcrez.tablastarea;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TutorEliminarActivity extends Activity {
    EditText editCodtutor, editCodespecial;
    ControlBD controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_eliminar);
        controlhelper=new ControlBD(this);
        editCodtutor=(EditText)findViewById(R.id.editCodtutor);
        editCodespecial=(EditText)findViewById(R.id.editCodespecial);
    }
    public void eliminarTutor(View v){
        String regEliminadas;
        String codt=editCodtutor.getText().toString();
        String code=editCodespecial.getText().toString();

        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(codt)||TextUtils.isEmpty(code)) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            Tutor tt = new Tutor();
            tt.setCodtutor(codt);
            tt.setCodespecial(code);

            controlhelper.abrir();
            regEliminadas = controlhelper.eliminar(tt);
            controlhelper.cerrar();
            Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        }
    }
    public void limpiar(View v){
        editCodtutor.setText("");
        editCodespecial.setText("");
    }
}