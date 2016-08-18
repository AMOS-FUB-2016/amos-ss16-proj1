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
		Von: <stripes:text name="von"></stripes:text><br /><br />
		Nach: <stripes:text name="nach"/><br /><br />
		Datum: <stripes:text name="hinfahrt" formatType="date" formatPattern="YYYY-MM-dd" value="jjjj-mm-tt"/><br /><br />
		Reisende:
		<stripes:select name="reisende" size="1">
			<stripes:option value="1">1 Reisender</stripes:option>
			<stripes:option value="2">2 Reisende</stripes:option>
			<stripes:option value="3">3 Reisende</stripes:option>
			<stripes:option value="4">4 Reisende</stripes:option>
			<stripes:option value="5">5 Reisende</stripes:option>
		</stripes:select><br/><br/>
		Klasse 1: <stripes:radio name="klasse" value="1"/><br />
		Klasse 2: <stripes:radio name="klasse" value="2"/><br /><br />
		Preis (Sollwert): <stripes:text name="preis" value="0"/><br /><br />
		<stripes:submit name="Eintragen" value="senden"/><br /> <br/>
		<c:if test="${actionBean.result != null}">
			<b>${actionBean.result}</b><br/>
			Von ${actionBean.von} nach ${actionBean.nach}<br/>
    		Datum: ${actionBean.hinfahrt}<br/>
		   	Reisende: ${actionBean.reisende} Klasse: ${actionBean.klasse}<br/><br/>
		   	Preis (Sollwert): ${actionBean.preis}<br />
		</c:if>
		
	</stripes:form>
</t:genericpage>