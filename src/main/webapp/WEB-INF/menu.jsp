<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>


<a href="${pageContext.request.contextPath}/department">
    Department
</a>
||
<a href="${pageContext.request.contextPath}/worker">
    Emploee
</a>
<sec:authorize access="isAuthenticated()">
||<a href="<c:url value="/logout" />">Logout</a>



&nbsp;
<span style="color:limegreen">[ <sec:authentication property="name"/> ]</span>
</sec:authorize>