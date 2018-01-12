<%-- 
    Document   : organization
    Created on : Jan 9, 2018, 6:47:50 AM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organization</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <div class="container">
            <h1>Organization</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingPage">Sightings</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayHeroPage">Heroes</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationPage">Locations</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayOrganizationPage">Organizations</a></li>
                </ul>    
            </div>
                <div class="row">
    <!-- 
        Add a col to hold the summary table - have it take up half the row 
    -->
    <div class="col-md-8">
        <h2>Organizations</h2>
        <table id="contactTable" class="table table-hover">
            <tr>
                <th>Organization Name</th>
                <th>Address</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>Description</th>
            </tr>
            <c:forEach var="currentOrganization" items="${organizationList}">
                <tr>
                    <td><c:out value="${currentOrganization.organizationName}"/></td>
                    <td><c:out value="${currentOrganization.address}"/></td>
                    <td><c:out value="${currentOrganization.state}"/></td>
                    <td><c:out value="${currentOrganization.zipCode}"/></td>
                    <td><c:out value="${currentOrganization.description}"/></td>
                    <td><a href="displayOrganizationEdit?organizationId=${currentOrganization.organizationId}">Edit</a></td>
                    <td><a href="deleteOrganization?organizationId=${currentOrganization.organizationId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>                    
      </div>   
    
    
      <div class="col-md-4">
        <h2>Add New Organization</h2>
        <form class="form-horizontal" 
              role="form" method="POST" 
              action="createOrganization">
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
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Create Organization"/>
                </div>
            </div>
        </form>

    </div> <!-- End col div -->
    
    
    
   </div>  
 </div>
                            
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
