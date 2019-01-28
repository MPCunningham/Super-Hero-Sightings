<%-- 
    Document   : sightingDetails
    Created on : Oct 30, 2018, 4:16:20 PM
    Author     : 4oaks
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sighting Details</title>
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
                    <p>
                        Date: <c:out value="${sighting.date}"/> 
                    </p>
                    <p>
                        Super: <c:out value="${superPerson.name}"/>                                    
                    </p>
                    <p>
                        Location: <c:out value="${location.name}"/>                                   
                    </p>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
