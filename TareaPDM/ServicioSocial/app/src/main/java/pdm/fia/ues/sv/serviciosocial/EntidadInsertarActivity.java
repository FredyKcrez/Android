package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EntidadInsertarActivity extends Activity {

    ControlBD helper;
    EditText editNombre_organizacion;
    EditText editCodigo_org;
    EditText editRubro;
    EditText editTelefono;
    EditText editDireccion;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entidad_insertar);
        helper = new ControlBD(this);
        editNombre_organizacion = (EditText) findViewById(R.id.editNombre_organizacion);
        editCodigo_org = (EditText) findViewById(R.id.editCodigo_org);
        editRubro = (EditText) findViewById(R.id.editRubro);
        editTelefono = (EditText) findViewById(R.id.editTelefono);
        editDireccion = (EditText) findViewById(R.id.editDireccion);
    }
    public void insertarEntidad(View v) {
        String nombre=editNombre_organizacion.getText().toString();
        String codigo=editCodigo_org.getText().toString();
        String rubro=editRubro.getText().toString();
        String telefono=editTelefono.getText().toString();
        String direccion=editDireccion.getText().toString();
        String regInsertados;

            Entidad entidad = new Entidad();
            entidad.setNombre_organizacion(nombre);
            entidad.setCodigo_org(codigo);
            entidad.setRubro(rubro);
            entidad.setTelefono(telefono);
            entidad.setDireccion(direccion);
            helper.abrir();
            regInsertados = helper.insertar(entidad);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();

    }
    public void limpiarTexto(View v) {
        editNombre_organizacion.setText("");
        editCodigo_org.setText("");
        editRubro.setText("");
        editTelefono.setText("");
        editDireccion.setText("");
    }
}
