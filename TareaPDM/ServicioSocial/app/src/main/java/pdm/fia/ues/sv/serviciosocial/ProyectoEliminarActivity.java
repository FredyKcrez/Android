package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ProyectoEliminarActivity extends Activity {

    EditText editCodigoProyecto;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecto_eliminar);
        controlhelper=new ControlBD (this);
        editCodigoProyecto=(EditText)findViewById(R.id.editCodigoProyecto);
    }
    public void eliminarProyecto(View v){
        String regEliminadas;
        Proyecto pro=new Proyecto();
        pro.setCodigoProyecto(editCodigoProyecto.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(pro);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}