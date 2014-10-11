<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Login Application Using Spring MVC</title>
</head>
<body>
	<form action="showProfile" method="post">
		<table cellpadding="0" cellspacing="3" border="0" style="border:1px solid black;">
			<tr>
  			 	<th colspan=2>Your Profile</th>
			</tr>
			 <c:forEach items="${profileDetail}" var="profileEntity">
			<tr>
				<td>Profile Id:</td>
				<td><c:out value="${profileEntity.profileid}"/></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><c:out value="${profileEntity.country}"/></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><c:out value="${profileEntity.postalcode}"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><c:out value="${profileEntity.gender}"/></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><c:out value="${profileEntity.phone}"/></td>
			</tr>
			<tr>
				<td>Bio-Data</td>
				<td><c:out value="${profileEntity.bio}"/></td>
			</tr>
			<tr>
				<td>Occupation</td>
				<td><c:out value="${profileEntity.occupation}"/></td>
			</tr>
			<tr>
				<td>Language</td>
				<td><c:out value="${profileEntity.language}"/></td>
			</tr>
			<tr>
				<td>Interests</td>
				<td><c:out value="${profileEntity.interests}"/></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><c:out value="${profileEntity.dob}"/></td>
			</tr>
			<tr>
				<td>Activities</td>
				<td><c:out value="${profileEntity.activities}"/></td>
			</tr>
			<tr>
				<td>What's on Mind</td>
				<td><c:out value="${profileEntity.whatsonmind}"/></td>
			</tr>
			<tr>
				<td>Profile Picture</td>
				<td><img src="getUserImage/<c:out value="${profileEntity.profileid}"/>" height="200px" width="200px" align="left"/></td>
			</tr>
			
			</c:forEach>
			<tr>
				<td><input type="submit" name="editProfile" value="Edit Profile"></td>
				<td><input type="submit" name="editPicture" value="Edit Picture"></td>			
			</tr>
		</table>
	</form>
</body>
</html>