
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	
  table{
   border:solid;
   padding:0%
  }  
  
*{
  padding:2%;
}

</style>

</head>
<body id="content" height="800px" width="100%">

<form name="moduleFoam" method="post" action="RegisterServlet?action=activate" onSubmit="return validateTicketDetails()">
<table align="center" width="28%" height="40%">

<tr>
<th align="center" colspan="5"><h1>Activate Your Account</h1></th>
</tr>

<tr>
<td align="left" colspan="2">Email-Id:</td>
<td ><input id="emailId" name="emailId" type='text' maxlength="15" required="required" pattern="[A-Za-z]{1,15}"/></td>
</tr>

<tr>
<td align="left" colspan="2">Activation Code:</td>
<td ><input id="activationCode" name="activationCode" type='number' maxlength="15" required="required" pattern="[0-9]{1,15}"/></td>
</tr>


<tr>
<td>
<div>
<input align="right" style="margin-top: 20px; margin-left: 120%;}" type="submit" value = "Activate">
</div>
</td>

<td>
<div>
<input align="right" type="button" style="margin-top: 20px; margin-left: 120%;}"  value = "Reset">
</div>
</td>

</tr>

</table>

</form>

</body>
</html>