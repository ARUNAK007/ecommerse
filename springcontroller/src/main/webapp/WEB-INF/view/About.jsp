<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
Developed by AK

</body>
</html>