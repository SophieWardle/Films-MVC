<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Films</title>
<link rel="stylesheet" href="scripts/index.css">
</head>
<body>
<jsp:include page="/includes/header.jsp"/>

<div class="search-main">
	<h2> Search For A Film</h2>
	<form action="search-film-servlet" method="POST">
	<label for="userInput">Search for </label>
	<input type="search" placeholder="" name="userInput">
	<label for="searchOptions">in:</label>
	<select name="searchOptions" id="searchOptions">
		<option value="title">Title</option>
		<option value="year">Year</option>
		<option value="director">Director</option>
		<option value="stars">Stars</option>
	</select>
	<input type="submit" value="Search">
</form>
</div>


</body>
</html>