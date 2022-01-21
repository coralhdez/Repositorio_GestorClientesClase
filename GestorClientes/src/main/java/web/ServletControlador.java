
package web;

import datos.ClientesDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //1. OBTENEMOS EL LISTADO DE LOS CLIENTES
        List<Cliente> clientes = new ClientesDaoJDBC().listar();
        
        System.out.println("clientes: " + clientes);
        
        //2.COMPARTIMOS EL LISTADO DE CLIENTES EN ALCANCE DE REQUEST
        request.setAttribute("clientes", clientes);
        
        //3.REDIRECCIONAMOS EL FLUJO A UNA NUEVA PÁGINA
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
        
    }
    
    
    
}
