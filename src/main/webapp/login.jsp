<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import='com.serv.dao.Database_con'%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 #container{
  position:absolute;
  top:30%;
  left:30%;
  background-color:blue;
  display:inline-block;
  width:40%;
  height:45vh;
  align-items: center;
 }
 h1{
  text-align: center;
  font-size: 2em;
  color:white;
 }
form{
  text-align: center;
  font-size: 1.3em;
  color:white;
 }
 input{
 margin:0em 0em 1em 0em;
 }
 button{
 margin:1em;
 }
 
 a{
 text-decoration: none;
 color:gray;
 }

</style>

</head>
<body>
<div id=container>
<h1>Login</h1>
<form action="login.jsp">
  UserName: <input name='name' type="text" ><br>
  Password: <input name='pass' type="text" ><br>
  <button>Login</button><br>
  <a href="index.html">Back to Home</a>
</form>
</div>

<%
  String name=request.getParameter("name");
  String pass=request.getParameter("pass");
  
  Database_con obj=new Database_con();

  if(obj.varifyUser(name, pass)){
	  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
	  rd.forward(request, response);
  }
%>
</body>
</html>