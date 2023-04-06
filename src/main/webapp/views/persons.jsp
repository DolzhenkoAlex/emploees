<%-- 
	Document   : index
	Create on  : 27.02.2023
	Author     : Dolzhenko A.
--%>

<%@ page language="java" contentType="text/html" 
    pageEncoding="UTF-8"%>
    
    
<%@ page import="domain.Person"%>
<%@ page import="domain.Role"%>

<%
Role r1 = new Role(1l, "директор");
Role r2 = new Role(2l, "бухгалтер");
Role r3= new Role(3l, "менеджер");
Role r4 = new Role(4l, "маркетолог");
Role[] roles = new Role[]{r1, r2, r3, r4};
int lengthRole = roles.length;

Person p1 = new Person(1l, "Иван","Иванов", "ivanov@mail.ru", "+7 (961)-289-55-24",1l, r1);
Person p2 = new Person(2l, "Петр","Петров", "petrov@mail.ru", "+7 (961)-289-44-39",2l, r2);
Person p3= new Person(3l, "Сидор","Сидоров", "sidorov@mail.ru", "+7 (961)-289-33-57",3l, r3);
Person p4 = new Person(4l, "Иван","Иванов", "ivanov@mail.ru", "+7 (961)-289-44-39",4l, r4);
Person[] persons = new Person[]{p1, p2, p3, p4};
int length = persons.length;
%>

    
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
				<thead>
					<tr>
						<th>Код</th>
						<th>Фамилия</th>
						<th>Имя</th>
						<th>Должность</th>
						<th>Телефон</th>
						<th>Эл. почта</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < length; i++) {
							out.println("<tr>"
							                     +"<td >"+persons[i].getId()+"</td>" 
							                     +"<td >"+persons[i].getLastName()+"</td>"
							                     +"<td >"+persons[i].getFirstName()+"</td>"
							                     +"<td >"+persons[i].getRole()+"</td>"
							                     +"<td >"+persons[i].getPhone()+"</td>"
							                     +"<td >"+persons[i].getEmail()+"</td>"
										 + "</tr>");
						}
					%>
				</tbody>
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
							<select>
								<option disabled>Выберите должность</option>
								
								<%
									for (int i = 0; i < lengthRole; i++) {
										out.println("<option value='"+roles[i].getNamerole()+"'>"
							             + roles[i].getNamerole() 
										 + "</option>");
									} 
								%>
							</select>
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