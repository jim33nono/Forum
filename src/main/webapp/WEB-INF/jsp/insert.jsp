
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<form class="form-signin">
<h2 class="form-signin-heading">加入會員</h2>

<label for="username" class="sr-only">Username</label> 
<input type="text" id="username" class="form-control" placeholder="帳號" required autofocus>
 
<label for=password class=sr-only>Password</label> 
<input type="password" id="password" class="form-control" placeholder="密碼" required>

<label for=email class=sr-only>Email</label> 
<input type="email" id="email" class="form-control" placeholder="email" required>

<input type="button" class="btn btn-lg btn-success btn-block" onclick="insert()" value="送出" />
<input type="button" class="btn btn-lg btn-primary btn-block" onclick="history.go(0)" value="返回" />
</form>
