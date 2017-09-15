package Servlets;

import Exception.ProfessorInvalidoException;
import Exception.TamanhoInvalidoArrayException;
import Universidade.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Gonçalves
 */
public class CriaProfessorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        int siape = Integer.parseInt(request.getParameter("siape"));
        String formacao = request.getParameter("formacao");
        String cpf = request.getParameter("cpf");
        char sexo = request.getParameter("sexo").charAt(0);
        String proximaPagina = "";
        try {
            Professor p = new Professor(formacao, siape, nome, cpf, sexo);
            proximaPagina = "PaginaProfessor";
        } catch (TamanhoInvalidoArrayException ex) {
            proximaPagina = "TamanhoInvalido";
        } catch (ProfessorInvalidoException ex) {
            proximaPagina = "ProfessorInvalido";
        }finally{
            request.getRequestDispatcher(proximaPagina+".jsp").forward(request, response);
        }
    }
}
