<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Film" %>

	<jsp:include page="/includes/header.jsp"/>

	<div class="films-main">
		<table class="films-table">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Year</th>
			<th>Director</th>
			<th>Stars</th>
			<th>Review</th>
		</tr>
			<c:forEach items="${films}" var="f">
		<tr>
			<td>${f.id}</td>
			<td>${f.title}</td>
			<td>${f.year}</td>
			<td>${f.director}</td>
			<td>${f.stars}</td>
			<td>${f.review}</td>
			<td>
				<a href="./update-film-servlet?id=${f.getId()}" id="updateBtn">Update</a>
				<a href="./delete-film-servlet?id=${f.getId()}" 
				onClick="return confirm('Are You Sure You Wish To Delete This Film?')" id="deleteBtn">Delete</a>
			</td>
		</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>