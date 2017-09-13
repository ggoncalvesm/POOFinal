<%-- 
    Document   : PaginaProfessor
    Created on : 13/09/2017, 11:31:35
    Author     : Gabriel Gonçalves
--%>

<%@page import="Universidade.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página do Professor</title>
    </head>
    <body>
        <%
            if(Professor.professores.size() > 0){
                %>
                <h1>Deu certo</h1>
            <%}else{%>
                <h1>Algo deu errado :-( </h1>
            <%}
        %>
    </body>
</html>
