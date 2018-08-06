package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoProyectoActualizarActivity extends Activity {


    ControlBD helper;
    EditText editCodigoTipoProyecto;
    EditText editTipoProyecto;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_proyecto_actualizar);
        helper = new ControlBD(this);
        editCodigoTipoProyecto = (EditText) findViewById(R.id.editCodigoTipoProyecto);
        editTipoProyecto = (EditText) findViewById(R.id.editTipoProyecto);
    }
    public void consultarTipoProyecto(View v) {
        helper.abrir();
        TipoProyecto tp = helper.consultarTipoProyecto(editCodigoTipoProyecto.getText().toString());
        helper.cerrar();
        if(tp == null)
            Toast.makeText(this, "Tipo de proyecto " + editCodigoTipoProyecto.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editTipoProyecto.setText(tp.getTipoProyecto());
        }
    }
    public void actualizarTipoProyecto(View v) {
        TipoProyecto tp = new TipoProyecto();
        tp.setCodigoTipoProyecto(editCodigoTipoProyecto.getText().toString());
        tp.setTipoProyecto(editTipoProyecto.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(tp);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCodigoTipoProyecto.setText("");
        editTipoProyecto.setText("");

    }

}
