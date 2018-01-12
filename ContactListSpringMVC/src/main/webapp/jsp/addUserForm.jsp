<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crypto Currency</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <style>
            footer {
                opacity: 0.5;
                font-size: 11px;
                vertical-align: bottom;
                margin-top: 25px;
                margin-bottom: 35px;
            }
            </style>
    </head>
    <body>
        <div class="container"> 
            <h1 style = "text-align:center">Crypto Talk</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" 
                        class="active">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/displayPosts">
                            Posts
                        </a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath} /">
                            News & More Info
                        </a>
                    </li>
                    <li role="presentation" class="pull-right">
                        <a href="${pageContext.request.contextPath}/login">
                            Log-In
                        </a>
                    </li>
                </ul>    
            </div>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <p>Hello : ${pageContext.request.userPrincipal.name}
                    | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
                </p>
            </c:if>
            <h1>Add User Form</h1>
            <form method="POST" action="addUser">
                Username: <input type="text" 
                                 name="username"/><br/>
                Password: <input type="password" 
                                 name="password"/><br/>
                Admin User? <input type="checkbox" 
name="isAdmin" value="yes"/> <br/>
                <input type="submit" value="Add User"/><br/>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
    <footer style="text-align:center">
        This blog is meant for updates, news, and discussion about all things cryptocurrency.  Invest at your own risk.
    </footer>
</html>