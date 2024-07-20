<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/multiplechoice.css">
    <script type="text/javascript"></script>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
</head>
<body>
    <div class="sidebar">
       
        <div class="logo">CURDLIK</div>
        <ul class="menu">

            <li class="active">
                <a href="admin.jsp" ><i class="fas fa-tachometer-alt"></i>
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
    
    <% Integer readingId = (Integer) session.getAttribute("readingId");
    System.out.println(readingId);
    %>
     
    <div class="app" style="margin-top:-670px; margin-left:600px;">
      <h1>Multiple Choice</h1> 
    
      <div class="quiz">
         <form action="choiceServlet" method="post" >
        <div id="answer-buttons">
            <p>Question</p>
           <textarea name="question" class="btn"></textarea>
           <p>Option 1</p>
           <input type="text" name="option1" class="btn">
           <p>Option 2</p>
           <input type="text" name="option2" class="btn">
           <p>Option 3</p>
           <input type="text" name="option3" class="btn">
           <p>Option 4</p>
           <input type="text" name="option4" class="btn">
           <p>Correct Answer</p>
           <input type="text" name="correctAnswer" class="btn">
        </div>
        <button id="next-btn1" onclick="prev()" >Previous</button>
        <button  type="submit" id="next-btn2">Add</button>
        <input type="button" id="next-btn3" onclick="next()" value="Next">
        </form> 
       
      </div>
     
    </div>
     
    <script>
    function prev() {
        window.history.back();
    }

    function next() {
        window.location.href = "truefalse.jsp";
    }
</script>
    
</body>
</html>