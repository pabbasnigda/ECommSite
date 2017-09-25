<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Commerce Mobile Portal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<style>
p
{
	background-color: powderblue;
}
</style>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fuild">
    	<div class="navbar-header">
    	<a class="navbar-brand" href="#">HOME</a>
  		
  <ul class="nav navbar-nav">
  <li class="active"><a href="#">MOBILES</a></li>
  </ul></div>
  <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li class="active"><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
  </ul>
  </div>
</nav>
<div class="container"></div>
<div class="jumbotron">
<h3>NIIT ECOMMERCE MOBILE PORTAL</h3>
<h5>Welcome to the home of all things of NIIT store</h5>
</div>
<p>Currently we have some list of items shown below</p>

<div class="container">
<table class="table table-bordered">
<thead>
	<tr>
		<th>MOBILE NAMES</th>
		<th>PRICE</th>
	</tr>
</thead>
<tbody>
	<tr>
		<td><font color="blue">IPhone 6s</font></td>
		<td>34000</td>
	</tr>
	<tr>
		<td><font color="blue">Blackberry</font></td>
		<td>12000</td>
	</tr>
	<tr>
		<td><font color="blue">Samsung</font></td>
		<td>11000</td>
	</tr>
	<tr>
		<td><font color="blue">vivo</font></td>
		<td>24879</td>
	</tr>
</tbody>
</table>
</div>
<footer>
	Thanks!!Visit Again &copy;NIIT E-commerce Web Project 2017
</footer>
</body>
</html>