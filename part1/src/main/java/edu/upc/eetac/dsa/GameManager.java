package edu.upc.eetac.dsa;

import java.util.List;

/**
 * Created by rosa on 18/11/2016.
 */
public interface GameManager {

    List<User> userByName();
    void addUser(String name,int id);
    void updateUsers();
    List<Etakemon>();
    void addEtakemon(String nom,String descripcio,int tipus);

}
