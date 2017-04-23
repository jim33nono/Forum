<%@page import="java.util.*"%>
<%@page import="com.yesee.ntp.model.bean.UserInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h2>修改文章</h2>
<c:forEach var="updatebook" items="${updateBook}">
<form role="form">
  <div class="form-group">
    <label for="subject">標題</label>
    <input type="text" class="form-control" id="subject" value="${updatebook.subject}" placeholder="標題" autofocus>
  </div>
  <div class="form-group">
    <label for="content">內文</label>
    <textarea class="form-control" id="content">${updatebook.content}</textarea>
  </div>
  <div class="form-group">
    <label for="file">檔案上傳</label>
    <input type="file" id="file">
    <p class="help-block">原始檔案 : ${updatebook.filelist}</p>
    <input type="hidden"  id="originalfilename" value="${updatebook.filelist}"/>
    <p class="help-block">檔案大小不得超過 1mb。</p>
    <input type="button" class="btn btn-warning" id="uploadbut" onclick=" updateUpload()" value="修改檔案"/>
     
 
       <div id="ajaxResponse"></div>
  </div>
  
  <input type="button" class="btn btn-success" onclick="updateBook(${updatebook.id})" value="送出"/>
  <input type="button" class="btn btn-primary" onclick="updateownBookview()" value="返回"/>
</form>
</c:forEach>