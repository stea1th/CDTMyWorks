<%-- 
    Document   : datumzeit1
    Created on : 15.05.2018, 11:30:37
    Author     : vvlasov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% java.util.Date d = new java.util.Date(); %>
        <p>Heute ist der <%= d %>.</p>
    </body>
</html>
