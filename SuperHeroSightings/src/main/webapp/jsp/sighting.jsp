<%-- 
    Document   : sighting
    Created on : Jan 9, 2018, 6:49:58 AM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sighting</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <div class="container">
            <h1>Sightings</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySightingPage">Sightings</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHeroPage">Heroes</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationPage">Organizations</a></li>
                </ul>    
            </div>

            <div class="col-md-8">
                <h2>Sightings</h2>
                <table id="SightingTable" class="table table-hover">
                    <thead>
                        <tr>
                            <th>Sighting Date</th>
                            <th>Location</th>
                            <th>Heroes</th>
                            <th>Edit</th>
                            <th>Delete</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="currentSighting" items="${sightingList}">
                            <tr>
                                <td><c:out value="${currentSighting.dateSighted}"/></td>
                                <td>${currentSighting.sightingLocation.locationName}</td>
                                <td><c:forEach var="heros" items="${currentSighting.herosSighted}">${heros.name}</c:forEach></td>
                                <td><a href="displaySightingEdit?sightingId=${currentSighting.sightingId}">Edit</a></td>
                                <td><a href="deleteSighting?sightingId=${currentSighting.sightingId}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>                    
            </div> 

            <div class="col-md-4">
                <h2>Add a New Sighting </h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createSighting">
                    <div class="form-group">
                        <label for="add-sighting-date" class="col-md-4 control-label">Sighting Date:</label>
                        <div class="col-md-8">
                            <input type="date" class="form-control" name="sightingDate" placeholder="Sighting Date"/>     <!--used date, may need local date-->
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="location" class="col-md-4 control-label">Location:</label>
                        <div class="col-md-8">
                            <select class="form-control" name="location" placeholder="Location" required>
                                <c:forEach var="location" items="${locationList}">
                                    <option value="${location.locationId}">${location.locationName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="hero" class="col-md-4 control-label">Heros:</label>
                        <div class="col-md-8">
                            <select multiple class="form-control" name="hero" placeholder="Hero" required>
                                <c:forEach var="hero" items="${heroList}">
                                    <option value="${hero.heroId}">${hero.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Sighting"/>
                        </div>
                    </div>
                </form>

            </div>
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
