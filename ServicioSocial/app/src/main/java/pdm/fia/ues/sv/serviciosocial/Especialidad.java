package pdm.fia.ues.sv.serviciosocial;

/**
 * Created by Agustin on 5/22/2015.
 */
public class Especialidad {
    private String codigo_esp;
    private String nombre_esp;
    private String cantidad_estudiantes;

    public Especialidad(){
    }

    public Especialidad(String codigo_esp, String nombre_esp, String cantidad_estudiantes) {
        this.codigo_esp = codigo_esp;
        this.nombre_esp = nombre_esp;
        this.cantidad_estudiantes = cantidad_estudiantes;
    }


    public String getCodigo_esp() {

        return codigo_esp;
    }

    public void setCodigo_esp(String codigo_esp) {

        this.codigo_esp = codigo_esp;
    }

    public String getNombre_esp() {

        return nombre_esp;
    }

    public void setNombre_esp(String nombre_esp) {

        this.nombre_esp = nombre_esp;
    }

    public String getCantidad_estudiantes() {

        return cantidad_estudiantes;
    }

    public void setCantidad_estudiantes(String cantidad_estudiantes) {
        this.cantidad_estudiantes = cantidad_estudiantes;
    }
}
