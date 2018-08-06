package pdm.fia.ues.sv.serviciosocial;

/**
 * Created by Agustin on 5/23/2015.
 */

public class EncargS {
    private String codencarg;
    private String nombre;
    private String apellido;
    private String sexo;
    private String correo;

    public EncargS(){
    }
    public EncargS(String codencarg,String nombre,String apellido,String sexo,String correo){
        this.codencarg=codencarg;
        this.nombre=nombre;
        this.apellido=apellido;
        this.sexo=sexo;
        this.correo=correo;
    }

    public String getCodencarg() {
        return codencarg;
    }
    public void setCodencarg(String codencarg) {
        this.codencarg = codencarg;
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
}
