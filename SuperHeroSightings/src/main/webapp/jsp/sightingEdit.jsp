<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Sightings</title>
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
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySightingPage">Sighting</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHeroPage">Hero</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationPage">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationPage">Organization</a></li>
                </ul>    
            </div>

            <div class="col-md-6">
                <h2>Edit Sighting</h2>
                <form action="${pageContext.request.contextPath}/updateSighting" method="post">
                    <div class="form-group">
                        <label for="sightingDate">Date Sighted:</label>
                        <input type="date" class="form-control" name="sightingDate" value="${sighting.dateSighted}"/> 
                    </div>
                    <div class="form-group">
                        <label for="location">Location:</label>
                        <select class="form-control" name="location">
                            <c:forEach var="location" items="${locations}">
                                <c:choose>
                                    <c:when test="${location.locationId == sighting.sightingLocation.locationId}">
                                        <option value="${location.locationId}" selected>${sighting.sightingLocation.locationName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${location.locationId}">${location.locationName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="hero">Heros:</label>
                        <select multiple class="form-control" name="hero">
                            <c:forEach var="hero" items="${sighting.herosSighted}">
                                <option value="${hero.heroId}">${hero.name}</option>
                            </c:forEach>
                        </select>
                    </div>


                    <input name="sightingId" type="hidden" value="${sighting.sightingId}"/>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>






        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
