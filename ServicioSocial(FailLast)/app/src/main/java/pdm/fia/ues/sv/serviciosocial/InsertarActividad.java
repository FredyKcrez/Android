package pdm.fia.ues.sv.serviciosocial;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class InsertarActividad extends ActionBarActivity {
    private EditText idActividad,codTipoActividad,actividad,fecha,numHoras,comentario;
    private ControlBD db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new ControlBD(getApplicationContext());
        setContentView(R.layout.activity_insertar_actividad);
        idActividad=(EditText)findViewById(R.id.idactividad);
        codTipoActividad=(EditText)findViewById(R.id.codTipoActividad);
        actividad=(EditText)findViewById(R.id.actividad);
        fecha=(EditText)findViewById(R.id.fecha);
        numHoras=(EditText)findViewById(R.id.numhoras);
        comentario=(EditText)findViewById(R.id.comentario);

    }

    public void insertarActividad(View v){
        Actividad activi=new Actividad();
        activi.setIdactividad(idActividad.getText().toString());
        activi.setCodTIpoActividad(codTipoActividad.getText().toString());
        activi.setActividad(actividad.getText().toString());
        activi.setFecha(fecha.getText().toString());
        try {
            activi.setNumhoras(Integer.parseInt(numHoras.getText().toString()));
        }catch (Exception e){
            activi.setNumhoras(0);
        }
        activi.setComentario(comentario.getText().toString());
        try {
            db.abrir();
            String msj=db.insertar(activi);
            db.cerrar();
            Toast.makeText(getApplicationContext(),msj,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            db.cerrar();
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }


}
