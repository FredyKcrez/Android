package com.fredykcrez.p2cr11005plus;

/**
 * Created by Fredy Kcrez on 6/7/2015.
 */
public class PartidosClausura {
	private String numFecha;
 	private String codEquipo;
 	private int golesAFavor;
 	private int golesEnContra;
 	private String rival;

    public PartidosClausura() {
    }

 	//Constructor para todos los campos de la BD (todos son obligatorios)
 	public PartidosClausura(String numFecha, String codEquipo, int golesAFavor, int golesEnContra, String rival) {
 		this.setNumFecha(numFecha);
		this.setCodEquipo(codEquipo);
		this.setGolesAFavor(golesAFavor);
		this.setGolesEnContra(golesEnContra);
		this.setRival(rival);
 	}

    public String getNumFecha() {
        return numFecha;
    }

    public void setNumFecha(String numFecha) {
        this.numFecha = numFecha;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public String getRival() {
        return rival;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }
}
