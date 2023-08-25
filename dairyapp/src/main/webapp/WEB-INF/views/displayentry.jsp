<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
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
			<h1>Entry</h1>
			date			: ${entry.entrydate}
			<br/><br/>
			description		: ${entry.description}
			<br/> <br/>
			<a href="./userhomepage"><button type="button">Back TO Home</button></a>
		</div>
		
	</div>
</body>
</html>