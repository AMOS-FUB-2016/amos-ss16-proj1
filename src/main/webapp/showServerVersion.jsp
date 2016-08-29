<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>

<t:genericpage>
	<h1>Server-Version</h1>
	<stripes:errors />
	<p>${actionBean.result}</p>
</t:genericpage>
