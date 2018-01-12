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
            <h1>Heroes!!!</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingPage">Sightings</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayHeroPage">Heroes</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationPage">Organizations</a></li>
                </ul>    
            </div>
            <div class="col-md-8">
                <h2>Recorded Heroes</h2>
                <table id="HeroTable" class="table table-hover">
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Super Power</th>
                        <th>Organization</th>
                    </tr>
                    <c:forEach var="currentHero" items="${heroList}">
                        <tr>
                            <td><c:out value="${currentHero.name}"/></td>
                            <td><c:out value="${currentHero.description}"/></td>
                            <td><c:out value="${currentHero.superPower}"/></td>
                            <td><c:forEach var="orgs" items="${currentHero.organizations}">${orgs.organizationName}</c:forEach></td>
                            <td><a href="displayHeroEdit?heroId=${currentHero.heroId}">Edit</a></td>    
                            <td><a href="deleteHero?heroId=${currentHero.heroId}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>                    
            </div>
            <div class="col-md-4">
                <h2>Add a New Hero </h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createHero">
                    <div class="form-group">
                        <label for="add-name" class="col-md-4 control-label">Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="name" placeholder="Name"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="add-description" class="col-md-4 control-label">Description:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="description" placeholder="Description"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-superpower" class="col-md-4 control-label">Super Power:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="superpower" placeholder="Superpower"/>
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="organization" class="col-md-4 control-label">Organization:</label>
                        <div class="col-md-8">

                            <select multiple class="form-control" name="organization" placeholder="Organization" required>
                                <c:forEach var="organization" items="${organizationList}">
                                    <option value="${organization.organizationId}">${organization.organizationName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Hero"/>
                        </div>
                    </div>
                </form>

            </div>
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
