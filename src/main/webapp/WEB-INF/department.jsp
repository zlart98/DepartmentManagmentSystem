<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <title>Department</title>
</head>

<body>
<jsp:include page="menu.jsp"></jsp:include>

<span style="color:red"><p><strong>${inputFormatException}</strong></p></span>
<sec:authorize access="hasRole('ADMIN')">
<div>
    <div>
        <p><strong>Создание отдела</strong></p>
    </div>

    <form action="/department/saveOrUpdate" method="post" accept-charset="utf-8">
        <input type="text" name="name" placeholder="Название отдела" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button type="submit">Создать</button>
    </form>
</div>
</sec:authorize>
<div>
    <p><strong>Список отделов</strong></p>
</div>
<div>
    <table>
        <tr>
            <th>Название</th>
            <th>Номер</th>
        </tr>
        <c:forEach var="department" items="${departmentList}">
            <tr>
                <td><p><a href="/department/enterTheDepartment/${department.idDepartment}/">${department.departmentName}</a><p></td>
                <td><p><c:out value="${department.idDepartment}"></c:out><p></td>
                <sec:authorize access="hasRole('ADMIN')">
                <td><p><a href="/department/removeDepartment?idDepartment=${department.idDepartment}">Удаление отдела</a><p></td>
                <td><form action="/department/saveOrUpdate?idDepartment=${department.idDepartment}" method="post" accept-charset="utf-8">
                    <input type="text" name="name" placeholder="Название отдела" />
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
