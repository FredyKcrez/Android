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


public class EliminarAlum_Pro extends ActionBarActivity {
    //constrolers
    private Context context;
    private ControlBD db;

    //view
    private EditText carnet,codProyecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_alum__pro);
        context=getApplicationContext();
        db=new ControlBD(context);
        carnet=(EditText)findViewById(R.id.carnet);
        codProyecto=(EditText)findViewById(R.id.codProyecto1);
    }
    public void eliminarAlumnoPro(View v){
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
                cancelar();
            }
        });
        dialog.show();

    }

    public void aceptar() {

        String msj = null;
        AlumnoProyecto alumPro = new AlumnoProyecto();
        alumPro.setCarnet(carnet.getText().toString());
        alumPro.setCodigoProyecto(codProyecto.getText().toString());

        try {
            db.abrir();
            msj=db.eliminar(alumPro);
            db.cerrar();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            db.cerrar();
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();

        }
        cancelar();


    }

    public void cancelar() {
        finish();
    }

    public void clearScreen(View v){

        carnet.setText(" ");
        codProyecto.setText(" ");

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
