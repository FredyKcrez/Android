package perfildocentes.sv.ues.fia.eisi.tablascr11005;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TablasCR11005Activity extends ListActivity {
    String[] menu={"Tabla Tutor","Tabla Encargado Servicio Social","Llenar Base de Datos"};
    String[] activities={"TutorMenuActivity","EncargServSocialMenuActivity"};
    ControlBDCR11005 BDhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, menu));
    }
    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        if(position!=2){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class.forName("perfildocentes.sv.ues.fia.eisi.tablascr11005."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            //CODIGO PARA LLENAR BASE DE DATOS
            BDhelper.abrir();
            String tost=BDhelper.llenarBDCarnet();
            BDhelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }
}