<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hero</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <div class="container">
            <h1>Edit Heros</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingPage">Sighting</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayHeroPage">Hero</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationPage">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationPage">Organization</a></li>
                </ul>    
            </div>

            <div class="col-md-6">
                <h2>Edit a Hero </h2>
                <form action="${pageContext.request.contextPath}/updateHero" method="post">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input name="name" type="text" class="form-control" value="${hero.name}"/>
                    </div>
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <input type="text" class="form-control" name="description" value="${hero.description}"/>
                    </div>
                    <div class="form-group">
                        <label for="superPower">Super Power:</label>
                        <input type="text" class="form-control" name="superPower" value="${hero.superPower}"/>
                    </div>
                    <div class="form-group">
                        <label for="organization">Organization:</label>
                        <select multiple class="form-control" name="organization">
                            <c:forEach var="organization" items="${hero.organizations}">
                                <option value="${organization.organizationId}">${organization.organizationName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input name="heroId" type="hidden" value="${hero.heroId}"/>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
