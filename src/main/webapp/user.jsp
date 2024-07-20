<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.*,controller.*,model.*,java.util.*,java.io.*" %>
<% readingDao rdo=new readingDao();
List <reading> allReadings=rdo.getAllReadingInfo();
request.setAttribute("allReadings", allReadings);

List<reading> basic=rdo.getReadingBybasiclevel();
request.setAttribute("basic",basic);

List<reading> inter =rdo.getReadingByinterMediatelevel();
request.setAttribute("inter",inter);

List<reading> advance =rdo.getReadingByadvancelevel();
request.setAttribute("advance",advance);
%>
<!Doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Conpatible" content="IE=edge">
<meta name="viewpoint" content="width=device-width,initial-scale=1.0">
<title>Complete Responsive Flower Website Design </title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" href="./css/user.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
	table {
		width:100%;
		height: 100%;
		border-collapse: collapse;
	}
	
	tbody{
		display: block;
		width:100%;
		table-layout:fixed;
	}
	
	

	table .tablerow{
			width:100%;
			display: grid;
			grid-template-columns: repeat(3,1fr);
		}
	table tr td {
		padding-bottom: 55px;
		padding-left: 45px;
		width: 100%;
	}
</style>
</head>


<body>
<header>
<input type="checkbox" name="" id="toggler">
<label for="toggler" class="fas fa-bars"></label>
<a href="#" class="logo" style="text-decoration: none;"> CRUDLIK </a> 
<nav class="navbar">
<a href="#basic" onclick="basic()" style="text-decoration: none;">Basic</a>
<a href="#intermediate" onclick="intermediate()" style="text-decoration: none;">Intermediate</a>
<a href="#advance" onclick="advanced()" style="text-decoration: none;">Advanced</a>
<a href="#profile"  data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight" style="text-decoration: none;">Profile</a>

</nav>

</header>

	<section class="products" id="basic">
		<h1 class="heading" style="margin-top: 45px;"> Basic</h1>
		<div class="box-container">
		
			<table class="basictable" >
			 <tr class="tablerow">
        <% for (reading b : basic) { %>
        <td class="tablecolumn">
            <div class="box">
                <a href="userclickview1.jsp?data-value=<%= b.getReadingId() %>">
                    <div class="image">
                        <img src="./img/basic.jpg" alt="">
                    </div>
                </a>
                <div class="content">
                    <h3><%= b.getTitle() %></h3>
                </div>
            </div>
        </td>
        <% } %>
    </tr>
				
				
				<tr>
					<td >
						<div class="button">
							<button type="button" class="btn btn-primary btn-lg"  style="margin-left:550px;">Level Test</button>
				
						</div>
					</td>
				</tr>
				
			</table>
		</div>
		
		<br>
		
		
		</section>
		
		
		<section class="products" id="intermediate">
		<h1 class="heading" style="margin-top: -14px;">Intermediate</h1>
		<div class="box-container">
			<table class="basictable" >
				<tr class="tablerow">
				
				 <% for (reading i : inter) { %>
					<td class="tablecolumn">

						<div class="box">
	<a href="userclickview1.jsp?data-value=<%= i.getReadingId() %>">
						<div class="image">
						   <img src="./img/intermediate.jpg" alt="">
						</div>
		                </a>
						</div>
						<div class="content">
						<h3><%= i.getTitle() %></h3>

						</div>
						</div>
					</td>
					<% } %>
					<!-- <td class="tablecolumn">

						<div class="box">
	
						<div class="image">
						<img src="./image/intermediate.jpg" alt="">
		
						</div>
						<div class="content">
						<h3>Quiz 2</h3>

						</div>
						</div>
					</td>
					<td class="tablecolumn">

						<div class="box">
	
						<div class="image">
						<img src="./image/intermediate.jpg" alt="">
		
						</div>
						<div class="content">
						<h3>Quiz 3</h3>

						</div>
						</div>
					</td> -->
				</tr>
				
				
				<tr>
					<td colspan="3">
						<div class="button">
							<button type="button" class="btn btn-primary btn-lg" style="margin-left:550px;">Level Test</button>
				
						</div>
					</td>
				</tr>
				
			</table>
		
		
		<br>
		</section>
		
		
		<section class="products" id="advance">
		<h1 class="heading" style="margin-top: -14px;">Advanced</h1>
		<div class="box-container">
			<table class="basictable" >
			
			
				<tr class="tablerow">
				 <% for (reading a : advance) { %>
					<td class="tablecolumn">

						<div class="box">
	<a href="userclickview1.jsp?data-value=<%= a.getReadingId() %>">
						<div class="image">
						<img src="./img/advanced.jpg" alt="">
		
						</div>
						</a>
						<div class="content">
						<h3><% a.getTitle(); %>></h3>

						</div>
						</div>
					</td>
					<% } %>
					<!-- <td class="tablecolumn">

						<div class="box">
	
						<div class="image">
						<img src="./image/advanced.jpg" alt="">
		
						</div>
						<div class="content">
						<h3>Quiz 2</h3>

						</div>
						</div>
					</td>
					<td class="tablecolumn">

						<div class="box">
	
						<div class="image">
						<img src="./image/advanced.jpg" alt="">
		
						</div>
						<div class="content">
						<h3>Quiz 3</h3>

						</div>
						</div>
					</td> -->
				</tr>
				
				</table>
				
				</div>
				</section>
		<section class="" id="profile">
			

<%UserLogin User = (UserLogin) session.getAttribute("loginUser");
System.out.println(User.getEmail());

%>
<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel" style="width: 355px;">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasRightLabel">PROFILE</h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body" class="offcanvas-body d-flex flex-column align-items-center gap-5">
    <div style="width: 100px; height: 100px; display: flex; justify-content: center; align-items: center; margin-left: 35%;" class="border border-black d-flex justify-content-center align-items-center rounded-circle"><img src="./img/profile.jpg" width="80%" height="80%" class="object-fit-cover" ></div>
                            <table style="height: 200px; font-size: 1.1rem; margin-top: 15%; margin-left: -33px; margin-right: -53px;">
                               <thead>
                                <tr>
                                    <td class="fw-bold">Username</td>
                                    <td><%= User.getName() %></td>
                                </tr>
                                <tr>
                                    <td class="fw-bold">Email</td>
                                    <td><%= User.getEmail() %></td>
                                </tr>
                                <tr>
                                    <td class="fw-bold">Level</td>
                                    <td><%= User.getLevelId() %></td>
                                </tr>
                               
                               </thead>
                            </table>
  </div>
  <form action="Logout" method="get">
    <div class="d-flex justify-content-center align-items-center">
        <button type="submit" style="width: 80%; margin-bottom: 30px;" class="btn btn-primary">Log Out</button>
    </div>
</form>
</div>
    </section>
		
		
		
</body>
</html>

