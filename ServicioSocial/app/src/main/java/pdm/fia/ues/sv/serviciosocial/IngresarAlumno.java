package pdm.fia.ues.sv.serviciosocial;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class IngresarAlumno extends ActionBarActivity {
    //controlers
    private Context context;
    private EditText carnet,nombre,apellido,matganadas,telefono1,telefono2,correo1,
            correo2,direccion;
    private Spinner sexo,carrera;
    private ControlBD db;
    //auxiliares
    private String sexoS,carreraS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_alumno);
        context=getApplicationContext();
        db=new ControlBD(context);
        carnet=(EditText)findViewById(R.id.carnet);
        nombre=(EditText)findViewById(R.id.nombre);
        apellido=(EditText)findViewById(R.id.apellido);
        sexo=(Spinner)findViewById(R.id.sexo);
        carrera=(Spinner)findViewById(R.id.carrera);
        matganadas=(EditText)findViewById(R.id.matganadas);
        telefono1=(EditText)findViewById(R.id.telefono1);
        telefono2=(EditText)findViewById(R.id.telefono2);
        correo1=(EditText)findViewById(R.id.correo1);
        correo2=(EditText)findViewById(R.id.correo2);
        direccion=(EditText)findViewById(R.id.direccion);

        AdapterView.OnItemSelectedListener sl=new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getId()){
                    case R.id.sexo:
                        sexoS=parent.getItemAtPosition(position).toString();
                        break;
                    case R.id.carrera:
                        carreraS=parent.getItemAtPosition(position).toString();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        sexo.setOnItemSelectedListener(sl);
        carrera.setOnItemSelectedListener(sl);
    }

    public void insertarAlumno(View v){
        int matGanadas=0;
        Alumno alumno= new Alumno();
        alumno.setCarnet(carnet.getText().toString());
        alumno.setNombre(nombre.getText().toString());
        alumno.setApellido(apellido.getText().toString());
        alumno.setSexo(sexoS);
        alumno.setCarrera(carreraS);
        try {
            if(!matganadas.getText().toString().equals(" ")){
                matGanadas=Integer.parseInt(matganadas.getText().toString());
            }
        }catch(Exception e){
            matGanadas=0;
        }

        alumno.setMatganadas(matGanadas);
        alumno.setTelefono1(telefono1.getText().toString());
        alumno.setTelefono2(telefono2.getText().toString());
        alumno.setCorreo1(correo1.getText().toString());
        alumno.setCorreo2(correo2.getText().toString());
        alumno.setDireccion(direccion.getText().toString());
        db.abrir();
        String msj = null;
        try {
            msj = db.insertar(alumno);
            db.cerrar();
            Toast.makeText(context, msj, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            db.cerrar();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void clearScreen(){
        carnet.setText(" ");
        nombre.setText(" ");
        apellido.setText(" ");
        sexo=(Spinner)findViewById(R.id.sexo);
        carrera=(Spinner)findViewById(R.id.carrera);
        matganadas.setText(" ");
        telefono1.setText(" ");
        telefono2.setText(" ");
        correo1.setText(" ");
        correo2.setText(" ");
        direccion.setText(" ");
    }
    public void atras(View v){
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ingresar_alumno, menu);
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
