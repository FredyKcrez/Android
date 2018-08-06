package perfildocentes.sv.ues.fia.eisi.tablascr11005;

/**
 * Created by william on 20/05/2015.
 */
public class Tutor {
    private String codTutor;
    private String codEspecial;
    private String nombre;
    private String apellido;
    private String cargo;
    private String sexo;

    public Tutor(){
    }

    public Tutor(String nombre, String codEspecial, String apellido, String sexo, String cargo){
        this.setNombre(nombre);
        this.setApellido(sexo);
        this.setSexo(sexo);
        this.setCargo(cargo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String telefono) {
        this.cargo = telefono;
    }

    public String getCodTutor() {
        return codTutor;
    }

    public void setCodTutor(String codTutor) {
        this.codTutor = codTutor;
    }

    public String getCodEspecial() {
        return codEspecial;
    }

    public void setCodEspecial(String codEspecial) {
        this.codEspecial = codEspecial;
    }
}