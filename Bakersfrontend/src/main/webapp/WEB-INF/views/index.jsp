<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Index Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">

	.bs-example{
    	margin: 20px;
   		}
	.background{
		background-repeat: no-repeat;
		height: 315px;
		width: 1300px;
	}
</style>

<%-- <jsp:include page="showProduct.jsp" />  --%>
</head>

<body background="${pageContext.request.contextPath}/resources/pics/heart.jpg" >
${ExistingMessage}
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
                
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                    	<li><a href="#" data-toggle="dropdown" class="dropdown-toggle"><span class="glyphicon glyphicon-user"></span> Sign Up<b class="caret"></b></a>
                     
                        	<ul class="dropdown-menu">
                            	<li><a href="login">Login action</a></li>
                            	<li><a href="register">Registration action</a></li>
         
                        	</ul>
                    	</li>
                    </li>
                </ul>     
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
</div>
<!-- =================================-->
 


<center>

<h2><font color="Tomato">!!!!Welcome to world of CHOCOHUB!!!!</font></h2>
</center>

<div class="container">
		<c:forEach items="${ProductList}" var="product">
			<h2 style="color: blue">
				<c:out value="${product.name }" />
			</h2>


			<div class="row">
				<img src="/Bakersfrontend/myImage/imageDisplay?id=${product.id}"class="rounded float-left"
							class="img-responsive" style="width: 200px; height:120px">
										<!--  <img src="/Bakersfrontend/myImage/imageDisplay?id=${product.id}"-->		
										<!-- <div>				</div>-->
			</div>

			<div class="row">
				<div class="img">
					<div class="desc">
						<p>
						<div class="form-group">
							<input type="text" style="width: 400px;" class="form-control" value="${product.name}"
								readonly="readonly">
						</div>

						<div class="form-group">
							<input type="text" style="width: 400px;" class="form-control"
								value="Rs. ${product.price}" readonly="readonly">
						</div>
						<div class="form-group">
							<input type="text" style="width: 400px;" class="form-control"
								value="${product.description}" readonly="readonly">
						</div>
						<div>
							<form action="addtoCart/${product.id}">
								<input type="submit" value="Add to Cart" class="btn btn-primary" >
							</form>
							

						</div>

					</div>
				</div>
			</div>
		</c:forEach>
		<br/><br/><br/><br/><br/><br/><br/><br/><br/>
		<div class="container">
        <div id="map" style="width:100%;height:300px"></div>
        </div>
        <script>
function myMap() {
  var myCenter = new google.maps.LatLng(17.4836979,78.3158338);
  var mapCanvas = document.getElementById("map");
  var mapOptions = {center: myCenter, zoom: 5};
  var map = new google.maps.Map(mapCanvas, mapOptions);
  var marker = new google.maps.Marker({position:myCenter});
  marker.setMap(map);
  // Zoom to 9 when clicking on marker
  google.maps.event.addListener(marker,'click',function() {
    map.setZoom(9);
    map.setCenter(marker.getPosition());
  });
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALCNrf2vvP9ECAFAWh0I4OQIhnLLFTKoE&callback=myMap"></script>
		
		
</div>		
	</div><br/><br/><br/><br/>
	<jsp:include page="footer.jsp"></jsp:include> 

</body>
</html> 