package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class TipoActividadEliminarActivity extends Activity {
    EditText editcodTipoActividad,editcodModalidad;
    ControlBD controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_actividad_eliminar);
        controlhelper=new ControlBD(this);
        editcodTipoActividad=(EditText)findViewById(R.id.editcodigoTipoActividad);
        editcodModalidad=(EditText)findViewById(R.id.editcodModalidad);

    }

    public void eliminarTipoActividad(View v) throws SQLException {
        String regEliminadas;

        TipoActividad tipo=new TipoActividad();
        tipo.setCodtipoactividad(editcodTipoActividad.getText().toString());
        tipo.setCodmodalidad(editcodModalidad.getText().toString());

        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(tipo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

    public void limpiar(View v){
        editcodTipoActividad.setText("");
        editcodModalidad.setText("");

    }
}