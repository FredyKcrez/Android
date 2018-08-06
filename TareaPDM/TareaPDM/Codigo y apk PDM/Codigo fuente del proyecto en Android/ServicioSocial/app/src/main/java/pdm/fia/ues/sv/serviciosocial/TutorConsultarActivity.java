package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioGroup;

public class TutorConsultarActivity extends Activity {
    ControlBD helper;
    EditText editCodtutor;
    EditText editCodespecial;
    EditText editNombre;
    EditText editApellido;
    RadioGroup editSexo;
    EditText editCargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_consultar);
        helper = new ControlBD(this);

        editCodtutor = (EditText) findViewById(R.id.editCodtutor);
        editCodespecial = (EditText) findViewById(R.id.editCodespecial);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (RadioGroup) findViewById(R.id.editGrupo);
        editCargo = (EditText) findViewById(R.id.editCargo);
    }
    public void consultarTutor(View v) {
        helper.abrir();
        Tutor tt = helper.consultarTutor(editCodtutor.getText().toString(), editCodespecial.getText().toString());
        helper.cerrar();
        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(editCodtutor.getText().toString())||TextUtils.isEmpty(editCodespecial.getText().toString())) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            if (tt == null)
                Toast.makeText(this, "Tutor no registrado", Toast.LENGTH_LONG).show();
            else {
                editNombre.setText(tt.getNombre());
                editApellido.setText(tt.getApellido());
                switch (tt.getSexo()) {
                    case "F": {
                        editSexo.check(R.id.radiobutton1);
                        break;
                    }
                    case "M": {
                        editSexo.check(R.id.radiobutton2);
                        break;
                    }
                }
                editCargo.setText(tt.getCargo());
            }
        }
    }
    public void limpiarTexto(View v) {
        editCodtutor.setText("");
        editCodespecial.setText("");
        editNombre.setText("");
        editApellido.setText("");
        editSexo.clearCheck();
        editCargo.setText("");
    }
}