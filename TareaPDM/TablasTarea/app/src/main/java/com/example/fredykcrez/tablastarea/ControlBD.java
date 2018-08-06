package com.example.fredykcrez.tablastarea;

/**
 * Created by Fredy Kcrez on 20/05/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBD {
    private static final String[]camposTutor = new String[] {"codtutor","codespecial","nombre","apellido","sexo","cargo"};
    private static final String[]camposEncargS = new String[] {"codencarg","nombre","apellido","sexo","correo"};

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBD(Context ctx){
        this.context=ctx;
        DBHelper=new DatabaseHelper(context);
    }
    private static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, "alumno.s3db", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE encargs(codencarg VARCHAR(7) NOT NULL PRIMARY KEY,nombre VARCHAR(30),apellido VARCHAR(30),sexo VARCHAR(1),correo VARCHAR(50)); ");
                db.execSQL("CREATE TABLE tutor(codtutor VARCHAR(7) NOT NULL,codespecial VARCHAR(7) NOT NULL, nombre VARCHAR(30),apellido VARCHAR(30),sexo VARCHAR(1),cargo VARCHAR(50),PRIMARY KEY(codtutor,codespecial));");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
        }
    }
    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;
    }
    public void cerrar(){
        DBHelper.close();
    }

    public String insertar(EncargS encargS){
        String regInsertados="Registro Insertado Nº= " ;
        long contador=0;

        ContentValues enc = new ContentValues();
        enc.put("codencarg" , encargS.getCodencarg());
        enc.put("nombre" , encargS.getNombre());
        enc.put("apellido", encargS.getApellido());
        enc.put("sexo" , encargS.getSexo());
        enc.put("correo" , encargS.getCorreo());
        contador=db.insert("encargs" , null, enc);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción" ;
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertar(Tutor tutor){
        String regInsertados="Registro Insertado Nº= " ;
        long contador=0;
        /*if(verificarIntegridad(tutor,1))
        {
            ContentValues tt = new ContentValues();
            tt.put("codtutor", tutor.getCodtutor());
            tt.put("codepsecial", tutor.getCodespecial());
            tt.put("nombre", tutor.getNombre());
            tt.put("apellido", tutor.getApellido());
            tt.put("sexo", tutor.getSexo());
            tt.put("cargo", tutor.getCargo());
            contador=db.insert("tutor", null, tt);
        }*/
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String actualizar(EncargS encargS){
        if(verificarIntegridad(encargS, 4)){
            String[ ] id = {encargS.getCodencarg()};
            ContentValues cv = new ContentValues();
            cv.put("nombre", encargS.getNombre());
            cv.put("apellido" , encargS.getApellido());
            cv.put("sexo", encargS.getSexo());
            cv.put("correo", encargS.getCorreo());
            db.update( "encargs" , cv, "codencarg = ?" , id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con carnet " + encargS.getCodencarg() + " no existe";
        }
    }
    public String actualizar(Tutor tutor){
        if(verificarIntegridad(tutor, 2)){
            String[] id = {tutor.getCodtutor(), tutor.getCodespecial()};
            ContentValues cv = new ContentValues();
            cv.put("nombre" , tutor.getNombre());
            cv.put("apellido", tutor.getApellido());
            cv.put("sexo", tutor.getSexo());
            cv.put("cargo", tutor.getCargo());
            db.update( "tutor", cv, "codtutor = ? AND codespecial = ?" , id);
            return "Registro Actualizado Correctamente" ;
        }else{
            return "Registro no Existe" ;
        }
    }
    public String eliminar(EncargS encargS){
        String regAfectados="Filas afectadas = " ;
        int contador=0;
       /* if (verificarIntegridad(encargS,3)) {
            contador+=db.delete( "proyecto", "codencarg='" +encargS.getCodencarg()+"'", null);
        }*/
        contador+=db.delete( "encargs" , "codencarg='" +encargS.getCodencarg()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    public String eliminar(Tutor tutor){
        String regAfectados="Filas afectadas= " ;
        int contador=0;
        String where="codtutor='" +tutor.getCodtutor()+"'";
        where=where+" AND codespecial='" +tutor.getCodespecial()+"'";
        contador+=db.delete("tutor", where, null);
        regAfectados+=contador;
        return regAfectados;
    }
    public EncargS consultarEncargS(String codencarg){
        String[] id = {codencarg};
        Cursor cursor = db.query("encargs" , camposEncargS, "codencarg = ?" , id, null, null, null);
        if(cursor.moveToFirst()){
            EncargS encS = new EncargS();
            encS.setCodencarg(cursor.getString(0));
            encS.setNombre(cursor.getString(1));
            encS.setApellido(cursor.getString(2));
            encS.setSexo(cursor.getString(3));
            encS.setCorreo(cursor.getString(4));
            return encS;
        }else{
            return null;
        }
    }
    public Tutor consultarTutor(String codtutor,String codespecial){
        String[] idt = {codtutor, codespecial};
        Cursor cursor = db.query("tutor" , camposTutor, "codtutor = ? AND codespecial = ?", idt, null, null, null);
        if(cursor.moveToFirst()){
            Tutor tt = new Tutor();
            tt.setCodtutor(cursor.getString(0));
            tt.setCodespecial(cursor.getString(1));
            tt.setNombre(cursor.getString(2));
            tt.setApellido(cursor.getString(3));
            tt.setSexo(cursor.getString(4));
            tt.setCargo(cursor.getString(5));
            return tt;
        }else{
            return null;
        }
    }

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
            case 1:
            {
                //verificar que al insertar tutor exista codigo especialidad
                Tutor tutor = (Tutor)dato;
                String[] id1 = {tutor.getCodespecial()};
                //abrir();
                Cursor cursor1 = db.query("especialidad", null, "codespecial = ?",id1,null,null,null);
                if(cursor1.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2:
            {
                //verificar que al modificar tutor exista codigo de especialidad  y el codigo de tutor
                Tutor tutor1 = (Tutor)dato;
                String[] ids = {tutor1.getCodtutor(), tutor1.getCodespecial()};
                abrir();
                Cursor c = db.query("tutor", null, "codtutor = ? AND codespecial = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 3:
            {
                EncargS encargS = (EncargS)dato;
                Cursor ce=db.query(true, "proyecto", new String[] {"codencarg"}, "codencarg='"+encargS.getCodencarg()+"'",null,null,null,null,null);
                if(ce.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 4:
            {
                //verificar que exista Encargado Servicio Social
                EncargS encargS2 = (EncargS)dato;
                String[] idm = {encargS2.getCodencarg()};
                abrir();
                Cursor cm = db.query("encargs", null, "codencarg = ?", idm, null, null,
                        null);
                if(cm.moveToFirst()){
                    //Se encontro EncargS
                    return true;
                }
                return false;
            }
            default:
                return false;
        }
    }
    public String llenarBD(){
        final String[] VEcodencarg = {"OO12035","OF12044","GG11098","CC12021"};
        final String[] VEnombre = {"Carlos","Pedro","Sara","Gabriela"};
        final String[] VEapellido = {"Orantes","Ortiz","Gonzales","Coto"};
        final String[] VEsexo = {"M","M","F","F"};
        final String[] VEcorreo = {"Carlos@gmail.com","Pedro@gmail.com","Sara@gmail.com","Gabriela@gmail.com"};

        final String[] VTcodtutor = {"LL11035","SC11044","RD11098"};
        final String[] VTcodespecial= {"JL07115","SR20115","TS19115"};
        final String[] VTnombre = {"Saul","Juan","Rosa"};
        final String[] VTapellido = {"Andradez","Coto","Barrera"};
        final String[] VTsexo = {"M","M","F"};
        final String[] VTcargo = {"Jefa","Tester","Secretaria"};

        abrir();
        db.execSQL("DELETE FROM tutor");
        db.execSQL("DELETE FROM encargs");

        EncargS encargS = new EncargS();
        for(int i=0;i<4;i++){
            encargS.setCodencarg(VEcodencarg[i]);
            encargS.setNombre(VEnombre[i]);
            encargS.setApellido(VEapellido[i]);
            encargS.setSexo(VEsexo[i]);
            encargS.setCorreo(VEcorreo[i]);
            insertar(encargS);
        }
        Tutor tutor = new Tutor();
        for(int i=0;i<3;i++){
            tutor.setCodtutor(VTcodtutor[i]);
            tutor.setCodespecial(VTcodespecial[i]);
            tutor.setNombre(VTnombre[i]);
            tutor.setApellido(VTapellido[i]);
            tutor.setSexo(VTsexo[i]);
            tutor.setCargo(VTcargo[i]);
            insertar(tutor);
        }
        cerrar();
        return "Guardo Correctamente";
    }
}