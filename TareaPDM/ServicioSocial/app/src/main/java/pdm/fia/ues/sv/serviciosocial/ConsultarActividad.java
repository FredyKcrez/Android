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


public class ConsultarActividad extends ActionBarActivity {
    EditText idactividad;
    Context context;
    String layount;
    ControlBD db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_actividad);
        context=getApplicationContext();
        db= new ControlBD(context);
        idactividad=(EditText)findViewById(R.id.idactividad);
        layount=getIntent().getStringExtra("opcion");
    }

    public void consultarActividad(View v){
        String idactividadS=idactividad.getText().toString();


        String nexLayount;
        if (layount.equals("4")){
            nexLayount="ModificarActividad";
        }else{
            nexLayount="MostrarActividad";
        }
        db.abrir();

        if(db.consultarActividad(idactividadS)!=null){
            try {
                db.cerrar();
                Class<?> clase = Class.forName("pdm.fia.ues.sv.serviciosocial."+nexLayount);
                Intent intent = new Intent(context,clase);
                intent.putExtra("idactividad",idactividadS);
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }else{
            db.cerrar();
            Toast.makeText(getApplicationContext(),"No se encontro Actividad!", Toast.LENGTH_SHORT).show();
        }

    }
    public void atras(View v){
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consultar_actividad, menu);
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
