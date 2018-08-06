package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TutorInsertarActivity extends Activity {
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
        setContentView(R.layout.activity_tutor_insertar);
        helper = new ControlBD(this);

        editCodtutor = (EditText) findViewById(R.id.editCodtutor);
        editCodespecial = (EditText) findViewById(R.id.editCodespecial);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (RadioGroup) findViewById(R.id.editGrupo);
        editCargo = (EditText) findViewById(R.id.editCargo);
    }
    public void insertarTutor(View v) {
        String regInsertados;
        String codtutor=editCodtutor.getText().toString();
        String codespecial=editCodespecial.getText().toString();
        String nombre=editNombre.getText().toString();
        String apellido=editApellido.getText().toString();
        String sexo="";
        switch(editSexo.getCheckedRadioButtonId()){
            case R.id.radiobutton1: {
                sexo="F";
                break;
            }
            case R.id.radiobutton2: {
                sexo="M";
                break;
            }
        }
        String cargo=editCargo.getText().toString();

        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(codtutor)||TextUtils.isEmpty(codespecial)||TextUtils.isEmpty(nombre)||TextUtils.isEmpty(apellido)||TextUtils.isEmpty(sexo)||TextUtils.isEmpty(cargo)) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            Tutor tt = new Tutor();
            tt.setCodtutor(codtutor);
            tt.setCodespecial(codespecial);
            tt.setNombre(nombre);
            tt.setApellido(apellido);
            tt.setSexo(sexo);
            tt.setCargo(cargo);

            helper.abrir();
            regInsertados = helper.insertar(tt);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
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