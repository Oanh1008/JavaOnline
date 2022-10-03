<%@ include file="/WEB-INF/taglib/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Sign up - Page</title>
</head>
<body>
	
	<h3>Student Sign up Page</h3>
	
	<hr> <br>

	<form:form modelAttribute="student" action="${contextPath}/student/processForm" method="post">
		
		<label>Full name:</label>
		<form:input path="fullName" placeholder="What's your name"/>
		
		<br> <br>
		
		<label>Age:</label>
		<form:input path="age" placeholder="How old are you"/>
		
		<br> <br>
		
		<label>Country:</label>
		<form:select path="country">
			<c:forEach var="countryAsString" items="${countries}">
				<form:option value="${countryAsString}" label="${countryAsString}" />
			</c:forEach>
		</form:select>
		
		<br> <br>
		
		<label>Language:</label>
		<c:forEach var="languageAsString" items="${languages}">
			<form:radiobutton path="language" value="${languageAsString}" label="${languageAsString}"/>
		</c:forEach>
		
		
		<br> <br>
		
		<label>OS(s):</label>
		<c:forEach var="os" items="${operatingSystems}">
			<form:checkbox path="systems" value="${os}" label="${os}"/>
		</c:forEach>
		
		<br> <br>
		
		<input type="submit" value="Register">
	</form:form>
</body>
</html>