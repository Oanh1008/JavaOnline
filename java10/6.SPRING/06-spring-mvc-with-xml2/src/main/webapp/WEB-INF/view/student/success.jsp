<%@ include file="/WEB-INF/taglib/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Success - Page</title>
	<style>
		.green {
			color: green;
		} 
		
		.red {
			color: red;
		} 
	</style>
</head>
<body>

	<h3 class="green">Student Success Page</h3>
	
	<h3 class="green">Congratulations. You have registered our course successful !</h3>
	
	<hr>
	
	<p class="red">Your information </p>
	
	<p> Name: ${student.fullName} </p>
	<p> Age: ${student.age} </p>
	<p> Country: ${student.country} </p> 
	<p> Language: ${student.language} </p> 
	
	<hr>
	
	<p> Operating Systems: </p> 
	<ul>
		<c:forEach var="os" items="${student.systems}">
			<li>${os}</li>
		</c:forEach>
	</ul>


</body>
</html>