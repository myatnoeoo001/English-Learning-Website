<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.*,dao.*,controller.*,java.util.*;" %>
<% readingDao rdo=new readingDao();
  choiceDao cdao=new choiceDao();
  truefalseDao tfdao=new truefalseDao();
  blankDao bdao=new blankDao();
  reading read=rdo.levelTest1();
  
  List<choice> clist=cdao.choicelevelTest1();
  List<truefalse> tflist=tfdao.truefalselevelTest1();
  List<blank> blist=bdao.blanklevelTest1();
%>
    
<!Doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Conpatible" content="IE=edge">
<meta name="viewpoint" content="width=device-width,initial-scale=1.0">
<title>Complete Responsive Flower Website Design </title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" href="./css/userclickview1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script>
</script>
</head>
<body>
<header>
<input type="checkbox" name="" id="toggler">
<label for="toggler" class="fas fa-bars"></label>
<a href="#" class="logo" style="text-decoration: none;"> CRUDLIK </a> 
<nav class="navbar">
	<a href="user.jsp" onclick="basic()" style="text-decoration: none;">Home</a>


</nav>

</header>

	<section class="products" id="basic">
		<h1 class="heading" style="margin-top: 45px;"> Basic</h1>
		<div class="box-container">
			
						
						<h1 style="font-size: 34px;"></h1>
                        
                            
                                <h1><%= read.getTitle() %></h1>
                                <h3><%= read.getDescription() %></h3>
                                <%
			byte[] paragraphBytes = read.getParagraph().getBytes(1, (int) read.getParagraph().length());
			String paragraphBase64 = Base64.getEncoder().encodeToString(paragraphBytes);
			%>
<object data="data:application/pdf;base64,<%= paragraphBase64 %>" type="application/pdf" width="90%" height="500px">
</object>
                                
                            <div class="question">
                                <!-- Example single danger button -->
                    <div class="btn-group">
                        <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                          Choose questions type
                        </button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" id="1" onclick="multi()" href="#">MultiPle Choice</a></li>
                          <li><a class="dropdown-item" id="2" onclick="tf()" href="#">True/False</a></li>
                          <li><a class="dropdown-item" id="3" onclick="blank()" href="#">Blank</a></li>
                          
                        </ul>
                      </div>
                      
                      <form action="leveltestServlet" method="post">
                                <div class="questionbox" style="margin-top: 12px; font-size: 15px;">
                                    <div id="questionshow">
                                    <div id="multiple">
                                    <%
for (choice c : clist) {
%>
    <div>
        <p data-question-id="<%= c.getChoiceId()%>"><%= c.getQuestion() %></p>
       
       <input type="radio"   name="answerc_<%= c.getChoiceId() %>"   value="<%= c.getOption1()%>"> <%= c.getOption1()%>
        <% System.out.println(c.getChoiceId()); %>
        <input type="radio"  name="answerc_<%= c.getChoiceId() %>"   value="<%= c.getOption2()%>"> <%= c.getOption2()%>
        <input type="radio"  name="answerc_<%= c.getChoiceId() %>"  value="<%= c.getOption3()%>"> <%= c.getOption3()%>
        <input type="radio"  name="answerc_<%= c.getChoiceId() %>"   value="<%= c.getOption4()%>"> <%= c.getOption4()%>
     <hr>
    </div>
<%
}
%>
     <div class="button" style="line-height: 53px;" id="button">
   <input type="button" class="btn btn-outline-info"  id="btnnext" onclick="buttonnext1()" style="  margin-left: 22px; width: 88px;" value="next">
                                        
                                    </div>
                                    </div>
                                    <div id="truefalse">
                                        <%
for (truefalse tf : tflist) {
%>
    <div>
        <p data-question-id="<%= tf.getTrueFalseId()%>"><%= tf.getQuestion() %></p>
       
       <input type="radio"   name="answer_<%= tf.getTrueFalseId() %>"   value="true"> True
        <% System.out.println(tf.getTrueFalseId()); %>
        <input type="radio"  name="answer_<%= tf.getTrueFalseId() %>"  value="false"> False
    </div><hr>
<%
}
%>                      
                          <div class="button" style="line-height: 53px;" id="button">
   <input type="button" class="btn btn-outline-info"  id="btnnext" onclick="buttonnext2()" style="  margin-left: 22px; width: 88px;" value="next">
                                        
                                    </div>       
                                       
                                    </div>
                                    <div id="blank">
                                        <%
for (blank b:blist) {
%>
    <div>
        <p data-question-id="<%= b.getBlankId()%>"><%= b.getQuestion() %></p>
       
       Answer:<input type="text"   name="answerb_<%= b.getBlankId() %>">
        <% System.out.println(b.getBlankId()); %>
        <hr>
    </div>
<%
}
%> <div>
<input type="submit" value="Submit">
</div>
                                    </div>
                                    </div>
                                   
                                </div>
                                </form>
                            </div>
                        
                        <script>
                         
                            function multi(){
                                var btnmulti=document.getElementById("multiple");
                            var btntf=document.getElementById("truefalse");
                            var btnblank=document.getElementById("blank");
                              var question=document.getElementById("questionshow");
                              var button=document.getElementById("button");
                              button.style.display="block";
                              question.style.display="block";  
                                btnmulti.style.display="block";
                                btntf.style.display="none";
                                btnblank.style.display="none";
                                
                            }
                            function tf(){
                                var btnmulti=document.getElementById("multiple");
                            var btntf=document.getElementById("truefalse");
                            var btnblank=document.getElementById("blank");
                            var question=document.getElementById("questionshow");
                            var button=document.getElementById("button");
                              button.style.display="block";
                              question.style.display="block";  
                                btnmulti.style.display="none";
                                btntf.style.display="block";
                                btnblank.style.display="none";
                              
                            }
                            function blank(){
                                var btnmulti=document.getElementById("multiple");
                            var btntf=document.getElementById("truefalse");
                            var btnblank=document.getElementById("blank");
                            var question=document.getElementById("questionshow");
                            var button=document.getElementById("button");
                              button.style.display="block";
                              question.style.display="block";  
                                btnmulti.style.display="none";
                                btntf.style.display="none";
                                btnblank.style.display="block";
                            }
                            function buttonnext1(){
                                var btnmulti=document.getElementById("multiple");
                            var btntf=document.getElementById("truefalse");
                            var btnblank=document.getElementById("blank");
                            var question=document.getElementById("questionshow");
                            var button=document.getElementById("button");
                              button.style.display="block";
                              question.style.display="block";  
                                btnmulti.style.display="none";
                                btntf.style.display="block";
                                btnblank.style.display="none";
                            }
                            function buttonnext2(){
                                var btnmulti=document.getElementById("multiple");
                            var btntf=document.getElementById("truefalse");
                            var btnblank=document.getElementById("blank");
                            var question=document.getElementById("questionshow");
                            
                              question.style.display="block";  
                                btnmulti.style.display="none";
                                btntf.style.display="none";
                                btnblank.style.display="block";
                            }
                        </script>
						</div>
						
				
		</section>
		
		
	
</body>
</html>

    