package pdm.fia.ues.sv.serviciosocial;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EncargSActivity extends ListActivity {
    String[] menu={"Insertar Registro","Eliminar Registro","Actualizar Registro","Consultar Registro"};
    String[] activities={"EncargSInsertarActivity","EncargSEliminarActivity","EncargSActualizarActivity","EncargSConsultarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView=getListView();
        listView.setBackgroundColor(Color.GRAY);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l,v,position,id);
        String nombreValue=activities[position];
        l.getChildAt(position).setBackgroundColor(Color.GRAY);
        try{
            Class<?> clase=Class.forName("pdm.fia.ues.sv.serviciosocial."+nombreValue);
            Intent inte=new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}