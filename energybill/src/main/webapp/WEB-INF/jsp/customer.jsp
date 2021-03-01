<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Customer List</title>
</head>
<body>
<jsp:include page="menu.jsp"/>

<p>Insert a Customer :</p>
<table>
<form action="/user/customer/save">
    <tr>
        <td>nationalId :<input type="text" name="nationalId"/></td>
        <td>birthDate :<input type="date" name="birthDate"/></td>
        <td>firstName :<input type="text" name="firstName"/></td>
        <td> lastName :<input type="text" name="lastName"/></td>
        <td> fatherName :<input type="text" name="fatherName"/></td>
        <td> address :<input type="text" name="address"/></td>
        <td> postalCode :<input type="text" name="postalCode"/></td>
    </tr>
    <tr>
        <td><input type="submit"/></td>
    </tr>
</form>
    </table>

<p>Customer List</p>
<table border="1" style="width: 100%">
    <tr>
        <td>ID</td>
        <td>National_ID</td>
        <td>birthDate</td>
        <td>firstName</td>
        <td>lastName</td>
        <td>fatherName</td>
        <td>address</td>
        <td>postalCode</td>
        <td>update</td>
        <td>delete</td>
    </tr>

    <c:forEach items="${requestScope.customerList}" var="customer">
        <tr>
            <form action="/user/customer/update">
            <td><input type="text" readonly  name="customerId" value="${customer.customerId}"style="width: 100%"/></td>
            <td><input type="text"  name="nationalId" value="${customer.nationalId}"style="width: 100%"/></td>
            <td><input type="date"  name="birthDate" value="${customer.birthDate}"style="width: 100%"/></td>
            <td><input type="text"  name="firstName" value="${customer.firstName}"style="width: 100%"/></td>
            <td><input type="text"  name="lastName" value="${customer.lastName}"style="width: 100%"/></td>
            <td><input type="text"  name="fatherName" value="${customer.fatherName}"style="width: 100%"/></td>
            <td><input type="text"  name="address" value="${customer.address}"style="width: 100%"/></td>
            <td><input type="text"  name="postalCode" value="${customer.postalCode}"style="width: 100%"/></td>
            <td><input type="submit" value="update" style="width: 100%"/></td>
            <td><input type="button" onclick="removeCustomer(${customer.customerId})" value="delete" style="width: 100%"/></td>
            </form>
        </tr>
    </c:forEach>
</table>


<p>Find a customer by id :</p>
<form action="/user/customer/findById">
    <input type="text" name="id"/>
    <input type="submit"/>
</form>

<script>
    function removeCustomer(id) {
        if (confirm('are u sure?'))
            window.location = "/user/customer/delete?id=" + id;
    }
</script>
</body>
</html>
