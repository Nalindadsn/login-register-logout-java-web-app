<% 
	if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
}

%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

	<script src="vendor/jquery/jquery.min.js"></script>
	
	<script src="./lib/jquery.js"></script>
	<script src="./dist/jquery.validate.js"></script>
<script type="text/javascript">
$().ready(function() {
	// validate the comment form when it is submitted
	$("#commentForm").validate();

	// validate signup form on keyup and submit
	$("#register-form").validate({
		rules: {
			name: {
				required: true,
				minlength: 2
			},
			pass: {
				required: true,
				minlength: 5
			},
			re_pass: {
				required: true,
				minlength: 5,
				equalTo: "#pass"
			},
			email: {
				required: true,
				email: true
			},
			contact: {
				required: true,
				minlength: 10,
				maxlength: 10,
				number: true
			}
		},
		messages: {
			name: {
				required: "Please enter a username",
				minlength: "Your username must consist of at least 2 characters"
			},
			pass: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			re_pass: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address",
			contact: {
				required: "Please enter a phone number",
				minlength:"please enter valid phone number",
				maxlength:"please enter valid phone number",
				number:"please enter valid phone number"
			},
		}
	});

	
});</script>
<style type="text/css">
.error{
color:red
}</style>

</head>
<body>
 
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="update" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name" value=<%= session.getAttribute("name") %> />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" value=<%= session.getAttribute("email") %> />
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="pass" id="pass" placeholder="Password"  />
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="re_pass" id="re_pass"
									placeholder="Repeat your password" />
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact no" value=<%= session.getAttribute("mobile") %> />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>I
									agree all statements in <a href="#" class="term-service">Terms
										of service</a></label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/sign-up-concept-illustration_114360-7875.avif" alt="sing up image">
						</figure>
						
					</div>
				</div>
			</div>
		</section>


	</div>
	<!-- JS -->
	<script src="js/main.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
var status=document.getElementById("status").value;
if(status=="success"){
	swal("Congrates","Your account cretated succesfully","success");
}
if(status=="already"){
	swal("Sorry","Email already exist","error");
}

</script>


</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>