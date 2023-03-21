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
				<h2>Список должностей</h2>
				<ul>
					<li><a>директор</a></li>
					<li><a>бухгалтер</a></li>
					<li><a>менеджер</a></li>
				</ul>
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
							<button type="submit">Отправить</button>
						</p>		
					</div>
				</article>
			</section>
		</div>
		<jsp:include page="/WEB-INF/jspf/footer.jsp" />
	</body>
</html>