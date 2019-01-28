<%-- 
    Document   : home
    Created on : Oct 27, 2018, 6:18:23 PM
    Author     : 4oaks
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
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
                    <li role="presentation" class="active">
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
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/locations">Sighting Locations</a>
                    </li>
                </ul>
            </div>
            <div id="main">
                <div id='content'>
                    <p>
                        With the rising popularity of superhero movies, there has been a heightened awareness of superheroes in our midst.<br />
                        The frequency of superhero (and supervillain) sightings is increasing at an alarming rate.<br />
                        The Hero Education and Relationship Organization (HERO) has made it it's mission to bring to the attention of the public these special individuals.<br />
                        Follow the links above to report your own superhero (and supervillain) encounters and to view the information we currently have of these unusually gifted beings.   
                    </p>
                </div>
        </div>    
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
