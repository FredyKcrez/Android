package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProyectoConsultarActivity extends Activity {

    ControlBD helper;
    EditText editCodigoProyectoBuscar;
    EditText editCodigoProyecto;
    EditText editEncargado;
    EditText editEntidad;
    EditText editTutor;
    EditText editTipoProyecto;
    EditText editProyecto;
    EditText editCantidadAlumnos;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecto_consultar);
        helper = new ControlBD(this);
        editCodigoProyectoBuscar = (EditText) findViewById(R.id.editCodigoProyectoBuscar);
        editCodigoProyecto = (EditText) findViewById(R.id.editCodigoProyecto);
        editEncargado=(EditText) findViewById(R.id.editEncargado);
        editEntidad=(EditText) findViewById(R.id.editEntidad);
        editTutor=(EditText) findViewById(R.id.editTutor);
        editTipoProyecto = (EditText) findViewById(R.id.editTipoProyecto);
        editProyecto=(EditText) findViewById(R.id.editProyecto);
        editCantidadAlumnos=(EditText) findViewById(R.id.editCantidadAlumnos);


    }
    public void consultarProyecto(View v) {
        helper.abrir();
        Proyecto pro = helper.consultarProyecto(editCodigoProyectoBuscar.getText().toString());
        helper.cerrar();
        if(pro == null)
            Toast.makeText(this, "Proyecto " + editCodigoProyectoBuscar.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editCodigoProyecto.setText(pro.getCodigoProyecto());
            editEncargado.setText(pro.getCodigoEncargado());
            editEntidad.setText(pro.getCodigoEntidad());
            editTipoProyecto.setText(pro.getCodigoTipoProyecto());
            editTutor.setText(pro.getCodigoTutor());
            editProyecto.setText(pro.getNombreProyecto());
            editCantidadAlumnos.setText(String.valueOf(pro.getCantidadAlumnos()));
        }
    }
    public void limpiarTexto(View v){
        editCodigoProyecto.setText("");
        editEncargado.setText("");
        editEntidad.setText("");
        editTipoProyecto.setText("");
        editTutor.setText("");
        editProyecto.setText("");
        editCantidadAlumnos.setText("");
    }

}
