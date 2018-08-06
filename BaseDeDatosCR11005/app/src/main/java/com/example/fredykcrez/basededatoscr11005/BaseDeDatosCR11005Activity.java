package com.example.fredykcrez.basededatoscr11005;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BaseDeDatosCR11005Activity extends ListActivity{
    String[] menu= {"Tabla Alumno","Tabla Nota", "Tabla Materia", "Llenar Base de Datos"};
    String[] activities= {"AlumnoMenuActivity","NotaMenuActivity", "MateriaMenuActivity"};
    ControlBDCR11005 BDHelper;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        BDHelper = new ControlBDCR11005(this);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        if(position!=3){
            String nombreValue = activities[position];
            try{
                Class<?> clase=Class.forName("com.example.fredykcrez.basededatoscr11005."+nombreValue);
                Intent inte= new Intent(this, clase);
                this.startActivity(inte);
            } catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        } else{
            //codigo para llenar base de datos
            BDHelper.abrir();
            String tost=BDHelper.llenarBDCR11005();
            BDHelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }
}