package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class TipoActividadActualizarActivity extends Activity {

    ControlBD helper;
    EditText editcodTipoActividad;
    EditText editcodModalidad;
    EditText editcostoxHora;
    EditText editnombTipoActividad;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_actividad_actualizar);
        helper = new ControlBD(this);

        editcodTipoActividad = (EditText) findViewById(R.id.editcodigoTipoActividad);
        editcodModalidad = (EditText) findViewById(R.id.editcodModalidad);
        editcostoxHora = (EditText) findViewById(R.id.editcostoxHora);
        editnombTipoActividad = (EditText) findViewById(R.id.editnombTipoActividad);
    }

    public void consultarTipoActividad(View v) throws SQLException {

        helper.abrir();
        TipoActividad tipo1 = helper.consultarTipoActividad(editcodTipoActividad.getText().toString(), editcodModalidad.getText().toString());
        helper.cerrar();
        if(tipo1 == null)
            Toast.makeText(this, "Tipo de Actividad no registrada", Toast.LENGTH_LONG).show();
        else{

            editcostoxHora.setText(String.valueOf(tipo1.getCostoxhora()));
            editnombTipoActividad.setText(tipo1.getNomtipo());
        }
    }

    public void actualizarNota(View v) throws SQLException {

        TipoActividad tipo = new TipoActividad();
        tipo.setCodtipoactividad(editcodTipoActividad.getText().toString());
        tipo.setCodmodalidad(editcodModalidad.getText().toString());
        tipo.setCostoxhora(Float.valueOf(editcostoxHora.getText().toString()));
        tipo.setNomtipo(editnombTipoActividad.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(tipo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();

    }
    public void limpiarTexto(View v) {
        editcodTipoActividad.setText("");
        editcodModalidad.setText("");
        editcostoxHora.setText("");
        editnombTipoActividad.setText("");
    }
}