<%-- 
	Document   : deleteroles.jsp
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
<title>Удаление должности</title>

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
				<h3>Удаление должности</h3>
				<div class="text-article">
					<form method="POST" action="">
						<br> <br> 
						<div class="mb-3 row">
							<label for="idrole" class="col-sm-4 col-form-label">Код должности</label>
								<div class="col-sm-6"> 
									<input type="text" class="form-control" readonly
									value="${rolesDelete[0].getId()}" />
								</div>
						</div>
						<div class="mb-3 row">
							<label for="namerole" class="col-sm-4 col-form-label">Должность</label> 
							<div class="col-sm-6">
								<input type="text" class="form-control" name="namerole" readonly
								value="${rolesDelete[0].getNamerole()}" />
							</div>
						</div>
							<br> <br> <br> <br> <br>
							<button type="submit" class="btn btn-primary">Удалить</button>
							<a href='<c:url value="/roles" />' role="button"
								class="btn btn-secondary">Отменить/Возврат</a>
					</form>
				</div>
			</article>
			<jsp:include page="/WEB-INF/jspf/footer.jsp" />
		</section>
	</div>
</body>
</html>