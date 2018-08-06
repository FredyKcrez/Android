package pdm.fia.ues.sv.serviciosocial;

/**
 * Created by Agustin on 5/22/2015.
 */
public class TipoProyecto {

    private String codigoTipoProyecto;
    private String tipoProyecto;

    public TipoProyecto(String codigoTipoProyecto,String tipoProyecto) {

        this.codigoTipoProyecto=codigoTipoProyecto;
        this.tipoProyecto=tipoProyecto;
    }

    public TipoProyecto() {

    }

    public String getCodigoTipoProyecto() {
        return codigoTipoProyecto;
    }
    public void setCodigoTipoProyecto(String codigoTipoProyecto) {
        this.codigoTipoProyecto =codigoTipoProyecto;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }
    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto =tipoProyecto;
    }

    public String toString(){
        return codigoTipoProyecto;
    }

}
