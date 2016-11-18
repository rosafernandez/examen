package edu.upc.eetac.dsa;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        GameManager manager = new Manager();

        manager.addUser("rosa",1);
        manager.addUser("marina",2);

        manager.addEtakemon("pikaxu", "fort", 1);
        manager.addEtakemon("rakitxu", "debil", 3);


     /*
        List<User> lUser3 = manager.userByName();
        for (int i = 0; i<lUser3.size();i++){ //Imprimir los usuarios
            System.out.println(lUser3.get(i).getName());
        }
        */
    }
}
