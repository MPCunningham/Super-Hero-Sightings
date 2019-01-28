<%-- 
    Document   : locations
    Created on : Oct 27, 2018, 6:19:20 PM
    Author     : 4oaks
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Locations</title>
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
                    <li role="presentation">
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
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/locations">Sighting Locations</a>
                    </li>
                </ul>
            </div>
            <div class='row'>
                <div class='col-md-6'>
                    <h2 style="text-align:center;">All Locations</h2>
                    <table id='locationTable' class='table table-hover'>
                        <tr>
                            <th>Name</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="currentLocation" items="${locationList}">
                            <tr>
                                <td>
                                    <a href="locationDetails?locationId=${currentLocation.id}">
                                    <c:out value="${currentLocation.name}"/>
                                    </a>
                                </td>
                                <td>
                                    <a href="displayEditLocation?locationId=${currentLocation.id}">
                                    Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteLocation?locationId=${currentLocation.id}">
                                    Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>    
                    </table>
                </div>
                <div class='col-md-6'>
                    <h2 style="text-align:center;">Add Location</h2>
                    <form class='form-horizontal' role='form' method='POST' action='createLocation'>
                        <div class='form-group'>
                            <label for='name' class='col-md-4 control-label'>Name:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='name' Placeholder='Name' value="${name}" required/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <label for='description' class='col-md-4 control-label'>Description:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='description' Placeholder='Description' value="${description}"/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <label for='address' class='col-md-4 control-label'>Address:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='address' Placeholder='Address' value="${address}"/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <label for='latitude' class='col-md-4 control-label'>Latitude:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='latitude' Placeholder='Latitude' value="${latitude}"/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <label for='longitude' class='col-md-4 control-label'>Longitude:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='longitude' Placeholder='Longitude' value="${longitude}"/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <div class='col-md-offset-4 col-md-8'>
                                <input type='submit' class='btn btn-default' value='Create Location'/>
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
