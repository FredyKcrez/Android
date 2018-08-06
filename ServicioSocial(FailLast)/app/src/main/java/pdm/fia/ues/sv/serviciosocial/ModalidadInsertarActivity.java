package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class ModalidadInsertarActivity extends Activity {

    ControlBD helper;
    EditText editcodModalidad;
    EditText editnombModalidad;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modalidad_insertar);
        helper = new ControlBD(this);
        editcodModalidad = (EditText) findViewById(R.id.editcodModalidad);
        editnombModalidad = (EditText) findViewById(R.id.editnombModalidad);
    }


    public void insertarModalidad(View v) throws SQLException {
        String codModalidad=editcodModalidad.getText().toString();
        String nombModalidad=editnombModalidad.getText().toString();
        String regInsertados;

        Modalidad mod=new Modalidad();
        mod.setCodmodalidad(codModalidad);
        mod.setNombmodalidad(nombModalidad);

        helper.abrir();
        regInsertados=helper.insertar(mod);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editcodModalidad.setText("");
        editnombModalidad.setText("");
    }
}