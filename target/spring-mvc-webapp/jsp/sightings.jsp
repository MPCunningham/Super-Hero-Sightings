<%-- 
    Document   : sightings
    Created on : Oct 27, 2018, 6:18:38 PM
    Author     : 4oaks
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sightings</title>
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
                        <a href="${pageContext.request.contextPath}/">Home</a>
                    </li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/sightings">Report/ View Sightings</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/supers">SuperHero/ SuperVillains</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/powers">Super Powers</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/organizations">Super Organizations</a>
                    </li>
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/locations">Sighting Locations</a>
                    </li>
                </ul>
            </div>
            <div class='row'>
                <div class='col-md-6'>
                    <h2 style="text-align:center;">All Sightings</h2>
                    <table id='sightingTable' class='table table-hover'>
                        <tr>
                            <th>Date</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="currentSighting" items="${sightingList}">
                            <tr>
                                <td>
                                    <a href="sightingDetails?sightingId=${currentSighting.id}">
                                        <c:out value="${currentSighting.date}"/>
                                    </a>
                                </td>
                                <td>
                                    <a href="displayEditSighting?sightingId=${currentSighting.id}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteSighting?sightingId=${currentSighting.id}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>    
                    </table>
                </div>
                <div class='col-md-6'>
                    <h2 style="text-align:center;">Add Sighting</h2>
                    <form class='form-horizontal' role='form' method='POST' action='createSighting'>
                        <div class='form-group'>
                            <label for='date' class='col-md-4 control-label'>Date:</label>
                            <div class='col-md-8'>
                                <input type='date' class='form-control' name='date' required/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="superId" class="col-md-4 control-label">Super:</label>
                            <div class="col-md-8">
                                <select id="superId" 
                                        name="superId" 
                                        class="form-control">
                                    <c:forEach items="${superList}" var="currentSuper">
                                        <option value="${currentSuper.id}">
                                            <c:out value="${currentSuper.name}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="locationId" class="col-md-4 control-label">Location:</label>
                            <div class="col-md-8">
                                <select id="locationId" 
                                        name="locationId" 
                                        class="form-control">
                                    <c:forEach items="${locationList}" var="currentLocation">
                                        <option value="${currentLocation.id}">
                                            <c:out value="${currentLocation.name}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class='form-group'>
                            <div class='col-md-offset-4 col-md-8'>
                                <input type='submit' class='btn btn-default' value='Create Sighting'/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>     
        </div>    
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
