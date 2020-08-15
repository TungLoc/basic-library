<%-- 
    Document   : createNewBook
    Created on : Jul 3, 2020, 1:12:44 PM
    Author     : TungLoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Book Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN.role != 'Admin'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>
        <c:if test="${sessionScope.LOGIN.role == 'Admin'}">
            <form action="MainController">
                BookID <input type="text" name="txtBookID" value="" /></br>
                <font color="red">${requestScope.ERROR_BOOK.bookIDError}</font></br>
                Bookname <input type="text" name="txtBookname" value="" /></br>
                <font color="red">${requestScope.ERROR_BOOK.bookNameError}</font></br>
                Auhthor <input type="text" name="txtAuthor" value="" /></br>
                <font color="red">${requestScope.ERROR_BOOK.authorError}</font></br>
                Quantity <input type="text" name="txtQuantity" value="" /></br>
                <font color="red">${requestScope.ERROR_BOOK.quantityError}</font></br>
                Price <input type="text" name="txtPrice" value="" /></br>
                <font color="red">${requestScope.ERROR_BOOK.priceError}</font></br>
                ImageURL <input type="text" name="txtUrl" value="" /></br>
                <input type="checkbox" name="chkAvailable" value="ON" /> Available to borrow</br>
                <input type="submit" name="btnAction" value="Create Book" />
            </form>
        </c:if>
    </body>
</html>
