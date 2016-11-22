
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String[] args)
    {

        //User user = new User("rosa",1,"copito");
        Manager.getInstance().addUser("rosa",1,"copito");
        User user = Manager.getInstance().selectUser("rosa2");

        /*
        GameManager manager = new Manager();

        manager.addUser("rosa",1);
        manager.addUser("marina",2);

        manager.addEtakemon("pikaxu", "fort", 1);
        manager.addEtakemon("rakitxu", "debil", 3);



        List<User> lUser3 = manager.userByName();
        for (int i = 0; i<lUser3.size();i++){ //Imprimir los usuarios
            System.out.println(lUser3.get(i).getName());
        }
        */
    }
}
