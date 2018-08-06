package pdm.fia.ues.sv.serviciosocial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ConsultarAlum_Pro extends ActionBarActivity {
    //constrolers
    private Context context;
    private ControlBD db;
    private AlumnoProyecto alumPro;

    //view
    private EditText carnet,codProyecto,codActividad;

    ///
    private String opcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_alum__pro);
        context=getApplicationContext();
        db=new ControlBD(context);
        alumPro=new AlumnoProyecto();
        carnet=(EditText)findViewById(R.id.carnet);
        codProyecto=(EditText)findViewById(R.id.codProyecto);
        codActividad=(EditText)findViewById(R.id.codActividad);
        opcion=getIntent().getStringExtra("opcion");

    }
    public void buscarAlumnoProyecto(View v){
        alumPro.setCarnet(carnet.getText().toString());
        alumPro.setCodigoProyecto(codProyecto.getText().toString());
        alumPro.setIdactividad(codActividad.getText().toString());
        db.abrir();
        alumPro=db.consultarAlumnoProyecto(alumPro);
        db.cerrar();
        if(alumPro==null){
            Toast.makeText(getApplicationContext(), "No se encontraron datos!", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            String nexActivity;
            if(opcion.equals("4")){
                nexActivity="ModificarAlum_Pro";
            }else{
                nexActivity="MostrarAlum_Pro";
            }
            try {
                Class<?> clase = Class.forName("pdm.fia.ues.sv.serviciosocial."+nexActivity);
                Intent intent= new Intent(getApplicationContext(),clase);
                intent.putExtra("carnet",alumPro.getCarnet());
                intent.putExtra("codigoproyecto",alumPro.getCodigoProyecto());
                intent.putExtra("idactividad",alumPro.getIdactividad());
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void clearScreen(View v){
        carnet.setText(" ");
        codProyecto.setText(" ");
        codActividad.setText(" ");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consultar_alum_, menu);
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
