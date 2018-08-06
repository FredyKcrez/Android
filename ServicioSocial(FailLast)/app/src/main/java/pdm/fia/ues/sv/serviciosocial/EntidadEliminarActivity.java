package pdm.fia.ues.sv.serviciosocial;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EntidadEliminarActivity extends Activity {
    EditText editCodigo_org;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entidad_eliminar);
        controlhelper=new ControlBD (this);
        editCodigo_org=(EditText)findViewById(R.id.editCodigo_org);
    }
    public void eliminarEntidad(View v){
        String regEliminadas;
        Entidad entidad=new Entidad();
        entidad.setCodigo_org(editCodigo_org.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(entidad);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

}
