package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProyectoActualizarActivity extends Activity {

    ControlBD helper;
    EditText editCodigoProyecto;
    EditText editEncargado;
    EditText editEntidad;
    EditText editTutor;
    EditText editTipoProyecto;
    EditText editNombreProyecto;
    EditText editCantidadAlumnos;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecto_actualizar);
        helper = new ControlBD(this);
        editCodigoProyecto = (EditText) findViewById(R.id.editCodigoProyecto);
        editEncargado=(EditText) findViewById(R.id.editEncargado);
        editEntidad=(EditText) findViewById(R.id.editEntidad);
        editTutor=(EditText) findViewById(R.id.editTutor);
        editTipoProyecto = (EditText) findViewById(R.id.editTipoProyecto);
        editNombreProyecto=(EditText) findViewById(R.id.editNombreProyecto);
        editCantidadAlumnos=(EditText) findViewById(R.id.editCantidadAlumnos);
    }

    public void consultarProyecto(View v) {
        helper.abrir();
        Proyecto pro = helper.consultarProyecto(editCodigoProyecto.getText().toString());
        helper.cerrar();
        if(pro == null)
            Toast.makeText(this, "Proyecto " + editCodigoProyecto.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editCodigoProyecto.setText(pro.getCodigoProyecto());
            editEncargado.setText(pro.getCodigoEncargado());
            editEntidad.setText(pro.getCodigoEntidad());
            editTipoProyecto.setText(pro.getCodigoTipoProyecto());
            editTutor.setText(pro.getCodigoTutor());
            editNombreProyecto.setText(pro.getNombreProyecto());
            editCantidadAlumnos.setText(String.valueOf(pro.getCantidadAlumnos()));
        }
    }

    public void actualizarProyecto(View v) {
        Proyecto pro = new Proyecto();
        pro.setCodigoProyecto(editCodigoProyecto.getText().toString());
        pro.setCodigoEncargado(editEncargado.getText().toString());
        pro.setCodigoEntidad(editEntidad.getText().toString());
        pro.setCodigoTipoProyecto(editTipoProyecto.getText().toString());
        pro.setCodigoTutor(editTutor.getText().toString());
        pro.setNombreProyecto(editNombreProyecto.getText().toString());
        pro.setCantidadAlumnos(Integer.parseInt(editCantidadAlumnos.getText().toString()));

        helper.abrir();
        String estado = helper.actualizar(pro);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCodigoProyecto.setText("");
        editEncargado.setText("");
        editEntidad.setText("");
        editTipoProyecto.setText("");
        editTutor.setText("");
        editNombreProyecto.setText("");
        editCantidadAlumnos.setText("");

    }

}

