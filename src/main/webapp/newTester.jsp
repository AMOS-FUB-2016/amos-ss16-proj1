<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="userTest" class="de.fuberlin.chaostesting.UserTest" />

<t:genericpage>
	<h1>Chaos Testing</h1>
	<p>${userTest.newTester()}</p>
</t:genericpage>