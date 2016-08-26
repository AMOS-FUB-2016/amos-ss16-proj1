<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dynattr"
	uri="http://stripes.sourceforge.net/stripes-dynattr.tld"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:genericpage>
	<h1>Test-Definition</h1>
	<h3>Eingabe der Test-Daten</h3>
	<stripes:form beanclass="de.fuberlin.chaostesting.TestCrudAction" >
		<stripes:errors />
		<t:testFormBody/>
		<br />
		<br />
		<stripes:submit name="create" value="Speichern" />
		<br />
		<br />
		<c:if test="${result != null}">
			<b>${result}</b>
			<br />
			<t:testSummary test="${test}"/>
		</c:if>
	</stripes:form>
</t:genericpage>
