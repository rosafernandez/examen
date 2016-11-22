package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    final static Logger logger = Logger.getLogger(Manager.class);

    public static void main(String[] args)
    {

        //User user = new User("rosa",1,"copito");
        Manager.getInstance().addUser("rosa",1,"copito");
        User user = Manager.getInstance().selectUser("rosa2");
        if(user!= null)
            logger.info("nom: " + user.getName() +
                ", password: " + user.getPassword() +
                ", id: " + user.getId() + ", etakemons: " +
                user.getlEtakemons());

    }
}
