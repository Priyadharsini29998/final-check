<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Movie-Admin</title>
</head>
<link rel="stylesheet" href="./style/style.css" type="text/css">
<script src="./js/script.js" type="text/javascript"></script>
<body>
	<header> <span class="head-content">Movie Cruiser</span> <span><img
		src="./images/logo.png"></span> <span> <nav> <a
			class="header-link" href="ShowMovieListAdmin">Movies</a> </nav>
	</span> </header>
	<div>
		<h1>Edit Movie</h1>
		<form name="movie-cruiser" method="post"
			action="EditMovie?movieid=${movie.movieid}"
			onSubmit="return validate()">
			<table>
				<tr colspan="4">
					<td><label for="txtTitle">Title</label></td>
				</tr>

				<tr>
					<td colspan="4"><input type="text" class="extend-cell"
						id="txtTitle" name="txtTitle" value="${movie.title}"></td>
				</tr>
				<tr>
					<td><label for="txtGross">Gross ($)</label></td>
					<td>Active</td>
					<td><label for="txtLaunch">Date of Launch</label></td>
					<td><label for="drplist">Genre</label></td>
				</tr>
				<tr>
					<td><input type="text" class="right-side" id="txtGross"
						name="txtGross" value="<fmt:formatNumber
							value="${movie.boxOffice}" type="currency" />" /></td>
					<td><input type="radio" name="rdoActive" id="rdoyes"
						value="Yes" <c:if test="${movie.active eq 'true'}" Checked></c:if>>
						<label for="rdoyes">Yes</label> <input type="radio" id="rdono"
						name="rdoActive" value="No"
						<c:if test="${movie.active eq 'false'}"  Checked></c:if>>
						<label for="rdono">No</label></td>
					<td><input type="text" id="txtLaunch" name="txtLaunch"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${movie.dateOfLaunch}"/>"></td>
					<td><select name="genre" id="drplist">
							<option value="${movie.genre}">${movie.genre}</option>

							<option value="Superhero">Superhero</option>

							<option value="Romance">Romance</option>

							<option value="Comedy">Comedy</option>

							<option value="Adventure">Adventure</option>

							<option value="Thriller">Thriller</option>
					</select></td>
				<tr colspan="2">
					<td><input type="checkbox" id="chkVal" name="checkval"
						value="Yes"
						<c:if test="${movie.hasTeaser eq 'true'}" Checked></c:if>>
						<label for="chkVal">Has Teaser</label></td>
				</tr>
				<tr colspan="2">
					<td><input type="submit" class="btn-style" value="Save"
						name="btnSave" /></td>
				</tr>
			</table>
		</form>
	</div>
	<footer>
	<h4>Copyright &copy 2019</h4>
	</footer>

</body>
</html>