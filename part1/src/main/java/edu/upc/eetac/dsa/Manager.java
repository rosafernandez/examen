package edu.upc.eetac.dsa;

import java.util.*;
import org.apache.log4j.Logger;

/**
 * Created by rosa on 18/11/2016.
 */
public class Manager implements GameManager{

    final static Logger logger = Logger.getLogger(Manager.class);

    //hashmap de user i llista de etakemons
    Map<String,User> lUsers;
    private List<Etakemon> etakemons = new ArrayList<Etakemon>();

    // Creo el Singleton pq nomes hi hagi una instancia d'aquesta classe
    private static Manager instance;

    private Manager(){
        lUsers= new HashMap<String, User>();
    }

    public static Manager getInstance(){
        if (instance == null) instance = new Manager();
        return instance;
    }

    //-------------------------------------
    //implemento les funcions

    //afegir user
    public void addUser(String name, int id, String password){
        User nouUser = new User(name, id, password);
        lUsers.put(name, nouUser);
        logger.info("Usuari " + name + " afegit");
    }

    //consultar info de l'user passat pel name
    public User selectUser(String name){
        User usuari= lUsers.get(name);
        if(usuari==null){
            logger.error("l'usuari no existeix");
            return null;
        } else {
            logger.info("L'usuari seleccionat es: " + usuari.getName());
            return lUsers.get(name);
        }
    };

    //modifico els camps password i lEtakemons de un usuari passat pel name
    public void updateUser(String name, String password, List<Etakemon> lEtakemons){
        User updateUser = lUsers.get(name);
        if(updateUser==null){
            logger.error ("L'usuari no existeix");
        } else {
            logger.info("Al usuari " + name + "se li modificarà el password" + updateUser.getPassword());
            updateUser.setPassword(password);
            updateUser.setlEtakemons(lEtakemons);
            logger.info("L'usuari " + updateUser.getName() + "ha estat modificat amb el password" + updateUser.getPassword());
            lUsers.put(name, updateUser);
        }
    };

    //torna la llista de etakemons ordenats per ordre d'inserció d'un usuari passat pel name
    public List<Etakemon> selectEtakemons(String name){
        User selectedUser = lUsers.get(name);
        logger.info("el llistat de etakemons es: "+selectedUser.getlEtakemons() );
        return selectedUser.getlEtakemons();
    };

    //afegeix un etakemon a la llista de etakemons d'un usuari
    public void addEtakemon(Etakemon pokemon, String name){
        User updateUser = lUsers.get(name);
        updateUser.addlEtakemons(pokemon);
        logger.info("Al usuari "+updateUser.getName()+ "se li ha afegit el etakemon " +pokemon.getNom());
        lUsers.put(name, updateUser);
    };

    //llistar els usuaris ordenats pel nom
    public List<String> usersPorNombre(List<User> lUsers){
        //creo la llista buida ltemp d strings
        List<String> ltemp= new ArrayList<String>();
        //llegeix un a un la llista de users
        for (Map.Entry<String,User> temp: this.lUsers.entrySet()){
            ltemp.add(temp.getKey());
        //un cop tenim la llista ja la podem ordenar
        }
        Collections.sort(ltemp);
        logger.info ("La llista d'usuaris orenada pels noms es: " +ltemp);
        return ltemp;
    };
}