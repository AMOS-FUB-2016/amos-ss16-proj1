<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib prefix="dynattr" uri="http://stripes.sourceforge.net/stripes-dynattr.tld"%>

Von: <stripes:text name="test.von" />
<br />
<br />
Nach: <stripes:text name="test.nach" />
<br />
<br />
Datum: <dynattr:text type="date" name="test.zeitpunkt"
	formatType="date" formatPattern="YYYY-MM-dd" value="JJJJ-MM-TT" />
<br />
<br />
Uhrzeit: <dynattr:text type="time" name="uhrzeit"
	formatPattern="HH:mm" value="SS:MM" />
<br />
<br />
Erwachsene: <stripes:text name="test.erwachsene" value="${test.erwachsene}"/>
<br />
<br />

Klasse: 
<stripes:select name="test.klasse" size="1">
	<stripes:option value="KLASSE_1">Klasse 1</stripes:option>
	<stripes:option value="KLASSE_2">Klasse 2</stripes:option>
</stripes:select><br/>