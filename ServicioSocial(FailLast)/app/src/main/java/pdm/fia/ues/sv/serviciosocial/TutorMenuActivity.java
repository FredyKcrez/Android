package pdm.fia.ues.sv.serviciosocial;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.util.Calendar;

public class TutorMenuActivity extends TabActivity {
    ControlBD helper;
    EditText editCodtutor, editCodespecial, editNombre, editApellido, editCargo;
    EditText editCodtutor2, editCodespecial2, editNombre2, editApellido2, editCargo2;
    RadioGroup editSexo;
    RadioGroup editSexo2;

    ImageView image;
    final int FOTOGRAFIA = 654;
    Uri file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_menu);
        helper = new ControlBD(this);

        Resources res = getResources();
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator(res.getText(R.string.insertar));
        tabHost.addTab(spec);
        spec = tabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator(res.getText(R.string.consultar));
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);

        editCodtutor = (EditText) findViewById(R.id.editCodtutor);
        editCodespecial = (EditText) findViewById(R.id.editCodespecial);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (RadioGroup) findViewById(R.id.editGrupo);
        editCargo = (EditText) findViewById(R.id.editCargo);

        editCodtutor2 = (EditText) findViewById(R.id.editCodtutor2);
        editCodespecial2 = (EditText) findViewById(R.id.editCodespecial2);
        editNombre2 = (EditText) findViewById(R.id.editNombre2);
        editApellido2 = (EditText) findViewById(R.id.editApellido2);
        editSexo2 = (RadioGroup) findViewById(R.id.editGrupo2);
        editCargo2 = (EditText) findViewById(R.id.editCargo2);

        image = (ImageView) findViewById(R.id.mainimage);
        image.setOnClickListener(onClick);
        if(savedInstanceState != null) {
            if(savedInstanceState.getString("Foto") != null) {
                image.setImageURI(Uri.parse(savedInstanceState.getString("Foto")));
                file = Uri.parse(savedInstanceState.getString("Foto"));
            }
        }
    }

    public void insertarTutor(View v) {
        String regInsertados;
        String codtutor=editCodtutor.getText().toString();
        String codespecial=editCodespecial.getText().toString();
        String nombre=editNombre.getText().toString();
        String apellido=editApellido.getText().toString();
        String sexo="";
        switch(editSexo.getCheckedRadioButtonId()){
            case R.id.radiobutton1: {
                sexo="F";
                break;
            }
            case R.id.radiobutton2: {
                sexo="M";
                break;
            }
        }
        String cargo=editCargo.getText().toString();

        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(codtutor)||TextUtils.isEmpty(codespecial)||TextUtils.isEmpty(nombre)||TextUtils.isEmpty(apellido)||TextUtils.isEmpty(sexo)||TextUtils.isEmpty(cargo)) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            Tutor tt = new Tutor();
            tt.setCodtutor(codtutor);
            tt.setCodespecial(codespecial);
            tt.setNombre(nombre);
            tt.setApellido(apellido);
            tt.setSexo(sexo);
            tt.setCargo(cargo);

            helper.abrir();
            regInsertados = helper.insertar(tt);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }

    public void consultarTutor(View v) {
        helper.abrir();
        Tutor tt = helper.consultarTutor(editCodtutor2.getText().toString(), editCodespecial2.getText().toString());
        helper.cerrar();
        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(editCodtutor2.getText().toString())||TextUtils.isEmpty(editCodespecial2.getText().toString())) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            if (tt == null)
                Toast.makeText(this, "Tutor no registrado", Toast.LENGTH_LONG).show();
            else {
                editNombre2.setText(tt.getNombre());
                editApellido2.setText(tt.getApellido());
                switch (tt.getSexo()) {
                    case "F": {
                        editSexo2.check(R.id.radiobutton3);
                        break;
                    }
                    case "M": {
                        editSexo2.check(R.id.radiobutton4);
                        break;
                    }
                }
                editCargo2.setText(tt.getCargo());
            }
        }
    }

    public void actualizarTutor(View v) {
        String codt=editCodtutor2.getText().toString();
        String codes=editCodespecial2.getText().toString();
        String name=editNombre2.getText().toString();
        String apel=editApellido2.getText().toString();
        String sexo="";
        switch (editSexo2.getCheckedRadioButtonId()) {
            case R.id.radiobutton3: {
                sexo="F";
                break;
            }
            case R.id.radiobutton4: {
                sexo="M";
                break;
            }
        }
        String car=editCargo2.getText().toString();

        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(codt)||TextUtils.isEmpty(codes)||TextUtils.isEmpty(name)||TextUtils.isEmpty(apel)||TextUtils.isEmpty(sexo)||TextUtils.isEmpty(car)) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            Tutor tt = new Tutor();
            tt.setCodtutor(codt);
            tt.setCodespecial(codes);
            tt.setNombre(name);
            tt.setApellido(apel);
            tt.setSexo(sexo);
            tt.setCargo(car);

            helper.abrir();
            String estado = helper.actualizar(tt);
            helper.cerrar();
            Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarTutor(View v){
        //Verificar que no haya dato vacio
        if (TextUtils.isEmpty(editCodtutor2.getText().toString())||TextUtils.isEmpty(editCodespecial2.getText().toString())) {
            Toast.makeText(this, "Por favor llene los campos vacios", Toast.LENGTH_LONG).show();
        }
        //fin verificar vacio
        else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setCancelable(false);
            dialog.setTitle("Eliminar");
            dialog.setMessage("Realmente desea eliminar este Registro?");
            dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    aceptar();
                }
            });
            dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            dialog.show();
        }
    }

    public void aceptar() {
        String regEliminadas;
        String codt=editCodtutor2.getText().toString();
        String code=editCodespecial2.getText().toString();

        Tutor tt = new Tutor();
        tt.setCodtutor(codt);
        tt.setCodespecial(code);

        helper.abrir();
        regEliminadas = helper.eliminar(tt);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

    /*public void addGallery(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        image = (ImageView) findViewById(R.id. mainimage);
        image.setOnClickListener(onClick);
        if (savedInstanceState != null) {
            if (savedInstanceState.getString( "Foto") != null) {
                image.setImageURI(Uri. parse(savedInstanceState.getString("Foto")));
                file = Uri.parse(savedInstanceState.getString("Foto"));
            }
        }
    }*/

    public void onSaveInstanceState(Bundle bundle){
        if (file!=null){
            bundle.putString("Foto", file.toString());
        }
        super.onSaveInstanceState(bundle);
    }

    View.OnClickListener onClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File photo =new File(Environment.getExternalStorageDirectory(), String.valueOf(Calendar.getInstance().getTimeInMillis())+".jpg");
            file=Uri.fromFile(photo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
            startActivityForResult(intent, FOTOGRAFIA);
        }
    };

    @Override
    public void onActivityResult( int RequestCode, int ResultCode, Intent intent) {
        if (RequestCode==FOTOGRAFIA){
            if(ResultCode == RESULT_OK){
                image.setImageURI( file);
            }
            else{
                Toast. makeText(getApplicationContext(), "fotografia No tomada", Toast. LENGTH_SHORT).show();
            }
        }
    }

    public void limpiarTexto(View v) {
        editCodtutor.setText("");
        editCodespecial.setText("");
        editNombre.setText("");
        editApellido.setText("");
        editSexo.clearCheck();
        editCargo.setText("");
        image.setImageResource(R.drawable.img_default);

        editCodtutor2.setText("");
        editCodespecial2.setText("");
        editNombre2.setText("");
        editApellido2.setText("");
        editSexo2.clearCheck();
        editCargo2.setText("");
    }

    public void activar(View v) {
        ToggleButton bt = (ToggleButton) findViewById(R.id.toggle);
        EditText ed = (EditText) findViewById(R.id.editNombre2);
        EditText ed1 = (EditText) findViewById(R.id.editApellido2);
        EditText ed2 = (EditText) findViewById(R.id.editCargo2);
        RadioButton rb = (RadioButton) findViewById(R.id.radiobutton3);
        RadioButton rb1 = (RadioButton) findViewById(R.id.radiobutton4);
        Button b = (Button) findViewById(R.id.eliminar);
        Button b1 = (Button) findViewById(R.id.actualizar);

        if(bt.isChecked()) {
            ed.setEnabled(true);
            ed1.setEnabled(true);
            ed2.setEnabled(true);
            rb.setEnabled(true);
            rb1.setEnabled(true);
            b.setEnabled(true);
            b1.setEnabled(true);
        } else {
            ed.setEnabled(false);
            ed1.setEnabled(false);
            ed2.setEnabled(false);
            rb.setEnabled(false);
            rb1.setEnabled(false);
            b.setEnabled(false);
            b1.setEnabled(false);
        }
    }
}