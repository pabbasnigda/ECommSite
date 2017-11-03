<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
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
                <ul class="nav navbar-nav">
                    <li><a href="viewcart">CART</a></li>
               </ul> 
                <ul class="nav navbar-nav navbar-right">
                       
                              <li> <a href="<c:url value="j_spring_security_logout" />">Logout</a></li>
                    	</ul>
                    	
                </ul> 
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
</div>


<br>
<br>
<br>
<br>
<div id= "printableArea">
 
     <div class="container">
        <div class="well">     


		<table class ="table table-hover ">
		<thead>
		<tr>
	
	<th>Product image</th>
	<th>Product name</th>
	<th>product price</th>
	<th>Quantity</th>
	

	
	
</tr>
</thead>	
<tbody>	
<c:forEach items="${cd}" var="cd">
		<tr>
		<td><img src="/Bakersfrontend/myImage/imageDisplay?id=${cd.productid}" alt="" width="200" height="200" /></td>
			<td>${cd.name}</td>
			<td>${cd.price}</td>
			<td>${cd.quantity}</td>
			
			
		</tr>
</c:forEach>	
	</tbody>	
	
</table>
     <div class='form-control'>
     
                  Total:  <span class='amount'>Rs.${total}${cod}</span>
     </div>  
 
  
</div>
</div>
</div>
<div class="row">
		<div class="col-md-offset-2 col-md-2">
			<button class="btn btn-info" onclick="printDiv('printableArea')">
				<span class="glyphicon glyphicon-print"></span>Print Invoice</button>
		</div>
		<div class="col-md-4">
       <a href="continueshopping" class="btn btn-danger">
        	<span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping</a>
     	</div>
 </div>
 
 
   </div><br/><br/><br/><br/>
	<jsp:include page="footer.jsp"></jsp:include> 

</body>
</html>
