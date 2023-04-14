<%-- 
	Document   : index
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
<title>Roles</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jspf/header.jsp" />
	<div id="main">
		<section>
		<aside class="leftAside">
			<h3>Список должностей</h3>
				<table>
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
				<h3>Наименование должности</h3>
				<div class="text-article">
					<form method="POST" action="">
						<p>
							<label for="namerole">Должность</label> 
							<input type="text" name="namerole" />
						</p>
					
					<p>
						<br>
						<br>
						<br>
						<button type="submit">Добавить</button>
					</p>
					</form>
				</div>
			</article>
		</section>
	</div>
	<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>