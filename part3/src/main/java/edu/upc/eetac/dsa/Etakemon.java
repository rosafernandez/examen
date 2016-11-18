package edu.upc.eetac.dsa;



//creo la classe etakemon amb els seus atributs, el constructor i els getters i setters (code-> generate)
public class Etakemon extends DAO {

    public int tipus;
    public String nom, descripcio;

    public Etakemon(int tipus, String nom, String descripcio) {
        this.tipus = tipus;
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
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
}


