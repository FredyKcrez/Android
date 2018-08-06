package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoProyectoConsultarActivity extends Activity {

    ControlBD helper;
    EditText editCodigoTipoProyectoBuscar;
    EditText editCodigoTipoProyecto;
    EditText editTipoProyecto;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_proyecto_consultar);
        helper = new ControlBD(this);
        editCodigoTipoProyectoBuscar = (EditText) findViewById(R.id.editCodigoTipoProyectoBuscar);
        editCodigoTipoProyecto = (EditText) findViewById(R.id.editCodigoTipoProyecto);
        editTipoProyecto = (EditText) findViewById(R.id.editTipoProyecto);


    }
    public void consultarTipoProyecto(View v) {
        helper.abrir();
        TipoProyecto tp = helper.consultarTipoProyecto(editCodigoTipoProyectoBuscar.getText().toString());
        helper.cerrar();
        if(tp == null)
            Toast.makeText(this, "Tipo de proyecto " + editCodigoTipoProyectoBuscar.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editCodigoTipoProyecto.setText(tp.getCodigoTipoProyecto());
            editTipoProyecto.setText(tp.getTipoProyecto());
        }
    }
    public void limpiarTexto(View v){
        editCodigoTipoProyecto.setText("");
        editTipoProyecto.setText("");
    }
}
