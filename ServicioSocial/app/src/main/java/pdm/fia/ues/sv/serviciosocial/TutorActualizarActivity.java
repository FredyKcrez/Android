package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioGroup;

public class TutorActualizarActivity extends Activity {
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
        setContentView(R.layout.activity_tutor_actualizar);
        helper = new ControlBD(this);

        editCodtutor = (EditText) findViewById(R.id.editCodtutor);
        editCodespecial = (EditText) findViewById(R.id.editCodespecial);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (RadioGroup) findViewById(R.id.editGrupo);
        editCargo = (EditText) findViewById(R.id.editCargo);
    }
    public void actualizarTutor(View v) {
        String codt=editCodtutor.getText().toString();
        String codes=editCodespecial.getText().toString();
        String name=editNombre.getText().toString();
        String apel=editApellido.getText().toString();
        String sexo="";
        switch (editSexo.getCheckedRadioButtonId()) {
            case R.id.radiobutton1: {
                sexo="F";
                break;
            }
            case R.id.radiobutton2: {
                sexo="M";
                break;
            }
        }
        String car=editCargo.getText().toString();

        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(codt)||TextUtils.isEmpty(codes)||TextUtils.isEmpty(name)||TextUtils.isEmpty(apel)||TextUtils.isEmpty(sexo)||TextUtils.isEmpty(car)) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            Tutor tt = new Tutor();
            tt.setCodtutor(codt);
            tt.setCodespecial(codes);
            tt.setNombre(name);
            tt.setApellido(apel);
            tt.setSexo(sexo);
            tt.setCargo(car);

            helper.abrir();
            String estado = helper.actualizar(tt);
            helper.cerrar();
            Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
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