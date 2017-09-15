<%-- 
    Document   : PaginaProfessor
    Created on : 13/09/2017, 11:31:35
    Author     : Gabriel Gonçalves
--%>

<%@page import="FalsaDao.ProfessorDAO"%>
<%@page import="Universidade.Turma"%>
<%@page import="Universidade.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página do Professor</title>
    </head>
    <body>
        <a href="index.html">Voltar para a página inicial</a>
        <%
            ProfessorDAO banco = new ProfessorDAO();
            if(banco.qntElementos() > 0){
                Professor professor = banco.consulta(0);
                out.print("Professor "+professor+" criado");
            }
            else{
                out.print("Algo deu errado :-(");
            }%>
    </body>
</html>
