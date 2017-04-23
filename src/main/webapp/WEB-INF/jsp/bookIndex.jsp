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
<script src="js/ajaxfileupload.js"></script>
<script src="js/onClick.js"></script>
<script src="js/Setting.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Form Handling</title>
</head>
<body>

	<div id="container" class="container">
	 

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">使用者</h3>
			</div>
			<div class="panel-body">
				<div id="user">
					歡迎 : ${name} 
					<div id="but" align="right">
				<input id="usertype" type="hidden" value="${usertype}" name="usertype" /> 
				<input id="update" type="button" class="btn btn-xs btn-info" onclick="updateView()" value="修改個人資料" />
				<input id="updateall" type="hidden" class="btn btn-xs btn-warning" onclick="updateallChoose()" value="修改/刪除會員資料" />
				<input id="logout" type="button" class="btn btn-xs btn-success" onclick="logout()" value="登出" />
				
						</div>
				</div>
			</div>
		</div>
		
		<div id="bookpage">
		
		<input  type="button" class="btn btn-primary" onclick="insertBookview()" value="新增文章" />
		<input  type="button" class="btn btn-warning" onclick="updateownBookview()" value="修改/刪除文章"/>
		<div align="right">
		<label for="searchbook">全文搜索:</label><input  type="text" size="29" id="searchbook" placeholder="全文搜索(日期查詢格式:yyyy-mm-dd)" />
		<input  type="button" class="btn btn-default" onclick="search()" value="查詢"/>
		</div>
		<c:choose>
		<c:when test="${Listsize == 0}">
			<p><c:out value="查無資料，請重新輸入!!"></c:out></p>
		</c:when>
		<c:otherwise>
			
		
		<div id="list">
		<table class="table table-striped">
		
		<tr>
		<td width="20%">標題</td>
		<td width="50%">內文</td>
		<td width="10%">建立者</td>
		<td width="10%">建立時間</td>
		<td width="10%"></td>
		</tr>
		
       <c:forEach var="findbook" items="${findbook}">
        
        <tr>
		<td>${findbook.subject}</td>
		<td>${findbook.content}</td>
		<td>${findbook.user}</td>
		<td>${findbook.createtime}</td>
		<td><div align="right">
		<input  type="button" class="btn btn-success" onclick="bookDetailview(${findbook.id})" value="查看"/>

		</div></td>
		</tr>
		
        </c:forEach>
        
        </table>
        </div>
        </c:otherwise>
	    </c:choose>
		</div>
		
		
	</div>


</body>
</html>