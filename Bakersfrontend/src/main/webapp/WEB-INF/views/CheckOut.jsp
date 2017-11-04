<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CheckOut</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
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
            
        </div>
    </nav>
</div>
<br>
<br>

<div class="container">
   <div class="col-xs-offset-2 col-xs-12">
             <div class="form-group">
                 <label style="color:white;" class="control-label" for="total"><h3><strong>Grand Total : ${total}</strong></h3></label>
                </div>
                </div>                    
        
            <div class="row .payment-dialog-row" id="checkOut-box">
                <div class="col-md-4 col-md-offset-4 col-xs-12">
                    <div class="panel panel-default credit-card-box">
                        <div class="panel-heading">
                            <h3 class="panel-title"><span class="panel-title-text">Payment Details </span><img class="img-responsive panel-title-image" src="<c:url value="/resources/assets/img/accepted_cards.png"/>"></h3></div>
                        <div class="panel-body">
                            <form:form action="invoice" id="payment-form" modelAttribute="card">
                            <div class="row">
                                    <div class="col-xs-12">
                                        <div class="form-group">
                                        	<form:label class="control-label" path="card_name">Name on Card</form:label>
                                            <div class="input-group">
                                               <form:input class="form-control" type="text" required="" placeholder="Name on Your Card" path="card_name"/>
                                                <div class="input-group-addon"><span><i class="fa fa-user"></i></span></div>
                                                </div>
                                             </div>
                                        </div>
                                    </div>

                                <div class="row">
                                    <div class="col-xs-12">
                                        <div class="form-group">
                                            <form:label class="control-label" path="card_number">Card number </form:label>
                                            <div class="input-group">
                                                <form:input class="form-control" type="tel" required="" placeholder="Valid Card Number" path="card_number"/>
                                                <div class="input-group-addon"><span><i class="fa fa-credit-card"></i></span></div>
                                                 </div>
                                        </div>
                                    </div>
                                </div>
                              <%--   <div class="alert alert-danger alert-dismissable fade in">
                                 <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                                 <strong><form:errors path="card_number"></form:errors></strong>
                                 </div> --%>
                                <div class="row">
                                    <div class="col-xs-9">
                                        <div class="form-group">
                                            <label class="control-label" for="cardExpiry"><span class="hidden-xs">expiration </span><span class="visible-xs-inline">EXP </span> date</label>
                                            <!-- <input class="form-control" type="tel" required="" placeholder="MM / YY" id="cardExpiry">
                                        --> <div class="row">
                                        <div class="col-xs-5">
                                         
              <select class="form-control col-sm-2" name="expiry-month" placeholder="Month" id="expiry-month">
                <option>Month</option>
                <option value="01">Jan (01)</option>
                <option value="02">Feb (02)</option>
                <option value="03">Mar (03)</option>
                <option value="04">Apr (04)</option>
                <option value="05">May (05)</option>
                <option value="06">June (06)</option>
                <option value="07">July (07)</option>
                <option value="08">Aug (08)</option>
                <option value="09">Sep (09)</option>
                <option value="10">Oct (10)</option>
                <option value="11">Nov (11)</option>
                <option value="12">Dec (12)</option>
              </select>
            </div>
            <div class="col-xs-4">
              <select class="form-control" name="expiry-year" placeholder="year">
                <option>year</option>
                <option value="18">2018</option>
                <option value="19">2019</option>
                <option value="20">2020</option>
                <option value="21">2021</option>
                <option value="22">2022</option>
                <option value="23">2023</option>
                <option value="24">2024</option>
                <option value="25">2025</option>
                <option value="26">2026</option>
                <option value="27">2027</option>
                <option value="28">2028</option>
              </select>
            </div>
</div>
                                        </div>
                                    </div>
                                    <div class="col-xs-3 pull-right">
                                          <div class="form-group">
                                            <label class="control-label" for="cardCVC">CVV code</label>
                                            <input class="form-control" type="tel" required="" placeholder="CVV" id="cardCVC">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <button class="btn btn-success btn-block btn-lg" type="submit" >Pay With Card</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
   
   <br>
  

   <form:form action="CodInvoice" id="payment-form" modelAttribute="card">                         
  	<div class="row">
    <div class="col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4">
        <button class="btn btn-warning btn-block" data-toggle="modal" data-target="#myModal" type="button">Cash on Delivery</button>
    </div></div>
    <div class="modal fade" id="myModal" role="dialog" tabindex="-1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title">Cash On Delivery</h4></div>
                <div class="modal-body">
                    <p>A delivery Charge of <Strong>Rs.99/-</Strong> is applicable for Cash on Delivery for orders below Rs.200/-</p>
                    <div class="col-xs-offset-2 col-xs-12">
             <div class="form-group">
                 <label class="control-label" for="total"><h3><strong>Grand Total : ${total}</strong></h3></label>
                </div>
                </div>                    
        
                </div>
                <div class="modal-footer">
                    <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
                    <button class="btn btn-primary" type="submit">Agree & Place the Order</button>
                </div>
            </div>
        </div>
    </div>
   
 </form:form>
    </div>
    
   </div><br/><br/><br/><br/>
	<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>