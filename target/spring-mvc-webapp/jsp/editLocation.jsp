<%-- 
    Document   : editLocation
    Created on : Oct 29, 2018, 9:01:42 PM
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
        <title>Edit Location</title>
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
                        <sf:form class="form-horizontal" role="form" modelAttribute="location" action="editLocation" method="POST">
                            <sf:input type="hidden" id="id" path="id"/>
                            <div class="form-group">
                                <label for="name" class="col-md-1 control">Name:</label>
                                <div class="col-md-8">
                                    <sf:input type="text" class="form-control" id="name" path="name" placeholder="Name"/>
                                    <sf:errors path="name" cssClass="error"></sf:errors>    
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="description" class="col-md-1 control">Description:</label>
                                <div class="col-md-8">
                                    <sf:input type="text" class="form-control" id="description" path="description" placeholder="Description"/>
                                    <sf:errors path="description" cssClass="error"></sf:errors>    
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="address" class="col-md-1 control">Address:</label>
                                <div class="col-md-8">
                                    <sf:input type="text" class="form-control" id="address" path="address" placeholder="Address"/>
                                    <sf:errors path="address" cssClass="error"></sf:errors>    
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="latitude" class="col-md-1 control">Latitude:</label>
                                <div class="col-md-8">
                                    <sf:input type="text" class="form-control" id="latitude" path="latitude" placeholder="Latitude"/>
                                    <sf:errors path="latitude" cssClass="error"></sf:errors>    
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="longitude" class="col-md-1 control">Longitude:</label>
                                <div class="col-md-8">
                                    <sf:input type="text" class="form-control" id="longitude" path="longitude" placeholder="Longitude"/>
                                    <sf:errors path="longitude" cssClass="error"></sf:errors>    
                                </div>
                            </div>
                                <div>
                                    <div class="col-md-offset-4 col-md-8">
                                        <input type="submit" class="btn btn-default" value="Update Location"/>
                                    </div>
                                </div>    
                        </sf:form>        
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>            
    </body>
</html>
