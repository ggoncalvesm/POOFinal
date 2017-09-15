<%-- 
    Document   : HorariosTurma.jsp
    Created on : 15/09/2017, 09:51:54
    Author     : Gabriel Gonçalves
--%>

<%@page import="FalsaDao.TurmaDAO"%>
<%@page import="Externo.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Horários da turma</title>
    </head>
    <body>
        <table>
            <%Grade tabela = new TurmaDAO().consulta(0).getHorario().;%>
        <tr>
            <%
                
            %>
        </tr>    
        </table>
    </body>
</html>
