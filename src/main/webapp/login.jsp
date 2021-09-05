<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021-09-05
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div align="center">
    <h1>Login Form</h1>
    <form action="<%=request.getContextPath()%>/auth" method="post">
        <table style="with: 100%">
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>

    </form>
    <c:if test ="${not empty message}">
        <div class="alert alert-${alert}">
            ${message}
        </div>
    </c:if>
    <div class="container text-left">
        <a href="<%=request.getContextPath()%>/register" class="btn btn-success">Register</a>
    </div>
</div>
</body>
</html>
