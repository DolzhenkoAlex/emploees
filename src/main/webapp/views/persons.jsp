<%-- 
	Document   : index
	Create on  : 27.02.2023
	Author     : Dolzhenko A.
--%>

<%@ page language="java" contentType="text/html" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title>Сотрудники</title>
	<head>
		<meta charset="UTF-8">
		<title>Persons</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jspf/header.jsp" />
		<div id="main">
			<aside class="leftAside">
				<h3>Список сотрудников</h3>
				<table>
					<tr>
						<th>Фамилия</th>
						<th>Имя</th>
						<th>Должность</th>
						<th>Телефон</th>
						<th>Эл. почта</th>
					</tr>
					<tr>
						<td>Иванов</td>
						<td>Иван</td>
						<td>директор</td>
						<td width="150">+7 (961)-289-55-24</td>
						<td>ivanov@mail.ru</td>
					</tr>
					<tr>
						<td>Петров</td>
						<td>Петр</td>
						<td>бухгалтер</td>
						<td>+7 (961)-289-44-39</td>
						<td>petrov@mail.ru</td>
					</tr>
					<tr>
						<td>Сидоров</td>
						<td>Сидор</td>
						<td>менеджер</td>
						<td>+7 (961)-289-33-57</td>
						<td>sidorov@mail.ru</td>
					</tr>
				</table>
			</aside>
			<section>
				<article>
					<h3>Данные по сотруднику</h3>
					<div class="text-article">
						<form method="POST" action="">
						<p>
							<label for="lastname">Фамилия</label>
							<input type="text" name="lastname" />
						</p>
						<p>
							<label for="firstname">Имя</label>
							<input type="text" name="firstname" />
						</p>
						<p>
							<label for="rolename">Должность</label>
							<input type="text" name="rolename" />
						</p>
						<p>
							<label for="phone">Телефон</label>
							<input type="text" name="phone" />
						</p>
						<p>
							<label for="email">Эл. почта </label>
							<input type="text" name="email" />
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