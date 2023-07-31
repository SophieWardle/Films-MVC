<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/includes/header.jsp"/>

<div class="update-film">
	<h2>Update the film: <span>${film.getTitle()}</span></h2>
	<form action="update-film-servlet" method="POST">
	<label id="title">Title: </label>
	<input type="text" id="title" name="title" value="${film.getTitle()}"><br>
	<label id="year">Year: </label>
	<input type="text" id="year" name="year" value="${film.getYear()}"><br>
	<label id="director">Director: </label>
	<input type="text" id="director" name="director" value="${film.getDirector()}"><br>
	<label id="stars">Stars: </label>
	<input type="text" id="stars" name="stars" value="${film.getStars()}"><br>
	<label id="review">Review: </label>
	<input type="text" id="review" name="review" value="${film.getReview()}"><br>
	<input type="text" name="id" value="${film.getId()}" style="visibility:hidden">
	<input type="submit" name="submit" value="Update">
	</form>
</div>
</body>
</html>