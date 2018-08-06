package pdm.fia.ues.sv.serviciosocial;

/**
 * Created by Agustin on 5/22/2015.
 */

public class Entidad {
    private String nombre_organizacion;
    private String codigo_org;
    private String rubro;
    private String direccion;
    private String telefono;

    public Entidad(){
    }

    public Entidad(String nombre_organizacion, String codigo_org, String rubro, String direccion, String telefono) {
        this.nombre_organizacion = nombre_organizacion;
        this.codigo_org = codigo_org;
        this.rubro = rubro;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre_organizacion() {
        return nombre_organizacion;
    }

    public void setNombre_organizacion(String nombre_organizacion) {
        this.nombre_organizacion = nombre_organizacion;
    }

    public String getCodigo_org() {
        return codigo_org;
    }

    public void setCodigo_org(String codigo_org) {
        this.codigo_org = codigo_org;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
