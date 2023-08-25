<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Entry page</title>
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
			<h1>Update Entry HERE</h1>
			<form method="POST" action="./processupdateentry">
				<label for="entrydate">date : </label>
				<input type="text" name="entrydate" value="<fmt:formatDate value="${entry.entrydate}" pattern="yyyy-MM-dd"/>" readonly required />
				<br/><br/>
				<label for="description">description : </label>
				<textarea rows="10" cols="21" name="description" placeholder="enter desc" required >${entry.description}</textarea>
				<input type="hidden" name="userid" value="${user.id}" />
				<input type="hidden" name="id" value="${entry.id}" />
				<br/><br/>
				<button type="submit">update</button>
			</form><br/>
		</div>
		
	</div>
</body>
</html>