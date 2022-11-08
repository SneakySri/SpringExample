<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<title>orders</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body bgcolor=rgba( 71, 147, 227, 1)>
<nav class="navbar navbar-inverse" style="padding-top: 5px;font-size: 16px;">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="">Amazon</a>
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="/main/index">Home</a></li>
            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
            <li><a href="/main/cart"><span class="glyphicon glyphicon-log-in"></span>Cart</a></li>
            <li><a href="/main/order"><span class="glyphicon glyphicon-log-in"></span>My Order</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
          </ul>
        </div>
      </nav>
      
      <center>
<h1>${msg}</h1>
</center>
</body>
</html>