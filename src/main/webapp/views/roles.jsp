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
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page import="domain.Role"%>
<%@ page import="controller.RoleServlet"%>

<% 
Role r1 = new Role(1l, "директор");
Role r2 = new Role(2l, "бухгалтер");
Role r3= new Role(3l, "менеджер");
Role r4 = new Role(4l, "маркетолог");
Role[] roles = new Role[]{r1, r2, r3, r4};
int length = roles.length;
pageContext.setAttribute("roles", roles);
%>

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
								<td><c:out value="${role.getId()}"></c:out> </td>
								<td><c:out value="${role.getNamerole()}"></c:out> </td>
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
							<label for="namerole">Должность</label> <input type="text"
								name="namerole" />
						</p>
					</form>
					<p>
						<button type="submit">Добавить</button>
					</p>
				</div>
			</article>
		</section>
	</div>
	<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>