<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>My Web</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form class="user" id="frm" action="memberJoin.do" onsubmit="return formCheck()" method="post">
                              
                                <div class="form-group row">
                                	<div class="col-sm-8 mb-3 mb-sm-0">
                                    	<input type="email" class="form-control form-control-user" id="id" name="id" placeholder="Email Address">
                                	</div>
                                	<div class="col-sm-4">
                                		
                                		<button class="btn btn-sm btn-primary" onclick="idCheckCall()" id="idCheck" value="No">중복체크</button>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            id="password" name="password" placeholder="Password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="password1" placeholder="Repeat Password">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="name" name="name"
                                        placeholder="This is Name..">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="tel" name="tel"
                                        placeholder="Tel..ex)010-0000-0000">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="address" name="address"
                                        placeholder="Your Address">
                                </div>
                                <input type="hidden" id="author" name="author" value ="USER"/>
                                <input type ="submit" class="btn btn-primary btn-user btn-block" value="Register Account"/>
                                    
                                <hr>
                                <a href="home.do" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="home.do" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="#">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="LoginForm.db">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>



<script type="text/javascript">

	function formCheck(){
		
		
		if(frm.idCheck.value == 'No'){
			alert("아이디 중복체크를 하세요");
			return false;
		}
		if(frm.password.value ==""){
			alert("패스워드는 필수 항목 입니다.");
			frm.password.focus();
			return false;
		}
		if(frm.name.value=="") {
			alert("이름은 필수 항목입니다.");
			frm.name.focus();
			return false;
		}
		if(frm.password.value != frm.password1.value){
			alert("패스워드가 일치 하지 않습니다.")
			frm.password.value="";
			frm.password1.value="";
			frm.password.focus();
			return false;
		}
	
		return true;
	}
	
	
	function idCheckCall(){ //ajax로 아이디를 중복체크 하는 함수 (JS는 함수라 칭함)
		
		event.preventDefault();
	
		if (frm.id.value == '') {
			alert('아이디가 빈칸');
			return;
		}
		
		const xhttp = new XMLHttpRequest(); //aJax 객체를 생성
		const id = frm.id.value;
		xhttp.onreadystatechange = function (){ // ajax가 동작될 떄 실행하는 함수
			if(xhttp.readyState==4){ //통신이 연결되서 데이터가 다 전달되었다면
				if(xhttp.status==200){ // 정상적으로 종료되었을때
					var b = xhttp.responseText; //결과데이터 받는 부분
					if(b == '1'){
						alert(id +"는 사용가능한 아이디 입니다.");
						frm.idCheck.value="Yes";
						frm.idCheck.style.display = "none";
						frm.password.focus();
					}else{
						alert(id+"는 이미 사용중인 아이디 입니다.");
						frm.id.value="";
						frm.id.focus();
					}
				}
			}
		}
		xhttp.open("GET","ajaxIdCheck.do?id="+id); //호출해야 할 방법과 주소
		xhttp.send(); //호출하는 부분
	}
	
</script>
</body>


</html>