<%@ include file="/WEB-INF/taglib/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Sign up - Page</title>
<link href="${contextPath}/resources/css/style.css" rel="stylesheet" />
</head>
<body>

	<h3 class="title">Customer Sign up Page</h3>

	<hr>
	<br>

	<form:form modelAttribute="customer"
		action="${contextPath}/customer/processForm" method="post">

		<div>
			<label>First name:</label> <br>
			<form:input path="firstName" />
			<form:errors path="firstName" cssClass="error"></form:errors>
		</div>

		
		

		<div>
			<label>Last name:</label> <br>
			<form:input path="lastName" />
			<form:errors path="lastName" cssClass="error"></form:errors>
		</div>

		<div>
			<label>Free Passes:</label> <br>
			<form:input path="freePasses" type="number" />
			<form:errors path="freePasses" cssClass="error" />
		</div>

		<div>
		
		<div>
			<label>Postal Code:</label> <br>
			<form:input path="postalCode" />
			<form:errors path="postalCode" cssClass="error" />
		</div>
		<div>
			<label>Course code:</label> <br>
			<form:input path="courseCode" />
			<form:errors path="courseCode" cssClass="error" />
		</div>
		<input type="submit" value="Register">
	</form:form>
</body>
</html>