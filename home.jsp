<!-- 
 * @authors Rahul Chhapgar, Darshan Patel
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 07/01/2017. (mm/dd/yyyy)
 * Last modified: 07/19/2017. (mm/dd/yyyy)
 * version 7
 * Groupinder Web-application.
 * References:
 	1. http://getbootstrap.com/
 	2. https://www.w3schools.com/
 	3. 
	4. 
 *
 *
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="com.bean.*"%>
<%@page import= "java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>Groupinder</title>
	
	<link rel="stylesheet" href="bootstrap/css/style.css">
	<link rel="stylesheet" href="bootstrap/css/style_try.css">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/groupinderUI.js"></script>
	<script type="text/javascript" src="bootstrap/js/register.js"></script>
</head>

<body>
		  <%User name = new User(); 
		  name=(User) session.getAttribute("currentUser");
		  String username = name.user_name;%>		

    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav metismenu" id="side-menu">
                    <li class="nav-header">                        
                        <div class="logo-element">G</div>
                    <li>
                        <a href="#"><i class="fa vcard-o"></i> 
						<span class="nav-label"> <strong class="font-bold">
						<%if(name == null)
							out.print("");
						else
		 					out.print("Welcome,  "+username);
		 				%>  </strong> 
						</span> <span class="caret"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="#">Profile</a></li>
                            <li><a href="#">Settings</a></li>                            
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-th-large"></i> 
						<span class="nav-label">Notes</span> <span class="caret"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="#">Create</a></li>
                            <li><a href="#">Manage</a></li>                            
                        </ul>
                    </li>
					<li>
                        <a href="#"><i class="fa fa-th-large"></i> 
						<span class="nav-label">Reminders</span> <span class="caret"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="#">Create</a></li>
                            <li><a href="#">Manage</a></li>                            
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-diamond"></i> <span class="nav-label">Calendar</span></a>
                    </li>                                    
                </ul>
            </div>
        </nav>
	</div>
    <div id="page-wrapper" class="background-G dashbard-1">
        <div class="row border-bottom">
			<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
					<form role="search" class="navbar-form-custom" action="#">
						<div class="form-group">
							<input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
						</div>
					</form>
				</div>
					<ul class="nav navbar-top-links navbar-right">
						<li>
							<span class="m-r-sm text-muted welcome-message">Welcome @ user.</span>					
							<a href="index.jsp"> <i class="fa fa-sign-out"></i> Log out </a>
						</li>                
					</ul>
			</nav>
        </div>        
<!-- edit 1 -->
<c:import url="/FetchNotesServlet" />
<table>
		<c:set var="count" value="1"/>
		<c:forEach items="${notes}" var="current_note">
			<c:if test="${count==4}">
		    <c:set var="count" value="1"/>
		    </c:if>
		    <c:if test="${count==1}">
		    <tr>
		    </c:if>
				<td>
				<div class = "note" id="column${count}" >
				<div class="noteTitle"> "${current_note.title}"</div>
				<div class="noteContent"> "${current_note.content}"</div>
				</div>			
				</td>
			<c:if test="${count==3}">
			    </tr>
			</c:if>
		<c:set var="count" value="${count+1}"/>

	    </c:forEach>
    </table>
<!-- end edit 1 -->
		<div class="footer">
			<div>
				<strong>Groupinder</strong>&copy; 2017
			</div>
		</div>           
    </div>
</body>
</html>