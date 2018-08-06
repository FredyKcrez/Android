package pdm.fia.ues.sv.serviciosocial;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends ActionBarActivity implements TextToSpeech.OnInitListener{

    String[] menu={"Tabla Proyecto","Tabla TipoProyecto","Tabla Entidad","Tabla Especialidad","Tabla Modalidad"
            ,"Tabla TipoActividad","Tabla Tutor","Tabla Encargado Servicio Social","Tabla Alumno","Tabla Alumno Proyecto","Tabla Actividad","LLenar Base de Datos"};

    String[] activities={"ProyectoMenuActivity","TipoProyectoMenuActivity","EntidadMenuActivity","EspecialidadMenuActivity","ModalidadMenuActivity",
            "TipoActividadMenuActivity","TutorMenuActivity","EncargSActivity","MainAlumno","MainAlumnoProyecto","MenuActividad"};
    ControlBD BDhelper;

    ListView listaMenu;
    AdapterView<?> adapter;
    private Context context;
    //atributo para opcion tts
    private TextToSpeech textToSpeech;
    //atributos Text To Speech
    private TextToSpeech repeatTTS;
    private static final int VR_REQUEST = 999;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BDhelper=new ControlBD(this);
        context=getApplicationContext();
        ImageButton speechBtn = (ImageButton) findViewById(R.id.speechBtn);
        listaMenu=(ListView)findViewById(R.id.listView3);
        ArrayAdapter<String> adapter=new ArrayAdapter(context,android.R.layout.simple_list_item_1,menu);
        listaMenu.setAdapter(adapter);
        textToSpeech = new TextToSpeech( this, this );
        listaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position!=11){
                    nexActivity(activities[position]);

                }else{

                    BDhelper.abrir();
                    String tost=BDhelper.llenarBD();
                    BDhelper.cerrar();
                    Toast.makeText(context, tost, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // con estas lineas se verifica si speech recognition es soportado,
        PackageManager packManager = getPackageManager();
        List<ResolveInfo> intActivities = packManager.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (intActivities.size() != 0) {
            speechBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenToSpeech();
                }
            });
        }//
        else
        {
            speechBtn.setEnabled(false);
            Toast.makeText(this, "Speech recognition no soportado!", Toast.LENGTH_LONG).show();
        }

    }

    public void nexActivity(String layount){
        try {

            Class<?> clase = Class.forName("pdm.fia.ues.sv.serviciosocial." + layount);
            Intent intent = new Intent(getApplicationContext(), clase);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            Toast.makeText(this, "ClassNotFount!!!", Toast.LENGTH_LONG).show();
        }

    }
    //metodos para escuchar opciones

    public void speak(View v) throws InterruptedException {
        for(int i=0;i<menu.length;i++){
            textToSpeech.setLanguage( new Locale( "spa", "ESP" ) );
            speak(menu[i]);
            Thread.sleep(2000);
        }
    }
    private void speak( String str ){
        textToSpeech.speak(str, TextToSpeech.QUEUE_FLUSH, null);
        textToSpeech.setSpeechRate(0.0f);
        textToSpeech.setPitch( 0.0f );
    }
    @Override
    public void onInit(int status) {
        if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
        {
            Toast.makeText( this, "ERROR LANG_MISSING_DATA | LANG_NOT_SUPPORTED", Toast.LENGTH_SHORT ).show();
        }

    }

    @Override
    protected void onDestroy() {
        if ( textToSpeech != null )
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }


    //metodos para seleccionar opcion
    private void listenToSpeech() {
        //inicia el intent
        Intent listenIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //indica package
        listenIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
        //msj de ventana ve voz
        listenIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say option!");
        //indicamos el speech modelo
        listenIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        startActivityForResult(listenIntent, VR_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //valida si hay resultados
        if (requestCode == VR_REQUEST && resultCode == RESULT_OK)
        {

            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String opcionMenu="";
            int numActivity=0;
            for(int i=0;i<results.size();i++){//aqui quiero optener la cadena, para despues buscar esa cadena
                opcionMenu+=results.get(i);
                numActivity =opcionSpeech(opcionMenu);
                if(numActivity>=0 && numActivity!=11){
                    i=results.size();
                    nexActivity(activities[numActivity]);
                }
                else{
                    if(numActivity==11) {
                        GuardarBase();
                    }
                }

            }
            //Toast.makeText(getApplicationContext(),Integer.toString(results.size()),Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(),opcionMenu,Toast.LENGTH_SHORT).show();

            if(numActivity==-1){
                Toast.makeText(getApplicationContext(),"No se obtuvo resultado!",Toast.LENGTH_SHORT).show();
            }


        }
        super.onActivityResult(requestCode, resultCode, data);
    }
   public int opcionSpeech(String cadenas){

     if(cadenas.equalsIgnoreCase("Tabla Proyecto")){
        return 0;
       }else
          if(cadenas.equalsIgnoreCase("Tabla Tipo Proyecto")){
              return 1;
          }else
             if(cadenas.equalsIgnoreCase("Tabla Entidad")){
                return 2;
             }else
                if(cadenas.equalsIgnoreCase("Tabla Especialidad")){
                   return 3;
                 }else
                    if(cadenas.equalsIgnoreCase("Tabla Modalidad")){
                       return 4;
                     }else
                        if(cadenas.equalsIgnoreCase("Tabla Tipo Actividad")){
                           return 5;
                         }else
                            if(cadenas.equalsIgnoreCase("Tabla Tutor")){
                               return 6;
                             }else
                                if(cadenas.equalsIgnoreCase("Tabla Encargado Servicio Social")){
                                  return 7;
                                 }else
                                    if(cadenas.equalsIgnoreCase("Tabla Alumno")){
                                      return 8;
                                     }else
                                        if(cadenas.equalsIgnoreCase("Tabla Alumno Proyecto")){
                                           return 9;
                                        }else
                                           if(cadenas.equalsIgnoreCase("Tabla Actividad")){
                                             return 10;
                                            }else
                                               if (cadenas.equalsIgnoreCase("LLenar Base de Datos")){
                                                  return 11;
                                               }else{
                                                     return -1;
                                                     }

   }

    public void GuardarBase(){
        //BDhelper=new ControlBD(this);
        BDhelper.abrir();
        String tost=BDhelper.llenarBD();
        BDhelper.cerrar();
        Toast.makeText(context, tost, Toast.LENGTH_SHORT).show();

    }
}
