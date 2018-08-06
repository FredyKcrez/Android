package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoProyectoInsertarActivity extends Activity {

    ControlBD helper;
    EditText editCodigo;
    EditText editTipo;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_proyecto_insertar);
        helper = new ControlBD(this);
        editCodigo = (EditText) findViewById(R.id.editCodigo);
        editTipo = (EditText) findViewById(R.id.editTipo);
    }
    public void insertarTipoProyecto(View v) {
        String codigo=editCodigo.getText().toString();
        String tipo=editTipo.getText().toString();
        String regInsertados;
        TipoProyecto tipoProyecto=new TipoProyecto();
        tipoProyecto.setCodigoTipoProyecto(codigo);
        tipoProyecto.setTipoProyecto(tipo);

        helper.abrir();
        regInsertados=helper.insertar(tipoProyecto);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCodigo.setText("");
        editTipo.setText("");

    }
}