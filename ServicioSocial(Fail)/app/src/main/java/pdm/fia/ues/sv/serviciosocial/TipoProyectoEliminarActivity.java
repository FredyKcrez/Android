package pdm.fia.ues.sv.serviciosocial;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoProyectoEliminarActivity extends Activity {

    EditText editCodigoTipoProyecto;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_proyecto_eliminar);
        controlhelper=new ControlBD (this);
        editCodigoTipoProyecto=(EditText)findViewById(R.id.editCodigoTipoProyecto);
    }
    public void eliminarTipoProyecto(View v){
        String regEliminadas;
        TipoProyecto tp=new TipoProyecto();
        tp.setCodigoTipoProyecto(editCodigoTipoProyecto.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(tp);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

}