package pdm.fia.ues.sv.serviciosocial;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ModificarAlum_Pro extends ActionBarActivity {
    //constrolers
    private Context context;
    private ControlBD db;

    //view
    private EditText carnet,codProyecto,codActividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_alum__pro);
        context=getApplicationContext();
        db=new ControlBD(context);
        carnet=(EditText)findViewById(R.id.carnet);
        codProyecto=(EditText)findViewById(R.id.codProyecto1);
        codActividad=(EditText)findViewById(R.id.codActividad2);
        String carnetS=getIntent().getStringExtra("carnet");
        String codproyectoS=getIntent().getStringExtra("codigoproyecto");
        carnet.setText(getIntent().getStringExtra("carnet"));
        codProyecto.setText(getIntent().getStringExtra("codigoproyecto"));
        codActividad.setText(getIntent().getStringExtra("idactividad"));
    }

    public void modificarAlumPro(View v) throws Exception {
        AlumnoProyecto alumPro=new AlumnoProyecto();
        alumPro.setCarnet(carnet.getText().toString());
        alumPro.setCodigoProyecto(codProyecto.getText().toString());
        alumPro.setIdactividad(codActividad.getText().toString());
        db.abrir();
        String msj= null;
        try {
            msj = db.actualizar(alumPro);

        } catch (Exception e){
            msj=e.getMessage();
            //Toast.makeText(getApplicationContext(),"Verifique integridad de los datos!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
        db.cerrar();


    }
    public void clearScreen(View v){
        carnet.setText(" ");
        codProyecto.setText(" ");
        codActividad.setText(" ");
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
