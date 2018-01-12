<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Edit Location</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
        <div class="container">
            <h1>Locations!</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingPage">Sighting</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHeroPage">Hero</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayLocationPage">Location</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationPage">Organization</a></li>
                </ul>    
            </div>

            <div class="col-md-6">
                <h2>Edit a Location</h2>
                <form action="${pageContext.request.contextPath}/updateLocation" method="post">
                    <div class="form-group">
                        <label for="name">Name:</label>                       
                        <input type="text" class="form-control" name="name" value="${location.locationName}"/>
                    </div>

                    <div class="form-group">
                        <label for="address" >Address:</label>
                        <input type="text" class="form-control" name="address" value="${location.address}"/>
                    </div>

                    <div class="form-group">
                        <label for="state">State:</label>
                        <input type="text" class="form-control" name="state" value="${location.state}"/>
                    </div>

                    <div class="form-group">
                        <label for="zipCode">Zip Code:</label>
                        <input type="text" class="form-control" name="zipCode" value="${location.zipCode}"/>
                    </div>
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <input type="text" class="form-control" name="description" value="${location.locationDescription}"/>
                    </div>

                    <div class="form-group">
                        <label for="latitude">Latitude:</label>
                        <input type="text" class="form-control" name="latitude" value="${location.latitude}"/>
                    </div>

                    <div class="form-group">
                        <label for="longitude">Longitude:</label>
                        <input type="text" class="form-control" name="longitude" value="${location.longitude}"/>
                    </div>
                    <input name="locationId" type="hidden" value="${location.locationId}"/>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>

    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>
