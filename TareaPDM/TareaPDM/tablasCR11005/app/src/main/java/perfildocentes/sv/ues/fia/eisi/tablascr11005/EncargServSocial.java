package perfildocentes.sv.ues.fia.eisi.tablascr11005;

/**
 * Created by william on 20/05/2015.
 */
public class EncargServSocial {
    private String codEncargSS;
    private String nombre;
    private String apellido;
    private String sexo;
    private String correo;

    public EncargServSocial(){
    }

    public EncargServSocial(String nombre, String apellido, String sexo, String correo){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setSexo(sexo);
        this.setCorreo(correo);
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodEncargSS() {
        return codEncargSS;
    }

    public void setCodEncargSS(String codEncargSS) {
        this.codEncargSS = codEncargSS;
    }
}