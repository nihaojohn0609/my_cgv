<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/mycgv_jsp.css">
<script src="http://localhost:9000/mycgv_jsp/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/mycgv_jsp/js/mycgv_jsp_jquery.js"></script> 
<script>
	let join_result = "${join_result}";
	if(join_result == 'ok'){
		alert("회원가입에 성공하셨습니다.");
	}
	
	/*
	$(document).ready(function(){
		$("#btnLogin").click(function(){
			var vForm = $("#loginForm");
			var formData = new FormData(vForm[0]);
			
			$.ajax({
				type: "POST",
				url: "login_proc.do",
				async: true,
				dataType: "json",
				contentType: false, //Ajax로 이메일 보낼 때 필수 추가 하여야 합니다.
				processData: false, //Ajax로 이메일 보낼 때 필수 추가 하여야 합니다.
				data: formData,
				success: function (result) {
					alert(result);
				}
				
			});
		});
	});
	*/
</script>

</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="login">
			<h1 class="title">로그인</h1>
			<form name="loginForm" action="login_proc.do" method="post">
				<ul>
					<li>
						<label>아이디</label>
						<input type="text" name="id" id="id">
					</li>
					<li>
						<label>패스워드</label>
						<input type="password" name="pass" id="pass">
					</li>
					<li>
						<button type="button" class="btn_style" id="btnLogin" >로그인</button>
						<button type="button" class="btn_style" id="btnLoginReset">다시쓰기</button>
					</li>
					<li>
						<span><a href="#">아이디 찾기> </a></span>
						<span><a href="#">비밀번호 찾기> </a></span>
					</li>
				</ul>
			</form>
		</section>
	</div>
	
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
















