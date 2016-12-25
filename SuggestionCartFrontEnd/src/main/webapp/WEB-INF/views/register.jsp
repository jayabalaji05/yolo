<!DOCTYPE html>
<html lang="en">
    <head> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="assets/css/main.css">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
		<title>Register</title>
		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
		<script>
		
		$(document).ready(function(){

			//minimum 8 characters
			var bad = /(?=.{8,}).*/;
			//Alpha Numeric plus minimum 8
			var good = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{8,}$/;
			//Must contain at least one upper case letter, one lower case letter and (one number OR one special char).
			var better = /^(?=\S*?[A-Z])(?=\S*?[a-z])((?=\S*?[0-9])|(?=\S*?[^\w\*]))\S{8,}$/;
			//Must contain at least one upper case letter, one lower case letter and (one number AND one special char).
			var best = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{8,}$/;

			$('#pass1').on('keyup', function () {
			    var password = $(this);
			    var pass = password.val();
			    var passLabel = $('[for="password"]');
			    var stength = 'Weak';
			    var pclass = 'danger';
			    if (best.test(pass) == true) {
			        stength = 'Very Strong';
			        pclass = 'success';
			    } else if (better.test(pass) == true) {
			        stength = 'Strong';
			        pclass = 'warning';
			    } else if (good.test(pass) == true) {
			        stength = 'Almost Strong';
			        pclass = 'warning';
			    } else if (bad.test(pass) == true) {
			        stength = 'Weak';
			    } else {
			        stength = 'Very Weak';
			    }

			    var popover = password.attr('data-content', stength).data('bs.popover');
			    popover.setContent();
			    popover.$tip.addClass(popover.options.placement).removeClass('danger success info warning primary').addClass(pclass);

			});

			$('input[data-toggle="popover"]').popover({
			    placement: 'top',
			    trigger: 'focus'
			});

			})
function email_validate(email) {
	var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;

	if (regMail.test(email) == false) {
		document.getElementById("status").innerHTML = "<span class='warning'>Email address is not valid yet.</span>";
	} else {
		document.getElementById("status").innerHTML = "<span class='valid'>Thanks, you have entered a valid Email address!</span>";
	}
}
function validatephone(phone) {
	var maintainplus = '';
	var numval = phone.value
	if (numval.charAt(0) == '+') {
		var maintainplus = '';
	}
	curphonevar = numval.replace(
			/[\\A-Za-z!"£$%^&\,*+_={};:'@#~,.Š\/<>?|`¬\]\[]/g, '');
	phone.value = maintainplus + curphonevar;
	var maintainplus = '';
	phone.focus;
}
function checkPass() {
	var pass1 = document.getElementById('pass1');
	var pass2 = document.getElementById('pass2');
	var message = document.getElementById('confirmMessage');
	if (pass1.value == pass2.value) {
		message.innerHTML = "Passwords Match"
	} else {
		message.innerHTML = "Passwords Do Not Match!"
	}
}
</script>
<style>
body, html{
     height: 100%;
 	background-repeat: no-repeat;
 	background: url(http://cdn.wonderfulengineering.com/wp-content/uploads/2014/09/blue-wallpaper-36.jpg)no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
 	font-family: 'Oxygen', sans-serif;
}
/*footer problem and header down*/
body {
  min-height: 1000px;
  padding-top:23px;
  font-family: 'Open Sans', sans-serif;
}
.main{
 	margin-top: 70px;
}
section{
	padding: 3rem 0;
}
h1.title { 
	font-size: 50px;
	font-family: 'Passion One', cursive; 
	font-weight: 400; 
}

hr{
	width: 10%;
	color: #fff;
}
.popover.primary {
    border-color:#337ab7;
}
.popover.primary>.arrow {
    border-top-color:#337ab7;
}
.popover.primary>.popover-title {
    color:#fff;
    background-color:#337ab7;
    border-color:#337ab7;
}
.popover.success {
    border-color:#d6e9c6;
}
.popover.success>.arrow {
    border-top-color:#d6e9c6;
}
.popover.success>.popover-title {
    color:#3c763d;
    background-color:#dff0d8;
    border-color:#d6e9c6;
}
.popover.info {
    border-color:#bce8f1;
}
.popover.info>.arrow {
    border-top-color:#bce8f1;
}
.popover.info>.popover-title {
    color:#31708f;
    background-color:#d9edf7;
    border-color:#bce8f1;
}
.popover.warning {
    border-color:#faebcc;
}
.popover.warning>.arrow {
    border-top-color:#faebcc;
}
.popover.warning>.popover-title {
    color:#8a6d3b;
    background-color:#fcf8e3;
    border-color:#faebcc;
}
.popover.danger {
    border-color:#ebccd1;
}
.popover.danger>.arrow {
    border-top-color:#ebccd1;
}
.popover.danger>.popover-title {
    color:#a94442;
    background-color:#f2dede;
    border-color:#ebccd1;
}
.form-group{
	margin-bottom: 15px;
}

label{
	margin-bottom: 15px;
}

input,
input::-webkit-input-placeholder {
    font-size: 11px;
    padding-top: 3px;
}

.main-login{
 	background-color: #fff;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

}

.main-center{
 	margin-top: 30px;
 	margin: 0 auto;
 	max-width: 330px;
    padding: 40px 40px;

}

.login-button{
	margin-top: 5px;
}

.login-register{
	font-size: 11px;
	text-align: center;
}

</style>
	</head>
	<body>
	<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Registration</h1>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form class="form-horizontal" method="post" action="register">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Your Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Name"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email" onchange="email_validate(this.value);">
								</div>
								<div class="status" id="status"></div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username" id="username"  placeholder="Enter your Username" required >
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="pass1" placeholder="Enter your Password" required data-toggle="popover" title="Password Strength" data-content="Enter Password....">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="pass2"  placeholder="Confirm your Password" required minlength="4" maxlength="16"
									onkeyup="checkPass(); return false;" />
								</div>
								<div><span id="confirmMessage" class="confirmMessage"></span> </div>
							</div>
						</div>
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Phone Number</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-phone" aria-hidden="true"></i></span>
									<input id="phone" class="form-control" type="text" placeholder="Phone Number" required maxlength="15" onkeyup="validatephone(this);"> 
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Register</button>
						</div>
						<div class="login-register">
				            <a href="login">Login</a>
				         </div>
					</form>
				</div>
			</div>
		</div>
		<br><br><br>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>