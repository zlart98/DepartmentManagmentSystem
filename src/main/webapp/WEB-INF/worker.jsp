<%--
  Created by IntelliJ IDEA.
  User: ostzna3
  Date: 06.09.2019
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Worker</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<span style="color:red"><p><strong>${inputFormatException}</strong></p></span>

<div>
    <sec:authorize access="hasRole('ADMIN')">
    <div>
        <p><strong>Создание работника</strong></p>
    </div>
    <form action="/worker/saveOrUpdate" method="post" accept-charset="utf-8">
        <input type="text" name="name" placeholder="Имя" />
        <input type="text" name="position" placeholder="Должность" />
        <input type="text" name="workposition" placeholder="Рабочее место" />
        <input type="text" name="idDepartment" placeholder="Номер департамента" />
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Создать</button>
    </form>
    </sec:authorize>
</div>
<div>
    <table>
        <tr>
            <th>Имя</th>
            <th>Должность</th>
            <th>Рабочее место</th>
            <th>Номер департамента</th>
        </tr>
        <c:forEach var="worker" items="${workerList}">
            <tr>
                <td><p>${worker.name}<p></td>
                <td><p>${worker.position}<p></td>
                <td><p>${worker.workposition}<p></td>
                <td><p>${worker.departmentByIdDepartment.idDepartment}<p></td>
                <sec:authorize access="hasRole('ADMIN')">
                <td><p><a href="/worker/removeWorker?idWorker=${worker.idWorker}">Убрать</a><p></td>
                <td><form action="/worker/saveOrUpdate?idWorker=${worker.idWorker}" method="post" accept-charset="utf-8">
                    <input type="text" name="name" placeholder="Имя" />
                    <input type="text" name="position" placeholder="Должность" />
                    <input type="text" name="workposition" placeholder="Место" />
                  <select name="idDepartment">
                         <c:forEach var="department" items="${departmentList}">
                         <option>${department.idDepartment}</option>
                         </c:forEach>
                     </select>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button type="submit">Редактирование</button>
                </form></td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
