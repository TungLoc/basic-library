<%-- 
    Document   : userpage
    Created on : Jun 30, 2020, 4:09:55 PM
    Author     : TungLoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
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
            <h1>Welcome: ${sessionScope.LOGIN.fullname} </h1>
            <c:url var="logout" value="MainController">
                <c:param name="btnAction" value="Logout"></c:param>
            </c:url>
            &nbsp;<a href="${logout}">Logout</a>
            <c:if test="${sessionScope.CART != null}">
                <c:url var="view" value="MainController">
                    <c:param name="btnAction" value="View"></c:param>
                </c:url>
                <a href="${view}">Cart</a>
            </c:if>
            <form action="MainController">
                Search <input type="text" name="txtSearch" value="${param.txtSearch}" />
                <input type="submit" value="Search" name="btnAction"/>
            </form>

                <c:if test="${requestScope.LIST_BOOK != null}">
                    <c:if test="${not empty requestScope.LIST_BOOK}">
                    <table border="1" width="100%">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Image</th>
                                <th>Bookname</th>
                                <th>Author</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" varStatus="counter" items="${requestScope.LIST_BOOK}">
                                <tr>
                                    <td width="8%">
                                        <p>${counter.count}</p>
                                    </td>
                                    <td width="30%">
                                        <img src="${list.url}" width="100%" height="300">
                                    </td>
                                    <td width="25%">
                                        <p>${list.bookname}</p>
                                    </td>
                                    <td width="10%">
                                        <p>${list.author}</p>
                                    </td>
                                    <td width="8%">
                                        <c:if test="${list.quantity > 0}"><p>${list.quantity}</p></c:if>
                                        <c:if test="${list.quantity == 0}"><p>Sold out</p></c:if>
                                        </td>
                                        <td width="8%">
                                            <p>${list.price}</p>
                                    </td>
                                    <td width="11%">
                                        <c:if test="${list.quantity > 0}">
                                            <form action="MainController">
                                                <input type="hidden" name="txtBookID" value="${list.bookID}" />
                                                <input type="hidden" name="txtBookname" value="${list.bookname}" />
                                                <input type="hidden" name="txtAuthor" value="${list.author}" />
                                                <input type="hidden" name="txtPrice" value="${list.price}" />
                                                <input type="hidden" name="txtUrl" value="${list.url}" />
                                                <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                <p><input type="submit" name="btnAction" value="Add to Cart" /></p>
                                            </form>
                                        </c:if>
                                        <c:if test="${list.quantity == 0}">
                                            <form action="MainController">
                                                <p><input type="submit" name="btnAction" value="Add to Cart" disabled=""/></p>
                                            </form>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </c:if>    
        </c:if>
    </body>
</html>
