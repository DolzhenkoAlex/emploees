<%-- 
	Document   : roles.jsp
	Create on  : 27.02.2023
	Author     : Dolzhenko A.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%--
	Внимание это подключение JSLT для jakarta
    используется вместо
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    используется  <%@ taglib prefix="c" uri="jakarta.tags.core" %>
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Role"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">


<title>Должности</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Roles</title>
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
							<th scope="col">Редактировать</th>
							<th scope="col">Удалить</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="role" items="${roles}">
							<tr>
								<td>${role.getId()}</td>
								<td>${role.getNamerole()}</td>
								<td width="20"><a
									href='<c:url value="/editrole?id=${role.getId()}" />'
									role="button" class="btn btn-outline-primary"> <img
										alt="Редактировать" src="images/icon-edit.png"></a></td>
								<td width="20"><a
									href='<c:url value="/deleterole?id=${role.getId()}" />'
									role="button" class="btn btn-outline-primary"> <img
										alt="Удалить" src="images/icon-delete.png"></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</aside>
		</section>
		<section>
			<article>
				<h3>Добавить должность</h3>
				<div class="text-article">
					<form method="POST" action="">
						<br>
						<br>
						<div class="mb-3 row">
							<label for="namerole" class="col-sm-3 col-form-label">Должность</label>
							<div class="col-sm-6">
								<input type="text" name="namerole" class="form-control"
									id="staticRole" />
							</div>
						</div>
						<p>
							<br> <br> <br> <br> <br>
							<br> <br> <br>
							<button type="submit" class="btn btn-primary">Добавить</button>
							<br>
						</p>
					</form>
				</div>
			</article>
			<jsp:include page="/WEB-INF/jspf/footer.jsp" />
		</section>
	</div>
</body>
</html>