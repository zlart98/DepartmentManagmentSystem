<%--
  Created by IntelliJ IDEA.
  User: ostzna3
  Date: 06.09.2019
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Worker</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<span style="color:red"><p><strong>${inputFormatException}</strong></p></span>

<div>
    <div>
        <p><strong>Создание работника</strong></p>
    </div>
    <form action="/worker/saveOrUpdate" method="post" accept-charset="utf-8">
        <input type="text" name="name" placeholder="Имя" />
        <input type="text" name="position" placeholder="Должность" />
        <input type="text" name="workposition" placeholder="Рабочее место" />
        <input type="text" name="idDepartment" placeholder="Номер департамента" />
        <button type="submit">Создать</button>
    </form>
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
                <td><p><a href="/worker/removeWorker?idWorker=${worker.idWorker}">Убрать</a><p></td>
                <td><form action="/worker/saveOrUpdate?idWorker=${worker.idWorker}" method="post" accept-charset="utf-8">
                    <input type="text" name="name" placeholder="Имя" />
                    <input type="text" name="position" placeholder="Должность" />
                    <input type="text" name="workposition" placeholder="Место" />

                  <%--  <select name="department">
                         <c:forEach var="department" items="${departmentList}">
                         <option>${department.idDepartment}</option>
                         </c:forEach>
                     </select>--%>
                    <button type="submit">Редактирование</button>
                </form></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
