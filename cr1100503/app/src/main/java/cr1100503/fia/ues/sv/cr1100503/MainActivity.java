package cr1100503.fia.ues.sv.cr1100503;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    String values[]={"ButtonActivity","TextViewActivity","EditTextActivity","CheckBoxActivity",
            "RadioButtonActivity","GalleryActivity","SpinnerActivity","TabWidgetActivity"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listv);
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,values);
        ListView listVi =(ListView)findViewById(R.id.listv);
        listVi.setAdapter(adaptador);
        listVi.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String nombreValue = values[position];
        try {
            Class<?> clase = Class.forName("cr1100503.eisi.fia.ues.sv.cr1100503." + nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*@Override
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
    }*/
}
