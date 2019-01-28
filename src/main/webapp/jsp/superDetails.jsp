<%-- 
    Document   : superDetails
    Created on : Oct 30, 2018, 4:17:16 PM
    Author     : 4oaks
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Super Details</title>
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
                        <a href="${pageContext.request.contextPath}/supers">Back To Supers</a>
                    </li>
                </ul>
            </div>
                    <p>
                        Name: <c:out value="${superPerson.name}"/> 
                    </p>
                    <p>
                        Description: <c:out value="${superPerson.description}"/> 
                    </p>
                    <p>
                        Organizations: <c:forEach items="${organizationList}" var="currentOrganization">
                                    <c:out value="${currentOrganization.name}"/>
                                </c:forEach>    
                    </p>
                    <p>
                        Powers: <c:forEach items="${powerList}" var="currentPower">
                                    <c:out value="${currentPower.name}"/>
                                </c:forEach>    
                    </p>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
    </body>
</html>
