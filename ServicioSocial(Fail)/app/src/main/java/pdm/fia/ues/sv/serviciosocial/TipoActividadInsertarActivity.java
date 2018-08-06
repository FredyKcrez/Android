package pdm.fia.ues.sv.serviciosocial;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class TipoActividadInsertarActivity extends ActionBarActivity {
    EditText codtipoActividad,codModalidad,nombTipo,costoxHora;
    ControlBD db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_actividad_insertar);
        db = new ControlBD(getApplicationContext());

        codtipoActividad=(EditText)findViewById(R.id.editcodigoTipoActividad);
        codModalidad=(EditText)findViewById(R.id.editcodModalidad);
        nombTipo=(EditText)findViewById(R.id.editnombTipoActividad);
        costoxHora=(EditText)findViewById(R.id.editcostoxHora);
    }


    public void insertarTipoActividad(View v) {

        String msj;

            TipoActividad tipo = new TipoActividad();
            tipo.setCodtipoactividad(codtipoActividad.getText().toString());
            tipo.setCodmodalidad(codModalidad.getText().toString());
            tipo.setNomtipo(nombTipo.getText().toString());
            tipo.setCostoxhora(Float.valueOf(costoxHora.getText().toString()));


            db.abrir();
            msj = db.insertar(tipo);

            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();


        db.cerrar();
    }
    public void limpiarTexto(View v) {
        codtipoActividad.setText("");
        codModalidad.setText("");
        nombTipo.setText("");
        costoxHora.setText("");

    }

}
