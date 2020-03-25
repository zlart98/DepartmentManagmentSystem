<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>


<a href="${pageContext.request.contextPath}/department">
    Department
</a>
||
<a href="${pageContext.request.contextPath}/worker">
    Emploee
</a>
||
<a href="/j_spring_security_logout">
    Logout
</a>

&nbsp;
<span style="color:limegreen">[ ${loginedUser.userName} ]</span>