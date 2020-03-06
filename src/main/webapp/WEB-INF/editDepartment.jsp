
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>department</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<div>
    <p><strong>Workers in Department</strong></p> <var>
    <input type="hidden" name="myhiddenvalue" value="<%= request.getParameter("idDepartment") %>" />
    <table>
        <tr>
            <th>Имя</th>
            <th>Должность</th>
            <th>Рабочее место</th>
        </tr>
        <c:forEach var="worker" items="${workersFromDepartment}">
            <tr>
                <td><p>${worker.name}<p></td>
                <td><p>${worker.position}<p></td>
                <td><p>${worker.workposition}<p></td>
                <td><p><a href="removeWorkerFromDepartment?idWorker=${worker.idWorker}">Удалить работника</a><p></td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <p><strong>Workers Without Department</strong></p>

        <tr>
            <th>Имя</th>
            <th>Рабочее место</th>
            <th>Должность</th>
        </tr>
        <c:forEach var="worker" items="${workersWithoutDepartment}">
            <tr>
                <td><p>${worker.name}<p></td>
                <td><p>${worker.position}<p></td>
                <td><p>${worker.workposition}<p></td>
                <td><p><a href="addWorkerInDepartment?idWorker=${worker.idWorker}">Добавить</a><p></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
