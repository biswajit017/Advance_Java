<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
<% 
    String message = request.getParameter("message"); 
    if (message != null) {
        out.println(message);
    } else {
        out.println("No message received.");
    }
%>
</h1>

    <a href="Index.html">Go Back</a>

</body>
</html>