<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Scroll 2 in Profile Management</title>
</head>
<body>
	
	<form action="editProfile" method="post">
		<table cellpadding="0" cellspacing="3" border="0" style="border:1px solid black;">
			 <c:forEach items="${profileDetail}" var="profileEntity">
			<tr>
				<td>Profile Id:</td>
				<td><input type="text" name="profileid" value="<c:out value="${profileEntity.profileid}"/>"  /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="country" value="<c:out value="${profileEntity.country}"/>" /></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><input type="text" name="postalcode" value="<c:out value="${profileEntity.postalcode}"/>"></td>
			</tr>
			<tr>
				<td>Date Of Birth(dd-mm-yyyy)</td>
				<td><input type="text" name="dob" value="<c:out value="${profileEntity.dob}"/>"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><select name="gender">
				 <option value="Male">Male</option>
				 <option value="Female">Female</option>
				  <option value="<c:out value="${profileEntity.gender}"/>" selected><c:out value="${profileEntity.gender}"/></option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Phone No</td>
				<td><input type="text" name="phone" value="<c:out value="${profileEntity.phone}"/>"></td>
			</tr>
			<tr>
				<td>Language</td>
				<td><input type="text" name="language" value="<c:out value="${profileEntity.language}"/>"></td>
			</tr>
			<tr>
				<td>Bio</td>
				<td><textarea name="bio" ><c:out value="${profileEntity.bio}"/></textarea></td>
			</tr>
			
			<tr>
				<td>Activities</td>
				<td><textarea name="activities" ><c:out value="${profileEntity.activities}"/></textarea></td>
			</tr>
			<tr>
				<td>Interests</td>
				<td><textarea name="interests" ><c:out value="${profileEntity.interests}"/></textarea></td>
			</tr>
			
			<tr>
				<td>What's On Your Mind</td>
				<td><input type="text" name="whatsonmind" value="<c:out value="${profileEntity.whatsonmind}"/>"></td>
			</tr>
			<tr>
				<td>Occupation</td>
				<td><select name="occupation">
				 <option value="teacher">Teacher</option>
				 <option value="student">Student</option>
				 <option value="professor">Professor</option>
				 <option value="expert">Experts</option>
				  <option value="databseValue" selected><c:out value="${profileEntity.occupation}"/></option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="edit" value="Edit"></td>
				<td><input type="submit" name="cancel" value="Cancel"></td>
				
				
			</tr>
			</c:forEach>
		</table>
	</form>
	
</body>
</html>