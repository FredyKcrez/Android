package pdm.fia.ues.sv.serviciosocial;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ModificarActividad extends ActionBarActivity {
    private EditText idActividad,codTipoActividad,actividad,fecha,numHoras,comentario;
    private ControlBD db;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_actividad);
        context=getApplicationContext();
        db=new ControlBD(context);
        idActividad=(EditText)findViewById(R.id.idactividad);
        codTipoActividad=(EditText)findViewById(R.id.codTipoActividad);
        actividad=(EditText)findViewById(R.id.actividad);
        fecha=(EditText)findViewById(R.id.fecha);
        numHoras=(EditText)findViewById(R.id.numhoras);
        comentario=(EditText)findViewById(R.id.comentario);
        idActividad.setText(getIntent().getStringExtra("idactividad"));
        consultarActividad();
    }


    public  void consultarActividad(){
        db.abrir();
        Actividad activi=db.consultarActividad(idActividad.getText().toString());
        db.cerrar();
        codTipoActividad.setText(activi.getCodTIpoActividad());
        actividad.setText(activi.getActividad());
        fecha.setText(activi.getFecha());
        numHoras.setText(String.valueOf(activi.getNumhoras()));
        comentario.setText(activi.getComentario());
    }
    public void modificarActividad(View v){
        Actividad activi=new Actividad();
        activi.setIdactividad(idActividad.getText().toString());
        activi.setCodTIpoActividad(codTipoActividad.getText().toString());
        activi.setActividad(actividad.getText().toString());
        activi.setFecha(fecha.getText().toString());
        activi.setNumhoras(Integer.parseInt(numHoras.getText().toString()));
        activi.setComentario(comentario.getText().toString());
        try {
            db.abrir();
            String msj=db.actualizar(activi);
            db.cerrar();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            atras(v);

        } catch (Exception e) {
            db.cerrar();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
    public void atras(View v){
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar_actividad, menu);
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
