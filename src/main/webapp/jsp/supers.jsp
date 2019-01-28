<%-- 
    Document   : supers
    Created on : Oct 27, 2018, 6:18:57 PM
    Author     : 4oaks
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SuperHero/ SuperVillain</title>
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
                    <li role="presentation" class="active">
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
                    <h2 style="text-align:center;">All Supers</h2>
                    <table id='superTable' class='table table-hover'>
                        <tr>
                            <th>Name</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="currentSuper" items="${superList}">
                            <tr>
                                <td>
                                    <a href="superDetails?superId=${currentSuper.id}">
                                        <c:out value="${currentSuper.name}"/>
                                    </a>
                                </td>
                                <td>
                                    <a href="displayEditSuper?superId=${currentSuper.id}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteSuper?superId=${currentSuper.id}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>    
                    </table>
                </div>
                <div class='col-md-6'>
                    <h2 style="text-align:center;">Add Super</h2>
                    <form class='form-horizontal' role='form' method='POST' action='createSuper'>
                        <div class='form-group'>
                            <label for='name' class='col-md-4 control-label'>Name:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='name' Placeholder='Name' required/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <label for='description' class='col-md-4 control-label'>Description:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='description' Placeholder='Description'/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="organizationIdList" class="col-md-4 control-label">Organizations:</label>
                            <div class="col-md-8">
                                <select multiple id="organizationIdList" 
                                        name="organizationIdList"  
                                        class="form-control">
                                    <c:forEach items="${organizationList}" var="currentOrganization">
                                        <option value="${currentOrganization.id}">
                                            <c:out value="${currentOrganization.name}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="powerIdList" class="col-md-4 control-label">Powers:</label>
                            <div class="col-md-8">
                                <select multiple id="powerIdList" 
                                        name="powerIdList" 
                                        class="form-control">
                                    <c:forEach items="${powerList}" var="currentPower">
                                        <option value="${currentPower.id}">
                                            <c:out value="${currentPower.name}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class='form-group'>
                            <div class='col-md-offset-4 col-md-8'>
                                <input type='submit' class='btn btn-default' value='Create Super'/>
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
