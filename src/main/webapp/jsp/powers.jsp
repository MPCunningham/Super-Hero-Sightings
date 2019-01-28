<%-- 
    Document   : powers
    Created on : Oct 27, 2018, 6:19:11 PM
    Author     : 4oaks
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Powers</title>
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
                    <li role="presentation" class="active">
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
                    <h2 style="text-align:center;">All Powers</h2>
                    <table id='powerTable' class='table table-hover'>
                        <tr>
                            <th>Name</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="currentPower" items="${powerList}">
                            <tr>
                                <td>
                                    <a href="powerDetails?powerId=${currentPower.id}">
                                        <c:out value="${currentPower.name}"/>
                                    </a>
                                </td>
                                <td>
                                    <a href="displayEditPower?powerId=${currentPower.id}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deletePower?powerId=${currentPower.id}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>    
                    </table>
                </div>
                <div class='col-md-6'>
                    <h2 style="text-align:center;">Add Power</h2>
                    <form class='form-horizontal' role='form' method='POST' action='createPower'>
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
                            <label for="superIdList" class="col-md-4 control-label">Supers:</label>
                            <div class="col-md-8">
                                <select id="superIdList" 
                                        name="superIdList" 
                                        multiple="multiple" 
                                        class="form-control">
                                    <c:forEach items="${superList}" var="currentSuper">
                                        <option value="${currentSuper.id}">
                                            <c:out value="${currentSuper.name}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class='form-group'>
                            <div class='col-md-offset-4 col-md-8'>
                                <input type='submit' class='btn btn-default' value='Create Power'/>
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
