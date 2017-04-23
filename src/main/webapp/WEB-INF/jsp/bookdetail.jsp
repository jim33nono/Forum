<%@page import="java.util.*"%>
<%@page import="com.yesee.ntp.model.bean.UserInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:forEach var="findbookdetail" items="${findbookdetail}">
	<c:set var="file" value="${findbookdetail.filelist}" />
	<h3>${findbookdetail.subject}</h3>
	<p>${findbookdetail.content}</p>
	<label>檔案</label>
	<c:choose>
		<c:when test="${file!=null}">
			<p><a onclick="dl()" href="#"><c:out value="${file}"></c:out></a></p>
			<input type="hidden" id="filename" value="${file}" />
		</c:when>
		<c:otherwise>
			<p><c:out value="本文章暫無檔案!!"></c:out></p>
		</c:otherwise>
	</c:choose>
<input type="hidden" id="bid" value="${findbookdetail.id}" />
</c:forEach>

<div id="reply">
<c:forEach var="reply" items="${reply}">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">${reply.user}</h3>
<h3 align="right" class="panel-title">${reply.createtime}</h3>
</div>
<div class="panel-body">${reply.content}</div>
</div>
</c:forEach>
</div>

<form>
  <div class="form-group">
    <label for="content">回覆內容</label>
    <textarea class="form-control" id="content"></textarea>
  </div>
<input type="button" class="btn btn-info" onclick="replyBook()"
	value="回覆文章" />
<input type="button" class="btn btn-primary" onclick="history.go(0)"
	value="返回" />
</form>
