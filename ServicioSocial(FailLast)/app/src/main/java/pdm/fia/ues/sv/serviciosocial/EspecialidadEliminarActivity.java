package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EspecialidadEliminarActivity extends Activity {

    EditText editCodigo_esp;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidad_eliminar);
        controlhelper=new ControlBD (this);
        editCodigo_esp=(EditText)findViewById(R.id.editCodigo_esp);
    }
    public void eliminarEntidad(View v){
        String regEliminadas;
        Especialidad especialidad=new Especialidad();
        especialidad.setCodigo_esp(editCodigo_esp.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(especialidad);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
