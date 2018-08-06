package pdm.fia.ues.sv.serviciosocial;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] menu={"Proyectos","Tipo Proyecto","Entidades","Especialidad","Modalidad","Tipo de Actividad","Tutores",
            "Encargado Servicio Social","Alumnos","Alumno-Proyecto","Actividades","LLenar Base de Datos"};
    String[] activities={"ProyectoMenuActivity","TipoProyectoMenuActivity","EntidadMenuActivity","EspecialidadMenuActivity","ModalidadMenuActivity",
            "TipoActividadMenuActivity","TutorMenuActivity","EncargSActivity","MainAlumno","MainAlumnoProyecto","MenuActividad"};
    ControlBD BDhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
        BDhelper=new ControlBD(this);
    }
    @Override

    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        if(position!=11){
            String nombreValue=activities[position];
            try{
                Class<?> clase=Class.forName("pdm.fia.ues.sv.serviciosocial."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
            BDhelper.abrir();
            String tost=BDhelper.llenarBD();
            BDhelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();
        }
    }
}