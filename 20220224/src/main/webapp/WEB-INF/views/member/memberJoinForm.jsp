<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../home/header.jsp"/>
<div align="center">
	<div><h1>회 원 가 입</h1></div>
	<div>
		<form id="frm" action="memberJoin.do " onsubmit="return formCheck();" method="Post">
			<div>
				<table border ="1">
					<tr>
						<th width ="100">* 아이디</th>
						<td width ="280">
							<input type="email" id= "id" name="id" required="required" placeholder="EX)abc@abc.com..">&nbsp;&nbsp;&nbsp;
							<button type="button" onClick="" id="idCheck" value="No">중복체크 </button>
						</td>
					</tr>
					<tr>
						<th>* password</th>
						<td><input type= "password" id = "password" name = "password" required="required"></td>
					</tr>
					<tr>
						<th>* password확인</th>
						<td><input type= "password" id = "password1" name = "password1" required="required"></td>
					</tr>
					<tr>
						<th>* 이 름</th>
						<td><input type= "text" id = "name" name = "name" required="required"></td>
					</tr>
					<tr>
						<th>* 전화번호</th>
						<td><input type= "tel" id = "tel" name = "tel"></td>
					</tr>
					<tr>
						<th>* 주 소</th>
						<td><input type= "text" id = "address" name = "address"></td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="hidden" id="author"name="author" value="USER">
				<input type="reset" value = "취 소">&nbsp;&nbsp;
				<input type="submit" value = "회원등록">
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	function formCheck(){
		/* if(frm.idCheck.value=='No'){
			alert("아이디 중복 체크를 해주세요.")
			return false;
		} */
		if(frm.password.value != frm.password1. value){
			alert("패스워드가 일치 하지 않습니다.")
			frm.password.value="";
			frm.password1.value="";
			frm.password.focus();
			return false;
		}
		
		return true;
	}
</script>
</body>
</html>