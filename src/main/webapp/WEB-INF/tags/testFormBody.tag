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