<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>

<t:genericpage>
	<h1>Antwort</h1>
	<stripes:errors />
	<xmp>${actionBean.result}</xmp>
</t:genericpage>
