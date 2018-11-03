/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Usuario;
import DAO.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LucasMello
 */
@WebServlet(name = "PortalServlet", urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String x = (String)session.getAttribute("nome");
            if(x == null) {
                RequestDispatcher rd = request.getRequestDispatcher("erroServlet");
                String msg = "Nao esta logado";
                request.setAttribute("page", "index.html");
                request.setAttribute("msg", msg);
                rd.forward(request, response);
            }
            UsuarioDao dao = new UsuarioDao();
            List<Usuario> usuarios = new ArrayList<Usuario>();
            usuarios = dao.carregarUsuarios();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PortalServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"CadasatrarUsuarioServlet\" method=\"POST\"> \n" +
"            Nome: <input type=\"text\" name=\"nome\" value=\"\"/><br/>\n" +
"            Login: <input type=\"text\" name=\"login\" value=\"\"/><br/>\n" +
"            Senha: <input type=\"text\" name=\"senha\" value=\"\"/><br/>\n" +
"            <input type=\"submit\" value=\"Salvar\"/>   \n" +
"        </form>");
            out.println("<table>");
            out.println("<tr>");
                        out.println("<td>"+"Id"+"</td>");
                        out.println("<td>"+"Nome"+"</td>");
                        out.println("<td>"+"Login"+"</td>");
                        out.println("<td>"+"Senha"+"</td>");
                        out.println("</tr>");
            for(Usuario p : usuarios) {
                        out.println("<tr>");
                        out.println("<td>"+p.getId()+"</td>");
                        out.println("<td style='color: green;'>"+p.getNome()+"</td>");
                        out.println("<td>"+p.getLogin()+"</td>");
                        out.println("<td>"+p.getSenha()+"</td>");
                        out.println("</tr>");
                }
            out.println("</table>");
            out.println("<br/>");
            out.println("<p><a href=LogoutServlet>logout</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
