<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>新增文章</h2>

<form id="insertform" name="insertform" role="form" enctype="multipart/form-data">
  <div class="form-group">
    <label for="subject">標題</label>
    <input type="text" class="form-control" id="subject" placeholder="標題" autofocus>
  </div>
  <div class="form-group">
    <label for="content">內文</label>
    <textarea class="form-control" id="content"></textarea>
  </div>
  <div class="form-group">
   
    <label for="file">檔案上傳</label>
    <input type="file" name="file" id="file">
    <p class="help-block">檔案大小不得超過 1mb。</p>
     <input type="button" class="btn btn-success" id="uploadbut" onclick=" Upload()" value="上傳檔案"/>
     
 
       <div id="ajaxResponse"></div>
 
         
  </div>
  
  <input type="button" class="btn btn-success" onclick="insertBook()" value="送出"/>
  <input type="button" class="btn btn-primary" onclick="history.go(0)" value="返回"/>
</form>