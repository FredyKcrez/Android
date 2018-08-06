package com.fredykcrez.p2cr11005plus;

/**
 * Created by Fredy Kcrez on 6/7/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDControl {
	private static final String[] camposEquipo = new String [] {"codEquipo","nomEquipo","ganados","perdidos","empatados"};
	private static final String[] camposPartidos = new String [] {"numFecha","codEquipo","golesAFavor","golesEnContra","rival"};

	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;

	public BDControl (Context ctx) {
 		this.context = ctx;
 		DBHelper = new DatabaseHelper(context);
 	}
 	
 	private static class DatabaseHelper extends SQLiteOpenHelper {
 		private static final String BASE_DATOS = "p2cr11005plus.s3db";
		private static final int VERSION = 1;
		public DatabaseHelper(Context context) {
		super(context, BASE_DATOS, null, VERSION);
 	}

 	    @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("CREATE TABLE equipo(codEquipo CHAR(3) NOT NULL, nomEquipo CHAR(30), ganados INTEGER, perdidos INTEGER, empatados INTEGER, CONSTRAINT pk_equipo PRIMARY KEY (codEquipo));");
                db.execSQL("CREATE TABLE partidosclausura2015(numFecha CHAR(2) NOT NULL, codEquipo CHAR(3) NOT NULL, golesAFavor INTEGER  NOT NULL, golesEnContra INTEGER  NOT NULL, rival CHAR(30) NOT NULL, CONSTRAINT pk_partidosclausura2015 PRIMARY KEY(numFecha));");
                db.execSQL("CREATE TRIGGER pk_partidosclausura2015 BEFORE INSERT ON partidosclausura2015 FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT codEquipo FROM equipo WHERE codEquipo = NEW.codEquipo) IS NULL) THEN RAISE(ABORT, 'No existe equipo') END; END;");
            } catch(SQLException e) {
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

    public String eliminar(Equipo equipo) {
        String regAfectados="filas afectadas= " ;
        int contador=0;
        if (verificarIntegridad(equipo, 3)) {
            contador += db.delete("partidosclausura2015", "codEquipo='" +equipo.getCodEquipo()+"'", null);
        }
        contador+=db.delete( "equipo" , "codEquipo='" +equipo.getCodEquipo()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    public String actualizar(PartidosClausura pc) {
        if(verificarIntegridad(pc, 1)){
            String[] id = {pc.getNumFecha()};
            ContentValues cv = new ContentValues();
            cv.put("codEquipo" , pc.getCodEquipo());
            cv.put("golesAFavor", pc.getGolesAFavor());
            cv.put("golesEnContra", pc.getGolesEnContra());
            cv.put("rival", pc.getRival());
            db.update( "partidosclausura2015", cv, "numFecha = ?", id);
            return "Registro Actualizado Correctamente";
        }else {
            return "Registro no Existe" ;
        }
    }

    public int consultarPC(String codEquipo) {
        String[] id = {codEquipo};
        Cursor cursor = db.rawQuery("SELECT codEquipo from equipo WHERE codEquipo=?", id);
        if(cursor.moveToFirst()){
            Cursor consulta= db.rawQuery("select count(numFecha) from partidosclausura2015 where rival='Metapan' and codEquipo=?",id);
            if(consulta.moveToFirst())
                return consulta.getInt(0);
            else

                return 0;
        }
        else{
            return 0;
        }
}

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion) {
            case 1:
            {
                //verificar que al modificar partidosClausura exista cdigo de equipo
                PartidosClausura pc = (PartidosClausura)dato;
                String[] ids = {pc.getCodEquipo()};
                abrir();
                Cursor c = db.query("partidosclausura2015", null, "codEquipo = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2: {
                //verificar que exista equipo
                Equipo eq= (Equipo)dato;
                String[] id = {eq.getCodEquipo()};
                abrir();
                Cursor c2 = db.query("equipo", null, "codEquipo = ?", id, null, null, null);
                if(c2.moveToFirst()){
                    //Se encontro Equipo
                    return true;
                }
                return false;
            }
            case 3:
            {
                Equipo eq2 = (Equipo)dato;
                Cursor c=db.query(true, "partidosclausura2015", new String[] {"codEquipo" }, "codEquipo='"+eq2.getCodEquipo()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            default:
                return false;
        }
    }

    public String llenarBDCarnet() {
        abrir();
        //limpiar la base
        db.execSQL("DELETE FROM equipo");
        db.execSQL("DELETE FROM partidosclausura2015");

        //llenar tabla equipo
        db.execSQL("INSERT INTO equipo VALUES('MET','Metapan','2','1','1')");
        db.execSQL("INSERT INTO equipo VALUES('FAS','Fas','3','1','0')");
        db.execSQL("INSERT INTO equipo VALUES('STL','Santa Tecla','3','0','1')");
        db.execSQL("INSERT INTO equipo VALUES('AGU','Aguila','2','0','2')");

        //llenar tabla partidos clausura 2015
        db.execSQL("INSERT INTO partidosclausura2015 VALUES('01','FAS','2','1','Aguila')");
        db.execSQL("INSERT INTO partidosclausura2015 VALUES('02','STL','3','1','Metapan')");
        db.execSQL("INSERT INTO partidosclausura2015 VALUES('03','AGU','1','2','Metapan')");
        db.execSQL("INSERT INTO partidosclausura2015 VALUES('04','STL','1','1','Fas')");

        cerrar();
        return "Guardo Correctamente";
    }
}