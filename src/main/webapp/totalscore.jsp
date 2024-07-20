<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Table Box with Different Marks</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
      body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
            font-family: 'Times New Roman', Times, serif;
            
        }
        
        .test {
            /* text-align: center; */
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            justify-content: center;
            width:380px;
            height:250px;
        }

        h2 {
            color: #333;
            font-size: 24px;
            align-items: center;
            text-align: center;
        }

        pre {
            color: #555;
            font-size: 18px;
            line-height: 1.6;
            justify-content: center;
        }

        button[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-left: 80px;
            text-align: center;
            align-items: center;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
       /*  form {
        display: inline;
        margin-right: 10px; /* Adjust the spacing between buttons */
    } */
</style>
</head>

<body>

<% 
		HttpSession s = request.getSession();
		int totalScore = (int) s.getAttribute("totalscore");
		int tfscore=(int) s.getAttribute("tfscore");
		int choicescore=(int) s.getAttribute("cscore");
		int blankscore=(int) s.getAttribute("bscore");
		%>
		<div class="test">
<form action="user.jsp" method="post">
<table style="width:350px;">
    <tr>
        <th style="font-size: 24px;"><h2>Total Score</h2></th>
    </tr>
    <tr>
        <td>Multiple Choice</td>
        <td><%= choicescore %></td>
    </tr>
    <tr>
        <td>True False</td>
        <td><%= tfscore %></td>
    </tr>
    <tr>
        <td>Blank</td>
        <td><%= blankscore %></td>
    </tr>
    <tr>
        <td colspan="2"><hr></td> <!-- Horizontal rule before Total Score -->
    </tr>
    <tr>
        <td>Total Score</td>
        <td><%= totalScore %></td>
    </tr>
    <tr>
        <td colspan="2"><a class="btn btn-primary" href="user.jsp" role="button" style="margin-left:150px;">Done</a></td>
    </tr>
</table>
</form>
</div>
</body>
</html>