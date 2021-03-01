
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Bill List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="menu.jsp"/>

<p>Insert Bill</p>
            <table border="1" style="width: 100%">
<form action="/user/bill/save">
    <tr>
    <td>
        <select name = "uiCustomerId">
        <Option value = "select">Select Customer</Option>
        <c:forEach items="${requestScope.customerList}" var="customerList">
            <option value="${customerList.customerId}">${customerList.firstName}</option>
        </c:forEach>
    </select>
    </td>
    </tr>

    <tr>
        <td>File Number : <input type="text" name="fileNumber"/></td>
        <td>identification Code : <input type="text" name="identificationCode"/></td>
        <td>computerPassCode : <input type="text" name="computerPassCode"/></td>
        <td>tariff : <input type="text" name="tariff"/>

        </tr>
    <tr>
        <td>period : <input type="text" name="period"/></td>
        <td>year : <input type="text" name="year"/></td>
        <td>paymentID : <input type="text" name="paymentID"/></td>
        <td>prompt : <input type="date" name="prompt"/></td>

    </tr>
    <tr>
        <td>credit : <input type="text" name="credit"/></td>
        <td>debit : <input type="text" name="debit"/></td>
        <td>normalConsumption : <input type="text" name="normalConsumption"/></td>
        <td>electricityPhase : <input type="text" name="electricityPhase"/></td>
    </tr>
    <tr>
        <td>highPeakConsumption : <input type="text" name="highPeakConsumption"/></td>
        <td>lowPeakConsumption : <input type="text" name="lowPeakConsumption"/></td>
        <td>tax :<input type="text" name="tax"/></td>
    </tr>
    <tr>
    <td><input type="submit"/></td>
    </tr>
</form>
            </table>


<p>Bill List</p>
<table border="1" style="width: 100%">
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
        <td>update</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${requestScope.billList}" var="bill">
    <tr>
        <form action="/user/bill/update">
            <td><input type="text" readonly  name="billId" value="${bill.billId}"style="width: 100%"/></td>
            <td><input type="text"  name="fileNumber" value="${bill.fileNumber}"style="width: 100%"/></td>
            <td><input type="text"  name="identificationCode" value="${bill.identificationCode}"style="width: 100%"/></td>
            <td><input type="text"  name="computerPassCode" value="${bill.computerPassCode}"style="width: 100%"/></td>
            <td><input type="text"  name="tariff" value="${bill.tariff}"style="width: 100%"/></td>
            <td><input type="text"  name="electricityPhase" value="${bill.electricityPhase}"style="width: 100%"/></td>
            <td><input type="text"  name="period" value="${bill.period}"style="width: 100%"/></td>
            <td><input type="text"  name="year" value="${bill.year}"style="width: 100%"/></td>
            <td><input type="text"  name="paymentID" value="${bill.paymentID}"style="width: 100%"/></td>
            <td><input type="date"  name="prompt" value="${bill.prompt}"style="width: 100%"/></td>
            <td><input type="text"  name="tax" value="${bill.tax}"style="width: 100%"/></td>
            <td><input type="text"  name="credit" value="${bill.credit}"style="width: 100%"/></td>
            <td><input type="text"  name="debit" value="${bill.debit}"style="width: 100%"/></td>
            <td><input type="text"  name="normalConsumption" value="${bill.normalConsumption}"style="width: 100%"/></td>
            <td><input type="text"  name="highPeakConsumption" value="${bill.highPeakConsumption}"style="width: 100%"/></td>
            <td><input type="text"  name="lowPeakConsumption" value="${bill.lowPeakConsumption}"style="width: 100%"/></td>
            <td><input type="text"  name="totalPayment" value="${bill.totalPayment}"style="width: 100%"/></td>
            <td><input type="submit" value="update" style="width: 100%"/></td>
            <td><input type="button" onclick="removeBill(${bill.billId})" value="delete" style="width: 100%"/></td>
        </form>
    </tr>
    </c:forEach>

</table>

<div>
   <p>Find a bill by id :</p>
    <form action="/user/bill/findById">
    <input type="text" name="id"/>
    <input type="submit"/>
</form>
</div>

<script>
    function removeBill(id) {
        if (confirm('are u sure?'))
            window.location = "/user/bill/delete?id=" + id;
    }
</script>

<c:set var="err_msg" value="${requestScope.err_msg}" />
<c:if test = "${requestScope.err_msg != null }" >
    <script>
        alert("Bill not found");
    </script>
</c:if>

</body>
</html>
