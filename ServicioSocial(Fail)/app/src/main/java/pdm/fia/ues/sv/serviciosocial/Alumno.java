package pdm.fia.ues.sv.serviciosocial;

/**
 * Created by Agustin on 5/24/2015.
 */

public class Alumno {
    private String carnet;
    private String nombre;
    private String apellido;
    private String sexo;
    private int matganadas;
    private String carrera;
    private String correo1;
    private String correo2;
    private String telefono1;
    private String telefono2;
    private String direccion;
    public Alumno(){
    }
    public Alumno(String carnet, String nombre, String apellido, String sexo,int matganadas,String carrera,String correo1,
                  String correo2,String telefono1,String telefono2,String direccion) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.matganadas=matganadas;
        this.carrera=carrera;
        this.correo1=correo1;
        this.correo2=correo2;
        this.telefono1=telefono1;
        this.telefono2=telefono2;
        this.direccion=direccion;
    }
    public String getCarnet() {
        return carnet;
    }
    public void setCarnet(String carnet) {
        this.carnet = carnet;
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
    public int getMatganadas() {
        return matganadas;
    }
    public void setMatganadas(int matganadas) {
        this.matganadas = matganadas;
    }
    public String getCarrera(){
        return carrera;
    }
    public void setCarrera(String carrera){
        this.carrera=carrera;
    }
    public String getTelefono1(){
        return telefono1;
    }
    public void setTelefono1(String telefono1){
        this.telefono1=telefono1;
    }
    public String getTelefono2(){
        return telefono2;
    }
    public void setTelefono2(String telefono2){
        this.telefono2=telefono2;
    }
    public String getCorreo1(){
        return correo1;
    }
    public void setCorreo1(String correo1){
        this.correo1=correo1;
    }
    public String getCorreo2(){
        return correo2;
    }
    public void setCorreo2(String correo2){
        this.correo2=correo2;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

}

