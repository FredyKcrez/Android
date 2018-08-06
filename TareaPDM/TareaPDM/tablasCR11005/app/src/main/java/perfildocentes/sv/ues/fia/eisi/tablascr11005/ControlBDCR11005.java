package perfildocentes.sv.ues.fia.eisi.tablascr11005;

/**
 * Created by william on 20/05/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBDCR11005 {
    private static final String[] camposTutor = new String[]{"codTutor", "codEspecial","nombre","apellido","cargo","sexo"};
    private static final String[] camposEncargServSocial = new String[]{"codEncargSS", "nombre", "apellido", "sexo","correo"};

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBDCR11005(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, "nuestrabase.s3db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE tutor(codTutor VARCHAR(10) NOT NULL,codigoEspecialidad VARCHAR(10) NOT NULL,nombre VARCHAR(30),apellido VARCHAR(30),cargo VARCHAR(50),sexo VARCHAR(1),PRIMARY KEY(codTutor,codEspecial));");
                db.execSQL("CREATE TABLE encargado_serv_social(codigoEncargado VARCHAR(10) NOT NULL PRIMARY KEY,nombre VARCHAR(10),apellido VARCHAR(30),sexo VARCHAR(1));");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //TODO Auto-generated method stub
        }
}

    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;
    }
    public void cerrar(){
        DBHelper.close();
    }

    public String insertar(Tutor tutor){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;

        if(verificarIntegridad(tutor,1))
        {
            ContentValues tut = new ContentValues();
            tut.put("codTutor", tutor.getCodTutor());
            tut.put("codEspecial", tutor.getCodEspecial());
            tut.put("nombre", tutor.getNombre());
            tut.put("apellido", tutor.getApellido());
            tut.put("sexo", tutor.getSexo());
            tut.put("cargo", tutor.getCargo());
            contador=db.insert("tutor", null, tut);
        }
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
}
    public String insertar(EncargServSocial encargServSocial){
        return null;
    }
    public String actualizar(Tutor tutor){
        return null;
    }
    public String actualizar(EncargServSocial encargServSocial){
        return null;
    }
    public String eliminar(Tutor tutor){
        return null;
    }
    public String eliminar(EncargServSocial encargServSocial){
        return null;
    }
    public Tutor consultarTutor(String codTutor, String codEspecial){
        String[] id = {codTutor, codEspecial};
        Cursor cursor = db.query("tutor", camposTutor, "codTutor = ? AND codEspecial = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Tutor tutor = new Tutor();
            tutor.setCodTutor(cursor.getString(0));
            tutor.setCodEspecial(cursor.getString(1));
            tutor.setNombre(cursor.getString(2));
            tutor.setApellido(cursor.getString(3));
            tutor.setSexo(cursor.getString(4));
            tutor.setCargo(cursor.getString(3));
            return tutor;
        }else{
            return null;
        }
    }
    public EncargServSocial consultarEncargServSocial(String codEncargSS){
        return null;
    }
    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
            case 1:
            {
                //verificar que al insertar tutor exista codigo especialidad
                Tutor tutor = (Tutor)dato;
                String[] id1 = {tutor.getCodEspecial()};
                //abrir();
                Cursor cursor1 = db.query("especialidad", null, "codigoEspecialidad = ?", id1, null, null, null);
                if(cursor1.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2:
            {
                //verificar que al modificar tutor exista codigo del tutor, codigo de especialidad, nombre, apellido, cargo y sexo
                Tutor tutor1 = (Tutor)dato;
                String[] ids = {tutor1.getCodTutor(), tutor1.getCodEspecial(), tutor1.getNombre(), tutor1.getApellido(), tutor1.getCargo(), tutor1.getSexo()};
                abrir();
                Cursor c = db.query("tutor", null, "codTutor = ? AND codigoEspecialidad = ? AND nombre = ? apellido = ? AND cargo = ? AND sexo = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 3:
            {
                EncargServSocial encargServSocial = (EncargServSocial)dato;
                Cursor c=db.query(true, "proyecto", new String[] {"codigoEncargado" }, "codigoEncargado='"+encargServSocial.getCodEncargSS()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 4:
            {
                //verificar que exista alumno
                EncargServSocial encargServSocial2 = (EncargServSocial)dato;
                String[] id = {encargServSocial2.getCodEncargSS()};
                abrir();
                Cursor c2 = db.query("encargado_serv_social", null, "codigoEncargado = ?", id, null, null, null);
                if(c2.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }
            default:
                return false;
        }
    }
    public String llenarBDCarnet(){
        final String[] VTcodtutor = {"TOD1203532","TFS1204476","TGC1109548","TCC1243021"};
        final String[] VTcodespecialidad = {"EOD1203532","EFS1204476","EGC1109548","ECC1243021"};
        final String[] VTnombre = {"Carlos","Pedro","Sara","Gabriela"};
        final String[] VTapellido = {"Orantes","Ortiz","Gonzales","Coto"};
        final String[] VTcargo = {"Jefe","Docente","Jefe","Secretaria"};
        final String[] VTsexo = {"M","M","F","F"};

        final String[] VEencargss = {"TOD1203532","TFS1204476","TGC1109548","TCC1243021"};
        final String[] VEnombre = {"Carlos","Pedro","Sara","Gabriela"};
        final String[] VEapellido = {"Orantes","Ortiz","Gonzales","Coto"};
        final String[] VEcorreo = {"Jefe","Docente","Jefe","Secretaria"};
        final String[] VEsexo = {"M","M","F","F"};

        abrir();
        db.execSQL("DELETE FROM tutor");
        db.execSQL("DELETE FROM encargado_serv_social");

        EncargServSocial encargServSocial = new EncargServSocial();
        for(int i=0;i<4;i++){
            encargServSocial.setCodEncargSS(VEencargss[i]);
            encargServSocial.setNombre(VEnombre[i]);
            encargServSocial.setApellido(VEapellido[i]);
            encargServSocial.setSexo(VEsexo[i]);
            encargServSocial.setCorreo(VEcorreo[i]);
            insertar(encargServSocial);
        }
        Tutor tutor = new Tutor();
        for(int i=0;i<4;i++){
            tutor.setCodTutor(VTcodtutor[i]);
            tutor.setCodEspecial(VTcodespecialidad[i]);
            tutor.setNombre(VTnombre[i]);
            tutor.setApellido(VTapellido[i]);
            tutor.setCargo(VTcargo[i]);
            tutor.setSexo(VTsexo[i]);
            insertar(tutor);
        }
        cerrar();
        return "Guardo Correctamente";
    }
}