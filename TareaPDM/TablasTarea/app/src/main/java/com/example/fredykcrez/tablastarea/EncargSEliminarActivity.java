package com.example.fredykcrez.tablastarea;

import android.app.Activity;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EncargSEliminarActivity extends Activity {
    EditText editCodencarg;
    ControlBD controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encarg_seliminar);
        controlhelper=new ControlBD (this);
        editCodencarg=(EditText)findViewById(R.id.editCodencarg);
    }
    public void eliminarEncargS(View v){
        String regEliminadas;
        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(editCodencarg.getText().toString())) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            EncargS encargS = new EncargS();
            encargS.setCodencarg(editCodencarg.getText().toString());
            controlhelper.abrir();
            regEliminadas = controlhelper.eliminar(encargS);
            controlhelper.cerrar();
            Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        }
    }
    public void limpiar(View view){
        editCodencarg.setText("");
    }
}