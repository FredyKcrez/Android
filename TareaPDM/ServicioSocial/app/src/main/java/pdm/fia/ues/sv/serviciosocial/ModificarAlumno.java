package pdm.fia.ues.sv.serviciosocial;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ModificarAlumno extends ActionBarActivity {
    //controlers
    private Context context;
    private EditText carnet,nombre,apellido,matganadas,telefono1,telefono2,correo1,
            correo2,direccion,sexo,carrera;
    private ControlBD db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_alumno);
        context=getApplicationContext();
        db=new ControlBD(context);
        carnet=(EditText)findViewById(R.id.carnet);
        nombre=(EditText)findViewById(R.id.nombre);
        apellido=(EditText)findViewById(R.id.apellido);
        sexo=(EditText)findViewById(R.id.sexo);
        carrera=(EditText)findViewById(R.id.carrera);
        matganadas=(EditText)findViewById(R.id.matganadas);
        telefono1=(EditText)findViewById(R.id.telefono1);
        telefono2=(EditText)findViewById(R.id.telefono2);
        correo1=(EditText)findViewById(R.id.correo1);
        correo2=(EditText)findViewById(R.id.correo2);
        direccion=(EditText)findViewById(R.id.direccion);
        String carnetA=getIntent().getStringExtra("carnetS");
        mostrarAlumno(carnetA);
    }
    private void mostrarAlumno(String carnetS) {
        Alumno alumno= new Alumno();
        db.abrir();
        alumno=db.consultarAlumno(carnetS);
        carnet.setText(alumno.getCarnet());
        nombre.setText(alumno.getNombre());
        apellido.setText(alumno.getApellido());
        sexo.setText(alumno.getSexo());
        carrera.setText(alumno.getCarrera());
        matganadas.setText(String.valueOf(alumno.getMatganadas()));
        telefono1.setText(alumno.getTelefono1());
        telefono2.setText(alumno.getTelefono2());
        correo1.setText(alumno.getCorreo1());
        correo2.setText(alumno.getCorreo2());
        direccion.setText(alumno.getDireccion());
        db.cerrar();
    }
    public void modificarAlumno(View v){
        Alumno alumno= new Alumno();
        alumno.setCarnet(carnet.getText().toString());
        alumno.setNombre(nombre.getText().toString());
        alumno.setApellido(apellido.getText().toString());
        alumno.setSexo(sexo.getText().toString());
        alumno.setCarrera(carrera.getText().toString());
        alumno.setMatganadas(Integer.parseInt(matganadas.getText().toString()));
        alumno.setTelefono1(telefono1.getText().toString());
        alumno.setTelefono2(telefono2.getText().toString());
        alumno.setCorreo1(correo1.getText().toString());
        alumno.setCorreo2(correo2.getText().toString());
        alumno.setDireccion(direccion.getText().toString());
        db.abrir();
        String msj = db.actualizar(alumno);
        db.cerrar();
        Toast.makeText(context, msj, Toast.LENGTH_SHORT).show();

    }
    public void clearScreen(View v) {
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar_alumno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
