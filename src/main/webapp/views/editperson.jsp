<%-- 
	Document   : editperson.jps
	Create on  : 25.04.2023
	Author     : Dolzhenko A.
--%>

<%@ page language="java" contentType="text/html" 
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<%@ page import="domain.Person"%>
<%@ page import="domain.Role"%>

    
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">

<title>Редактирование данных сотрудника</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery -->
<script defer src="js/jquery.min.js"></script>
<!-- Bootstrap JS + Popper JS -->
<script defer src="js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/jspf/header.jsp" />
	<div id="main">
		<aside class="leftAside">
			<h3>Список сотрудников</h3>
			<table class="table table-sm" id="table-info">
				<thead>
					<tr>
						<th>Код</th>
						<th>Фамилия</th>
						<th>Имя</th>
						<th>Должность</th>
						<th>Эл. почта</th>
						<th>Телефон</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="person" items="${persons}">
						<tr>
							<td>${person.getId()}</td>
							<td>${person.getLastName()}</td>
							<td>${person.getFirstName()}</td>
							<td>${person.getRole()}</td>
							<td>${person.getPhone()}</td>
							<td>${person.getEmail()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</aside>
		<section>
			<article>
				<h3>Редактирование данных </h3>
				<div class="text-article">
					<form method="POST" action="">
						<div class="mb-3 row">
							<label for="idperson" class="col-sm-4 col-form-label">Код сотрудника</label>
								<div class="col-sm-7"> 
									<input type="text" class="form-control" readonly
									value="${personsEdit[0].getId()}" />
								</div>
						</div>
						<div class="mb-3 row">
							<label for="lastname" class="col-sm-4 col-form-label">Фамилия</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="staticLastname"
									name="lastname" value="${personsEdit[0].getLastName()}"/>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="firstname" class="col-sm-4 col-form-label">Имя</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="staticFirstname"
									name="firstname" value="${personsEdit[0].getFirstName()}"/>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="rolename" class="col-sm-4 col-form-label">Должность</label>
							<div class="col-sm-7">
								<select name="role" class="form-control">
									<option >Выберите должность</option>
									<c:forEach var="role" items="${roles}">
										<option value="${role}">
											<c:out value="${role.getNamerole()}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="phone" class="col-sm-4 col-form-label">Телефон</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="staticphone"
									name="phone" value="${personsEdit[0].getPhone()}"/>
							</div>
						</div>
						<div class="mb-3 row">
							<label for="email" class="col-sm-4 col-form-label">Эл.почта </label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="staticemail"
									name="email" value="${personsEdit[0].getEmail()}"/>
							</div>
						</div>
						<p>
							<button type="submit" class="btn btn-primary">Редактировать</button>
							<a href='<c:url value="/persons" />' role="button"
								class="btn btn-secondary">Отменить/Возврат</a>
						</p>
					</form>

				</div>
			</article>
		</section>
	</div>
	<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>