<%@page import="model.blank"%>
<%@page import="dao.blankDao"%>
<%@page import="model.truefalse"%>
<%@page import="dao.truefalseDao"%>
<%@page import="model.choice"%>
<%@page import="dao.choiceDao"%>
<%@page import="model.reading"%>
<%@page import="java.util.*"%>
<%@page import="dao.readingDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="./css/admineditclickview.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

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
          
            <div>
                <h1 style="font-size: 34px;">Quiz 1</h1>
                <div class="container">
                    <div class="paragraph">
             <% 
            
             int rid=0;
             Object ridAttribute = request.getAttribute("rid");
             if (ridAttribute != null) {
                 rid = Integer.parseInt(ridAttribute.toString());
                 %>
                 <script>
                 alert("Your Quiz are update successful!!!!!");
                 </script>
            <% }
             else
            	 
               rid=Integer.parseInt(request.getParameter("readingid"));
             readingDao dao=new readingDao();
            reading read=dao.getReadingInfoById(rid);
            
             %>       
                    
               
                        <h1><%=read.getTitle() %> </h1>
                        <h3><%= read.getDescription() %></h3>
                        <%
			byte[] paragraphBytes = read.getParagraph().getBytes(1, (int) read.getParagraph().length());
			String paragraphBase64 = Base64.getEncoder().encodeToString(paragraphBytes);
			%>
