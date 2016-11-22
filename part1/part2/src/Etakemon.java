
/**
 * Created by rosa on 18/11/2016.
 */
public class Etakemon {

    private String nom;
    private String descripcio;
    private String tipus;


    public Etakemon(String nom, String descripcio, String tipus) {
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

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
}


