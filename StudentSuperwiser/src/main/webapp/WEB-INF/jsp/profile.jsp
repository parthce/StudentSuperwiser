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
<div id="slider1">
	<table>
			<tr>
				<td>Country</td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td>Postal Code</td>
				<td><form:input path="postalcode" /></td>
			</tr>
			<tr>
				<td>Date Of Birth(dd-mm-yyyy)</td>
				<td><form:input path="dob" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				
				<td>
					<form:select path="gender">
						<form:option value="Male" label="Male" />
						<form:option value="Female" label="Female" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Phone No</td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td>Language</td>
				<td><form:input path="language" /></td>
			</tr>
			<tr>
				<td>Bio</td>
				<td><form:textarea path="bio" /></td>
			</tr>
		</table>
</div>
<div id="slider2">
<table>
			<tr>
				<td>Activities</td>
				<td><form:textarea path="activities"/></td>
			</tr>
			<tr>
				<td>Interests</td>
				<td><form:textarea path="interests" /></td>
			</tr>
		</table>
</div>
<div id="slider3">
<table>
	  		<tr>
	  		 	<%-- <td><form:label path="image">Upload Image</form:label></td>	 --%>
				<td>Upload Image</td>
				<td><input type="file" name="image" id="image" accept="image/*"></td>
			</tr>  
			<tr>
				<td>What's On Your Mind</td>
				<td><form:input path="whatsonmind" /></td>
			</tr>
			<tr>
				<td>Occupation</td>
				<td>
				<form:select path="occupation">
						<form:option value="teacher" label="Teacher" />
						<form:option value="student" label="Student" />
						<form:option value="professor" label="Professor" />
						<form:option value="expert" label="Experts" />
				</form:select></td>
			</tr>
			<tr>
				<td><input type="submit" name="skip" value="SKIP"></td>
				<td><input type="submit" name="finish" value="FINISH"></td>
			</tr>
			</table>
</div>
</form:form>
</body>
</html>