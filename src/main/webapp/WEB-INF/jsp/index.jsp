<%@page import="java.util.*"%>
<%@page import="com.yesee.ntp.model.bean.UserInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/onClick.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Form Handling</title>
</head>
<body>

	<div id="container" class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">會員登入</h2>

			<label for="username" class="sr-only">Username</label> <input
				type="text" id="username" class="form-control" placeholder="帳號"
				required autofocus> <label for=password class=sr-only>Password</label>
			<input type="password" id="password" class="form-control"
				placeholder="密碼" required> <input type="button"
				class="btn btn-lg btn-primary btn-block" onclick="login()"
				value="登入" /> <input type="button"
				class="btn btn-lg btn-success btn-block" onclick="insertView()"
				value="加入會員" />
		</form>
		&nbsp
		<table border="1" id="BD" class="table table-striped">
			<thead>
				<tr>
					<td>Id</td>
					<td>Username</td>
					<td>Password</td>
					<td>權限</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="finduser" items="${finduser}">
					<c:set var="type" value="${finduser.usertype}" />

					<tr>
						<td>${finduser.id}</td>
						<td>${finduser.name}</td>
						<td>${finduser.password}</td>

						<c:choose>
							<c:when test="${type=='0'}">
								<td><c:out value="管理者"></c:out></td>
							</c:when>
							<c:otherwise>
								<td><c:out value="一般會員"></c:out></td>
							</c:otherwise>
						</c:choose>

					</tr>

				</c:forEach>
			</tbody>
		</table>


	</div>

</body>
</html>