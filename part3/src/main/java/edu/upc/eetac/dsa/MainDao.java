package edu.upc.eetac.dsa;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;


public class MainDao
{
    public static void main( String[] args ) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        User user = new User(9,"lola");
        User user1 = new User(1,"aitor");
        User user2 = new User(2,"oriol");
        User user3 = new User(3,"copito");
        User user4 = new User(4,"rosa");
        User user5 = new User(6,"marina");
        User user6 = new User(10,"marini");

        //user4.insert();
        //user6.update(); //per actualitzar poses el user q vols modificar
        //user.select(2); //el select es fa pel (id) no pel numero de user
        //user.select2(3,"pikatxu","fort");

        System.out.println("\n**********************************************************");
        //List<User> l = DAO.getAllUsers(); //mostrar llista d tots els users


    }
}