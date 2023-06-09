<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Feedback</title>

<!-- Font Icon -->
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
	<script src="./lib/jquery.js"></script>
	<script src="./dist/jquery.validate.js"></script>
<script type="text/javascript">
$().ready(function() {
	// validate the comment form when it is submitted
	$("#commentForm").validate();

	// validate signup form on keyup and submit
	$("#feedback-form").validate({
		rules: {

			name: {
				required: true
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
			},
			message: {
				required: true
			},
			
		},
		messages: {

			name: "Please enter a your name",
			email: "Please enter a valid email address",
			contact: {
				required: "Please enter a phone number",
				minlength:"please enter valid phone number",
				maxlength:"please enter valid phone number",
				number:"please enter valid phone number"
			},
			message: "Please enter your message",
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
						<h2 class="form-title">Have a questions?
</h2><p>Leave a message and we will help!

</p>
					
						<form method="post" action="feedback" class="feedback-form"
							id="feedback-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="email" name="email" id="email" placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="contact"><i class="zmdi zmdi-phone"></i></label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact no" />
							</div>
							<div class="form-group">
								<label for="message"><i></i></label>
								<textarea  style="width:95%; height:100px" id="message" name="message"></textarea> 
								
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Submit" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
						<a href="index.jsp">Back to Home</a> | 
						<a href="search.jsp">Search Feedback</a>
							<img src="images/pngwing.com (1).png" alt="sing up image">
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