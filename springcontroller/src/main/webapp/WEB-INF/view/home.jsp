<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Shopping Site</title>
<meta charset="UTF-8">
<base href="F:\projectfolder\">
<meta name="viewport" content="width=device-width, initialscale=1.0">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<style>
	.carousel-inner img {
  
    width: 100%;
    height: 100%;
  
  }

</style>
<body> <div class="text-white-50 bg-dark">
	
	<h1 class="d-inline">Shopping Site</h1>
	<input type="text" class="d-inline" placeholder="Search " >
<a type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" >profile</a>
<div class="dropdown-menu">
    <a class="dropdown-item" href="#">admin</a>
    <a class="dropdown-item" href="login.html"><i class="fas fa-user" &nbsp>user</i></a>
  </div>
<a  type="button"class="btn btn-primary dropdown-toggle" href="#">more</a>
<a type="button" class="btn btn-primary" href="#">cart</a>
</div>
<div class="text-white-50 bg-dark ">
	  <div class="btn-group">
    <button type="button" class="btn btn-info">Electronics</button>
    <button type="button" class="btn btn-info dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">TV</a>
      <a class="dropdown-item" href="#">SmartPhone</a>
      <a class="dropdown-item" href="#">Laptop</a>
      <a class="dropdown-item" href="#">AC</a>
    </div>
  </div>
<div class="btn-group">
    <button type="button" class="btn btn-info">Men</button>
    <button type="button" class="btn btn-info dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Shirts</a>
      <a class="dropdown-item" href="#">T-shirt</a>
      <a class="dropdown-item" href="#">jeans</a>
      <a class="dropdown-item" href="#">trousers</a>
    </div>
  </div>
  <div class="btn-group">
    <button type="button" class="btn btn-info">kids</button>
    <button type="button" class="btn btn-info dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Toys</a>
      <a class="dropdown-item" href="#">baby care</a>
      <a class="dropdown-item" href="#">footwear</a>
      <a class="dropdown-item" href="#">cloths</a>
    </div>
  </div>
  <div class="btn-group">
    <button type="button" class="btn btn-info">Women</button>
    <button type="button" class="btn btn-info dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">sarees</a>
      <a class="dropdown-item" href="#">T-shirt</a>
      <a class="dropdown-item" href="#">jeans</a>
      <a class="dropdown-item" href="#">skirts</a>
    </div>
  </div>
	</div>
</br></br>
<div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src= "001.jpg"alt="Los Angeles" width="500" height="700">
      <div class="carousel-caption">
      </div>   
    </div>
    <div class="carousel-item">
      <img src="002.jpg" alt="Chicago" width="500"height="700">
      <div class="carousel-caption">
      </div>   
    </div>
    <div class="carousel-item">
      <img src="003.jpg" alt="New York" width="500" height="700">
      <div class="carousel-caption">
        
      </div>    
    </div>
  </div>
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div><br><br>

	<div class="container"> 
<div class="row">  
 <div class="col-md-4">
 <figure class="figure">      
   <img src="10.jpeg" class="rounded" height="300" width="200">      
     <figcaption class="figure-caption">Laptop<br>$1089</figcaption> 
  </figure>
  </div>
 <div class="col-md-4">   
    <figure class="figure"><a href="shoe.html">   
      <img src="3.jpeg" class="rounded" height="300" width="200">      
         <figcaption class="figure-caption">Shoes<br>$39</figcaption></a> 
    </figure>
  </div>
 <div class="col-md-4">   
    <figure class="figure">   
      <img src="4.jpeg" class="rounded" height="300" width="200">      
         <figcaption class="figure-caption">vivo v11<br>$199</figcaption> 
    </figure>
 </div>
 <div class="col-md-4">   
    <figure class="figure">   
      <img src="5.jpeg" class="rounded" height="300" width="200">      
         <figcaption class="figure-caption">Samsung s10<br>$189</figcaption> 
    </figure>
 </div>
 <div class="col-md-4">   
    <figure class="figure">   
      <img src="6.jpeg" class="rounded" height="300" width="200">      
         <figcaption class="figure-caption">Sarees<br>$89</figcaption> 
    </figure>
 </div>
 <div class="col-md-4">   
    <figure class="figure">   
      <img src="7.jpeg" class="rounded" height="300" width="200">      
         <figcaption class="figure-caption">Sarees<br>$119</figcaption> 
    </figure>
 </div>
 <div class="col-md-4">   
    <figure class="figure">   
      <img src="8.jpeg" class="rounded" height="300" width="200">      
         <figcaption class="figure-caption">Transfomer Car<br>$99</figcaption> 
    </figure>
 </div>
 <div class="col-md-4">   
    <figure class="figure">   
      <img src="9.jpeg" class="rounded" height="300" width="200">      
         <figcaption class="figure-caption">Angel Toy<br>$59</figcaption> 
    </figure>
</div>
</div>
</div>

</body>
</html>
