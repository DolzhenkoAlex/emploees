<%-- 
	Document   : index
	Create on  : 27.02.2023
	Author     : Dolzhenko A.
--%>


<%@page language="java" contentType="text/html" 
	 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>Главная страница</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jspf/header.jsp" />
		<div id="main">
			<h2>Функции системы</h2>
			<ul>
				<%-- 
				<li><a href="/employees/views/persons.jsp">Сотрудники</a>
				--%>
				<li><a href="/employees/persons">Сотрудники</a>
				<li><a href="/employees/roles">Должности</a>
			</ul>
		</div>
		<jsp:include page="/WEB-INF/jspf/footer.jsp" />
	</body>
</html>