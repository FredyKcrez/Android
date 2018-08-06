package pdm.fia.ues.sv.serviciosocial;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EspecialidadInsertarActivity extends Activity {

    ControlBD helper;
    EditText editNombre_esp;
    EditText editCodigo_esp;
    EditText editCantidad_estudiantes;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidad_insertar);
        helper = new ControlBD(this);
        editNombre_esp = (EditText) findViewById(R.id.editNombre_esp);
        editCodigo_esp = (EditText) findViewById(R.id.editCodigo_esp);
        editCantidad_estudiantes = (EditText) findViewById(R.id.editCantidad_estudiantes);


    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public void insertarEspecialidad(View v) {
        String nombre= editNombre_esp.getText().toString();
        String codigo= editCodigo_esp.getText().toString();
        String cantidad_estudiantes= editCantidad_estudiantes.getText().toString();
        String regInsertados;


            Especialidad especialidad = new Especialidad();
            especialidad.setNombre_esp(nombre);
            especialidad.setCodigo_esp(codigo);
            especialidad.setCantidad_estudiantes(cantidad_estudiantes);

            helper.abrir();
            regInsertados = helper.insertar(especialidad);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();

    }

    public void limpiarTexto(View v) {
        editNombre_esp.setText("");
        editCodigo_esp.setText("");
        editCantidad_estudiantes.setText("");

    }
}
