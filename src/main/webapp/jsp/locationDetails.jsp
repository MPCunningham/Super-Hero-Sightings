<%-- 
    Document   : locationDetails
    Created on : Oct 29, 2018, 3:27:08 PM
    Author     : 4oaks
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Location Details</title>
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
                        <a href="${pageContext.request.contextPath}/locations">Back To Locations</a>
                    </li>
                </ul>
            </div>
                    <p>
                        Name: <c:out value="${location.name}"/> 
                    </p>
                    <p>
                        Description: <c:out value="${location.description}"/> 
                    </p>
                    <p>
                        Address: <c:out value="${location.address}"/> 
                    </p>
                    <p>
                        Latitude: <c:out value="${location.latitude}"/> 
                    </p>
                    <p>
                        Longitude: <c:out value="${location.longitude}"/> 
                    </p>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>            
    </body>
</html>
