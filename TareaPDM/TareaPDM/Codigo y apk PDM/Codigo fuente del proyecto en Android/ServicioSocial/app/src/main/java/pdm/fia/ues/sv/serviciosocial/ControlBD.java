package pdm.fia.ues.sv.serviciosocial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class ControlBD {

    private static final String[]camposProyecto = new String [] {"codigoproyecto","codigoencargado","codigoentidad","codigotipoproyecto","codigotutor","nombreproyecto","cantidadalumnos"};
    private static final String[]camposTipoProyecto = new String [] {"codigotipoproyecto","tipoproyecto"};
    private static final String[]camposEntidad = new String [] {"codigo_org", "nombre_org", "rubro", "telefono", "direccion"};
    private static final String[]camposEspecialidad = new String [] {"codigo_esp","nom_esp","cantidad_estudiantes"};
    private static final String[]camposTipoActividad = new String [] {"codTipoActividad","codModalidad","nombTipo","costoxHora"};
    private static final String[] camposModalidad = new String [] {"codModalidad","nombModalidad"};
    private static final String[]camposTutor = new String[] {"codtutor","codespecial","nombre","apellido","sexo","cargo"};
    private static final String[]camposEncargS = new String[] {"codencarg","nombre","apellido","sexo","correo"};

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    private String alumnoT="alumno";
    private String alumnoproyectoT="alumnoproyecto";
    private String actividadT="actividad";

    public ControlBD(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "last.s3db";
        private static final int VERSION = 1;
        private static final String alumnoT="create table alumno(carnet varchar(7) not null primary key," +
                "nombre varchar(50) not null," +
                "apellido varchar(50) not null," +
                "carrera varchar(80) not null," +
                "sexo varchar(1) not null," +
                "matganadas integer not null," +
                "telefono1 varchar(9) not null," +
                "telefono2 varchar(9)," +
                "correo1 varchar(50) not null," +
                "correo2 varchar(50)," +
                "direccion varchar(100) not null);";
        private static final String actividadT="create table actividad(idactividad varchar(8) not null primary key," +
                " codTipoActividad varchar(8) not null, "+
                "actividad varchar(100) not null," +
                " fecha date not null," +
                "numhoras integer," +
                "observacion varchar(150));";
        private static final String alumnoProyectoT="create table alumnoproyecto(carnet varchar(7) not null," +
                "codigoproyecto varchar(10) not null," +
                "idactividad varchar(8)not null," +
                "primary key(carnet,codigoproyecto,idactividad));";
        private static final String fk_alumnoproyecto_alumno="create trigger fk_alumnoproyecto_alumno before insert on alumnoproyecto " +
                " for each row " +
                " begin " +
                " select case " +
                " when((select carnet from alumno where alumno.carnet=new.carnet)is null)then " +
                "raise(abort,'No existe Alumno') " +
                " end; " +
                " end; ";
        private static final String fk_alumnoproyecto_proyecto="create trigger fk_alumnoproyecto_proyecto before insert on alumnoproyecto " +
                " for each row " +
                " begin " +
                " select case " +
                " when((select codigoproyecto from proyecto where proyecto.codigoproyecto=new.codigoproyecto)is null)then " +
                " raise(abort,'No existe Proyecto') " +
                " end; " +
                " end; ";
        private static final String fk_alumnoproyecto_actividad="create trigger fk_alumnoproyecto_actividad before insert on alumnoproyecto " +
                " for each row " +
                " begin " +
                " select case " +
                " when((select idactividad from actividad where actividad.idactividad=new.idactividad)is null)then " +
                " raise(abort,'No existe Actividad')" +
                " end; " +
                " end; ";
        private static final String fk_actividad_tipoActividad=" create trigger fk_actividad_tipoactividad before insert on actividad " +
                " for each row " +
                " begin " +
                "    select case " +
                "    when((select codTipoActividad from tipoactividad where tipoactividad.codTipoActividad=new.codTipoActividad)is null) " +
                "    then raise(abort,'No existe TipoActividad')" +
                "    end; " +
                "    end; ";
        private static final String eliminarAlumno="Create trigger eliminarAlumno before delete on alumno " +
                " for each row " +
                " begin " +
                "    delete from alumnoproyecto where alumnoproyecto.carnet=old.carnet; " +
                "    end; ";
        private static final  String eliminarActividad=" CREATE TRIGGER eliminarActividad " +
                " BEFORE DELETE ON actividad " +
                " FOR EACH ROW " +
                " BEGIN " +
                " delete from alumnoproyecto where alumnoproyecto.idactividad=old.idactividad; " +
                "END;";
        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("CREATE TABLE tipo_proyecto(codigotipoproyecto VARCHAR(10) NOT NULL PRIMARY KEY,   tipoproyecto VARCHAR(50));");
                db.execSQL("CREATE TABLE proyecto(codigoproyecto VARCHAR(10) NOT NULL PRIMARY KEY,codigoencargado VARCHAR(10) NOT NULL,codigoentidad VARCHAR(10) NOT NULL,codigotipoproyecto VARCHAR(10) NOT NULL,codigotutor VARCHAR(10) NOT NULL,nombreproyecto VARCHAR(100),cantidadalumnos INTEGER,CONSTRAINT fk_tipo_proyecto FOREIGN KEY (codigotipoproyecto) REFERENCES tipo_proyecto(codigotipoproyecto) ON DELETE RESTRICT);");
                db.execSQL("CREATE TABLE entidad(codigo_org VARCHAR(5) NOT NULL PRIMARY KEY, nombre_org VARCHAR(30), rubro VARCHAR(30), telefono VARCHAR(8), direccion VARCHAR(100) ); ");
                db.execSQL("CREATE TABLE especialidad(codigo_esp VARCHAR(5) NOT NULL PRIMARY KEY, nom_esp VARCHAR(30), cantidad_estudiantes VARCHAR(50));");
                db.execSQL("CREATE TABLE tipoactividad(codTipoActividad VARCHAR(8) NOT NULL,codModalidad VARCHAR(8) NOT NULL,nombTipo VARCHAR(30),costoxHora FLOAT, PRIMARY KEY(codTipoActividad,codModalidad));");
                db.execSQL("CREATE TABLE modalidad(codModalidad VARCHAR(8) NOT NULL PRIMARY KEY,nombModalidad VARCHAR(30));");
                db.execSQL("CREATE TABLE encargs(codencarg VARCHAR(7) NOT NULL PRIMARY KEY,nombre VARCHAR(30),apellido VARCHAR(30),sexo VARCHAR(1),correo VARCHAR(50)); ");
                db.execSQL("CREATE TABLE tutor(codtutor VARCHAR(7) NOT NULL,codespecial VARCHAR(7) NOT NULL, nombre VARCHAR(30),apellido VARCHAR(30),sexo VARCHAR(1),cargo VARCHAR(50),PRIMARY KEY(codtutor,codespecial));");
                db.execSQL(alumnoT);
                db.execSQL(actividadT);
                db.execSQL(alumnoProyectoT);
                db.execSQL(fk_alumnoproyecto_actividad);
                db.execSQL(fk_alumnoproyecto_alumno);
                db.execSQL(fk_alumnoproyecto_proyecto);
                db.execSQL(eliminarAlumno);
                db.execSQL(eliminarActividad);
                db.execSQL(fk_actividad_tipoActividad);


            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }
    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;
    }
    public void cerrar(){
        DBHelper.close();
    }

    public String insertar(Proyecto proyecto){
        String regInsertados = "Proyecto Insertado # ";
        if(verificarIntegridad(proyecto,1)) {

            long contador = 0;
            ContentValues project = new ContentValues();
            project.put("codigoproyecto", proyecto.getCodigoProyecto());
            project.put("codigoencargado", proyecto.getCodigoEncargado());
            project.put("codigoentidad", proyecto.getCodigoEntidad());
            project.put("codigotipoproyecto", proyecto.getCodigoTipoProyecto());
            project.put("codigotutor", proyecto.getCodigoTutor());
            project.put("nombreproyecto", proyecto.getNombreProyecto());
            project.put("cantidadalumnos", proyecto.getCantidadAlumnos());
            contador = db.insert("proyecto", null, project);
            if (contador == -1 || contador == 0) {
                regInsertados = "Error al Insertar el proyecto, Proyecto Duplicado. Verificar inserción";
            } else {
                regInsertados = regInsertados + contador;
            }
        }
        else{
            regInsertados = "El tipo de proyecto no existe";
        }
        return regInsertados;
    }
    public String insertar(TipoProyecto tipoProyecto){
        String regInsertados="Tipo Proyecto Insertado # ";
        long contador=0;
        ContentValues tproject = new ContentValues();
        tproject.put("codigotipoproyecto", tipoProyecto.getCodigoTipoProyecto());
        tproject.put("tipoproyecto", tipoProyecto.getTipoProyecto());
        contador=db.insert("tipo_proyecto", null, tproject);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Tipo Proyecto Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String actualizar(Proyecto proyecto){
        if(verificarIntegridad(proyecto, 5)){
            if(verificarIntegridad(proyecto, 2)) {
                String[] id = {proyecto.getCodigoProyecto()};
                ContentValues cv = new ContentValues();
                cv.put("codigoencargado", proyecto.getCodigoEncargado());
                cv.put("codigoentidad", proyecto.getCodigoEntidad());
                cv.put("codigotipoproyecto", proyecto.getCodigoTipoProyecto());
                cv.put("codigotutor", proyecto.getCodigoTutor());
                cv.put("nombreproyecto", proyecto.getNombreProyecto());
                cv.put("cantidadalumnos", proyecto.getCantidadAlumnos());
                db.update("proyecto", cv, "codigoproyecto = ?", id);
                return "Registro Actualizado Correctamente";
            }
            else{
                return "Tipo de proyecto " + proyecto.getCodigoTipoProyecto() + " no existe";
            }
        }else{
            return "Proyecto con codigo " + proyecto.getCodigoProyecto() + " no existe";
        }
    }
    public String actualizar(TipoProyecto tipoProyecto){
        if(verificarIntegridad(tipoProyecto, 6)){
            String[] id = {tipoProyecto.getCodigoTipoProyecto()};
            ContentValues cv = new ContentValues();
            cv.put("tipoproyecto", tipoProyecto.getTipoProyecto());
            db.update("tipo_proyecto", cv, "codigotipoproyecto = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Tipo proyecto con codigo" + tipoProyecto.getCodigoTipoProyecto() + " no existe";
        }
    }

    public String eliminar(Proyecto proyecto){
        String regAfectados="filas afectadas= ";
        int contador=0;
         if (verificarIntegridad(proyecto,22)) {
            contador+=db.delete("alumnoproyecto", "codigoproyecto='"+proyecto.getCodigoProyecto()+"'", null);
         }
        contador+=db.delete("proyecto", "codigoproyecto='"+proyecto.getCodigoProyecto()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    public String eliminar(TipoProyecto tipoProyecto){
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(tipoProyecto,3)) {
            contador+=db.delete("proyecto", "codigotipoproyecto='"+tipoProyecto.getCodigoTipoProyecto()+"'", null);
        }
        contador+=db.delete("tipo_proyecto", "codigotipoproyecto='"+tipoProyecto.getCodigoTipoProyecto()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    public Proyecto consultarProyecto(String codigoProyecto){
        String[] id = {codigoProyecto};
        Cursor cursor = db.query("proyecto", camposProyecto, "codigoproyecto = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Proyecto pro = new Proyecto();
            pro.setCodigoProyecto(cursor.getString(0));
            pro.setCodigoEncargado(cursor.getString(1));
            pro.setCodigoEntidad(cursor.getString(2));
            pro.setCodigoTipoProyecto(cursor.getString(3));
            pro.setCodigoTutor(cursor.getString(4));
            pro.setNombreProyecto(cursor.getString(5));
            pro.setCantidadAlumnos(cursor.getInt(6));

            return pro;
        }else{ return null;
        }
    }
    public TipoProyecto consultarTipoProyecto(String codigoTipoProyecto){
        String[] id = {codigoTipoProyecto};
        Cursor cursor = db.query("tipo_proyecto", camposTipoProyecto, "codigotipoproyecto = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            TipoProyecto tp = new TipoProyecto();
            tp.setCodigoTipoProyecto(cursor.getString(0));
            tp.setTipoProyecto(cursor.getString(1));
            return tp;
        }else{ return null;
        }
    }



    public String insertar(Entidad entidad){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues enti = new ContentValues();
        enti.put("nombre_org", entidad.getNombre_organizacion());
        enti.put("codigo_org", entidad.getCodigo_org());
        enti.put("rubro", entidad.getRubro());
        enti.put("telefono", entidad.getTelefono());
        enti.put("direccion", entidad.getDireccion());

        contador=db.insert("entidad", null, enti);

        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public String insertar(Especialidad especialidad){

        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues espe = new ContentValues();

        espe.put("nom_esp", especialidad.getNombre_esp());
        espe.put("codigo_esp", especialidad.getCodigo_esp());
        espe.put("cantidad_estudiantes", especialidad.getCantidad_estudiantes());

        contador=db.insert("especialidad", null, espe);

        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }

        return regInsertados;
    }



    public String actualizar(Entidad entidad)
    {
        if(verificarIntegridad(entidad, 7))
        {
            String[ ] id = {entidad.getCodigo_org()};

            ContentValues cv = new ContentValues();

            cv.put("nombre_org", entidad.getNombre_organizacion());
            cv.put("rubro", entidad.getRubro());
            cv.put("telefono", entidad.getTelefono());
            cv.put("direccion", entidad.getDireccion());
            db.update("entidad", cv, "codigo_org = ?", id);

            return "Registro Actualizado Correctamente" ;
        }else{
            return "Registro con codigo " + entidad.getCodigo_org() + " no existe";
        }
    }

    public String actualizar(Especialidad especialidad){

        if(verificarIntegridad(especialidad, 8))
        {
            String[ ] id = {especialidad.getCodigo_esp()};

            ContentValues cv = new ContentValues();

            cv.put("nom_esp", especialidad.getNombre_esp());
            cv.put("cantidad_estudiantes", especialidad.getCantidad_estudiantes());

            db.update("especialidad", cv, "codigo_esp = ?", id);

            return "Registro Actualizado Correctamente" ;
        }else{
            return "Registro con codigo " + especialidad.getCodigo_esp() + " no existe";
        }
    }


    public String eliminar(Entidad entidad)
    {
        String regAfectados="filas afectadas= " ;
        int contador=0;

        if (verificarIntegridad(entidad,19))
        {
            contador+=db.delete( "proyecto", "codigoentidad='"+entidad.getCodigo_org()+"'", null);
        }

        contador+=db.delete(  "entidad", "nombre_org='"+entidad.getCodigo_org()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    public String eliminar(Especialidad especialidad){

        String regAfectados="filas afectadas= " ;
        int contador=0;

        if (verificarIntegridad(especialidad,8))
        {
            String[] codi={especialidad.getCodigo_esp()};
            Cursor cursor = db.query("tutor", camposTutor, "codespecial = ?", codi, null, null, null);
            if(cursor.moveToFirst()){
                Tutor tt = new Tutor();
                tt.setCodtutor(cursor.getString(0));
                tt.setCodespecial(cursor.getString(1));
                tt.setNombre(cursor.getString(2));
                tt.setApellido(cursor.getString(3));
                tt.setSexo(cursor.getString(4));
                tt.setCargo(cursor.getString(5));
                contador+=db.delete( "proyecto", "codigotutor='"+tt.getCodtutor()+"'", null);

            }
            contador+=db.delete( "tutor", "codespecial='"+especialidad.getCodigo_esp()+"'", null);

        }
        contador+=db.delete(  "especialidad", "codigo_esp='"+especialidad.getCodigo_esp()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    public Entidad consultarEntidad(String codigo_org){

        String[] id = {codigo_org};
        Cursor cursor = db.query("entidad", camposEntidad, "codigo_org = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Entidad entidad = new Entidad();
            entidad.setNombre_organizacion(cursor.getString(0));
            entidad.setCodigo_org(cursor.getString(1));
            entidad.setRubro(cursor.getString(2));
            entidad.setTelefono(cursor.getString(3));
            entidad.setDireccion(cursor.getString(4));
            return entidad;
        }else{
            return null;
        }
    }

    public Especialidad consultarEspecialidad(String codigo_esp){

        String[] id = {codigo_esp};
        Cursor cursor = db.query("especialidad", camposEspecialidad, "codigo_esp = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Especialidad especialidad = new Especialidad();
            especialidad.setCodigo_esp(cursor.getString(0));
            especialidad.setNombre_esp(cursor.getString(1));
            especialidad.setCantidad_estudiantes(cursor.getString(2));

            return especialidad;
        }else{
            return null;
        }
    }

    /////////////////parte3//////

    public String insertar(TipoActividad tipo) throws SQLException {
        String regInsertados = "Registro Insertado # ";

        if (verificarIntegridad(tipo,9)) {

            ContentValues datos = new ContentValues();
            long contador = 0;

            datos.put("codTipoActividad", tipo.getCodtipoactividad());
            datos.put("codModalidad", tipo.getCodmodalidad());
            datos.put("nombTipo", tipo.getNomtipo());
            datos.put("costoxHora", tipo.getCostoxhora());

            contador = db.insert("tipoactividad", null, datos);
            regInsertados += contador;

            if (contador < 0) {
                regInsertados = "Error: Verifique Datos";
            }
        }else {
            regInsertados = "Error: No existe esa modalidad";
        }
        return regInsertados;
    }

    public String insertar(Modalidad mod){

        String regInsertados="Modalidad # ";
        long contador=0;


        ContentValues moda = new ContentValues();
        moda.put("codModalidad",mod.getCodmodalidad());
        moda.put("nombModalidad",mod.getNombmodalidad());

        contador=db.insert("modalidad", null, moda);

        if(contador<0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;

    }

    public String actualizar(TipoActividad tipo) throws SQLException {
        if(verificarIntegridad(tipo, 12)){
            String[] id = {tipo.getCodtipoactividad(), tipo.getCodmodalidad()};
            ContentValues cv = new ContentValues();
            cv.put("costoxHora", tipo.getCostoxhora());
            cv.put("nombTipo", tipo.getNomtipo());

            db.update("tipoactividad", cv, "codTipoActividad = ? AND codModalidad = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro no Existe";
        }
    }

    public String actualizar(Modalidad moda) throws SQLException {

        if(verificarIntegridad(moda, 10)){

            String[] id = {moda.getCodmodalidad()};
            ContentValues cv = new ContentValues();
            cv.put("nombModalidad", moda.getNombmodalidad());
            db.update("modalidad", cv, "codModalidad = ?", id);

            return "Registro Actualizado Correctamente";

        }else{
            return "Registro con codigo " + moda.getCodmodalidad() + " no existe";
        }
    }

    public String eliminar(TipoActividad tipo){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="codTipoActividad='"+tipo.getCodtipoactividad()+"'";
        where=where+" AND codModalidad='"+tipo.getCodmodalidad()+"'";

        contador+=db.delete("tipoactividad", where, null);
        regAfectados+=contador;
        return regAfectados;
    }

    public String eliminar(Modalidad moda) throws SQLException {

        String regAfectados="filas afectadas= ";
        int contador=0;

        if (verificarIntegridad(moda,11)) {
            contador+=db.delete("tipoactividad", "codModalidad='"+moda.getCodmodalidad()+"'", null);
        }
        contador+=db.delete("modalidad", "codModalidad='"+moda.getCodmodalidad()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }



    public TipoActividad consultarTipoActividad(String codTipoActividad, String codModalidad){

        String[] id = {codTipoActividad, codModalidad};
        Cursor cursor = db.query("tipoactividad", camposTipoActividad, "codTipoActividad = ? AND codModalidad = ?", id, null, null, null);

        if(cursor.moveToFirst()){
            TipoActividad tipo = new TipoActividad();

            tipo.setCodtipoactividad(cursor.getString(0));
            tipo.setCodmodalidad(cursor.getString(1));
            tipo.setNomtipo(cursor.getString(2));
            tipo.setCostoxhora(cursor.getFloat(3));

            return tipo;
        }else{
            return null;
        }
    }

    public Modalidad consultarModalidad(String codmod){

        String[] id = {codmod};
        Cursor cs = db.query("modalidad", camposModalidad, "codModalidad = ?", id, null, null, null);
        if(cs.moveToFirst()){
            Modalidad modalidad = new Modalidad();
            modalidad.setCodmodalidad(cs.getString(0));
            modalidad.setNombmodalidad(cs.getString(1));
            return modalidad;
        }else{
            return null;
        }
    }

    //////////////fin parte 3//////

    ///////////////Parte 4/////////////

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
       if(verificarIntegridad(tutor,13))
        {
            ContentValues tt = new ContentValues();
            tt.put("codtutor", tutor.getCodtutor());
            tt.put("codespecial", tutor.getCodespecial());
            tt.put("nombre", tutor.getNombre());
            tt.put("apellido", tutor.getApellido());
            tt.put("sexo", tutor.getSexo());
            tt.put("cargo", tutor.getCargo());
            contador=db.insert("tutor", null, tt);
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
    public String actualizar(EncargS encargS){
        if(verificarIntegridad(encargS, 16)){
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
        if(verificarIntegridad(tutor, 14)){
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
       if (verificarIntegridad(encargS,20)) {
            contador+=db.delete( "proyecto", "codigoencargado='" +encargS.getCodencarg()+"'", null);
        }
        contador+=db.delete( "encargs" , "codencarg='" +encargS.getCodencarg()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    public String eliminar(Tutor tutor){
        String regAfectados="Filas afectadas= " ;
        int contador=0;
        if (verificarIntegridad(tutor,21)) {
            contador+=db.delete( "proyecto", "codigotutor='" +tutor.getCodtutor()+"'", null);
        }
        contador+=db.delete("tutor","codtutor='" +tutor.getCodtutor()+"'"+" AND codespecial='" +tutor.getCodespecial()+"'", null);
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

    ///////////////Fin parte 4////////////////////////

    /////////////// Parte 5///////////////////

    public String insertar(Alumno alumno)throws Exception,SQLException{

        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues alum= new ContentValues();
        alum.put("carnet",alumno.getCarnet());
        alum.put("nombre",alumno.getNombre());
        alum.put("apellido",alumno.getApellido());
        alum.put("carrera",alumno.getCarrera());
        alum.put("sexo",alumno.getSexo());
        alum.put("matganadas",alumno.getMatganadas());
        alum.put("telefono1",alumno.getTelefono1());
        alum.put("telefono2",alumno.getTelefono2());
        alum.put("correo1",alumno.getCorreo1());
        alum.put("correo2",alumno.getCorreo2());
        alum.put("direccion",alumno.getDireccion());
        contador=db.insert(alumnoT,null,alum);
        if(contador<0)
        {
            regInsertados= "Error: Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertar(AlumnoProyecto alumPro)throws Exception,SQLException{
        String regInsertados="Registro Insertado Nº= ";
        ContentValues datos=new ContentValues();
        long contador;

        datos.put("carnet",alumPro.getCarnet());
        datos.put("codigoproyecto",alumPro.getCodigoProyecto());
        datos.put("idactividad",alumPro.getIdactividad());

        contador =db.insert(alumnoproyectoT,null,datos);
        if(contador<0)
        {
            regInsertados= "Error al Insertar el registro, Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String insertar(Actividad acti)throws Exception,SQLException{
        ContentValues datos=new ContentValues();
        String regInsertados="Registro Insertado # ";
        long contador=0;
        datos.put("idactividad",acti.getIdactividad());
        datos.put("codTipoActividad",acti.getCodTIpoActividad());
        datos.put("actividad",acti.getActividad());
        datos.put("fecha",acti.getFecha());
        datos.put("numhoras",acti.getNumhoras());
        datos.put("observacion",acti.getComentario());
        contador = db.insert(actividadT,null,datos);
        regInsertados+=contador;
        if(contador<0){
            regInsertados="Error: Verifique Datos";
        }
        return regInsertados;
    }
    public String actualizar(Alumno alumno){
        if(verificarIntegridad(alumno,17)) {
            ContentValues alum = new ContentValues();
            alum.put("carnet",alumno.getCarnet());
            alum.put("nombre",alumno.getNombre());
            alum.put("apellido",alumno.getApellido());
            alum.put("carrera",alumno.getCarrera());
            alum.put("sexo",alumno.getSexo());
            alum.put("matganadas",alumno.getMatganadas());
            alum.put("telefono1",alumno.getTelefono1());
            alum.put("telefono2",alumno.getTelefono2());
            alum.put("correo1",alumno.getCorreo1());
            alum.put("correo2",alumno.getCorreo2());
            alum.put("direccion",alumno.getDireccion());
            db.update(alumnoT, alum, "carnet=?", new String[]{alumno.getCarnet()});
            return "Alumno Modificado Correctamente";
        }
        return " ";
    }
    public String actualizar(AlumnoProyecto alumPro)throws Exception,SQLException{
        String regInsertados="Registro Actualizado ";
        ContentValues datos=new ContentValues();
        long contador;

        datos.put("carnet",alumPro.getCarnet());
        datos.put("codigoproyecto",alumPro.getCodigoProyecto());
        datos.put("idactividad",alumPro.getIdactividad());
        String values[]={alumPro.getCarnet(),alumPro.getCodigoProyecto(),alumPro.getIdactividad()};
        contador =db.update(alumnoproyectoT, datos, "carnet=? and codigoproyecto=? and idactividad=?", values);
        if(contador<=0)
        {
            regInsertados= "Error al Actualizar registro!";
        }
        return regInsertados;
    }
    public String actualizar(Actividad acti){
        ContentValues datos=new ContentValues();
        String regInsertados="Registro Modificado!";
        long contador=0;
        datos.put("idactividad",acti.getIdactividad());
        datos.put("codTipoActividad",acti.getCodTIpoActividad());
        datos.put("actividad",acti.getActividad());
        datos.put("fecha",acti.getFecha());
        datos.put("numhoras",acti.getNumhoras());
        datos.put("observacion",acti.getComentario());
        contador = db.update(actividadT,datos,"idactividad=?",new String[]{acti.getIdactividad()});
        regInsertados+=contador;
        if(contador<0){
            regInsertados="Error: Verifique Datos";
        }
        return regInsertados;
    }
    public String eliminar(Alumno alumno){
        String filasAfectadas="Filas afectadas = ";
        String where="carnet= ?";
        long filas=0;
        if(verificarIntegridad(alumno,17)) {
            filas = db.delete(alumnoT, where, new String[]{alumno.getCarnet()});
            filasAfectadas+=filas;
            if(filas<0){
                filasAfectadas="Error: verifique existencia de datos";
            }

        }
        return  filasAfectadas;
    }
    public String eliminar(AlumnoProyecto alumPro)throws Exception,SQLException{
        String filasAfectadas="Filas afectadas = ";
        long filas;
        String datos[]={alumPro.getCarnet(),alumPro.getCodigoProyecto()};
        filas=db.delete(alumnoproyectoT,"carnet=? and codigoproyecto=?",datos);
        filasAfectadas+=filas;
        if(filas<0){
            filasAfectadas="Error: verifique existencia de datos";
        }
        return filasAfectadas;
    }
    public String eliminar(Actividad acti)throws Exception,SQLException{
        String filasAfectadas="Filas afectadas = ";
        long filas;
        String datos[]={acti.getIdactividad()};
        filas=db.delete(actividadT,"idactividad=?",datos);
        filasAfectadas+=filas;
        if(filas<0){
            filasAfectadas="Error: verifique existencia de datos";
        }
        return filasAfectadas;
    }
    public Alumno consultarAlumno(String carnet){

        String []id= new String[]{carnet};
        Cursor c = db.query(alumnoT,null,"carnet=?",id,null,null,null);
        while (c.moveToFirst()){
            Alumno alumno = new Alumno();
            alumno.setCarnet(c.getString(0));
            alumno.setNombre(c.getString(1));
            alumno.setApellido(c.getString(2));
            alumno.setCarrera(c.getString(3));
            alumno.setSexo(c.getString(4));
            alumno.setMatganadas(Integer.parseInt(c.getString(5)));
            alumno.setTelefono1(c.getString(6));
            alumno.setTelefono2(c.getString(7));
            alumno.setCorreo1(c.getString(8));
            alumno.setCorreo2(c.getString(9));
            alumno.setDireccion(c.getString(10));
            return alumno;
        }
        return null;
    }
    public AlumnoProyecto consultarAlumnoProyecto(AlumnoProyecto alumP){
        AlumnoProyecto newAlumP=null;
        String where="carnet=? and codigoproyecto=? and idactividad=?";
        String values[]={alumP.getCarnet(),alumP.getCodigoProyecto(),alumP.getIdactividad()};
        Cursor c = db.query(alumnoproyectoT, null, where, values, null, null, null);
        while(c.moveToFirst()){
            newAlumP=new AlumnoProyecto();
            newAlumP.setCarnet(c.getString(0));
            newAlumP.setCodigoProyecto(c.getString(1));
            newAlumP.setIdactividad(c.getString(2));
            return newAlumP;
        }
        return newAlumP;
    }
    public Actividad consultarActividad(String idActividad){
        Actividad actividad=null;
        Cursor cursorAct= db.rawQuery("select * from actividad where idactividad=?",new String[]{idActividad});
        while (cursorAct.moveToFirst()){
            actividad=new Actividad();
            actividad.setIdactividad(cursorAct.getString(0));
            actividad.setCodTIpoActividad(cursorAct.getString(1));
            actividad.setActividad(cursorAct.getString(2));
            actividad.setFecha(cursorAct.getString(3));
            actividad.setNumhoras(Integer.parseInt(cursorAct.getString(4)));
            actividad.setComentario(cursorAct.getString(5));
            return actividad;

        }
        return actividad;
    }
    public String[] mostrarAlumnoProyecto(String carnet,String codProyecto){
        String newAlumPro[] = {" "," "};
        Cursor cc=db.rawQuery("select nombre from alumno where carnet=?",new String[]{carnet});
        if(cc.moveToFirst()) {
            newAlumPro[0] = cc.getString(0);
            cc = db.rawQuery("select nombreproyecto from proyecto where codigoproyecto=?", new String[]{codProyecto});
            if (cc.moveToFirst()) {
                newAlumPro[1] = cc.getString(0);
                return newAlumPro;
            }
        }
        return  newAlumPro;
    }

    public ArrayList<String> getActividades(String carnet,String codPro){
        ArrayList<String> listAct = new ArrayList<String>();
        String datos[]={carnet,codPro};
        Cursor cr = db.rawQuery("select * from actividad where idactividad=(select idactividad from alumnoproyecto where alumnoproyecto.carnet=? and alumnoproyecto.codigoproyecto=?)",datos);
        while (cr.moveToNext()){
            listAct.add(cr.getString(2));
        }
        return listAct;
    }

    public int numHoras(String carnet){
        int numeroHoras=0;
        Cursor cursoNumHoras=db.rawQuery("select sum(numhoras) from actividad where idactividad=(select idactividad from alumnoproyecto where carnet = ?)",new String[]{carnet});
        if(cursoNumHoras.moveToFirst()){
            numeroHoras=cursoNumHoras.getInt(0);
        }
        return numeroHoras;
    }

    /////////////////Fin parte 5//////////////


    public ArrayList<TipoProyecto> BuscarTipoProyectos(){
        ArrayList<TipoProyecto> listAct = new ArrayList<TipoProyecto>();

        Cursor cr = db.rawQuery("select * from tipo_proyecto",null);
        while (cr.moveToNext()){
            TipoProyecto tp=new TipoProyecto();
            tp.setCodigoTipoProyecto(cr.getString(0));
            tp.setTipoProyecto(cr.getString(1));
            listAct.add(tp);
        }
        return listAct;
    }

    public boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
            case 1:
            {
//verificar que al insertar proyecto exista el tipo de proyecto, tutot.
                Proyecto proyecto = (Proyecto)dato;
                String[] id1 = {proyecto.getCodigoTipoProyecto()};
                String[] ids2={proyecto.getCodigoTutor()};
                String[] ids3={proyecto.getCodigoEncargado()};
                String[] ids4={proyecto.getCodigoEntidad()};

//abrir();
                Cursor cursor1 = db.query("tipo_proyecto", null, "codigotipoproyecto = ?", id1, null, null, null);
                Cursor c1 = db.query("tutor", null, "codtutor= ?", ids2, null, null, null);
                Cursor c2 = db.query("encargs", null, "codencarg= ?", ids3, null, null, null);
                Cursor c3 = db.query("entidad", null, "codigo_org= ?", ids4, null, null, null);

                if(cursor1.moveToFirst() && c1.moveToFirst() && c2.moveToFirst() && c3.moveToFirst() ){
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2:
            {
//verificar que al modificar proyecto exista tipo de proyecto
                Proyecto proyecto1 = (Proyecto)dato;
                String[] ids = {proyecto1.getCodigoTipoProyecto()};
                String[] ids2={proyecto1.getCodigoTutor()};
                String[] ids3={proyecto1.getCodigoEncargado()};
                String[] ids4={proyecto1.getCodigoEntidad()};

                abrir();
                Cursor c = db.query("tipo_proyecto", null, "codigotipoproyecto = ?", ids, null, null, null);
                Cursor c1 = db.query("tutor", null, "codtutor= ?", ids2, null, null, null);
                Cursor c2 = db.query("encargs", null, "codencarg= ?", ids3, null, null, null);
                Cursor c3 = db.query("entidad", null, "codigo_org= ?", ids4, null, null, null);

                if(c.moveToFirst() && c1.moveToFirst() && c2.moveToFirst() && c3.moveToFirst() ){
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 3:
            {
                TipoProyecto tipoProyecto = (TipoProyecto)dato;
                Cursor c=db.query(true, "proyecto", new String[] {
                        "codigotipoproyecto" }, "codigotipoproyecto='"+tipoProyecto.getCodigoTipoProyecto()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 4:
            {/*
                Materia materia = (Materia)dato;
                Cursor cmat=db.query(true, "nota", new String[] {
                        "codmateria" }, "codmateria='"+materia.getCodmateria()+"'",null, null, null, null, null);
                if(cmat.moveToFirst())
                    return true;
                else
                    return false;*/
            }
            case 5:
            {
//verificar que exista proyecto
                Proyecto proyecto2 = (Proyecto)dato;
                String[] id = {proyecto2.getCodigoProyecto()};
                abrir();
                Cursor c2 = db.query("proyecto", null, "codigoproyecto = ?", id, null, null, null);
                if(c2.moveToFirst()){
//Se encontro Alumno
                    return true;
                }
                return false;
            }
            case 6:
            {
//verificar que exista tipo_proyecto
                TipoProyecto tp2 = (TipoProyecto)dato;
                String[] idm = {tp2.getCodigoTipoProyecto()};
                abrir();
                Cursor cm = db.query("tipo_proyecto", null, "codigotipoproyecto = ?", idm, null, null, null);
                if(cm.moveToFirst()){
//Se encontro Materia
                    return true;
                }
                return false;
            }
            case 7:
            {
                //verificar que existe Entidad

                Entidad entidad = (Entidad)dato;

                String[] id = {entidad.getCodigo_org()};
                abrir();
                Cursor c = db.query("entidad", null, "codigo_org = ?", id, null, null, null);


                if(c.moveToFirst())
                {
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 8:
            {

                //verificar que exista Especialidad
                Especialidad especialidad = (Especialidad)dato;
                String[] idm = {especialidad.getCodigo_esp()};
                abrir();
                Cursor cm = db.query("tutor", null, "codespecial = ?", idm, null, null, null);

                if(cm.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 9: {
                //verificar que al insertar TipoActividad exista Modalidad del Proyecto
                TipoActividad tipo = (TipoActividad) dato;
                String[] id1 = {tipo.getCodmodalidad()};
                //abrir();
                Cursor cs = db.query("modalidad", null, "codModalidad = ?", id1, null, null, null);
                if (cs.moveToFirst()) {
                    //Se encontraron datos
                    return true;
                }
                return false;
            }

            case 10: {
                //verificar que exista la modalidad
                Modalidad modalidad = (Modalidad) dato;
                String[] id = {modalidad.getCodmodalidad()};
                abrir();
                Cursor c2 = db.query("modalidad", null, "codModalidad = ?", id, null, null, null);

                if (c2.moveToFirst()) {
                    //Se encontro la modalidad
                    return true;
                }
                return false;
            }

            case 11: {
                Modalidad modalidad = (Modalidad) dato;
                Cursor c = db.query(true, "tipoactividad", new String[]{
                        "codModalidad"}, "codModalidad='" + modalidad.getCodmodalidad() + "'", null, null, null, null, null);

                if (c.moveToFirst())
                    return true;
                else
                    return false;


            }
            case 12:
            {
//verificar que al modificar nota exista carnet del alumno, el codigo de materia y el ciclo
                TipoActividad tipo = (TipoActividad)dato;
                String[] ids = {tipo.getCodtipoactividad(), tipo.getCodmodalidad()};
                abrir();
                Cursor c = db.query("tipoactividad", null, "codTipoActividad = ? AND codModalidad = ?", ids, null, null, null);
                if(c.moveToFirst()){
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 13:
            {
                //verificar que al insertar tutor exista codigo especialidad
                Tutor tutor = (Tutor)dato;
                String[] id1 = {tutor.getCodespecial()};
                //abrir();
                Cursor cursor1 = db.query("especialidad", null, "codigo_esp = ?",id1,null,null,null);
                if(cursor1.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 14:
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

            case 16:
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
            case 17: {//verificar si existe alumno
                Alumno alumno1 = (Alumno) dato;
                Cursor cursoA = db.query(alumnoT, new String[]{"carnet"}, "carnet ='" + alumno1.getCarnet() + "'", null, null, null, null);
                if (cursoA.moveToFirst()) {
                    return true;
                }
                return false;
            }
            case 18: {//verifica que el Estudiante ya pueda realizar horas sociales
                AlumnoProyecto alumno = (AlumnoProyecto) dato;
                Cursor curso = db.query(alumnoT, new String[]{"carnet"}, "carnet ='" + alumno.getCarnet() + "' and matganadas>28", null, null, null, null);
                if (curso.moveToFirst()) {
                    return true;
                }
                return false;
            }
            case 19:
            {
                Entidad ent = (Entidad)dato;
                Cursor c=db.query(true, "proyecto", new String[] {
                        "codigoentidad" }, "codigoentidad='"+ent.getCodigo_org()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 20:
            {
                EncargS encargS = (EncargS)dato;
                Cursor ce=db.query(true, "proyecto", new String[] {"codigoencargado"}, "codigoencargado='"+encargS.getCodencarg()+"'",null,null,null,null,null);
                if(ce.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 21:
            {
                Tutor tutor = (Tutor)dato;
                Cursor ce=db.query(true, "proyecto", new String[] {"codigotutor"}, "codigotutor='"+tutor.getCodtutor()+"'",null,null,null,null,null);
                if(ce.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 22:
            {
                Proyecto po = (Proyecto)dato;
                Cursor ce=db.query(true, "alumnoproyecto", new String[] {"codigoproyecto"}, "codigoproyecto='"+po.getCodigoProyecto()+"'",null,null,null,null,null);
                if(ce.moveToFirst())
                    return true;
                else
                    return false;
            }
            default:
                return false;
        }
    }
    public String llenarBD(){

        final String[] VPcodigoproyecto = {"P1","P2","P3"};
        final String[] VPcodigoencargado = {"OO12035","OO12035","CC12021"};
        final String[] VPcodigoentidad = {"MS890","MH908","MA567"};
        final String[] VPcodigotipoproyecto = {"10001","10001","10002"};
        final String[] VPcodigotutor = {"LL11035","SC11044","SC11044"};
        final String[] VPnombreproyecto = {"Sistema contable para la tienda","Sistema de control de notas","Instructor"};
        final String[] VPcantidadalumnos = {"10","8","20"};


        final String[] VTPcodigotipoproyecto = {"10001","10002"};
        final String[] VTPtipoproyecto = {"Desarrollo de software","Social"};

        final String[] VAcodigo_org = {"MS890","MH908","MA567","CC421"};
        final String[] VAnom_org = {"M. Salud","M. Hacienda","M. Agricultura","Centro Cultural"};
        final String[] VArubro = {"Salud","Fisco","Agricultura","Cultura"};
        final String[] VAtelefono = {"34567567", "45780325", "76429572", "98573927"};
        final String[] VAdireccion = {"San Salvador","San Vicente","La Libertad","Santa Ana"};

        final String[] VMcodigo_esp = {"UIG90","PKL95","HJE45","TTI45"};
        final String[] VMnombre_esp = {"Doctorado","Maestria","Licenciatura","Profesorado"};
        final String[] VMcantidad_estudiantes = {"12", "23", "10", "16"};


        final String[] TPcodTipoActividad = {"TMOD0001","TMOD0002","TMOD0003","TMOD0004"};
        final String[] TPcodModalidad = {"MOD00001","MOD00002","MOD00003","MOD00004"};
        final String[] TPnombTipo = {"Creacion_Modelo_ER","Creacion_Manual","Diseno_de_Interfaz","Entrevista"};
        final double[] TPcostoxHora = {2.00,1.00,0.50,2.00};
        final String[] McodModalidad = {"MOD00001","MOD00002","MOD00003","MOD00004"};
        final String[] MnombModalidad= {"Diseño_Sistema","Documentacion","Programacion","Determinacion_requerimiento"};



        final String[] VEcodencarg = {"OO12035","OF12044","GG11098","CC12021"};
        final String[] VEnombre = {"Carlos","Pedro","Sara","Gabriela"};
        final String[] VEapellido = {"Orantes","Ortiz","Gonzales","Coto"};
        final String[] VEsexo = {"M","M","F","F"};
        final String[] VEcorreo = {"Carlos@gmail.com","Pedro@gmail.com","Sara@gmail.com","Gabriela@gmail.com"};

        final String[] VTcodtutor = {"LL11035","SC11044","RD11098"};
        final String[] VTcodespecial= {"UIG90","UIG90","PKL95"};
        final String[] VTnombre = {"Saul","Juan","Rosa"};
        final String[] VTapellido = {"Andradez","Coto","Barrera"};
        final String[] VTsexo = {"M","M","F"};
        final String[] VTcargo = {"Jefa","Tester","Secretaria"};


        final String[] VAcarnet = {"OO12035", "EE11002", "GG11098", "CC12021"};
        final String[] VAnombre = {"Carlos", "Pedro", "Sara", "Gabriela"};
        final String[] VAapellido = {"Orantes", "Ortiz", "Gonzales", "Coto"};
        final String[] carrera={"Ingenieria Electica","Ingenieria Civil","Arquitectura","Ingenieria Quimica"};
        final String[] VAsexo = {"M", "M", "F", "F"};
        final int matGanadas[]={28,35,40,20};
        final String[] telefono1={"7879000","79894524","78790412","78963212"};
        final String[] telefono2={" ","79885515"," ","78963213"};
        final String[] correo1={"eee@hotmail.es","aaa@gmail.com","asfe@gmail.com","dddfa@gmail.com"};
        final String[] correo2={" ","effg@gmail.com"," "," "};
        final String[] direccion={"Jayaque","Tepecoyo","Sacacoyo","Talnique"};

        final String[] idactividad={"00000001","00000002","00000003","00000004"};
        final String[] idTipoActividad={"TMOD0001","TMOD0001","TMOD0001","TMOD0001"};
        final String[] actividad={"Programar","Programar2","Programar3","Programar4"};
        final String[] fecha={"22/05/2015","22/05/2015","22/05/2015","22/05/2015"};
        final int[] numHoras={100,150,200,400};
        final String[] observacion={"En proceso","En proceso","En proceso","En proceso"};


        abrir();

        db.execSQL("DELETE FROM tipo_proyecto");
        db.execSQL("DELETE FROM entidad");
        db.execSQL("DELETE FROM especialidad");

        db.execSQL("DELETE FROM modalidad");
        db.execSQL("DELETE FROM tipoactividad");
        db.execSQL("DELETE FROM tutor");
        db.execSQL("DELETE FROM encargs");
        db.execSQL("DELETE FROM alumnoproyecto");
        db.execSQL("DELETE FROM alumno");
        db.execSQL("DELETE FROM actividad");
        db.execSQL("DELETE FROM proyecto");


        TipoProyecto tipoProyecto = new TipoProyecto();
        for(int i=0;i<2;i++){
            tipoProyecto.setCodigoTipoProyecto(VTPcodigotipoproyecto[i]);
            tipoProyecto.setTipoProyecto(VTPtipoproyecto[i]);
            insertar(tipoProyecto);

        }

        Entidad entidad = new Entidad();
        for(int i=0;i<4;i++){
            entidad.setCodigo_org(VAcodigo_org[i]);
            entidad.setNombre_organizacion(VAnom_org[i]);
            entidad.setRubro(VArubro[i]);
            entidad.setTelefono(VAtelefono[i]);
            entidad.setDireccion(VAdireccion[i]);
            insertar(entidad);
        }
        Especialidad especialidad = new Especialidad();
        for(int i=0;i<4;i++){
            especialidad.setCodigo_esp(VMcodigo_esp[i]);
            especialidad.setNombre_esp(VMnombre_esp[i]);
            especialidad.setCantidad_estudiantes(VMcantidad_estudiantes[i]);
            insertar(especialidad);
        }

        Modalidad mod = new Modalidad();
        for(int i=0;i<4;i++){
            mod.setCodmodalidad(McodModalidad[i]);
            mod.setNombmodalidad(MnombModalidad[i]);
            insertar(mod);
        }


        TipoActividad tipo = new TipoActividad();
        for(int i=0;i<4;i++){
            tipo.setCodtipoactividad(TPcodTipoActividad[i]);
            tipo.setCodmodalidad(TPcodModalidad[i]);
            tipo.setNomtipo(TPnombTipo[i]);
            tipo.setCostoxhora((float) TPcostoxHora[i]);
            insertar(tipo);
        }






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

        Proyecto proyecto = new Proyecto();
        for(int i=0;i<3;i++) {
            proyecto.setCodigoProyecto(VPcodigoproyecto[i]);
            proyecto.setCodigoEncargado(VPcodigoencargado[i]);
            proyecto.setCodigoEntidad(VPcodigoentidad[i]);
            proyecto.setCodigoTipoProyecto(VPcodigotipoproyecto[i]);
            proyecto.setCodigoTutor(VPcodigotutor[i]);
            proyecto.setNombreProyecto(VPnombreproyecto[i]);
            proyecto.setCantidadAlumnos(Integer.parseInt(VPcantidadalumnos[i]));
            insertar(proyecto);
        }

        Alumno alumno = new Alumno();
        for (int i = 0; i < 4; i++) {
            alumno.setCarnet(VAcarnet[i]);
            alumno.setNombre(VAnombre[i]);
            alumno.setApellido(VAapellido[i]);
            alumno.setSexo(VAsexo[i]);
            alumno.setMatganadas(matGanadas[i]);
            alumno.setCarrera(carrera[i]);
            alumno.setTelefono1(telefono1[i]);
            alumno.setTelefono2(telefono2[i]);
            alumno.setCorreo1(correo1[i]);
            alumno.setCorreo2(correo2[i]);
            alumno.setDireccion(direccion[i]);
            try {
                insertar(alumno);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Actividad act = new Actividad();
        for (int i = 0; i < 4; i++) {
            act.setCodTIpoActividad(idTipoActividad[i]);
            act.setIdactividad(idactividad[i]);
            act.setActividad(actividad[i]);
            act.setFecha(fecha[i]);
            act.setNumhoras(numHoras[i]);
            act.setComentario(observacion[i]);
            try {
                insertar(act);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        cerrar();
        return "Guardo Correctamente";
    }






}