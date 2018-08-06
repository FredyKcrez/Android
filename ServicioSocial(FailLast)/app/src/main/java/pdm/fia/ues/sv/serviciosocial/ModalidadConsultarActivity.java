package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class ModalidadConsultarActivity extends Activity {

    ControlBD helper;
    EditText editcodModalidad;
    EditText editnombModalidad;
    EditText editcodModalidadBuscar;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidad_consultar);
        helper = new ControlBD(this);
        editcodModalidad = (EditText) findViewById(R.id.editcodModalidad);
        editnombModalidad = (EditText) findViewById(R.id.editnombModalidad);
        editcodModalidadBuscar = (EditText) findViewById(R.id.editcodModalidadBuscar);
    }

    public void consultar(View v) throws SQLException {

        helper.abrir();
        Modalidad modalidad = helper.consultarModalidad(editcodModalidadBuscar.getText().toString());
        helper.cerrar();

        if(modalidad == null)
            Toast.makeText(this, "Modalidad con codigo " + editcodModalidadBuscar.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editcodModalidad.setText(modalidad.getCodmodalidad());
            editnombModalidad.setText(modalidad.getNombmodalidad());
        }
    }

    public void limpiarTexto(View v){
        editcodModalidad.setText("");
        editnombModalidad.setText("");
    }
}