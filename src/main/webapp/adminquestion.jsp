<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dao.*,model.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/adminquestion.css">
    <script type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<%levelDao level=new levelDao();
List<level> listlevel=level.getAllLevelInfo();
%>
<body>
    <div>
    <div class="sidebar">
       
        <div class="logo">CURDLIK</div>
        <ul class="menu">

            <li class="active">
                <a href="admin.html" ><i class="fas fa-tachometer-alt"></i>
                <span>Dashboard</span>
                </a>
            </li>
           
            <li class="upload">
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
                <a href="#"><i class="fas fa-sign-out"></i>
                <span>Logout</span>
                </a>
            </li>
        </ul>
    </div>
   
    <div class="app" style="margin-top:-650px; margin-left:600px;">
      <h1>Reading</h1>  
       <form action="readingServlet" method="post" enctype="multipart/form-data">
       
             <div class="quiz">
        
        <div id="answer-buttons">
       
        <select name="levelId" style="width:130px; height:43px; margin-bottom:23px; border-radius:12px;"> <!-- Select element to choose level -->
            <% for (level l : listlevel) { %>
                <option value="<%= l.getLevelId() %>"><%= l.getName() %></option>
            <% } %>
        </select>
        
            <p>Title</p>
           <input type="text" name="title" class="btn">
           <p>Description</p>
           <textarea rows="4" cols="10" name="des" class="btn"></textarea>
           <p>File</p>
           <input type="file" name="pdfile" class="btn">
        </div>
 
        <button id="next-btn1" onclick="prev()" >Previous</button>
        <button type="submit" id="next-btn2">Add</button>
        <button id="next-btn3" onclick="next()" >Next</button>
      </div>
      </form>
    </div>
    </div>
    <script>
       
        function prev() {
            var btn=document.getElementById("next-btn1");
            btn.style="disabled";
            btn.disabled=true;
          
        }

       
        function next() {
           
            window.location.href = "multiplechoice.jsp"; 
        }
    </script>
</body>
</html>