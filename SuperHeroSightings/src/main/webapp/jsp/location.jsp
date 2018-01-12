<%-- 
    Document   : location
    Created on : Jan 9, 2018, 6:47:05 AM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Location</title>
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingPage">Sightings</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHeroPage">Heroes</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayLocationPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationPage">Organizations</a></li>
                </ul>    
            </div>
            <div class="col-md-8">
                <h2>Locations</h2>
                <table id="LocationTable" class="table table-hover">
                    <tr>
                        <th>Location Name</th>
                        <th>Address</th>
                        <th>State</th>
                        <th>Zip Code</th>
                        <th>Description</th>
                        <th>Latitude</th>
                        <th>Longitude</th>
                    </tr>
                    <c:forEach var="currentLocation" items="${locationList}">
                        <tr>
                            <td><c:out value="${currentLocation.locationName}"/></td>
                            <td><c:out value="${currentLocation.address}"/></td>
                            <td><c:out value="${currentLocation.state}"/></td>
                            <td><c:out value="${currentLocation.zipCode}"/></td>
                            <td><c:out value="${currentLocation.locationDescription}"/></td>
                            <td><c:out value="${currentLocation.latitude}"/></td>
                            <td><c:out value="${currentLocation.longitude}"/></td>
                            <td><a href="displayLocationEdit?locationId=${currentLocation.locationId}">Edit</a></td>
                            <td><a href="deleteLocation?locationId=${currentLocation.locationId}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>                    
            </div>   


            <div class="col-md-4">
                <h2>Add New Location</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="createLocation">
                    <div class="form-group">
                        <label for="add-name" class="col-md-4 control-label">Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="name" placeholder="Name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-address" class="col-md-4 control-label">Address:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="address" placeholder="Address"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add-state" class="col-md-4 control-label">State:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="state" placeholder="State"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="add-zip-code" class="col-md-4 control-label">Zip Code:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="zipCode" placeholder="Zip Code"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="add-description" class="col-md-4 control-label">Description:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="description" placeholder="Description"/>
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="add-latitude" class="col-md-4 control-label">Latitude:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="latitude" placeholder="Latitude"/>
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="add-longitude" class="col-md-4 control-label">Longitude:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="longitude" placeholder="Longitude"/>
                        </div>

                    </div>




                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Create Location"/>
                        </div>
                    </div>
                </form>


            </div>
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
