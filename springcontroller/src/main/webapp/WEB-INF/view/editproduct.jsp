<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditProduct</title> 
<meta name="viewport" content="width=device-width, initialscale=1.0">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>

<div class="text-white-50 bg-dark">
	<div class="d-inline">
	<h1 class="d-inline">Shopping Site</h1>
	<input type="Search" class="d-inline" placeholder="Search " >
<a class="btn btn-primary" href='userhome'>Home</a>
<a type="lable" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" >${name}</a>
<div class="dropdown-menu">
<c:url value="admin" var="admin"/>
    <a class="dropdown-item" href='${admin}'>Admin</a>
 <c:url value="login" var="login"/>
    <a class="dropdown-item" href='${login}'><i class="fas fa-user" >user</i></a>
  </div>
<a  type="lable"class="btn btn-primary dropdown-toggle" data-toggle="dropdown">more</a>
<div class="dropdown-menu">
<c:url value="contact" var="contact"/>
    <a class="dropdown-item" href='${contact}'>contact us</a>
    <c:url value="About" var="about"/>
    <a class="dropdown-item" href='${about}'>About us</a>
</div></div>
<c:url value="cart" var="gotocart"/>
<a type="button" class="btn btn-primary" href='${gotocart}'>cart<span class="badge" id="count">${cartsize}</span></a>

<c:if test="${logoutstatus}==true"> 
<jsp:forward page="userhome"/>
</c:if>

  <%String username=(String)session.getAttribute("username") ; %> 

<%if(username.equals("anonymousUser")){
	out.println(" ");   
   }
   else {%>
<%--    <a class="btn btn-primary"  > <%out.println(username); %></a> --%>
   <a href='springcontroller/j_spring_security_logout' class="btn btn-primary">logout</a>
   <% } %>  

<%--  <%String username=(String)session.getAttribute("username") ;  --%>
<%--   out.println(username);%>  --%>

<!--  <a href='springcontroller/j_spring_security_logout' class="btn btn-primary">logout</a> -->
<br><br>
</div><br>
<div class="container"  >
<h2 style="padding: 1% 30%" >Edit Product Details</h2>

<form method="post" action="updateproduct" style="padding: 3% 30%" modelAttribute="addproduct" enctype="multipart/form-data">

<div class="form-group">
      <label >ProductId:</label>
      <input class="form-control"  name="productid" value="${currproduct.productid}" required>
    </div><div class="form-group">
      <label >ProductName:</label>
      <input type="text" class="form-control"  placeholder="Enter productname" name="productName" value="${currproduct.productName}"required>
    </div>
    <div class="form-group">
      <label >product price:</label>
      <input type="number" class="form-control"  placeholder="Enter product price" name="price" value="${currproduct.price}" required>
    </div>
     <div class="form-group">
      <label >Quantity:</label>
      <input type="number" class="form-control"  placeholder="Enter Quantity" name="quantity" value="${currproduct.quantity}" required>
    </div>
     <div class="form-group">
      <label >product Description:</label>
      <input type="textarea" class="form-control"  placeholder="Enter description" name="description" value="${currproduct.description}"  required>
    </div>
    <div class="form-group">
      <label >Select CategoryId:</label>
       <select name="categoryId" class="form-control" required>
					<c:forEach items="${categorylist}" var="category">
   							 <option value="${category.categoryId}">
    											   ${category.categoryname}
   							  </option>
					</c:forEach>
	</select>
    </div>
    
     <div class="form-group">
      <label >Select SupplierId</label>
     <select name="supplierId" class="form-control" required>
					<c:forEach items="${supplierlist}" var="supplier">
   							 <option value="${supplier.supplierId}">
    											   ${supplier.suppliername}
   							  </option>
					</c:forEach>
	</select>
    </div>
    <div class="form-group">
      <label >Select Product Image</label>
<input type="file" name="image" class="form-control" required/>    
</div>
    
    <input type="submit" class="btn btn-primary" value="update"/>&nbsp&nbsp&nbsp&nbsp<a class="btn btn-primary" href='ProductDetails'>back</a>
</form>
</div>
</body>
</html>