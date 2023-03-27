<%-- 
	Document   : index
	Create on  : 27.02.2023
	Author     : Dolzhenko A.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<aside class="leftAside">
				<h3>Список должностей</h3>
				<table>
					<tr>
						<th>Id</th>
						<th>Должность</th>
					</tr>
					<tr>
						<td align="center">1</td>
						<td align="center">директор</td>
					</tr>
					<tr>
						<td align="center">2</td>
						<td align="center">бухгалтер</td>
					</tr>
					<tr>
						<td align="center">3</td>
						<td align="center">менеджер</td>
					</tr>
				</table>
			</aside>
			<section>
				<article>
					<h3>Наименование должности</h3>
					<div class="text-article">
						<form  method="POST" action="">
						<p>
							<label for="namerole">Должность</label>
							<input type="text" name="namerole" />
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