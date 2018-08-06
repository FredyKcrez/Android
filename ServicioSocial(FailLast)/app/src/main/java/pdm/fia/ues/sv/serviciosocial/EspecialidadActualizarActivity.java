package pdm.fia.ues.sv.serviciosocial;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EspecialidadActualizarActivity extends Activity {

    ControlBD helper;
    EditText editCodigo_esp;
    EditText editNombre_esp;
    EditText editCantidad_estudiantes;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidad_actualizar);
        helper = new ControlBD(this);
        editCodigo_esp = (EditText) findViewById(R.id.editCodigo_esp);
        editNombre_esp = (EditText) findViewById(R.id.editNombre_esp);
        editCantidad_estudiantes = (EditText) findViewById(R.id.editCantidad_estudiantes);

    }

    public void consultarEspecialidad(View v) {
        helper.abrir();
        Especialidad especialidad = helper.consultarEspecialidad(editCodigo_esp.getText().toString());
        helper.cerrar();
        if(especialidad == null)
            Toast.makeText(this, "Especialidad con Codigo " + editCodigo_esp.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre_esp.setText(especialidad.getNombre_esp());
            editCodigo_esp.setText(especialidad.getCodigo_esp());
            editCantidad_estudiantes.setText(especialidad.getCantidad_estudiantes());

        }
    }

    public void actualizarEspecialidad(View v) {
        Especialidad especialidad = new Especialidad();
        especialidad.setCodigo_esp(editCodigo_esp.getText().toString());
        especialidad.setNombre_esp(editNombre_esp.getText().toString());
        especialidad.setCantidad_estudiantes(editCantidad_estudiantes.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(especialidad);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCodigo_esp.setText("");
        editNombre_esp.setText("");
        editCantidad_estudiantes.setText("");
    }
}
