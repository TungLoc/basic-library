<%-- 
    Document   : createNewAccount
    Created on : Jul 1, 2020, 3:16:26 PM
    Author     : TungLoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            Username <input type="text" name="txtUsername" value="" /></br>
            <font color="red">${requestScope.ERROR.userIDError}</font></br>
            Fullname <input type="text" name="txtFullname" value="" /></br>
            <font color="red">${requestScope.ERROR.fullnameError}</font></br>
            Address <input type="text" name="txtAddress" value="" /></br>
            Phone <input type="text" name="txtPhone" value="" /></br>
            Password <input type="password" name="txtPassword" value="" /></br>
            <font color="red">${requestScope.ERROR.passwordError}</font></br>
            RePassword <input type="password" name="txtRePassword" value="" /></br>
            <font color="red">${requestScope.ERROR.rePasswordError}</font></br>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
            <input type="submit" value="Create" name="btnAction" />
        </form>
    </body>
</html>
