<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Entry page</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>">
</head>
<body>
	<div>
		<div class="top">
			<img alt="dairy book image" id="dairyimg" src="<c:url value="/resources/images/dairy.jpeg" />">
			<p>Dairy App</p>
			
		</div><br/><br/><hr/>
		
		<div class="firstdiv">
		<h2>welcome <span style="color:steelblue">${user.username}</span> </h2>
			<img alt="dairy book image" src="<c:url value="/resources/images/dairy.jpeg" />">
		</div>
		<div class="seconddiv">
			<h1>Add Entry HERE</h1>
			<form method="POST" action="./saveentry">
				<label for="entrydate">date : </label>
				<input type="date" name="entrydate" required />
				<br/><br/>
				<label for="description">description : </label>
				<textarea rows="10" cols="21" name="description" placeholder="enter desc" required ></textarea>
				<input type="hidden" name="userid" value="${user.id}" />
				<br/><br/>
				<button type="submit">save</button>
			</form><br/>
		</div>
		
	</div>
</body>
</html>