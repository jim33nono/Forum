<%@page import="java.util.*"%>
<%@page import="com.yesee.ntp.model.bean.UserInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2 class="form-signin-heading">修改會員資料</h2>
<table border="1" id="BD" class="table table-striped">
			<thead>
				<tr>
					<td>Id</td>
					<td>Username</td>
					<td>Password</td>
					<td>權限</td>
					<td></td>
					<td></td>
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
                       <td><input type="button" class="btn btn-xs btn-warning" onclick="updateallView(${finduser.id})" value="修改" /></td>
                       <td><input type="button" class="btn btn-xs btn-danger" onclick="deleteUser(${finduser.id})" value="刪除" /></td>
					</tr>

				</c:forEach>
				
			</tbody>
		</table>
<input type="button" class="btn btn-lg btn-primary btn-block" onclick="history.go(0)" value="返回" />