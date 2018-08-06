package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EntidadConsultarActivity extends Activity {

    ControlBD helper;
    EditText editNombre_organizacion;
    EditText editCodigo_org;
    EditText editRubro;
    EditText editTelefono;
    EditText editDireccion;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entidad_consultar);
        helper = new ControlBD(this);

        editNombre_organizacion = (EditText) findViewById(R.id.editNombre_organizacion);
        editCodigo_org = (EditText) findViewById(R.id.editCodigo_org);
        editRubro = (EditText) findViewById(R.id.editRubro);
        editTelefono = (EditText) findViewById(R.id.editTelefono);
        editDireccion = (EditText) findViewById(R.id.editDireccion);
    }
    public void consultarAlumno(View v) {
        helper.abrir();
        Entidad entidad = helper.consultarEntidad(editCodigo_org.getText().toString());
        helper.cerrar();
        if(entidad == null)
            Toast.makeText(this, "Entidad con Codigo " + editCodigo_org.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre_organizacion.setText(entidad.getNombre_organizacion());
            editRubro.setText(entidad.getRubro());
            editTelefono.setText(entidad.getTelefono());
            editDireccion.setText(entidad.getDireccion());
        }
    }
    public void limpiarTexto(View v){
        editNombre_organizacion.setText("");
        editCodigo_org.setText("");
        editRubro.setText("");
        editTelefono.setText("");
        editDireccion.setText("");
    }
}
