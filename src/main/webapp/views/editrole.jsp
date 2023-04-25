<%-- 
	Document   : editroles.jsp
	Create on  : 25.04.2023
	Author     : Dolzhenko A.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Role"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">

<head>
<meta charset="UTF-8">
<title>Edit roles</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery -->
<script defer src="js/jquery.min.js"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

</head>
<body>
	<jsp:include page="/WEB-INF/jspf/header.jsp" />
	<div id="main">
		<section>
			<aside class="leftAside">
				<h3>Список должностей</h3>
				<table class="table table-sm" id="table-info">
					<thead>
						<tr>
							<th scope="col">Код</th>
							<th scope="col">Должность</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="role" items="${roles}">
							<tr>
								<td>${role.getId()}</td>
								<td>${role.getNamerole()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</aside>
		</section>
		<section>
			<article>
				<h3>Редактирование должности</h3>
				<div class="text-article">
					<form method="POST" action="">
						<p>
							<br /> <label for="idrole" class="col-form-label">Код
								должности</label> <input type="text" readonly
								value="${rolesEdit[0].getId()}" />
						</p>
						<br> <label for="namerole">Должность</label> <input
							type="text" name="namerole" value="${rolesEdit[0].getNamerole()}" />
						<p>
							<br> <br> <br> <br> <br>
							<br> <br>
							<button type="submit" class="btn btn-primary">Редактировать</button>
							<a href='<c:url value="/roles" />' role="button"
								class="btn btn-secondary">Отменить</a>
						</p>
					</form>
				</div>
			</article>
			<jsp:include page="/WEB-INF/jspf/footer.jsp" />
		</section>
	</div>
</body>
</html>