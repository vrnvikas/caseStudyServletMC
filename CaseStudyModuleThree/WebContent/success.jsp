<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p align="center">Your firm is Successfully Registered</p>
<p align="center">Activate Your Account with following activation code</p>

<p align="center">
${sessionScope.activationCode}
</p>

<p><h2 align="center"><a href="RegisterServlet?action=home">Home</a>
</h2></p>

</body>
</html>