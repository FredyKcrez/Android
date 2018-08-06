package pdm.fia.ues.sv.serviciosocial;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EspecialidadConsultarActivity extends Activity {

    ControlBD helper;
    EditText editNombre_esp;
    EditText editCodigo_esp;
    EditText editCantidad_estudiantes;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidad_consultar);
        helper = new ControlBD(this);

        editNombre_esp = (EditText) findViewById(R.id.editNombre_esp);
        editCodigo_esp = (EditText) findViewById(R.id.editCodigo_esp);
        editCantidad_estudiantes = (EditText) findViewById(R.id.editCantidad_estudiantes);
    }
    public void consultarAlumno(View v) {
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
    public void limpiarTexto(View v){
        editNombre_esp.setText("");
        editCodigo_esp.setText("");
        editCantidad_estudiantes.setText("");
    }
}