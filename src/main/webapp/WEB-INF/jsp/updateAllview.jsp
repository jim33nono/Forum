<%@page import="java.util.*"%>
<%@page import="com.yesee.ntp.model.bean.UserInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form class="form-signin">
<h2 class="form-signin-heading">修改會員資料</h2>

<c:forEach var="findupdateuser" items="${findupdateuser}">
<c:set var="type" value="${findupdateuser.usertype}" />
<label for="username" class="sr-only">Username</label> 
<input type="text" id="username" class="form-control" value="${findupdateuser.name}" disabled>
 
<label for=password class=sr-only>Password</label> 
<input type="password" id="password" class="form-control"  placeholder="密碼"  required autofocus>

<label for=email class=sr-only>Email</label> 
<input type="email" id="email" class="form-control" value="${findupdateuser.email}" placeholder="email"  required>

<input type="radio" name="usertype" id="usertype"  <c:if test="${type=='0'}">checked</c:if> value="0" placeholder="權限"  />使用者
<input type="radio" name="usertype" id="usertype"  <c:if test="${type=='1'}">checked</c:if> value="1" placeholder="權限" />一般會員
</c:forEach>

<input type="button" class="btn btn-lg btn-success btn-block" onclick="updateChooseuser()" value="送出" />
<input type="button" class="btn btn-lg btn-primary btn-block" onclick="updateallChoose()" value="返回" />
</form>