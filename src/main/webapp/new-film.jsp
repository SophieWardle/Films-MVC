<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="scripts/index.css">
</head>
<body>

<jsp:include page="/includes/header.jsp"/>

<div class="new-film-main">
	
	<h2>Add A New Film</h2>
	<form action="insert-film-servlet" method="POST">
		<label id="title">Title:</label>
		<input type="text" name="title">
		<label id="year">Year:</label>
		<input type="text" name="year"> 
		<label id="director">Director:</label>
		<input type="text" name="director">
		<label id="stars">Stars:</label>
		<input type="text" name="stars">
		<label id="review">Review:</label>
		<input type="text" name="review">
		<input type="submit" value="Add">
	</form>
	
</div>

</body>
</html>