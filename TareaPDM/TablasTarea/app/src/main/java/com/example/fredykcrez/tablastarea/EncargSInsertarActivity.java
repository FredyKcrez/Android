package com.example.fredykcrez.tablastarea;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioGroup;

public class EncargSInsertarActivity extends Activity {
    ControlBD helper;
    EditText editCodencarg;
    EditText editNombre;
    EditText editApellido;
    RadioGroup editSexo;
    EditText editCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encarg_sinsertar);
        helper = new ControlBD(this);

        editCodencarg = (EditText) findViewById(R.id.editCodencarg);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (RadioGroup) findViewById(R.id.editGrupo);
        editCorreo = (EditText) findViewById(R.id.editCorreo);
    }

    public void insertarEncargS(View v) {
        String codencarg=editCodencarg.getText().toString();
        String nombre=editNombre.getText().toString();
        String apellido=editApellido.getText().toString();
        String sexo="";
        switch(editSexo.getCheckedRadioButtonId()){
            case R.id.radiobutton1: {
                sexo="F";
                break;
            }
            case R.id.radiobutton2: {
                sexo="M";
                break;
            }
        }
        String correo=editCorreo.getText().toString();
        String regInsertados;

        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(codencarg)||TextUtils.isEmpty(nombre)||TextUtils.isEmpty(apellido)||TextUtils.isEmpty(sexo)||TextUtils.isEmpty(correo)) {
        	Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else{
        	EncargS encargS=new EncargS();
        	encargS.setCodencarg(codencarg);
	        encargS.setNombre(nombre);
	        encargS.setApellido(apellido);
	        encargS.setSexo(sexo);
	        encargS.setCorreo(correo);

	        helper.abrir();
	        regInsertados=helper.insertar(encargS);
	        helper.cerrar();
	        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	    }
    }
    public void limpiarTexto(View v) {
        editCodencarg.setText("");
        editNombre.setText("");
        editApellido.setText("");
        editSexo.clearCheck();
        editCorreo.setText("");
    }
}