package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class ProyectoInsertarActivity extends Activity {

    ControlBD helper;
    EditText editCodigo;
    EditText editProyecto;
    EditText editEntidad;
    EditText editEncargado;
    EditText editTutor;
    EditText editTipo;
    EditText editCantidadAlumnos;
    //Spinner spnTP;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyecto_insertar);
        helper = new ControlBD(this);
/*
        ArrayList<TipoProyecto> tipoproyectos= new ArrayList<TipoProyecto>();

        try{
            helper.abrir();
            tipoproyectos=helper.BuscarTipoProyectos();
            helper.cerrar();
        }catch (Exception e){

        }

        spnTP=(Spinner)findViewById(R.id.spnTipoProyecto);

        ArrayAdapter<TipoProyecto> adaptador =
                new ArrayAdapter<TipoProyecto>(this,
                android.R.layout.simple_list_item_1,
                tipoproyectos);

        spnTP.setAdapter(adaptador);
        */


        editCodigo = (EditText) findViewById(R.id.editCodigo);
        editProyecto = (EditText) findViewById(R.id.editProyecto);
        editEntidad = (EditText) findViewById(R.id.editEntidad);
        editEncargado = (EditText) findViewById(R.id.editEncargado);
        editTutor = (EditText) findViewById(R.id.editTutor);
        editCantidadAlumnos = (EditText) findViewById(R.id.editCantidadAlumnos);
        editTipo = (EditText) findViewById(R.id.editTipo);
    }
    public void insertarProyecto(View v) {
        String codigo=editCodigo.getText().toString();
        String tipo=editTipo.getText().toString();
        String entidad=editEntidad.getText().toString();
        String encargado=editEncargado.getText().toString();
        String proyecto=editProyecto.getText().toString();
        String tutor=editTutor.getText().toString();
        String cantidadalumnos=editCantidadAlumnos.getText().toString();

        String regInsertados;
        Proyecto project=new Proyecto();
        project.setCodigoProyecto(codigo);
        project.setCodigoEntidad(entidad);
        project.setCodigoEncargado(encargado);
        project.setCodigoTutor(tutor);
        project.setCodigoTipoProyecto(tipo);
        project.setNombreProyecto(proyecto);
        project.setCantidadAlumnos(Integer.parseInt(cantidadalumnos));

        helper.abrir();
        regInsertados=helper.insertar(project);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCodigo.setText("");
        editProyecto.setText("");
        editTipo.setText("");
        editEncargado.setText("");
        editEntidad.setText("");
        editTutor.setText("");
        editCantidadAlumnos.setText("");

    }




}
