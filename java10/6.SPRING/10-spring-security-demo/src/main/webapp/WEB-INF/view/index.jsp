<%@ include file="/WEB-INF/taglib/import.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - Security Page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link
	href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
	rel="stylesheet" crossorigin="anonymous" />
<link href="${contextPath}/static/css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<h1>Welcome to Spring Security Tutorials</h1>
		<hr>
			<h3>User: <sec:authentication property="principal.username"/></h3>
			<h3>Role(s): <sec:authentication property="principal.authorities"/></h3>
			<div>
				<sec:authorize access="hasRole('MANAGER')">
					<a href="${contextPath}/leaders">Leadership meeting</a>(Only for Manager peeps)
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN')">
					<a href="${contextPath}/system">IT systems meeting</a>(Only for Admin peeps)
				</sec:authorize>
				
				
			</div>
			
		<hr>
		<form action="${contextPath}/logout" method="post">
			<input class="btn btn-success" type="submit" value="Logout">
			
			<!-- _csrf -->
		
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
	</div>
	
</body>
</html>