<object data="data:application/pdf;base64,<%= paragraphBase64 %>" type="application/pdf" width="90%" height="500px">
</object>
                       
                        </div>
        </div>
    
    <div class="tabular--wrapper">
        <div class="btn-group">
            <div style="padding-bottom: 34px;">
            <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
              Choose Type Of questions
            </button>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" onclick="multi()" href="#">Multiple Choice</a></li>
              <li><a class="dropdown-item" onclick="tf()" href="#">True/False</a></li>
              <li><a class="dropdown-item" onclick="blank()" href="#">Blank</a></li>
            
            </ul>
        </div>
          </div>
          <div id="choose">
            <div class="table-container" >
           
            <table id="multiple">
            <%choiceDao chDao=new choiceDao();
            List<choice>choiceList=chDao.getChoiceByParagraphId(rid);
            %>
                <thead>
                    <tr>
                        <th >
                            Multiple choice
                        </th>
                        <th>
                            Option1
                        </th>
                        <th>
                           Option2
                        </th>
                        <th>
                            Option3
                        </th>
                        <th>
                            Option4
                        </th>
                        <th>
                            Correct Answer
                        </th>
                        <th>Edit</th>
                    </tr>
                    <tbody>
                    
                    <%int ch=1;
                    for(choice c:choiceList){ %>
                     <form action="ChoiceEditServlet" method="post">
                        <tr>
                        
                            <td>
                             
                            <textarea name="chquestion" id="" cols="20" rows="" > <%=c.getQuestion() %></textarea>
                            </td>
                            <td><textarea name="option1" id="" cols="15" rows=""><%=c.getOption1() %></textarea></td>
                            <td><textarea name="option2" id="" cols="15" rows=""><%=c.getOption2() %></textarea></td>
                            <td><textarea name="option3" id="" cols="15" rows=""><%=c.getOption3() %></textarea></td>
                            <td><textarea name="option4" id="" cols="15" rows=""><%=c.getOption4() %></textarea></td>
                            <td><textarea name="choiceCorrect" id="" cols="15" rows=""><%=c.getCorrectAnswer() %></textarea></td>
                          
                            <td><input type="submit" value="Edit" name="Edit" ></td>
                            
                        </tr>
                         <input type="hidden" value="<%=c.getChoiceId() %>" name="choiceid">
                           <input type="hidden" value="<%=rid %>" name="editrid">
                            </form>
                       <%} %> 
                    </tbody>
                   
                    
                   <%--  <% boolean editSuccess = (boolean) request.getAttribute("editSuccess"); 
                    if (editSuccess ) {
                    %>
                    <script>
                    alert("     Your Update quizes are successful!!!    ")
                    </script>
                    <%} else{%>
                    <script>
                    alert("    Please Try Again!!!   ")
                    </script>
                    <%} %> --%>
                </thead>
            </table>
           
        </div><br>
        <div class="table-container" >
        
        
         
            <table id="truefalse">
             <%truefalseDao tfDao=new truefalseDao();
            List<truefalse> truefalseList=tfDao.getTrueFalseByParagraphId(rid);
            %>
                <thead>
                    <tr>
                        <th>
                       
                            True/False Questions
                        </th>
                       
                        <th style="width: 12px; padding: -12px;">
                            Correct Answer
                        </th>
                        <th>Edit</th>
                    </tr>
                    <tbody>
                     <% 
                    for(truefalse t:truefalseList){ %>
                    <form action="TrueFalseEditServlet" method="post">
                        <tr>
                            <td>
                                <textarea name="truefalsequestion" id="" cols="40" rows=""> <%=t.getQuestion() %></textarea>
                            </td>
                            <td>  <textarea name="truefalseCorrect" id="" cols="40" rows=""><%=t.getCorrectAnswer() %></textarea></td>
                            <input type="hidden" value="<%=t.getTrueFalseId() %>" name="truefalseid">
                             <input type="hidden" value="<%=rid %>" name="editrid">
                            <td><input type="submit" value="Edit" name="Edit" ></td>
                        </tr>
                        </form>
                        <%} %>
                    </tbody>
                    
                </thead>
            </table>
            
        </div><br>
        <div class="table-container" >
         
            <table id="blank">
              <%blankDao bDao=new blankDao();
            List<blank> blankList=bDao.getblankByParagraphId(rid);%>
                <thead>
                
                    <tr>
                        <th>
                            Blank Questions
                        </th>
                        
                        <th>
                            Correct Answer
                        </th>
                        <th>Edit</th>
                    </tr>
                    <tbody>
                    <% 
                    for(blank b:blankList){ %>
                    <form action="BlankEditServlet" method="post">
                        <tr>
                            <td>
                                <textarea name="blankQuestion" id="" cols="40" rows=""><%=b.getQuestion() %></textarea>
                            </td>
                           
                           
                            <td>  <textarea name="blankCorrectAnswer" id="" cols="40" rows=""><%=b.getCorrectAnswer() %></textarea></td>
                              <input type="hidden" value="<%=b.getBlankId() %>" name="blankid">
                               <input type="hidden" value="<%=rid %>" name="editrid">
                            <td><input type="submit" value="Edit" name="Edit" ></td>
                        </tr>
                         </form>
                         <%} %>
                    </tbody>
                    
                </thead>
            </table>
           
        </div>
          </div>
        </div>
    </div>
    <script>
                         
        function multi(){
            var btnmulti=document.getElementById("multiple");
        var btntf=document.getElementById("truefalse");
        var btnblank=document.getElementById("blank");
          var choose=document.getElementById("choose");
          choose.style.display="block";  
            btnmulti.style.display="block";
            btntf.style.display="none";
            btnblank.style.display="none";
            
        }
        function tf(){
            var btnmulti=document.getElementById("multiple");
        var btntf=document.getElementById("truefalse");
        var btnblank=document.getElementById("blank");
        var question=document.getElementById("choose");
        
          question.style.display="block";  
            btnmulti.style.display="none";
            btntf.style.display="block";
            btnblank.style.display="none";
          
        }
        function blank(){
            var btnmulti=document.getElementById("multiple");
        var btntf=document.getElementById("truefalse");
        var btnblank=document.getElementById("blank");
        var question=document.getElementById("choose");
      
          question.style.display="block";  
            btnmulti.style.display="none";
            btntf.style.display="none";
            btnblank.style.display="block";
        }
     
    </script>
</body>
</html>