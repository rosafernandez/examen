import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rosa on 22/11/2016.
 */
@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class loginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Manager.getInstance().addUser("rosa",1,"copito");
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
        System.out.print(usuario);
        System.out.print(pass);
            User user = Manager.getInstance().selectUser(usuario);
            if(user!= null) {
                if(user.getPassword().equals(pass)){
                    request.getRequestDispatcher("/etakemon.jsp").forward(request,response);
                }
            }
        /*float operando1 = Float.parseFloat(request.getParameter("operando1"));
        float operando2 = Float.parseFloat(request.getParameter("operando2"));
        String operacion = request.getParameter("operacion");
        double sol = 0;

        if ("SUMA".equals(operacion)) {
            sol = operando1 + operando2;
        }
        if ("RESTA".equals(operacion)) {
            sol = operando1 - operando2;
        }
        if ("MULTIPLICACION".equals(operacion)) {
            sol = operando1 * operando2;
        }
        if ("DIVISION".equals(operacion)) {
            sol = operando1 / operando2;
        }
        request.setAttribute("RESULT", sol);
        request.getRequestDispatcher("/CalculatorResultV1.jsp").forward(request, response);*/
    }
}


