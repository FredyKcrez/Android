package com.example.fredykcrez.basededatoscr11005;

/**
 * Created by Fredy Kcrez on 19/05/2015.
 */
public class Materia {
    private String codmateria;
    private String nommateria;
    private String unidadesval;

    public Materia(){
    }

    public Materia(String codmateria, String nommateria, String unidadesval){
        this.setCodmateria(codmateria);
        this.setNommateria(nommateria);
        this.setUnidadesval(unidadesval);
    }

    public String getCodmateria() {
        return codmateria;
    }

    public void setCodmateria(String codmateria) {
        this.codmateria = codmateria;
    }

    public String getNommateria() {
        return nommateria;
    }

    public void setNommateria(String nommateria) {
        this.nommateria = nommateria;
    }

    public String getUnidadesval() {
        return unidadesval;
    }

    public void setUnidadesval(String unidadesval) {
        this.unidadesval = unidadesval;
    }
}
