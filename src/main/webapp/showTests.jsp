<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<jsp:useBean id="now" class="java.util.Date"/>

<t:genericpage>
	<h1>Test-Liste</h1>
	<table style = "border:1px solid grey; background-color: #F8F8F8">
		<tr><th>Von</th><th>Nach</th><th>Datum</th><th>Reisende</th><th>Klasse</th><th>Angebot</th><th>Sparpreis</th><th>Flexpreis</th><th>Aktionen</th></tr>
		<c:forEach items="${actionBean.tests}" var="test">
			<tr><td>${test.von}
			</td><td>${test.nach}
			</td><td>${test.zeitpunkt}
			</td><td>${test.reisende}
			</td><td>${test.klasse}
			</td><td>${test.angebot}
			</td><td>${test.sparpreis}
			</td><td>${test.flexpreis}
			</td><td>
			<stripes:link beanclass="de.fuberlin.chaostesting.ExecuteTestAction">
				<stripes:param name="id" value="${test.id}"/>
				Ausführen
			</stripes:link>
			 | 
			<stripes:link beanclass="de.fuberlin.chaostesting.UpdateTestAction">
				<stripes:param name="id" value="${test.id}"/>
				Bearbeiten
			</stripes:link>
			</td></tr>
		</c:forEach>
	</table>
	<fmt:formatDate value="${now}" pattern="dd-MM-yyyy" />
</t:genericpage>