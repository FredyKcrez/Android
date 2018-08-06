package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EncargSConsultarActivity extends Activity {
    ControlBD helper;
    EditText editCodencarg;
    EditText editNombre;
    EditText editApellido;
    RadioGroup editSexo;
    EditText editCorreo;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encarg_sconsultar);
        helper = new ControlBD(this);

        editCodencarg = (EditText) findViewById(R.id.editCodencarg);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (RadioGroup) findViewById(R.id.editGrupo);
        editCorreo = (EditText) findViewById(R.id.editCorreo);
    }
    public void consultarEncargS(View v) {
        helper.abrir();
        EncargS encargS = helper.consultarEncargS(editCodencarg.getText().toString());
        helper.cerrar();
        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(editCodencarg.getText().toString())) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            if (encargS == null)
                Toast.makeText(this, "Encargado con codigo " + editCodencarg.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
            else {
                editNombre.setText(encargS.getNombre());
                editApellido.setText(encargS.getApellido());
                switch (encargS.getSexo()) {
                    case "F": {
                        editSexo.check(R.id.radiobutton1);
                        break;
                    }
                    case "M": {
                        editSexo.check(R.id.radiobutton2);
                        break;
                    }
                }
                //editSexo.setText(encargS.getSexo());
                editCorreo.setText(encargS.getCorreo());
            }
        }
    }
    public void limpiarTexto(View v){
        editCodencarg.setText("");
        editNombre.setText("");
        editApellido.setText("");
        editSexo.clearCheck();
        editCorreo.setText("");
    }
}