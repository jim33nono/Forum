<%@page import="java.util.*"%>
<%@page import="com.yesee.ntp.model.bean.UserInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h2>修改/刪除文章</h2>

<table class="table table-striped">
		
		<tr>
		<td width="20%">標題</td>
		<td width="40%">內文</td>
		<td width="10%">建立者</td>
		<td width="10%">建立時間</td>
		<td width="20%"></td>
		</tr>

<c:forEach var="findownbook" items="${findownBook}">
        <tr>
		<td>${findownbook.subject}</td>
		<td>${findownbook.content}</td>
		<td>${findownbook.user}</td>
		<td>${findownbook.createtime}</td>
		<td><div align="right">
		<input  type="button" class="btn btn-warning" onclick="updateBookview(${findownbook.id})" value="修改"/>
		<input  type="button" class="btn btn-danger" onclick="deleteBook(${findownbook.id})" value="刪除"/>
		</div></td>
		</tr>
</c:forEach>
        
        </table>
  
  
  <input type="button" class="btn btn-primary" onclick="history.go(0)" value="返回"/>
