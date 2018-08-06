package pdm.fia.ues.sv.serviciosocial;

/**
 * Created by Agustin on 5/23/2015.
 */
public class TipoActividad {
    private String codtipoactividad;
    private String codmodalidad;
    private Float costoxhora;
    private String nomtipo;

    public TipoActividad() {
    }

    public TipoActividad(String codtipoactividad, String codmodalidad, Float costoxhora, String nomtipo) {
        this.codtipoactividad = codtipoactividad;
        this.codmodalidad = codmodalidad;
        this.costoxhora = costoxhora;
        this.nomtipo = nomtipo;
    }

    public String getCodtipoactividad() {
        return codtipoactividad;
    }

    public void setCodtipoactividad(String codtipoactividad) {
        this.codtipoactividad = codtipoactividad;
    }

    public String getCodmodalidad() {
        return codmodalidad;
    }

    public void setCodmodalidad(String codmodalidad) {
        this.codmodalidad = codmodalidad;
    }

    public Float getCostoxhora() {
        return costoxhora;
    }

    public void setCostoxhora(Float costoxhora) {
        this.costoxhora = costoxhora;
    }

    public String getNomtipo() {
        return nomtipo;
    }

    public void setNomtipo(String nomtipo) {
        this.nomtipo = nomtipo;
    }
}