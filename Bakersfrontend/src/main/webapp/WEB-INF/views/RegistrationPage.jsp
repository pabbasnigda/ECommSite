<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" href="resources/css/Pretty-Footer.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	  
</head>
<body>
<div class="bs-example">
    <nav id="myNavbar" class="navbar navbar-inverse" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">CHOCOHUB</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#">HOME</a></li>
                    <li><a href="#">PROFILE</a></li>
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle">MESSAGES<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="">Inbox</a></li>
                            <li><a href="#">Drafts</a></li>
                            <li><a href="#">Sent Items</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Trash</a></li>
                        </ul>
                    </li>
                </ul>
               
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
</div>
	
<c:url var="actionUrl" value="saveUser" />

<form:form  commandName="user" method="post" action="${actionUrl }" class="form-horizontal" >
	<h2 class="text-center"><font color="#006699">REGISTRATION</font></h2>

	<div class="form-group">
		<label for="First Name" class="col-xs-4 control-label">First Name</label>
		<div class="col-xs-4">
			<form:input name="id" path="firstName" placeholder="User First Name" class="form-control" />
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="First Name" class="col-xs-4 control-label">Last Name</label>
		<div class="col-xs-4">
			<form:input name="id" path="lastName" placeholder="User Last Name" class="form-control" />
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="Supplier Name" class="col-xs-4 control-label">Email</label>
		<div class="col-xs-4">
			<form:input name="id" path="email" placeholder="User Name" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="code" class="col-xs-4 control-label">Password</label>
		<div class="col-xs-4">
			<form:input name="password"  path="password" placeholder="User Password" class="form-control" />
		</div>
	</div>
	
	
	<div class="form-group">
		<label for="code" class="col-xs-4 control-label">Phone Number</label>
		<div class="col-xs-4">
			<form:input name="phone"  path="phone" placeholder="User Phone" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
	<label for="code" class="col-xs-4 control-label"></label>
		<div class="col-xs-4">
		<div class="text-center">
			<input type="submit" value="Register" id="btn-add" class="btn btn-primary"></div>
		</div>
	</div>
	
	</div>
	</form:form>
	<br><br><br><br>
	<jsp:include page="footer.jsp"></jsp:include>
	</body>
	</html>