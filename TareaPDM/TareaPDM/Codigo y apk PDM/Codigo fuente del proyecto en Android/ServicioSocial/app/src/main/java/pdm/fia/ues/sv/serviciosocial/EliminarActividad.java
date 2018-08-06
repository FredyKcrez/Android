package pdm.fia.ues.sv.serviciosocial;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EliminarActividad extends ActionBarActivity {
    EditText idactividad;
    Context context;
    ControlBD db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_actividad);
        context=getApplicationContext();
        db= new ControlBD(context);
        idactividad=(EditText)findViewById(R.id.idactividad2);
    }

    public  void eliminarActividad(View v){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        dialog.setTitle("Eliminar");
        dialog.setMessage("Realmente desea eliminar este Registro?");
        dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                aceptar();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                atras(idactividad);
            }
        });
        dialog.show();
    }
    public void aceptar(){
        String idActividad=idactividad.getText().toString();
        db.abrir();
        Toast.makeText(context,idActividad,Toast.LENGTH_SHORT).show();
        if(db.consultarActividad(idActividad)!=null){
            Actividad actividad=new Actividad();
            actividad.setIdactividad(idActividad);
            try {

                Toast.makeText(context,db.eliminar(actividad),Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        db.cerrar();
        atras(idactividad);
    }
    public void atras(View v){
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eliminar_actividad, menu);
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
