package edu.upc.eetac.dsa;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rosa on 18/11/2016.
 */

public class User {
    final static Logger logger = Logger.getLogger (User.class);
    private String name;
    private String password;
    private int id;
    private List<Etakemon> lEtakemons;

    public User(String name, int id, String password) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.lEtakemons = new ArrayList<Etakemon>();
    }

    public static Logger getLogger() {
        return logger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Etakemon> getlEtakemons() {
        return lEtakemons;
    }

    public void setlEtakemons(List<Etakemon> lEtakemons) {
        this.lEtakemons = lEtakemons;
    }

    public void addlEtakemons(Etakemon e) {
        this.lEtakemons.add(e);
    }
}
