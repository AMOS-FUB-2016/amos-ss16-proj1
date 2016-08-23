<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dynattr"
	uri="http://stripes.sourceforge.net/stripes-dynattr.tld"%>

<t:genericpage>
	<h1>Test-Definition</h1>
	<h3>Änderung der Test-Daten</h3>
	<stripes:form beanclass="de.fuberlin.chaostesting.UpdateTestAction">
		<stripes:errors />
		<stripes:hidden name="id" value="${ActionBean.id}" />
		Von: <stripes:text name="test.von" />
		<br />
		<br />
		Nach: <stripes:text name="test.nach" />
		<br />
		<br />
		Datum: <dynattr:text type="date" name="test.zeitpunkt"
			formatType="date" formatPattern="YYYY-MM-dd" />
		<br />
		<br />
		Uhrzeit: <dynattr:text type="time" name="uhrzeit"
			formatPattern="HH:mm" />
		<br />
		<br />
		Reisende:
		<stripes:select name="test.reisende" size="1">
			<stripes:option value="1">1 Reisender</stripes:option>
			<stripes:option value="2">2 Reisende</stripes:option>
			<stripes:option value="3">3 Reisende</stripes:option>
			<stripes:option value="4">4 Reisende</stripes:option>
			<stripes:option value="5">5 Reisende</stripes:option>
		</stripes:select>
		<br />
		<br />
		Klasse 1: <stripes:radio name="test.klasse" value="1"
			checked="checked" />
		<br />
		Klasse 2: <stripes:radio name="test.klasse" value="2" />
		<br />
		<br />
		Angebot: <stripes:checkbox name="test.angebot" value="true"
			checked="checked" />
		<br />
		Sparpreis: <stripes:checkbox name="test.sparpreis" value="true" />
		<br />
		Flexpreis: <stripes:checkbox name="test.flexpreis" value="true" />
		<br />
		<br />
		<stripes:submit name="Eintragen" value="senden" />
		<br />
		<br />
		<c:if test="${actionBean.result != null}">
			<b>${actionBean.result}</b>
			<br />
			Von ${actionBean.test.von} nach ${actionBean.test.nach}<br />
    		Datum: ${actionBean.test.zeitpunkt}<br />
		   	Reisende: ${actionBean.test.reisende} Klasse: ${actionBean.test.klasse}<br />
			<br />
		   	Angebot: ${actionBean.test.angebot} Sparpreis: ${actionBean.test.sparpreis} Flexpreis: ${actionBean.test.flexpreis}<br />
			<br />
		</c:if>
	</stripes:form>
</t:genericpage>
