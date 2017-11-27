<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1 class="text-center" style="margin-top: 30px">Vending Machine Of Doom!!!</h1>
            <hr/>
            <div id="junkFoodColumn" class="col-md-9">
                <c:forEach var="junkFood" items="${junkFood}">
                    <div class="col-md-4">
                        <div class="panel panel-default">
                            <a style="text-decoration:none" href="${pageContext.request.contextPath}/makeSelection/${junkFood.id}">
                                <div class="panel-body">
                                    <p class="text-left">${junkFood.id}</p>
                                    <p class="text-center">${junkFood.name}</p>
                                    <p class="text-center">${junkFood.price}</p>
                                    <br>
                                    <p class="text-center">Quantity Left: ${junkFood.quantity}</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="col-md-3">
                <div class="row">
                    <h3 class="text-center">Total $ In</h3>
                    <form>
                        <div class="form-group">
                            <input class="form-control" id="wallet" type="text" value="${wallet}" disabled>
                        </div>
                    </form>
                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/addMoney/dollar" class="btn btn-default">Add Dollar</a>
                        <a href="${pageContext.request.contextPath}/addMoney/quarter" class="btn btn-default">Add Quarter</a>
                    </div>
                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/addMoney/dime" class="btn btn-default">Add Dime</a>
                        <a href="${pageContext.request.contextPath}/addMoney/nickel" class="btn btn-default">Add Nickel</a>
                    </div>
                    <hr>
                </div>
                <div class="row">
                    <h3 class="text-center">Output Msg</h3>
                    <form>
                        <div class="form-group">
                            <input value="${message}" class="form-control" disabled></input>
                        </div>
                        <div class="form-group">
                            <h3 style="display:inline">Item: </h3>
                            <input id="itemNumber" class="form-control" type="text" value="<c:if test="${selection != 0}">${selection}</c:if>" style="width:75%;display:inline" disabled>
                            </div>
                        </form>
                        <a href="makePurchase" class="btn btn-default btn-block">Make Purchase</a>
                        <hr>
                    </div>
                    <div class="row" style="margin-bottom: 30px">
                        <h3 class="text-center">Change</h3>
                        <form>
                            <div class="form-group">
                                <textarea id="currentChangeMsg" style="text-align:left" class="form-control" row="2" disabled><c:if test="${currentChange != null}">Quarters ${currentChange.quarters} Dimes ${currentChange.dimes} Nickels ${currentChange.nickels} Pennies ${currentChange.pennies}
                                </c:if></textarea>
                        </div>
                    </form>
                    <a class="btn btn-default btn-block" href="returnChange">Return Change</a>

                </div>
            </div>
        </div>
        
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

