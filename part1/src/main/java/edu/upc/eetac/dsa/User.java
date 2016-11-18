package edu.upc.eetac.dsa;
import java.util.List;

/**
 * Created by rosa on 18/11/2016.
 */

public class User {
    final static Logger logger = Logger.getLogger (User.class);

        private String name;
        private int id;
        private List<Etakemon> lEtakemons;

    public User(String name, int id, List<Etakemon> lEtakemons) {
        this.name = name;
        this.id = id;
        this.lEtakemons = lEtakemons;
    }

    public String getName() {
        return name;
    }

}
