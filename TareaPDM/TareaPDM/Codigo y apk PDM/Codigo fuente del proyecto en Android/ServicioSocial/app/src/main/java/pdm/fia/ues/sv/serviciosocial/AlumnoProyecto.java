package pdm.fia.ues.sv.serviciosocial;

import android.app.Activity;

/**
 * Created by Walter on 20/05/2015.
 */
public class AlumnoProyecto {
    private String carnet;
    private String codigoProyecto;
    private String idactividad;
    public AlumnoProyecto(){

    }
    public AlumnoProyecto(String carnet, String codigoProyecto, String idactividad) {
        this.carnet = carnet;
        this.codigoProyecto = codigoProyecto;
        this.idactividad = idactividad;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }


    public String getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(String idactividad) {
        this.idactividad = idactividad;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }
}

