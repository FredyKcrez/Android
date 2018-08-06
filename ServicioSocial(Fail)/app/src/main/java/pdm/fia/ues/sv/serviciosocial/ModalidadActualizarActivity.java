package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class ModalidadActualizarActivity extends Activity {
    ControlBD helper;
    EditText editcodModalidad;
    EditText editnombModalidad;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidad_actualizar);
        helper = new ControlBD(this);
        editcodModalidad = (EditText) findViewById(R.id.editcodModalidad);
        editnombModalidad = (EditText) findViewById(R.id.editnombModalidad);
    }

    public void consultarModalidad(View v) throws SQLException {

        helper.abrir();
        Modalidad modalidad = helper.consultarModalidad(editcodModalidad.getText().toString());
        helper.cerrar();

        if(modalidad == null)
            Toast.makeText(this, "Modalidad con codigo " + editcodModalidad.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editnombModalidad.setText(modalidad.getNombmodalidad());
        }
    }

    public void actualizarModalidad(View v) throws SQLException {
        Modalidad modalidad = new Modalidad();
        modalidad.setCodmodalidad(editcodModalidad.getText().toString());
        modalidad.setNombmodalidad(editnombModalidad.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(modalidad);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editcodModalidad.setText("");
        editnombModalidad.setText("");
    }
}