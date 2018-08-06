package com.fredykcrez.p2cr11005plus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    String[] menu={"Eliminar Equipo","Actualizar Partidos Clausura","Consultar Partidos Clausura","LLenar Base de Datos"};
    String[] activities={"EliminarEquipo","ActualizarPartidosClausura","ConsultaPartidosClausura"};
    BDControl BDhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        BDhelper=new BDControl(this);
    }
    
    @Override
    protected void onListItemClick(ListView l,View v,int position,long id) {
        super.onListItemClick(l, v, position, id);
        if(position!=3) {
            String nombreValue=activities[position];
            try {
                Class<?> clase=Class.forName("com.fredykcrez.p2cr11005plus."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            //CODIGO PARA LLENAR BASE DE DATOS
            BDhelper.abrir();
            String tost=BDhelper.llenarBDCarnet();
            BDhelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }
}