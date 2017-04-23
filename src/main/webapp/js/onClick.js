function login() {

	var un = $("#username").val();
	var pw = $("#password").val();

	if (un == null || un == "") {
		alert("帳號尚未輸入!!");
		$("#username").focus();
		return false;
	}

	if (pw == null || pw == "") {
		alert("密碼尚未輸入!!");
		$("#password").focus();
		return false;
	}

	$.ajax({
		type : "POST",
		url : "login",
		data : {
			name : un,
			password : pw,
		},
		data_type : 'json',
		success : function(response) {
			if (response) {
				location.href = 'bookIndex';
			} else {
				alert("登入失敗，請確認您的帳號密碼!!")
			}

		}

	});
}

function insertView() {

	$.ajax({
		type : "POST",
		url : "insertView",
		success : function(response) {
			$("#container").html(response);
		}
	});
}

function insert() {

	var un = $("#username").val();
	var pw = $("#password").val();
	var em = $("#email").val();

	if (un == null || un == "") {
		alert("帳號尚未輸入!!");
		$("#username").focus();
		return false;
	}
	if (pw == null || pw == "") {
		alert("密碼尚未輸入!!");
		$("#password").focus();
		return false;
	}
	if (em == null || em == "") {
		alert("E-mail尚未輸入!!");
		$("#email").focus();
		return false;
	}

	$.ajax({
		type : "POST",
		url : "insert",
		data : {
			name : un,
			password : pw,
			email : em,
		},
		data_type : 'json',
		success : function(response) {
			if (response) {
				location.href = './';
			} else {
				alert("帳號重複，請重新輸入!!")
			}
		}
	});
}

function updateView() {

	$.ajax({
		type : "POST",
		url : "updateView",
		success : function(response) {
			$("#container").html(response);
		}
	});
}

function update() {

	var un = $("#username").val();
	var pw = $("#password").val();
	var em = $("#email").val();

	if (pw == null || pw == "") {
		alert("密碼尚未輸入!!");
		$("#password").focus();
		return false;
	}
	if (em == null || em == "") {
		alert("E-mail尚未輸入!!");
		$("#email").focus();
		return false;
	}

	$.ajax({
		type : "POST",
		url : "update",
		data : {
			name : un,
			password : pw,
			email : em,
		},
		data_type : 'json',
		success : function(response) {
			if (response) {
				alert("修改成功")
				location.href = 'bookIndex';
			}
		}
	});
}
function updateallChoose() {

	$.ajax({
		type : "POST",
		url : "updateallChoose",
		success : function(response) {
			$("#container").html(response);
		}
	});
}

function updateallView(a) {

	var id = a;

	$.ajax({
		type : "POST",
		url : "updateallView",
		data : {
			id : id,
		},
		data_type : 'json',
		success : function(response) {
			$("#container").html(response);
		}
	});
}
function updateChooseuser() {

	var un = $("#username").val();
	var pw = $("#password").val();
	var em = $("#email").val();
	var ut = $('input[name=usertype]:checked').val();

	if (pw == null || pw == "") {
		alert("密碼尚未輸入!!");
		$("#password").focus();
		return false;
	}
	if (em == null || em == "") {
		alert("E-mail尚未輸入!!");
		$("#email").focus();
		return false;
	}

	$.ajax({
		type : "POST",
		url : "updateChooseuser",
		data : {
			name : un,
			password : pw,
			email : em,
			usertype : ut,
		},
		data_type : 'json',
		success : function(response) {
			if (response) {
				alert("修改成功")
				location.href = 'bookIndex';
			}
		}
	});
}
function deleteUser(a) {

	reply = confirm("確定刪除會員?");

	if (!reply) {
		return false;
	}

	var id = a;

	$.ajax({
		type : "POST",
		url : "deleteUser",
		data : {
			id : id,
		},
		data_type : 'json',
		success : function(response) {
			alert("刪除成功");
			location.href = 'bookIndex';
		}
	});
}
function logout() {

	$.ajax({
		type : "POST",
		url : "logout",
		success : function(response) {

			location.href = './';
		}
	});

}
function insertBookview() {

	$.ajax({
		type : "POST",
		url : "insertBookview",
		success : function(response) {
			$("#bookpage").html(response);
		}
	});
}
function updateownBookview() {

	$.ajax({
		type : "POST",
		url : "updateownBookview",
		success : function(response) {
			$("#bookpage").html(response);
		}
	});
}
function bookDetailview(a) {
	var id = a;
	$.ajax({
		type : "POST",
		url : "bookDetailview",
		data : {
			id : id,
		},
		data_type : 'json',
		success : function(response) {
			$("#bookpage").html(response);
		}
	});
}
function replyBook() {

	var content = $("#content").val();
	var bid = $("#bid").val();
	
	if (content == null || content == "") {
		alert("請輸入回覆內容!!");
		$("#content").focus();
		return false;
	}
	$.ajax({
		type : "POST",
		url : "replyBook",
		data : {
			bid : bid,
			content : content,
		},
		data_type : 'json',
		success : function(response) {
			
			$("#bookpage").html(response);
		}
	});
}

function insertBook() {

	var subject = $("#subject").val();
	var content = $("#content").val();
	var data = $("#file").val();
	var filenm = data.split('\\');
	var filelist = filenm[filenm.length-1];
	
	
	if (subject == null || subject == "") {
		alert("請輸入標題!!");
		$("#subject").focus();
		return false;
	}
	if (content == null || content == "") {
		alert("請輸入內文!!");
		$("#content").focus();
		return false;
	}

	$.ajax({
		type : "POST",
		url : "insertBook",
		data : {
			subject : subject,
			content : content,
			filelist : filelist,
		},
		data_type : 'json',
		success : function(response) {
			location.href = 'bookIndex';
		}
	});
}

