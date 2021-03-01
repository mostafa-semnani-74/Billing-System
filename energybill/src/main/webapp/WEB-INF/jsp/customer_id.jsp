
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer By Id</title>
</head>
<body>
<jsp:include page="menu.jsp"/>

<table>
    <tr>
        <td>ID</td>
        <td>National_ID</td>
        <td>birthDate</td>
        <td>firstName</td>
        <td>lastName</td>
        <td>fatherName</td>
        <td>address</td>
        <td>postalCode</td>
    </tr>
</table>

<table>
    <c:set var="customer" value="${requestScope.customer}" />
    <tr>
        <td>${customer.customerId}</td>
        <td>${customer.nationalId}</td>
        <td>${customer.birthDate}</td>
        <td>${customer.firstName}</td>
        <td>${customer.lastName}</td>
        <td>${customer.fatherName}</td>
        <td>${customer.address}</td>
        <td>${customer.postalCode}</td>
    </tr>
</table>

</body>
</html>
