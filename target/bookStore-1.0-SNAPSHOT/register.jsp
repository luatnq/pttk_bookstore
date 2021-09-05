
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div align="center">
    <h1>Register Form</h1>
    <form action="<%= request.getContextPath() %>/insert" method="post">
        <table style="with: 80%">
            <tr>
                <td>Full name</td>
                <td><input type="text" name="fullName"/></td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td><input type="text" name="phoneNumber"/></td>
            </tr>
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address"/></td>
            </tr>
            <tr>
                <td>Contact No</td>
                <td><input type="text" name="contact"/></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
