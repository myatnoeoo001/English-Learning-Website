<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.*,controller.*,model.*,java.util.*" %>
<% truefalseDao tfdao=new truefalseDao();
int value =Integer.parseInt(request.getParameter("data-value").toString());
System.out.println("Value: " + value);
List<truefalse> tf=tfdao.getAllTrueFalseInfo();
request.setAttribute("tf", tf);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>For TrueFalse</h1>

<input type="radio" value="true">True
<input type="radio" value="false">False
</body>
</html>