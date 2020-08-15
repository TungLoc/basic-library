<%-- 
    Document   : view
    Created on : Jul 4, 2020, 5:29:46 PM
    Author     : TungLoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
        <style>
            p {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN.role != 'User'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>
        <c:if test="${sessionScope.LOGIN.role == 'User'}">
            <h1>Your Order Details: </h1>
            <c:url var="back" value="MainController">
                <c:param name="btnAction" value="Search"></c:param>
                <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
            </c:url>
            <h2 style="color: red;">${requestScope.MESSAGE}</h2>
            <h2 style="color: red;">${requestScope.QUANTITY}</h2>
            <a href="${back}">Back to shopping</a>
            <c:set var="total" value="0"></c:set>
            <c:set var="cart" value="${sessionScope.CART}"></c:set>
                <table border="1" width="100%">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Image</th>
                            <th>Bookname</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" varStatus="counter" items="${cart.cart.values()}">
                    <input type="hidden" name="" value="${total = total + dto.price * dto.quantity}" />
                    <form action="MainController">
                        <tr>
                            <td width="10%">
                                <p>${counter.count}</p>
                            </td>
                            <td width="30%"><img src="${dto.url}" width="100%" height="300"></td>
                            <td width="25%">
                                <p>${dto.bookname}</p>
                            </td>
                            <td width="8%">
                                <p><input type="number" name="txtQuantity" value="${dto.quantity}" /></p>
                            </td>
                            <td width="8%">
                                <p>${dto.price}</p>
                            </td>
                            <td width="9%">
                                <p>${dto.price * dto.quantity}</p>
                            </td>
                            <td width="5%">
                                <input type="hidden" name="txtBookID" value="${dto.bookID}" />
                                <p><input type="submit" name="btnAction" value="Delete Order" /></p>
                            </td>
                            <td width="5%">
                                <p><input type="submit" name="btnAction" value="Update Order" /></p>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>
        <h1>Total: ${total}</h1>
        <form action="MainController">
            <input type="hidden" name="txtTotal" value="${total}" />
            <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
            <input type="submit" name="btnAction" value="Checkout" />
        </form>
    </c:if>
</body>
</html>
