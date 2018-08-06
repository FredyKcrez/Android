package pdm.fia.ues.sv.serviciosocial;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MenuActividad extends ActionBarActivity {
    private final String layout[]={"ConsultarActividad","EliminarActividad","InsertarActividad","ModificarActividad"};
    private  String nombre=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_actividad);
        ListView lista=(ListView)findViewById(R.id.listView2);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion="0";
                nombre=layout[position];
                if(position==3){
                    nombre=layout[0];
                    opcion="4";
                }
                Class<?> clase = null;
                try {
                    clase = Class.forName("pdm.fia.ues.sv.serviciosocial." + nombre);
                    Intent intent = new Intent(getApplicationContext(), clase);
                    intent.putExtra("opcion",opcion);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_actividad, menu);
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
