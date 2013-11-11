<html>
<%@ page import="openjpa.person.api.Person" %>
<head>
<title>Using GET Method to Read Form Data</title>
</head>
<body>
<h3>Person added successfully!</h3>
	Person id: <%= ((Person)request.getAttribute("person")).getId()%>
	<br />
	Person name: <%= ((Person)request.getAttribute("person")).getName()%>
	<br />
</body>
</html>