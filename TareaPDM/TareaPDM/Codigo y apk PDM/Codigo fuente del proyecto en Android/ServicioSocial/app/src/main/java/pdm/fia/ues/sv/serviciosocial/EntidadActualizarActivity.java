package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EntidadActualizarActivity extends Activity {

    ControlBD helper;
    EditText editCodigo_org;
    EditText editNombre_org;
    EditText editRubro;
    EditText editTelefono;
    EditText editDireccion;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entidad_actualizar);
        helper = new ControlBD(this);
        editCodigo_org = (EditText) findViewById(R.id.editCodigo_org);
        editNombre_org = (EditText) findViewById(R.id.editNombre_organizacion);
        editRubro = (EditText) findViewById(R.id.editRubro);
        editTelefono = (EditText) findViewById(R.id.editTelefono);
        editDireccion = (EditText) findViewById(R.id.editDireccion);
    }

    public void consultarEntidad(View v) {
        helper.abrir();
        Entidad entidad = helper.consultarEntidad(editCodigo_org.getText().toString());
        helper.cerrar();
        if(entidad == null)
            Toast.makeText(this, "Entidad con Codigo " + editCodigo_org.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre_org.setText(entidad.getNombre_organizacion());
            editRubro.setText(entidad.getRubro());
            editTelefono.setText(entidad.getTelefono());
            editDireccion.setText(entidad.getDireccion());
        }
    }

    public void actualizarEntidad(View v) {
        Entidad entidad = new Entidad();
        entidad.setCodigo_org(editCodigo_org.getText().toString());
        entidad.setNombre_organizacion(editNombre_org.getText().toString());
        entidad.setRubro(editRubro.getText().toString());
        entidad.setTelefono(editTelefono.getText().toString());
        entidad.setDireccion(editDireccion.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(entidad);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCodigo_org.setText("");
        editNombre_org.setText("");
        editRubro.setText("");
        editTelefono.setText("");
        editDireccion.setText("");
    }
}
