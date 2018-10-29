<%-- 
    Document   : index
    Created on : 08/10/2018, 22:09:42
    Author     : LucasMello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="POST"> 
            Login: <input type="text" name="login" value=""/><br/>
            Senha: <input type="text" name="senha" value=""/><br/>
            <input type="submit" value="Logar"/>   
        </form>  
    </body>
</html>
