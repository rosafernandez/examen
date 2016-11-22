package edu.upc.eetac.dsa;

import java.util.List;

/**
 * Created by rosa on 18/11/2016.
 */
public interface GameManager {
    //List<User> userByName();
    List<String> usersPorNombre(List<User> lUsers);
    void addUser(String name, int id, String password);
    void updateUser(String name, String password, List<Etakemon> lEtakemons);
    User selectUser(String name);
    List<Etakemon> selectEtakemons(String name);
    void addEtakemon(Etakemon pokemon, String name);
}
