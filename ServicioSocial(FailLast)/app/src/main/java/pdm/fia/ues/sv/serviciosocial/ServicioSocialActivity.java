package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ServicioSocialActivity extends Activity {

    EditText editText;
    EditText editText2;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_social);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

    }
    public void login(View v) {
        String usuario=editText.getText().toString();
        String password=editText2.getText().toString();

        if(usuario.equalsIgnoreCase("Docente") && password.equalsIgnoreCase("PDM115")){
            try {
                Class<?> clase = Class.forName("pdm.fia.ues.sv.serviciosocial.MainActivity");
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(this,"Usuario o Password no validos", Toast.LENGTH_SHORT).show();
        }
    }
}
