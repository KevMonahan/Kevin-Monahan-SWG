<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Super Hero Sightings!!</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingPage">Sightings</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHeroPage">Heroes</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationPage">Organizations</a></li> 
                </ul>    
            </div>
            <div class="jumbotron">
                <h2>Spotted yourself a superhuman eh? Report it here! Our Goal Is To Keep Track Of All Sightings!</h2>
                <p>
                    What are we looking for? Super Heroes and Super Villains alike!
                    If you spot someone that's got some special powers, create a sighting using our webpage!
                    Report to us the Superhumans name and description, the location you spotted them, and any organizations they belong to.
                    We encourage you to speak up, don't keep your best friend's abilities hidden and share them with the world using our easy app!
                </p>
            </div>
                <h2>Last 10 Sightings</h2>
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                                <th>Sighting Date</th>
                                <th>Sighting Location</th>
                                <th>Heroes Sighted</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="sighting" items="${sightings}">
                                <tr>
                                    <td>${sighting.date}</td>
                                    <td>${sighting.hero.heroName}</td>
                                    <td>${sighting.location.locationName}</td>
                                    <td>${sighting.location.city}</td>
                                    <td>${sighting.location.state}</td>
                                    <td>${sighting.location.zipcode}</td>
                                    <td>${sighting.location.latitude}</td>
                                    <td>${sighting.location.longitude}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

