
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bill By Id</title>
</head>
<body>
<jsp:include page="menu.jsp"/>

<table>
    <tr>
        <td>ID</td>
        <td>fileNumber</td>
        <td>identificationCode</td>
        <td>computerPassCode</td>
        <td>tariff</td>
        <td>electricityPhase</td>
        <td>period</td>
        <td>year</td>
        <td>paymentID</td>
        <td>prompt</td>
        <td>tax</td>
        <td>credit</td>
        <td>debit</td>
        <td>normalConsumption</td>
        <td>highPeakConsumption</td>
        <td>lowPeakConsumption</td>
        <td>totalPayment</td>
    </tr>
    <c:set var="bill" value="${requestScope.bill}" />
        <tr>
            <td>${bill.billId}</td>
            <td>${bill.fileNumber}</td>
            <td>${bill.identificationCode}</td>
            <td>${bill.computerPassCode}</td>
            <td>${bill.tariff}</td>
            <td>${bill.electricityPhase}</td>
            <td>${bill.period}</td>
            <td>${bill.year}</td>
            <td>${bill.paymentID}</td>
            <td>${bill.prompt}</td>
            <td>${bill.tax}</td>
            <td>${bill.credit}</td>
            <td>${bill.debit}</td>
            <td>${bill.normalConsumption}</td>
            <td>${bill.highPeakConsumption}</td>
            <td>${bill.lowPeakConsumption}</td>
            <td>${bill.totalPayment}</td>
        </tr>
</table>

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
