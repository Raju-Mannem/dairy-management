<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>userhome page</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>">
</head>
<body>
	<div>
		<div class="top">
			<img alt="dairy book image" id="dairyimg" src="<c:url value="/resources/images/dairy.jpeg" />">
			<p>Dairy App</p>
			
		</div><br/><br/><hr/>
		<div class="bodydiv">
	
		<h2>welcome <span style="color:steelblue">${user.username}</span> </h2>
		<h2 ><a href="./logout" id="signout" style="float: right;">signout</a></h2>
		
		<span class="userhomep">List of past Entries</span>
		<a href="./addentry" style="text-decoration: none;"><input type="button" class="addentrybtn" value="Add Entry" ></a>
		
		<table style="text-align: center;">
			<tr><th colspan="1">Date</th><th colspan="3">Actions</th></tr>
			<c:if test="${entrieslist.size()==0}">
			<tr><td colspan="4">You have "0" Entries</td></tr>
			</c:if>
			
			<c:forEach items="${entrieslist}" var="e">
				<tr><td><fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy" /> </td>
				<td><a href="./viewentry?id=${e.id}">View</a></td>
				<td><a href="./updateentry?id=${e.id}">Update</a></td>
				<td><a href="./deleteentry?id=${e.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		
	</div>
	
</body>
</html>