package pdm.fia.ues.sv.serviciosocial;

/**
 * Created by Agustin on 5/24/2015.
 */

public class Actividad {

    private String codTIpoActividad;
    private String idactividad;
    private String actividad;


    private String fecha;
    private int numhoras;
    private String comentario;
    public Actividad() {
    }

    public Actividad(String codTIpoActividad, String idactividad, String actividad, String fecha, int numhoras, String comentario) {
        this.codTIpoActividad = codTIpoActividad;
        this.idactividad = idactividad;
        this.actividad = actividad;
        this.fecha = fecha;
        this.numhoras = numhoras;
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodTIpoActividad() {
        return codTIpoActividad;
    }

    public void setCodTIpoActividad(String codTIpoActividad) {
        this.codTIpoActividad = codTIpoActividad;
    }

    public String getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(String idactividad) {
        this.idactividad = idactividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public int getNumhoras() {
        return numhoras;
    }

    public void setNumhoras(int numhoras) {
        this.numhoras = numhoras;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
