<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SingUp</title>
	<meta name="viewport" content="width=device-width, initialscale=1.0">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script>
function validate(){
	
	
	
}


</script>
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
<div class="container" style="padding: 10% 30%" >
  <h2>Login</h2>
  <form action="adduser" name="signup" method="post">
  <div class="form-group">
      <label >UserName:</label>
      <input type="text" class="form-control"  placeholder="Enter email" name="userName" required>
    </div>
    <div class="form-group">
      <label >Email:</label>
      <input type="email" class="form-control"  placeholder="Enter email" name="email" required>
    </div>
    <div class="form-group">
      <label >MobileNumber:</label>
      <input type="number" class="form-control"  placeholder="Enter mobilenumber" name="mobileNumber" required>
    </div>
<!--     <div class="form-check"> -->
<!--   <label class="form-check-label"> -->
<!--   <label >Gender:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp -->
<!--     <input type="radio" class="form-check-input" name="male">male -->
<!--   </label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp -->
<!--   <label class="form-check-label"> -->
<!--   <input type="radio" class="form-check-input" name="female">female -->
<!--   </label> -->
<!--   </div> -->
    <div class="form-group">
      <label >Password:</label>
      <input  type="password" class="form-control"  placeholder="Enter password" name="password" required>
    </div>
          <input type="hidden" name="user_role" value="ROLE_USER">
    
    <c:url value="login" var="login"/>
    <button type="submit" class="btn btn-default" onclick="return validate()" href="${login}">signUp</button>
  </form>
  </div>

</body>
</html>