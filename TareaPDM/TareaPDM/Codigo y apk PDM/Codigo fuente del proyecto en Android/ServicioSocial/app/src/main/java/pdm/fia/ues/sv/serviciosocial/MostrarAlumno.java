package pdm.fia.ues.sv.serviciosocial;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MostrarAlumno extends ActionBarActivity {
    //controlers
    private Context context;
    private EditText carnet,nombre,apellido,matganadas,telefono1,telefono2,correo1,
            correo2,direccion,sexo,carrera;
    private ControlBD db;
    String carnetS;
    String tel=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_alumno);
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
        carnetS=getIntent().getStringExtra("carnetS");
        tel=telefono1.getText().toString();
        mostrarAlumno(carnetS);
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

    public void selecionarTelefono(View v){
        final CharSequence telefonos[]={telefono1.getText(),telefono2.getText()};
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("LLamar? Elije un Telefono!");
        dialog.setItems(telefonos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tel=telefonos[which].toString();
                llamar(telefono1);
            }
        });
        dialog.show();

    }
    public void llamar(View v){
        selecionarTelefono(v);
        Intent intent = new Intent(Intent.ACTION_CALL);
        if(!tel.equals(" ")){
            intent.setData(Uri.parse("tel: "+tel));
            this.startActivity(intent);
        }else{
            Toast t=Toast.makeText(this,"Error al intentar realizar LLamada", Toast.LENGTH_SHORT);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar_alumno, menu);
        return true;
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String option="";
        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings:
                return true;
            case R.id.mainalumno:
                option="MainTarea";
                break;
            case R.id.modificarAlumno:
                option="ModificarAlumno";
                break;
            case R.id.eliminarAlumno:
                db.abrir();
                Alumno alumno=new Alumno();
                alumno.setCarnet(carnetS);
                try {
                    Toast.makeText(getApplicationContext(), db.eliminar(alumno), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                option="ConsultarAlumno";
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        try {
            Class<?> clase = Class.forName("pdm.eisi.fia.ues.sv.tareapdm."+option);
            Intent intent= new Intent(getApplicationContext(),clase);
            intent.putExtra("carnetS",carnetS);
            startActivity(intent);
            return true;
        } catch (ClassNotFoundException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return false;
    }*/
}
