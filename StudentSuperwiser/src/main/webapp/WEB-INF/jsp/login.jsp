<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
<html>

    <body onload='document.loginForm.username.focus();'>
        <h1 id="banner">Login to Security Demo</h1> 
       
        <a href="/SpringSecurity/newuser">Go to Registration page</a>
        
        <form name="f" action="<c:url value='j_spring_security_check'/>"
                    method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type='text' name='userName' /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='password'></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
		<td></td>
		<td>Remember Me: <input type="checkbox" name="_spring_security_remember_me" /></td>
	</tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit">&nbsp;<input name="reset" type="reset"></td>
                </tr>
            </table>
        </form>
    </body>
</html>