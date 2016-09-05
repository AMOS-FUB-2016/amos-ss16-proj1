<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/res/style.css" type="text/css" />
<link rel="apple-touch-icon" sizes="57x57" href="/res/logo/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="/res/logo/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="/res/logo/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="/res/logo/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="/res/logo/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="/res/logo/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="/res/logo/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="/res/logo/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="/res/logo/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="/res/logo/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="/res/logo/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="/res/logo/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="/res/logo/favicon-16x16.png">
<link rel="manifest" href="/res/logo/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/res/logo/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">

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
				-
				<stripes:link 
					beanclass="de.fuberlin.chaostesting.ExecuteAllTestsAction">Alle Tests ausführen</stripes:link>
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
