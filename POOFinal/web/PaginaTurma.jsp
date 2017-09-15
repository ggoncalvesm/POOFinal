<%-- 
    Document   : PaginaTurma
    Created on : 15/09/2017, 09:27:41
    Author     : Gabriel Gonçalves
--%>

<%@page import="Universidade.Turma"%>
<%@page import="FalsaDao.TurmaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página da Turma</title>
    </head>
    <body>
        <a href="index.html">Voltar para a página inicial</a> <a href = "HorariosTurma.jsp">Visualizar alocação de horários</a>
        <%
            TurmaDAO banco = new TurmaDAO();
            if(banco.qntElementos() > 0){
                Turma turma = banco.consulta(0);
                turma.alocaHorario();
                out.println("Turma "+turma+" criada");
            }
            else{
                out.println("Algo deu errado :-(");
            }%>
    </body>
</html>
