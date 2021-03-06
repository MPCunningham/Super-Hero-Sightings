<%-- 
    Document   : organizationDetails
    Created on : Oct 30, 2018, 3:26:59 PM
    Author     : 4oaks
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organization Details</title>
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
                        <a href="${pageContext.request.contextPath}/organizations">Back To Organizations</a>
                    </li>
                </ul>
            </div>
                    <p>
                        Name: <c:out value="${organization.name}"/> 
                    </p>
                    <p>
                        Description: <c:out value="${organization.description}"/> 
                    </p>
                    <p>
                        Address: <c:out value="${organization.address}"/> 
                    </p>
                    <p>
                        Phone Number: <c:out value="${organization.phoneNumber}"/> 
                    </p>
                    <p>
                        Supers: <c:forEach items="${superList}" var="currentSuper">
                                    <c:out value="${currentSuper.name}"/>
                                </c:forEach>    
                    </p>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>    
    </body>
</html>
