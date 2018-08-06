package pdm.fia.ues.sv.serviciosocial;

/**
 * Created by Agustin on 5/23/2015.
 */

public class Tutor {
    private String codtutor;
    private String codespecial;
    private String nombre;
    private String apellido;
    private String sexo;
    private String cargo;

    public Tutor(){
    }
    public Tutor(String codtutor,String codespecial,String nombre,String apellido,String sexo,String cargo){
        this.setCodtutor(codtutor);
        this.setCodespecial(codespecial);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setSexo(sexo);
        this.setCargo(cargo);
    }

    public String getCodtutor() {
        return codtutor;
    }
    public void setCodtutor(String codtutor) {
        this.codtutor = codtutor;
    }
    public String getCodespecial() {
        return codespecial;
    }
    public void setCodespecial(String codespecial) {
        this.codespecial = codespecial;
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
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
