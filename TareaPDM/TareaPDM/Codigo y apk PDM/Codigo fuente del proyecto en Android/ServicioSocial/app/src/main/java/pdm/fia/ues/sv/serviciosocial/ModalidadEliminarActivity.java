package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class ModalidadEliminarActivity extends Activity {
    EditText editcodModalidad;
    ControlBD controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidad_eliminar);
        controlhelper=new ControlBD (this);
        editcodModalidad=(EditText)findViewById(R.id.editcodModalidad);
    }

    public void eliminarModalidad(View v) throws SQLException {

        String regEliminadas;
        Modalidad modalidad=new Modalidad();
        modalidad.setCodmodalidad(editcodModalidad.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(modalidad);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}