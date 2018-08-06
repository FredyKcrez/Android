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


public class ConsultarAlumno extends ActionBarActivity {
    EditText carnet;
    Context context;
    String layount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_alumno);
        context =getApplicationContext();
        carnet=(EditText)findViewById(R.id.carnet);
        layount=getIntent().getStringExtra("layount0");




    }

    public void consultarAlumno(View v) throws ClassNotFoundException {
        String carnetS=carnet.getText().toString();
        ControlBD db = new ControlBD(context);
        Alumno alumno=new Alumno();
        alumno.setCarnet(carnetS);
        String nexLayount;
        if (layount.equals("4")){
            nexLayount="ModificarAlumno";
        }else{
            nexLayount="MostrarAlumno";
        }
        db.abrir();
        if(db.verificarIntegridad(alumno,17)){
            try {
                db.cerrar();
                Class<?> clase = Class.forName("pdm.fia.ues.sv.serviciosocial."+nexLayount);
                Intent intent = new Intent(context,clase);
                intent.putExtra("carnetS",carnetS);
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }else{
            db.cerrar();
            Toast.makeText(getApplicationContext(),"No se encontro Alumno", Toast.LENGTH_SHORT).show();
        }

    }
    public void clearScreen(View v){
        carnet.setText(" ");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consultar_alumno, menu);
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
