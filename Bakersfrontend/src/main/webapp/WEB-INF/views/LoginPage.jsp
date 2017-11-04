<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<style>

</style>
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
           
               
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
</div>

	
<form  method="post" action="j_spring_security_check" class="form-horizontal" >
	<h2 class="text-center"><font color="#006699">LOGIN</font></h2>
	<!--<h2 class="text-center">LOGIN</h2>-->
    <br/>
	
	<div class="form-group">
		<label for="User Email" class="col-xs-4 control-label">Email</label>
		<div class="col-xs-4">
			<input name="j_username" type="email"  placeholder=" User Email" class="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="code" class="col-xs-4 control-label">Password</label>
		<div class="col-xs-4">
			<input name="j_password"  type="password" placeholder="User Password" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
	<label for="code" class="col-xs-4 control-label"></label>
		<div class="col-xs-4">
		<div class="text-left">
			<input type="submit" value="Login" id="btn-add" class="btn btn-primary"></div>
		</div>
	</div>
	

	<div class="form-group">
	<label for="code" class="col-xs-4 control-label"></label>
		<div class="col-xs-4">
		<div class="text-left">
			<div class="checkbox">
                    <label>
                        <input type="checkbox">Remember me</label>
             </div>
                </div>
		</div>
	</div>
	
	
	
	
	
</form>
    
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>