<%-- 
    Document   : editSighting
    Created on : Oct 30, 2018, 4:16:59 PM
    Author     : 4oaks
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Sighting</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div id="header" style="text-align:center;">
                <h1>Super Hero Sightings</h1>
                <hr />
            </div>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/sightings">Back To Sightings</a>
                    </li>
                </ul>
            </div>
            <sf:form class="form-horizontal" role="form" modelAttribute="sighting" action="editSighting" method="POST">
                <sf:input type="hidden" id="id" path="id"/>
                <div class="form-group">
                    <label for="date" class="col-md-1 control">Date:</label>
                    <div class="col-md-8">
                        <sf:input type="date" class="form-control" id="date" path="date"/>
                        <sf:errors path="date" cssClass="error"></sf:errors>    
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="superId" class="col-md-1 control">Super:</label>
                        <div class="col-md-8">
                            <sf:select id="superId" 
                                   path="superId" 
                                   class="form-control">
                                <c:forEach items="${superList}" var="currentSuper">
                                    <option value="${currentSuper.id}">
                                        <c:out value="${currentSuper.name}"/>
                                    </option>
                                </c:forEach>
                            </sf:select>        
                        </div> 
                    </div>  
                <div class="form-group">
                    <label for="locationId" class="col-md-1 control">Location:</label>
                    <div class="col-md-8">
                        <sf:select id="locationId" 
                                   path="locationId" 
                                   class="form-control">
                            <c:forEach items="${locationList}" var="currentLocation">
                                <option value="${currentLocation.id}">
                                    <c:out value="${currentLocation.name}"/>
                                </option>
                            </c:forEach>
                        </sf:select>        
                    </div> 
                </div>        
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Sighting"/>
                    </div>
                </div>    
            </sf:form>        
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
    </body>
</html>
