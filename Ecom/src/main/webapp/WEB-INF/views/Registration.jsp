<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/Registration">
  <div class="container">
    <h1>Registration form</h1>

<label> Name: </label><br>       
<input type="text" name="name" /> <br>
<label> Password: </label><br> 
<input type="password" name="password" /> <br>
<label> Age: </label><br>         
<input type="number" name="age" /> <br>
<label> Location: </label><br>         
<input type="text" name="location" /> <br><br>  
<button type="submit">submit</button>
 </div> 
</form>

<h1>Registration Details</h1>
<a href="details">click here</a>


</body>
</html>