<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="testTest" class="de.fuberlin.chaostesting.TestTest" />
<jsp:setProperty name="testTest" property="executeId" value="${param.id}"/>

<t:genericpage>
	<h1>Testausführung</h1>
	${testTest.executeTest()}
</t:genericpage>