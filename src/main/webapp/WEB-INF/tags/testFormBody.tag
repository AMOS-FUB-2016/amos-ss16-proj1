<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib prefix="dynattr" uri="http://stripes.sourceforge.net/stripes-dynattr.tld"%>

<table class="form">
	<tr>
		<td>Von:</td>
		<td><stripes:text name="test.von" /></td>
		<td><stripes:errors field="test.von"/></td>
	</tr>
	<tr>
		<td>Nach:</td>
		<td><stripes:text name="test.nach" /></td>
		<td><stripes:errors field="test.nach"/></td>
	</tr>
	<tr>
		<td>Datum:</td>
		<td><dynattr:text type="date" name="test.zeitpunkt"
				formatType="date" formatPattern="YYYY-MM-dd" value="JJJJ-MM-TT" /></td>
		<td><stripes:errors field="test.zeitpunkt"/></td>
	</tr>
	<tr>
		<td>Uhrzeit:</td>
		<td><dynattr:text type="time" name="uhrzeit"
				formatPattern="HH:mm" value="SS:MM" /></td>
		<td><stripes:errors field="uhrzeit"/></td>
	</tr>
	<tr>
		<td>Erwachsene:</td>
		<td><stripes:text name="test.erwachsene"
				value="${test.erwachsene}" /></td>
		<td><stripes:errors field="test.erwachsene"/></td>
	</tr>
	<tr>
		<td>Klasse:</td>
		<td><stripes:select name="test.klasse" size="1">
				<stripes:option value="KLASSE_1">Klasse 1</stripes:option>
				<stripes:option value="KLASSE_2">Klasse 2</stripes:option>
			</stripes:select></td>
		<td><stripes:errors field="test.klasse"/></td>
	</tr>
</table>
<stripes:errors field="test.VonNach"/>
