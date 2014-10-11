<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Scroll 1 in Profile Management</title>
<style>
table
{
border:1px solid black;
padding:0px;
border-spacing:3px;
}
</style>
</head>
<body>
 <h6><a href="<c:url value='j_spring_security_logout'/>">Click here to logout</a></h6>
<form:form method="post" action="addProfile" enctype="multipart/form-data" commandName="profile">

</form:form>
</body>
</html>