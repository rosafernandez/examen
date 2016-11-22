package edu.upc.eetac.dsa;

/**
 * Created by rosa on 18/11/2016.
 */
public class Etakemon {

    private String nom;
    private String descripcio;
    private int tipus;


    public Etakemon(String nom, String descripcio, int tipus) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.tipus = tipus;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }
}