function updateBookview(a) { 
	var id = a;
	
	$.ajax({
		type : "POST",
		url : "updateBookview",
		data : {
			id : id,
		},
		data_type : 'json',
		success : function(response) {
			$("#bookpage").html(response);
		}
	});
}

function updateBookview(a) { 
	var id = a;
	
	$.ajax({
		type : "POST",
		url : "updateBookview",
		data : {
			id : id,
		},
		data_type : 'json',
		success : function(response) {
			$("#bookpage").html(response);
		}
	});
}
function updateBook(a) { 
	var id = a;
	
	var subject = $("#subject").val();
	var content = $("#content").val();
	var data = $("#file").val();
	var filenm = data.split('\\');
	var filelist = filenm[filenm.length-1];
	
	if (subject == null || subject == "") {
		alert("請輸入標題!!");
		$("#subject").focus();
		return false;
	}
	if (content == null || content == "") {
		alert("請輸入內文!!");
		$("#content").focus();
		return false;
	}
	
	$.ajax({
		type : "POST",
		url : "updateBook",
		data : {			
		  id : id,
	      subject : subject,
	      content : content,
	      filelist : filelist,
        },
		data_type : 'json',
		success : function(response) {		
			$("#bookpage").html(response);
		}
	});
}

function deleteBook(a) { 
	
	reply = confirm("確定刪除文章並刪除回文?");

	if (!reply) {
		return false;
	}
	var id = a;
	   	
	$.ajax({
		type : "POST",
		url : "deleteBook",
		data : {			
		  id : id,   
        },
		data_type : 'json',
		success : function(response) {	
			alert("刪除成功");
			$("#bookpage").html(response);
		}
	});
}
function search() { 
	
	var search = $("#searchbook").val();
	
	if (search == null || search == "") {
		alert("請輸入關鍵字!!");
		$("#searchbook").focus();
		return false;
	}
	
	$.ajax({
		type : "POST",
		url : "searchBook",
		data : {			
			search : search,   
        },
		data_type : 'json',
		success : function(response) {
					
			$("#container").html(response);
		}
	});
}
function Upload() { 

	var oMyForm = new FormData();
	var data = $("#file").val();

	
	
	var filelist = file.files;		
	oMyForm.append("file", file.files[0]);
	
 
	if (data == null || data == "") {
		alert("請選擇檔案!!!");
		return false;
	     }
		
	if (filelist[0].size > 1024*1024) {
	alert("上傳檔案不得超過1MB!!!");
	return false;
     }
	
	$.ajax({
		type : "POST",
		url : "doUpload",
		 dataType: 'text',
		    processData: false,
		    contentType: false,
		data : oMyForm,
		success : function(response) {
			
			var msg = response;
			
			if(msg == "Success"){
			
			$("#uploadbut").attr("type","hidden");
			
		    }  
			$("#ajaxResponse").text(response);
		}
	});
}
function updateUpload() { 
	var a = $("#originalfilename").val();
	var data = $("#file").val();
	var filelist = file.files;	
	var oMyForm = new FormData();
			
	oMyForm.append("file", file.files[0]);
	oMyForm.append("name", a);
 
	if (data == null || data == "") {
		alert("請選擇檔案!!!");
		return false;
	     }
		
	if (filelist[0].size > 1024*1024) {
	alert("上傳檔案不得超過1MB!!!");
	return false;
     }
	
	$.ajax({
		type : "POST",
		url : "doUpateupload",
		 dataType: 'text',
		    processData: false,
		    contentType: false,
		data : oMyForm,
		success : function(response) {
			
			var msg = response;
			
			if(msg == "Success"){
			
			$("#uploadbut").attr("type","hidden");
			
		    }  
			$("#ajaxResponse").text(response);
		}
	});
}
function Upload() { 

	var oMyForm = new FormData();
	var data = $("#file").val();

	
	
	var filelist = file.files;		
	oMyForm.append("file", file.files[0]);
	
 
	if (data == null || data == "") {
		alert("請選擇檔案!!!");
		return false;
	     }
		
	if (filelist[0].size > 1024*1024) {
	alert("上傳檔案不得超過1MB!!!");
	return false;
     }
	
	$.ajax({
		type : "POST",
		url : "doUpload",
		 dataType: 'text',
		    processData: false,
		    contentType: false,
		data : oMyForm,
		success : function(response) {
			
			var msg = response;
			
			if(msg == "Success"){
			
			$("#uploadbut").attr("type","hidden");
			
		    }  
			$("#ajaxResponse").text(response);
		}
	});
}
function dl() {
	var a = $("#filename").val();
	
//	var a = $("#originalfilename").val();
//	var data = $("#file").val();
//	var filelist = file.files;	
//	var oMyForm = new FormData();
//			
//	oMyForm.append("file", file.files[0]);
//	oMyForm.append("name", a);
// 
	
	$.ajax({
		type : "POST",
		url : "dl",
		 dataType: 'json',
		data : { filename : a },
		success : function(response) {
			
//			var msg = response;
//			
//			if(msg == "Success"){
//			
//			$("#uploadbut").attr("type","hidden");
//			
//		    }  
//			$("#ajaxResponse").text(response);
		}
	});
}