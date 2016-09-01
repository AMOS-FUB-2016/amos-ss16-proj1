<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="res/style.css" type="text/css" />
<title>Chaos Testing</title>
</head>
<body>
	<header>
		<nav>
			<div class="left">
				<a href="index.jsp">Startseite</a> - <a href="defineTest.jsp">Test-Definition</a>
				-
				<stripes:link beanclass="de.fuberlin.chaostesting.ShowTestsAction">Test-Liste</stripes:link>
				-
				<stripes:link
					beanclass="de.fuberlin.chaostesting.ShowResponsesAction">Antwort-Liste</stripes:link>
			</div>
			<div class="right">
				<a href="newAdmin.jsp">Test-Admin hinzufügen</a> - <a
					href="newTester.jsp">Test-Anwender hinzufügen</a> - <a
					href="showUsers.jsp">Nutzer-Liste</a>
			</div>
		</nav>
	</header>

	<section class="clear">
		<jsp:doBody />
	</section>

	<footer>
		<p>AMOS-Projekt - Testautomat - FU Berlin - 2016 - Mid-Release 4</p>
	</footer>
</body>
</html>
