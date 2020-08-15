<%-- 
    Document   : update
    Created on : Jul 3, 2020, 12:01:56 PM
    Author     : TungLoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN.role != 'Admin'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>
        <c:if test="${sessionScope.LOGIN.role == 'Admin'}">
            <form action="MainController">
                BookID <input type="text" name="txtBookID" value="${param.txtBookID}" readonly="true" /></br>
                Bookname <input type="text" name="txtBookname" value="${param.txtBookname}" /></br>
                <font color="red">${requestScope.ERROR_BOOK.bookNameError}</font></br>
                Auhthor <input type="text" name="txtAuthor" value="${param.txtAuthor}" /></br>
                <font color="red">${requestScope.ERROR_BOOK.authorError}</font></br>
                Quantity <input type="text" name="txtQuantity" value="${param.txtQuantity}" /></br>
                <font color="red">${requestScope.ERROR_BOOK.quantityError}</font></br>
                Price <input type="text" name="txtPrice" value="${param.txtPrice}" /></br>
                <font color="red">${requestScope.ERROR_BOOK.priceError}</font></br>
                ImageURL <input type="text" name="txtUrl" value="${param.txtUrl}" /></br>
                <input type="checkbox" name="chkAvailable" value="ON" 
                       <c:if test="${param.txtStatus == 'true'}">
                           checked="checked"
                       </c:if>/> Available to borrow</br>
                <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                <input type="submit" name="btnAction" value="Update Book" />
            </form>
        </c:if>
    </body>
</html>
