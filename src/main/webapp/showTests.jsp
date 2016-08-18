<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="testTest" class="de.fuberlin.chaostesting.TestTest" />
<jsp:useBean id="now" class="java.util.Date"/>

<t:genericpage>
	<h1>Test-Liste</h1>
	<table style = "border:1px solid grey; background-color: #F8F8F8">
		<tr><th>Von</th><th>Nach</th><th>Datum</th><th>Reisende</th><th>Klasse</th><th>Preis</th></tr>
		<c:forEach items="${testTest.tests}" var="test">
			<tr><td>${test.testVon}
			</td><td>${test.testNach}
			</td><td>${test.testHinfahrt}
			</td><td>${test.testReisende}
			</td><td>${test.testKlasse}
			</td><td>${test.preis}
			</td><td><a href="executeTest.jsp?id=${test.id}">Ausführen</a>
			</td></tr>
		</c:forEach>
	</table>
	<fmt:formatDate value="${now}" pattern="dd-MM-yyyy" />
</t:genericpage>