<%-- 
    Document   : datumzeit2
    Created on : 15.05.2018, 11:46:14
    Author     : vvlasov
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%! Date letztes; %>
        <% Date aktuell = new Date();%>
        <p>Heute ist der <%= aktuell %>.</br>
            Der letzte Aufruf erfolgte am <%= letztes %>.</p>
        <%-- Umsetzen von letztes auf den aktuellen Zeitwert --%>
        <% letztes = aktuell; %>
    </body>
</html>
