<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="userTest" class="de.fuberlin.chaostesting.UserTest" />
<jsp:useBean id="now" class="java.util.Date"/>

<t:genericpage>
	<h1>Nutzer-Liste</h1>
	<table style = "border:1px solid grey; background-color: #F8F8F8">
		<tr><th>Nutzername</th><th>Passwort-Hash</th><th>Admin</th></tr>
		<c:forEach items="${userTest.users}" var="user">
		    <tr><td>${user.userName} </td><td> ${user.passHash} </td><td> ${user.admin}</td></tr>
		</c:forEach>
	</table>
	<fmt:formatDate value="${now}" pattern="dd-MM-yyyy" />
</t:genericpage>