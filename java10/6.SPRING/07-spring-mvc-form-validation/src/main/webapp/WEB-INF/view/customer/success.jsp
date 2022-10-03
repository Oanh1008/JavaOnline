<%@ include file="/WEB-INF/taglib/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customer Success - Page</title>
	<style>
		
	</style>
	<link href="${contextPath}/resources/css/style.css" rel="stylesheet" />
</head>
<body>

	<h3 class="green">Customer Success Page</h3>
	
	<h3 class="green">Congratulations. You have registered our course successful !</h3>
	
	<hr>
	
	<p class="red">Your information </p>
	
	<p> Name: ${customer.firstName} </p>
	<p> Last name: ${customer.lastName} </p>
	<p> Free Passes: ${customer.freePasses} </p>
	<p> Postal Code: ${customer.postalCode} </p>
	<p> Course Code: ${customer.courseCode} </p>
	


</body>
</html>