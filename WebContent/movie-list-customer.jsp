<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customer Movie List</title>
</head>
<link rel="stylesheet" href="./style/style.css" type="text/css">
<body>
	<header> <span class="head-content">Movie Cruiser</span> <span><img
		src="./images/logo.png"></span> <span> <nav> <a
			class="header-link" href="ShowFavorite">Favorites</a> <a
			class="header-link" href="ShowMovieListCustomer">Movies</a> </nav>
	</span> </header>
	<div>
		<h1>Movies</h1>
		<h3 class="cust-notify">${msg}</h3>
		<table>
			<tr>
				<th class="left-side cell-large">Title</th>
				<th class="right-side cell-large">Box Office</th>
				<th class="middle cell-medium">Genre</th>
				<th class="middle cell-medium">Has Teaser</th>
				<th class="middle cell-large">Action</th>
			</tr>
			<tr>

				<c:forEach items="${movie}" var="movie">
					<tr>
						<td class="left-side"><c:out value="${movie.title}"></c:out></td>
						<td class="right-side"><c:out value="${movie.boxOffice}"></c:out></td>
						<td class="middle"><c:out value="${movie.genre}"></c:out></td>
						<td class="middle"><c:out
								value="${movie.hasTeaser?'Yes':'No'}"></c:out></td>
						<td class="middle"><nav> <a class="action-note"
								href="AddToFavorite?movieid=${movie.movieid}">Add to
								Favorite</a> </nav></td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<footer> <span class="footer-content">Copyright &copy
		2019</span> </footer>
</body>
</html>