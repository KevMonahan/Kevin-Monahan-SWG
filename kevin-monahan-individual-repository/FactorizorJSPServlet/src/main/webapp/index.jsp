<%-- 
    Document   : index
    Created on : Nov 14, 2017, 3:22:29 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizor</title>
    </head>
    <body>
        <h1>Factorizor</h1>
        <p>
            Please enter the number that you want to factor:
        </p>
        <p>
        <form method="POST" action="FactorizorServlet">
            <input type="text" name="numberToFactor">
            <input type="submit" value="Find Factors!!!">
        </form>
        </p>
    </body>
</html>
