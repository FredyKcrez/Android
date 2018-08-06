package pdm.fia.ues.sv.serviciosocial;

/**
 * Created by Agustin on 5/23/2015.
 */
public class Modalidad {
    private String codmodalidad;
    private String nombmodalidad;

    public Modalidad() {
    }

    public Modalidad(String codmodalidad, String nombmodalidad) {
        this.codmodalidad = codmodalidad;
        this.nombmodalidad = nombmodalidad;
    }

    public String getCodmodalidad() {
        return codmodalidad;
    }

    public void setCodmodalidad(String codmodalidad) {
        this.codmodalidad = codmodalidad;
    }

    public String getNombmodalidad() {
        return nombmodalidad;
    }

    public void setNombmodalidad(String nombmodalidad) {
        this.nombmodalidad = nombmodalidad;
    }
}
