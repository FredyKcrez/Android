package perfildocentes.sv.ues.fia.eisi.tablascr11005;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TutorInsertarActivity extends Activity {
    ControlBDCR11005 helper;
    EditText editCarnet;
    EditText editCodmateria;
    EditText editCiclo;
    EditText editNotafinal;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_insertar);
        helper = new ControlBDCR11005(this);
        editCarnet = (EditText) findViewById(R.id.editCarnet);
        editCodmateria = (EditText) findViewById(R.id.editCodmateria);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editNotafinal = (EditText) findViewById(R.id.editNotafinal);
    }
    public void insertarNota(View v) {
        String regInsertados;
        String carnet=editCarnet.getText().toString();
        String codmateria=editCodmateria.getText().toString();
        String ciclo=editCiclo.getText().toString();
        String notafinal=editNotafinal.getText().toString();
        Tutor tutor= new Tutor();
        tutor.setCodTutor(carnet);
        tutor.setCodEspecial(codmateria);
        tutor.setNombre(ciclo);
        tutor.setApellido(notafinal);
        helper.abrir();
        regInsertados=helper.insertar(tutor);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCarnet.setText("");
        editCodmateria.setText("");
        editCiclo.setText("");
        editNotafinal.setText("");
    }
}