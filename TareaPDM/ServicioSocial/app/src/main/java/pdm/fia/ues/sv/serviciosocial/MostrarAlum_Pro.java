package pdm.fia.ues.sv.serviciosocial;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class MostrarAlum_Pro extends ActionBarActivity {
    //constrolers
    private Context context;
    private ControlBD db;

    //view
    private EditText carnet,codProyecto;
    private Spinner codActividad;
    private ProgressBar pro;
    private TextView porcentaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_alum__pro);
        context=getApplicationContext();
        db=new ControlBD(context);
        carnet=(EditText)findViewById(R.id.carnet);
        codProyecto=(EditText)findViewById(R.id.codProyecto1);
        codActividad= (Spinner) findViewById(R.id.codActividad2);
        pro=(ProgressBar)findViewById(R.id.progressBar);
        porcentaje=(TextView)findViewById(R.id.porcentaje);
        String carnetS=getIntent().getStringExtra("carnet");
        String codigoproyectoS=getIntent().getStringExtra("codigoproyecto");
        carnet.setText(carnetS);
        codProyecto.setText(codigoproyectoS);
        db.abrir();
        ArrayAdapter<ArrayList> adapter = new ArrayAdapter(context,android.R.layout.simple_spinner_item,db.getActividades(carnetS,codigoproyectoS));
        String datos[]=db.mostrarAlumnoProyecto(carnetS,codigoproyectoS);
        pro.setProgress(0);
        int numHoras=db.numHoras(carnetS);
        pro.setProgress(numHoras);
        Double aux = numHoras/500.0*100;
        porcentaje.setText(aux + " %");
        db.cerrar();
        carnet.setText(datos[0]);
        codProyecto.setText(datos[1]);

        codActividad.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar_alum_, menu);
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
