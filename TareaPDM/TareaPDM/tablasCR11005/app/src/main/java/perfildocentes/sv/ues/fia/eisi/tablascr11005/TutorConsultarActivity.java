package perfildocentes.sv.ues.fia.eisi.tablascr11005;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TutorConsultarActivity extends Activity {
    ControlBDCR11005 helper;
    EditText editCodTutor;
    EditText editCodEspecial;
    EditText editNombre;
    EditText editApellido;
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_consultar);
        helper = new ControlBDCR11005(this);
        editCodTutor = (EditText) findViewById(R.id.editCarnet);
        editCodEspecial = (EditText) findViewById(R.id.editCodmateria);
        editNombre = (EditText) findViewById(R.id.editCiclo);
        editApellido = (EditText) findViewById(R.id.editNotafinal);
    }
    public void consultarNota(View v) {
        helper.abrir();
        Tutor tutor = helper.consultarTutor(editCodTutor.getText().toString(), editCodEspecial.getText().toString());
        helper.cerrar();
        if(tutor == null)
            Toast.makeText(this, "Nota no registrada", Toast.LENGTH_LONG).show();
        else{
            editNombre.setText(String.valueOf(tutor.getNombre()));
        }
    }
    public void limpiarTexto(View v) {
        editCodTutor.setText("");
        editCodEspecial.setText("");
        editNombre.setText("");
        editApellido.setText("");
    }
}