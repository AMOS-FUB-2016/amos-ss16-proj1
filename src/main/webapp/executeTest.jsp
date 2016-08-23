<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>

<t:genericpage>
	<h1>Testausführung</h1>
	<stripes:errors />
	<xmp>${actionBean.response}</xmp>
</t:genericpage>
