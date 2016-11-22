
import com.sun.deploy.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rosa on 22/11/2016.
 */
@WebServlet(name = "etakemonServlet", urlPatterns = "/etakemon")
public class etakemonServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario= request.getParameter("usuario");
        String nom = request.getParameter("nom");
        String descripcio = request.getParameter("descripcio");
        String tipus = request.getParameter("tipus");

        Etakemon etak = new Etakemon(nom, descripcio, tipus);
        Manager.getInstance().addEtakemon(etak, usuario);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getQueryString();
        User u = Manager.getInstance().selectUser(usuario);
        if(u.getlEtakemons() == null){
            response.getWriter().write("sense etakemons");
        } else {
            String etakemons = "";
            for(int i = 0; i<u.getlEtakemons().size(); i++){
                etakemons += u.getlEtakemons().get(i).getNom() + "," + u.getlEtakemons().get(i).getDescripcio() + "," + u.getlEtakemons().get(i).getTipus() + ":";
            }
            response.getWriter().write(etakemons);

        }
    }
}


