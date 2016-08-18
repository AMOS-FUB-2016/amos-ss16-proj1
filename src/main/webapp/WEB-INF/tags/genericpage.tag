<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
	<head>
		<link rel="stylesheet" href="style.css" type="text/css" />
		<title>Chaos Testing</title>	
	</head>
	<body>
		<header>
			<nav>
				<div class="left">
					<a href="index.jsp">Startseite</a> - <a href="testDefinition.jsp">Test-Definition</a> - <a href="showTests.jsp">Test-Liste</a>
				</div>
				<div class="right">
					<a href="newAdmin.jsp">Test-Admin hinzufügen</a> - <a href="newTester.jsp">Test-Anwender hinzufügen</a> - <a href="showUsers.jsp">Nutzer-Liste</a>
				</div>
			</nav>		
		</header>
		
		<section class="clear">
	    	<jsp:doBody/>
	   	</section>
		
		<footer><p>AMOS-Projekt - Testautomat - FU Berlin - 2016 - Mid-Release 4</p></footer>
	</body>
</html>