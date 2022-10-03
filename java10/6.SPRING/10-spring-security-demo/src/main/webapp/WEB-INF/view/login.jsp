
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

		<form:form class="form-signin border border-secondary" method="post"
			action="/10-spring-security-demo/login">
			<c:if test="${param.error!=null}">
				<p class="bg-error">Bad Credentials</p>
			</c:if>
			<c:if test="${param.logout !=null }">
				<p class="text-white bg-success center">Logout Successful</p> 
			</c:if>
			<h2 class="form-signin-heading center">Login Page</h2>
			<p>
				<label for="username" class="sr-only">Username</label> <input
					type="text" id="username" name="username" class="form-control"
					placeholder="Username" required autofocus>
			</p>
			<p>
				<label for="password" class="sr-only">Password</label> <input
					type="password" id="password" name="password" class="form-control"
					placeholder="Password" required>
			</p>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Log
				in</button>
		</form:form>
		<div class="center">
			<a href="${contextPath}/user/register">?Register</a>
		</div>
	</div>
</body>
</html>