<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin</title>
</head>
<link rel="stylesheet" href="./style/style.css" type="text/css">
<body>
	<header>
		<span class="head-content">Movie Cruiser</span> <span><img
			src="./images/logo.png"></span> <span>
			<nav>
				<a class="header-link" href="ShowMovieListAdmin">Movies</a>
			</nav>
		</span>
	</header>
	<div>
		<h1>Movies</h1>

		<table>
			<tr>
				<th class="left-side cell-large">Title</th>
				<th class="right-side cell-large">Box Office</th>
				<th class="middle cell-small">Active</th>
				<th class="middle cell-medium">Date of Launch</th>
				<th class="middle cell-medium">Genre</th>
				<th class="middle cell-small">Has Teaser</th>
				<th class="middle cell-small">Action</th>
			</tr>
			<c:forEach items="${movieList}" var="movie">
				<tr>
					<td class="left-side"><c:out value="${movie.title}"></c:out></td>
					<td class="right-side"><fmt:formatNumber
							value="${movie.boxOffice}" type="currency" /></td>
					<td class="middle"><c:out value="${movie.active?'Yes':'No'}"></c:out></td>
					<td class="middle"><fmt:formatDate pattern="dd/MM/yyyy"
							value="${movie.dateOfLaunch}" /></td>
					<td class="middle"><c:out value="${movie.genre}"></c:out></td>
					<td class="middle"><c:out
							value="${movie.hasTeaser?'Yes':'No'}"></c:out></td>
					<td class="middle">
						<nav>
							<a class="action-note"
								href="ShowEditMovie?movieid=${movie.movieid}">Edit</a>
						</nav>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<footer>
		<span class="footer-content">Copyright &copy 2019</span>
	</footer>
</body>
</html>