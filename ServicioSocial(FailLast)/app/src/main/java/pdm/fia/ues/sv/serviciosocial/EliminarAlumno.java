package pdm.fia.ues.sv.serviciosocial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EliminarAlumno extends ActionBarActivity {
    EditText editCarnet;
    ControlBD db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_alumno);
        db=new ControlBD(getApplicationContext());
        editCarnet = (EditText) findViewById(R.id.editCarnet);
    }


    public void eliminarAlumno(View v) {
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
        Alumno alumno = new Alumno();
        alumno.setCarnet(editCarnet.getText().toString());
        try {
            db.abrir();
            Toast.makeText(getApplicationContext(), db.eliminar(alumno), Toast.LENGTH_SHORT).show();
            db.cerrar();
            cancelar();

        } catch (Exception e) {
            db.cerrar();
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelar() {
        finish();
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
