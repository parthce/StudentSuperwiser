<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Login Application Using Spring MVC</title>
</head>
<body>
	<form action="editPicture" method="post" enctype="multipart/form-data">
		<table cellpadding="0" cellspacing="3" border="0" style="border:1px solid black;">
			<tr>
  			 	<th colspan=2>Your Profile Picture</th>
			</tr>
			 <c:forEach items="${profileDetail}" var="profileEntity">
			
			<tr>
				<td>Profile Picture</td>
				<td><img src="getUserImage/<c:out value="${profileEntity.profileid}"/>" height="200px" width="200px" align="left"/></td>
			</tr>
			<tr>
				<td>Upload Image</td>
				<td><input type="file" name="image" id="file"></td>
			</tr>  
			</c:forEach>
			<tr>
				<td><input type="submit" name="update" value="Update"></td>
				<td><input type="submit" name="ok" value="Ok Done!"></td>			
			</tr>
		</table>
	</form>
</body>
</html>