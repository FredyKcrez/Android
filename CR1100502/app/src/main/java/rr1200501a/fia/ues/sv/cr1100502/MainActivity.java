package rr1200501a.fia.ues.sv.cr1100502;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    Button btnEjecutarActividad;
    Button btnEjecutarMetodo1;
    Button btnEjecutarMetodo2;
    Button btnEjecutarMetodo3;
    TextView lblEtiqueta;
    EditText edtParametro1;
    EditText edtParametro2;
    EditText edtParametro3;
    String sumastr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEjecutarActividad= (Button) findViewById(R.id.button);
        btnEjecutarMetodo1= (Button) findViewById(R.id.button2);
        btnEjecutarMetodo2= (Button) findViewById(R.id.button3);
        btnEjecutarMetodo3= (Button) findViewById(R.id.button4);
        lblEtiqueta=(TextView) findViewById(R.id.textView);
        edtParametro1=(EditText) findViewById(R.id.editText);
        edtParametro2=(EditText) findViewById(R.id.editText2);
        edtParametro3=(EditText) findViewById(R.id.editText3);
        edtParametro1=(EditText) findViewById(R.id.editText);
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numint1, numint2, numint3;
                float numfloat1, numfloat2, numfloat3;
                switch (v.getId()){
                    case R.id.button:
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT,"This is my text to send.");
                        intent.setType("text/plain");
                        startActivity(intent);
                        break;
                    case R.id.button2: //dos parametros flotantes
                        numfloat1 =(float) Float.valueOf(edtParametro1.getText().toString());
                        numfloat2 =(float) Float.valueOf(edtParametro2.getText().toString());
                        sumastr =Metodos.suma(numfloat1,numfloat2);
                        lblEtiqueta.setText(sumastr);
                        break;
                    case R.id.button3: //tres parametros flotantes
                        numfloat1 =(float) Float.valueOf(edtParametro1.getText().toString());
                        numfloat2 =(float) Float.valueOf(edtParametro2.getText().toString());
                        numfloat3 =(float) Float.valueOf(edtParametro3.getText().toString());
                        sumastr =Metodos.suma(numfloat1,numfloat2,numfloat3);
                        lblEtiqueta.setText(sumastr);
                        break;
                    case R.id.button4: //tres parametros flotantes
                        numint1 =(int) Integer.valueOf(edtParametro1.getText().toString());
                        numint2 =(int) Integer.valueOf(edtParametro2.getText().toString());
                        numint3 =(int) Integer.valueOf(edtParametro3.getText().toString());
                        sumastr =Metodos.suma(numint1,numint2,numint3);
                        lblEtiqueta.setText(sumastr);
                        break;
                }
            }
        };
        btnEjecutarActividad.setOnClickListener(onclick);
        btnEjecutarMetodo1.setOnClickListener(onclick);
        btnEjecutarMetodo2.setOnClickListener(onclick);
        btnEjecutarMetodo3.setOnClickListener(onclick);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
