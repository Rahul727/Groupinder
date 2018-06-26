<!-- 
 * @authors Rahul Chhapgar
 * Team 7 
 * Copyright 2017, all right reserved.
 * Date written: 07/06/2017.
 * Last modified: 06/07/2017.
 * Groupinder Web-application.
 * References:
 	1. http://getbootstrap.com/
 	2. https://www.w3schools.com/
 	3. https://v4-alpha.getbootstrap.com/components/navbar/
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE meta PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/nav.css" />
	<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
	<script type="text/javascript" src="bootstap/js/bootstrap.min.js"> </script>
		
	<style>
		/* Full-width input fields */
		input[type=text], input[type=password] {
		    width: 50%;
		    padding: 12px 20px;
		    margin: 8px 0;
		    display: inline-block;
		    border: 1px solid #ccc;
		    box-sizing: border-box;
		}
		
		/* Set a style for all buttons */
		button {
		    background-color: #4CAF50;
		    color: white;
		    padding: 14px 20px;
		    margin: 8px 0;
		    border: none;
		    cursor: pointer;
		    width: 100%;
		}
		
		button:hover {
		    opacity: 0.8;
		}
		
		/* Extra styles for the cancel button */
		.cancelbtn {
		    width: 50%;
		    padding: 10px 18px;
		    background-color: #f44336;
		}
		
		.container {
		    padding: 16px;
		}
		
		span.psw {
		    float: right;
		    padding-top: 16px;
		}
		
		/* The Modal (background) */
		.modal {
		    display: none; /* Hidden by default */
		    position: fixed; /* Stay in place */
		    z-index: 1; /* Sit on top */
		    left: 0;
		    top: 0;
		    width: 100%; /* Full width */
		    height: 100%; /* Full height */
		    overflow: auto; /* Enable scroll if needed */
		    background-color: rgb(0,0,0); /* Fallback color */
		    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
		    padding-top: 60px;
		}
		
		/* Modal Content/Box */
		.modal-content {
		    background-color: #fefefe;
		    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
		    border: 1px solid #888;
		    width: 80%; /* Could be more or less, depending on screen size */
		}
		
		/* The Close Button (x) */
		.close {
		    position: absolute;
		    right: 25px;
		    top: 0;
		    color: #000;
		    font-size: 35px;
		    font-weight: bold;
		}
		
		.close:hover,
		.close:focus {
		    color: red;
		    cursor: pointer;
		}
		
		/* Add Zoom Animation */
		.animate {
		    -webkit-animation: animatezoom 0.6s;
		    animation: animatezoom 0.6s
		}
		
		@-webkit-keyframes animatezoom {
		    from {-webkit-transform: scale(0)} 
		    to {-webkit-transform: scale(1)}
		}
		    
		@keyframes animatezoom {
		    from {transform: scale(0)} 
		    to {transform: scale(1)}
		}
		
		/* Change styles for span and cancel button on extra small screens */
		@media screen and (max-width: 300px) {
		    span.psw {
		       display: block;
		       float: none;
		    }
		    .cancelbtn {
		       width: 50%;
		    }
		}
	</style>
	
</head>

<!-- *****************************************************  HEADER  *************************************************  -->

<body class="body-color">


<!-- *****************************************************  BODY  *************************************************  -->

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto; margin-top:10%; margin-left:13%; ">New Note </button>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="#">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
     <!--  <img src="img_avatar2.png" alt="Avatar" class="avatar">  -->
    </div>

    <div class="container">
     <!--  <label><b>Username</b></label>  -->
      <input type="text" placeholder="123" name="uname" required>

      <!-- <label><b>Password</b></label>  -->
      <input type="password" placeholder="456" name="psw" required>
        
      <button type="submit" style="width:50%; ">Note it.</button>
    
       <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
    </div>
	
<!--   <div class="container" style="background-color:#f1f1f1">
      
    </div>
-->
  </form>
</div>

	<script>
		// Get the modal
		var modal = document.getElementById('id01');
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
	</script>

<!-- *****************************************************  FOOTER  **********************************************  -->
 
<div class="navbar navbar-toggleable-md bg-info navbar-fixed-bottom">

</div>

</body>
</html>