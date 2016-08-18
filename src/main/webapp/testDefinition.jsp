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
		Von: <stripes:text name="test.von"></stripes:text><br /><br />
		Nach: <stripes:text name="test.nach"/><br /><br />
		Datum: <stripes:text name="test.zeitpunkt" formatType="date" formatPattern="YYYY-MM-dd" value="jjjj-mm-tt"/><br /><br />
		Reisende:
		<stripes:select name="test.reisende" size="1">
			<stripes:option value="1">1 Reisender</stripes:option>
			<stripes:option value="2">2 Reisende</stripes:option>
			<stripes:option value="3">3 Reisende</stripes:option>
			<stripes:option value="4">4 Reisende</stripes:option>
			<stripes:option value="5">5 Reisende</stripes:option>
		</stripes:select><br/><br/>
		Klasse 1: <stripes:radio name="test.klasse" value="1" checked="checked"/><br />
		Klasse 2: <stripes:radio name="test.klasse" value="2"/><br /><br />
		Angebot: <stripes:checkbox name="test.angebot" value="true" checked="checked"/><br />
		<stripes:hidden name="test.angebot" value="false"/>
		Sparpreis: <stripes:checkbox name="test.sparpreis" value="true"/><br />
		<stripes:hidden name="test.sparpreis" value="false"/>
		Flexpreis: <stripes:checkbox name="test.flexpreis" value="true"/><br /><br />
		<stripes:hidden name="test.flexpreis" value="false"/>
		<stripes:submit name="Eintragen" value="senden"/><br /> <br/>
		<c:if test="${actionBean.result != null}">
			<b>${actionBean.result}</b><br/>
			Von ${actionBean.test.von} nach ${actionBean.test.nach}<br/>
    		Datum: ${actionBean.test.zeitpunkt}<br/>
		   	Reisende: ${actionBean.test.reisende} Klasse: ${actionBean.test.klasse}<br/><br/>
		   	Angebot: ${actionBean.test.angebot} Sparpreis: ${actionBean.test.sparpreis} Flexpreis: ${actionBean.test.flexpreis}<br /><br />
		</c:if>
	</stripes:form>
</t:genericpage>