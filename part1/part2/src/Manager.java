
import java.util.*;
import org.apache.log4j.Logger;

/**
 * Created by rosa on 18/11/2016.
 */
public class Manager implements GameManager{


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
    }

    //consultar info de l'user passat pel name
    public User selectUser(String name){
        User usuari= lUsers.get(name);
        if(usuari==null){
            return null;
        } else {
            return lUsers.get(name);
        }
    };

    //modifico els camps password i lEtakemons de un usuari passat pel name
    public void updateUser(String name, String password, List<Etakemon> lEtakemons){
        User updateUser = lUsers.get(name);
        if(updateUser==null){
        } else {
            updateUser.setPassword(password);
            updateUser.setlEtakemons(lEtakemons);
            lUsers.put(name, updateUser);
        }
    };

    //torna la llista de etakemons ordenats per ordre d'inserció d'un usuari passat pel name
    public List<Etakemon> selectEtakemons(String name){
        User selectedUser = lUsers.get(name);
        return selectedUser.getlEtakemons();
    };

    //afegeix un etakemon a la llista de etakemons d'un usuari
    public void addEtakemon(Etakemon pokemon, String name){
        User updateUser = lUsers.get(name);
        updateUser.addlEtakemons(pokemon);
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
        return ltemp;
    };
}