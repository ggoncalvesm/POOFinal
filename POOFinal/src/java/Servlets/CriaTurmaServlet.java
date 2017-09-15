/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Exception.TamanhoInvalidoArrayException;
import Exception.TurmaInvalidaException;
import FalsaDao.ProfessorDAO;
import Universidade.Professor;
import Universidade.Turma;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel Gonçalves
 */
public class CriaTurmaServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        int id = Integer.parseInt(request.getParameter("id"));
        Professor professor = new ProfessorDAO().consulta(request.getParameter("professor"));
        int limiteAlunos = Integer.parseInt(request.getParameter("limiteAlunos"));
        int aulasSemanais = Integer.parseInt(request.getParameter("aulasSemanais"));
        String proximaPagina = "";
        try {
            Turma t = new Turma(nome, id, professor, limiteAlunos, aulasSemanais);
            proximaPagina = "PaginaTurma";
        } catch (TamanhoInvalidoArrayException ex) {
            proximaPagina = "TamanhoInvalido";
        } catch (TurmaInvalidaException ex) {
            proximaPagina = "TurmaInvalida";
        }finally{
            request.getRequestDispatcher(proximaPagina+".jsp").forward(request, response);
        }
    }
}