
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  		<%!
public void jspInit()
{
 System.out.println("init called");
}
public String methodX()
{
 jspInit();
 return "methodX called";
}
%>
<%= methodX() %>
  		
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

<form name="moduleFoam" method="post" action="RegisterServlet?action=register" onSubmit="return validateTicketDetails()">
<table align="center" width="28%" height="40%">

<tr>
<th align="center" colspan="5"><h1>Register New User</h1></th>
</tr>

<tr>
<th align="center" colspan="5"><h3>On Submission,you will receive a verification code for Activation</h3></th>
</tr>


<tr>
<td align="left" colspan="2">Name:</td>
<td >First Name</td>
<td >Middle Name</td>
<td >Last Name</td>
</tr>

<tr>
<td align="left" colspan="2">Name:</td>
<td ><input id="firstName" name="firstName" type='text' maxlength="15" required="required" pattern="[A-Za-z]{1,15}"/></td>
<td ><input id="middleName" name="middleName" type='text' maxlength="15" required="required" pattern="[A-Za-z]{1,15}"/></td>
<td ><input id="lastName" name="lastName" type='text' maxlength="15" required="required" pattern="[A-Za-z]{1,15}"/></td>
</tr>


<tr>
<td align="left" colspan="2">Business Name:</td>
<td ><input id="businessName" name="businessName" type='text' maxlength="15" required="required" pattern="[A-Za-z]{1,15}"/></td>
</tr>

<tr>
<td align="left" colspan="2">Email-Id:</td>
<td ><input id="emailId" name="emailId" type='text' maxlength="15" required="required" pattern="[A-Za-z]{1,15}"/></td>
</tr>

<tr>
<td align="left" colspan="2">Mobile No:</td>
<td ><input id="mobileNo" name="mobileNo" type='number' maxlength="15" required="required" pattern="[0-9]{1,15}"/></td>
</tr>


<tr>
<td>
<div>
<input align="right" style="margin-top: 20px; margin-left: 120%;}" type="submit" value = "Register">
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