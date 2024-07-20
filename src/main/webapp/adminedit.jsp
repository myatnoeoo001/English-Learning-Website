<%@page import="model.reading"%>
<%@page import="dao.readingDao"%>
<%@page import="model.level"%>
<%@page import="java.util.List"%>
<%@page import="dao.levelDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="./css/adminedit.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
#all{
display:none;
}
</style>
</head>
<body>
  <div class="sidebar">
       
        <div class="logo">CRUDLIK</div>
        <ul class="menu">

            <li class="active">
                <a href="#" ><i class="fas fa-tachometer-alt"></i>
                <span>Dashboard</span>
                </a>
            </li>
           
            <li>
                <a href="adminquestion.jsp"><i class="fas fa-chart-bar"></i>
                <span>Upload</span>
                </a>
            </li>
            <li class="edit">
                <a href="adminedit.jsp"><i class="fas fa-chart-bar"></i>
                <span>Edit</span>
                </a>
            </li>
            
            <li class="logout">
                <a href="Logout"><i class="fas fa-sign-out"></i>
                <span>Logout</span>
                </a>
            </li>
        </ul>
    </div>
    <div class="main--content">
        <div class="header--wrapper">
            <div class="header--title">
                <span>Primary</span>
                <h2>Dashboard</h2>
            </div>
        </div>
        <div class="card--container">
           <!-- Example single danger button -->
<div class="btn-group">
<%levelDao dao=new levelDao();
List<level> levelList=dao.getAllLevelInfo();
%>
    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" >
      Choose Course
    </button>
    <ul class="dropdown-menu">
    <%for (level l:levelList){ %>
      <li><a class="dropdown-item" href="#" onclick="<%=l.getName()%>()" data-value="<%=l.getLevelId()%>"><%=l.getName() %></a></li>
      
      
      <%} %>
      
    
    </ul>
  </div>
           <%readingDao readingDao=new readingDao();
         List<reading>  readings;
         %>
  <br>
         <div style="padding-top: 44px; line-height: 33px;" id="all" >
         <div id="b">
       		<% readings=readingDao.getReadingBybasiclevel(); %> 

           <%for(reading r:readings){  %>
           
           
           <a href="admineditclickview.jsp?readingid=<%=r.getReadingId()%>"><%=r.getTitle() %></a>
           <br><%} %>
            </div>
           <div id="I">
           <% readings=readingDao.getReadingByinterMediatelevel(); %> 

           <%for(reading r:readings){  %>
           
           
           <a href="admineditclickview.jsp?readingid=<%=r.getReadingId()%>"><%=r.getTitle() %></a>
           <br><%} %>
            </div>
            <div id="A"><% readings=readingDao.getReadingByadvancelevel(); %> 

           <%for(reading r:readings){  %>
           
           
           <a href="admineditclickview.jsp?readingid=<%=r.getReadingId()%>"><%=r.getTitle() %></a>
           <br><%} %>
            </div>
         </div>
        </div>
    </div>
    <script>
    var bas=document.getElementById("b");
    var Inter=document.getElementById("I");
    var Advan=document.getElementById("A");
    var a=document.getElementById("all");
    function Basic(){
    	a.style.display="block";
    	bas.style.display="block";
    	Inter.style.display="none";
    	Advan.style.display="none";
    }
    function Intermediate(){
    	a.style.display="block";
    	bas.style.display="none";
    	Inter.style.display="block";
    	Advan.style.display="none";
    }
    function Advance(){
    	a.style.display="block";
    	bas.style.display="none";
    	Inter.style.display="none";
    	Advan.style.display="block";
    }
    
    </script>
</body>
</html>