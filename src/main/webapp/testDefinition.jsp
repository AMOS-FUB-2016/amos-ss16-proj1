<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
	<h1>Test-Definition</h1>
	<h3>
		Eingabe der Test-Daten
	</h3>
	<stripes:form beanclass="de.fuberlin.chaostesting.TestAction">
		<stripes:errors/>
		Von: <stripes:text name="test.testVon"></stripes:text><br /><br />
		Nach: <stripes:text name="test.testNach"/><br /><br />
		Datum: <stripes:text name="test.testHinfahrt" formatType="date" formatPattern="YYYY-MM-dd" value="jjjj-mm-tt"/><br /><br />
		Reisende:
		<stripes:select name="test.testReisende" size="1">
			<stripes:option value="1">1 Reisender</stripes:option>
			<stripes:option value="2">2 Reisende</stripes:option>
			<stripes:option value="3">3 Reisende</stripes:option>
			<stripes:option value="4">4 Reisende</stripes:option>
			<stripes:option value="5">5 Reisende</stripes:option>
		</stripes:select><br/><br/>
		Klasse 1: <stripes:radio name="test.testKlasse" value="1" checked="checked"/><br />
		Klasse 2: <stripes:radio name="test.testKlasse" value="2"/><br /><br />
		Preis (Sollwert): <stripes:text name="test.testPreis" value="0"/><br /><br />
		<stripes:submit name="Eintragen" value="senden"/><br /> <br/>
		<c:if test="${actionBean.result != null}">
			<b>${actionBean.result}</b><br/>
			Von ${actionBean.test.testVon} nach ${actionBean.test.testNach}<br/>
    		Datum: ${actionBean.test.testHinfahrt}<br/>
		   	Reisende: ${actionBean.test.testReisende} Klasse: ${actionBean.test.testKlasse}<br/><br/>
		   	Preis (Sollwert): ${actionBean.test.preis}<br />
		</c:if>
		
	</stripes:form>
</t:genericpage>