package pdm.fia.ues.sv.serviciosocial;

public class Proyecto {

    private String codigoProyecto;
    private String codigoEncargado;
    private String codigoTipoProyecto;
    private String codigoEntidad;
    private String codigoTutor;
    private String nombreProyecto;
    private int cantidadAlumnos;

    public Proyecto(String codigoProyecto, String codigoEncargado, String codigoTipoProyecto, String codigoEntidad, String codigoTutor, String nombreProyecto,int cantidadAlumnos) {
        this.codigoProyecto = codigoProyecto;
        this.codigoEncargado=codigoEncargado;
        this.codigoTipoProyecto=codigoTipoProyecto;
        this.codigoEntidad=codigoEntidad;
        this.codigoTutor=codigoTutor;
        this.nombreProyecto=nombreProyecto;
        this.cantidadAlumnos=cantidadAlumnos;
    }

    public Proyecto() {

    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }
    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto =codigoProyecto;
    }
    public String getCodigoEncargado() {
        return codigoEncargado;
    }
    public void setCodigoEncargado(String codigoEncargado) {
        this.codigoEncargado =codigoEncargado;
    }

    public String getCodigoTipoProyecto() {
        return codigoTipoProyecto;
    }
    public void setCodigoTipoProyecto(String codigoTipoProyecto) {
        this.codigoTipoProyecto =codigoTipoProyecto;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }
    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad =codigoEntidad;
    }

    public String getCodigoTutor() {
        return codigoTutor;
    }
    public void setCodigoTutor(String codigoTutor) {
        this.codigoTutor =codigoTutor;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto =nombreProyecto;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }
    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos =cantidadAlumnos;
    }


}