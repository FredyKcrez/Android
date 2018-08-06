package com.fredykcrez.p2cr11005plus;

/**
 * Created by Fredy Kcrez on 6/7/2015.
 */

public class Equipo {
	private String codEquipo;
 	private String nomEquipo;
 	private int ganados;
 	private int perdidos;
 	private int empatados;

    public Equipo() {
    }

 	//Constructor para todos los campos de la BD
 	public Equipo(String codEquipo, String nomEquipo, int ganados, int perdidos, int empatados) {
 		this.setCodEquipo(codEquipo);
		this.setNomEquipo(nomEquipo);
		this.setGanados(ganados);
		this.setPerdidos(perdidos);
		this.setEmpatados(empatados);
 	}

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    public int getEmpatados() {
        return empatados;
    }

    public void setEmpatados(int empatados) {
        this.empatados = empatados;
    }
}