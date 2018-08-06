package pdm.fia.ues.sv.serviciosocial;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class InsertarAlum_Pro extends ActionBarActivity {
    //constrolers
    private Context context;
    private ControlBD db;

    //view
    private EditText carnet,codProyecto,codActividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_alum__pro);
        context=getApplicationContext();
        db=new ControlBD(context);
        carnet=(EditText)findViewById(R.id.carnet);
        codProyecto=(EditText)findViewById(R.id.codProyecto1);
        codActividad=(EditText)findViewById(R.id.codActividad2);
    }


    public void guardar(View v) throws Exception {
        AlumnoProyecto alumPro=new AlumnoProyecto();
        alumPro.setCarnet(carnet.getText().toString());
        alumPro.setCodigoProyecto(codProyecto.getText().toString());
        alumPro.setIdactividad(codActividad.getText().toString());
        db.abrir();
        String msj= null;
        try {
            if(db.verificarIntegridad(alumPro,18)){
                msj = db.insertar(alumPro);
            }else{
                msj="Para realizar horas sociales debe tener mas de 28 materias ganadas";
            }

        } catch (Exception e){
            msj=e.getMessage();
            //Toast.makeText(getApplicationContext(),"Verifique integridad de los datos!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(),msj, Toast.LENGTH_SHORT).show();
        db.cerrar();


    }
    public void clearScreen(View v){
        carnet.setText(" ");
        codProyecto.setText(" ");
        codActividad.setText(" ");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_insertar_alum__pro, menu);
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
