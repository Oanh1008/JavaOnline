
<%@ include file="/WEB-INF/taglib/import.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Please sign in</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link
	href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
	rel="stylesheet" crossorigin="anonymous" />
<link href="${contextPath}/static/css/style.css"  rel="stylesheet" >

</head>
<body>
	<div class="container">

		<form:form modelAttribute="user" class="form-signin border border-secondary" method="post"
			action="/10-spring-security-demo/signin">
			
			<h2 class="form-signin-heading center">Register Page</h2>
			<p>
				<label for="username" class="sr-only">Username</label> 
				<form:input
					type="text" id="username" path="username" class="form-control"
					placeholder="Username"  />
			</p>
			<p>
				<label for="password" class="sr-only">Password</label> 
				<form:input
					type="password" id="password" path="password" class="form-control"
					placeholder="Password" />
			</p>
			<p>
				<label for="firstName" class="sr-only">First Name</label> 
				<form:input type="text" id="firstName" path="firstName" class="form-control"
					placeholder="First Name" />
			</p>
			<p>
				<label for="lastName" class="sr-only">Last Name</label> 
				<form:input type="text" id="lastName" path="lastName" class="form-control"
					placeholder="Last Name" />
			</p>
			<p>
				<label for="email" class="sr-only">Email</label> 
				<form:input type="email" id="lastName" path="email" class="form-control"
					placeholder="email" />
			</p>

			<button class="btn btn-lg btn-success btn-block" type="submit">Register</button>
		</form:form>
		<div class="center">
			<a href="${contextPath}/login">Already have account ? Login	</a>
		</div>
	</div>
</body>
</html>