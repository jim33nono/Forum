<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<form class="form-signin">
<h2 class="form-signin-heading">修改個人資料</h2>

<label for="username" class="sr-only">Username</label> 
<input type="text" id="username" class="form-control" value="${name}" disabled>
 
<label for=password class=sr-only>Password</label> 
<input type="password" id="password" class="form-control"  placeholder="密碼"  required autofocus>

<label for=email class=sr-only>Email</label> 
<input type="email" id="email" class="form-control" value="${email}" placeholder="email"  required>

<input type="button" class="btn btn-lg btn-success btn-block" onclick="update()" value="送出" />
<input type="button" class="btn btn-lg btn-primary btn-block" onclick="history.go(0)" value="返回" />
</form>