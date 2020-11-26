<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Tiger
  Date: 2020/11/25
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        select {
            width: 200px;
            height: 25px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/showAllTakeAirport" method="post">
    起飞机场：
    <select name="takeid">
        <option value="0">请选择：</option>
        <c:forEach items="${takeportList}" var="takeAirport">
            <option value="${takeAirport.id}">${takeAirport.portName}</option>
        </c:forEach>
    </select>
    降落机场：
    <select name="landid">
        <option value="0">请选择：</option>
        <c:forEach items="${landportList}" var="landAirport">
            <option value="${landAirport.id}">${landAirport.portName}</option>
        </c:forEach>
    </select>
    <input type="submit" value="查询">
</form>
<table border="1">
    <thead>
    <tr>
        <td>飞机编号</td>
        <td>起飞机场</td>
        <td>起飞城市</td>
        <td>降落机场</td>
        <td>降落城市</td>
        <td>航行时间</td>
        <td>票价(元)</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${airplaneList}" var="airplane">
        <tr align="center">
            <td>${airplane.airnumber }</td>
            <td>${airplane.takePort.portName }</td>
            <td>${airplane.takePort.portCity }</td>
            <td>${airplane.landPort.portName }</td>
            <td>${airplane.landPort.portCity }</td>
            <td>
                <c:if test="${airplane.time / 60 > 0}">
                    <fmt:formatNumber value="${airplane.time / 60}" pattern="0"/>小时
                </c:if>
                <c:if test="${airplane.time % 60 > 0}">
                    ${airplane.time % 60}分钟
                </c:if>
            </td>
            <td>${airplane.price }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
