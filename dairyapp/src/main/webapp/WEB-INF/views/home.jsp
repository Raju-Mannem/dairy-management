<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>">
</head>
<body>
	<div>
		<div class="top">
			<img alt="dairy book image" id="dairyimg" src="<c:url value="/resources/images/dairy.jpeg" />">
			<p>Dairy App</p>
			
		</div><br/><br/><hr/>
	
		<div class="firstdiv">
			<img alt="dairy book image" src="<c:url value="/resources/images/dairy.jpeg" />">
		</div>
		<div class="seconddiv">
			<h1>LOGIN HERE</h1>
			<form method="post" action="login">
				<label for="username">username : </label>
				<input type="text" name="username" placeholder="enter username" required />
				<br/><br/>
				<label for="username">password : </label>
				<input type="password" name="password" placeholder="enter password" required />
				<br/><br/>
				<button type="submit">Login</button>
			</form><br/>
			New user? <a href="./register">Register</a> Now
		</div>
		
	</div>
</body>
</html>