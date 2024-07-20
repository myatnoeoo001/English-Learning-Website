<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="dao.*,model.*,controller.*" %>
 <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
    <link rel="stylesheet" href="./css/admin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
  <%
     Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
    loginDao loginDao = new loginDao();
    List<UserLogin> user = loginDao.getAllUsers();
   	int stucount=loginDao.getcount();
   	int bcount=loginDao.Basiccount();
   	int icount=loginDao.Intercount();
   	int acount=loginDao.Advancount();
    %>  
	<div class="sidebar">
       
        <div class="logo">CURDLIK</div>
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
            <h3 class="main--title">User's Record</h3>
            <div class="card--wrapper">
                <div class="payment--card light-red" >

                    <div class="card--header">
                        <div class="amount">
                            <span class="title">
                                Total 
                            </span>
                            <span class="amount--value">Count <span style="margin-left: 35px;"><%=stucount%></span></span>
                        
                        </div>
                      
                    </div>
                    
                </div>
                <div class="payment--card light-purple" >

                    <div class="card--header">
                        <div class="amount">
                            <span class="title">
                                Basic
                            </span>
                            <span class="amount--value">Count <span><%=bcount %></span></span>
                        
                        </div>
                      
                    </div>
                   </div>
                <div class="payment--card light-green" >

                    <div class="card--header">
                        <div class="amount">
                            <span class="title">
                               Intermediate
                            </span>
                            <span class="amount--value">Count <span><%=icount%></span></span>
                        
                        </div>
                       
                    </div>
                    
                </div>
                <div class="payment--card light-blue" >

                    <div class="card--header">
                        <div class="amount">
                            <span class="title">
                               Advanced
                            </span>
                            <span class="amount--value">Count <span><%=acount %></span></span>
                        
                        </div>
                      
                    </div>
                   
                </div>
            </div>
        </div>
  
    <div class="tabular--wrapper">
        <h3 class="main--title">User Data</h3>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>
                            Name
                        </th>
                        <th>
                            Email
                        </th>
                        <th>
                            Level
                        </th>
                    </tr>
                </thead>
                <tbody>
                <% for(UserLogin u : user) {  %>
                
                    <tr>
                        <td>
                            <%= u.getName() %>
                        </td>
                        <td>
                            <%= u.getEmail() %>
                        </td>
                        <td>
                            <%=u.getLevelId() %>
                         	
                        </td>
                    </tr>
                    
<% } %>
                </tbody>
            </table>
        </div>
    </div>
    </div>
</body>
</html>