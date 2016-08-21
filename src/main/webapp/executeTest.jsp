<jsp:useBean id="startseite" class="de.fuberlin.chaostesting.Startseite" />
<jsp:useBean id="testTest" class="de.fuberlin.chaostesting.TestTest" />
<jsp:setProperty name="testTest" property="executeId" value="<%=request.getParameter(\"id\")%>"/>
<!DOCTYPE html> 
<html>
	<head>
		<link rel="stylesheet" href="style.css" type="text/css" />
		<title>Chaos Testing - Test-Liste</title>	
	</head>
	<body>
		<header>
			<nav>
				<div class="left">
					${startseite.navTest()}
				</div>
				<div class="right">
					${startseite.navUser()}
				</div>
				
			</nav>		
		</header>
		<section class="clear">
			<h1>Testausführung</h1>
			${testTest.executeTest()}
		</section>
		<footer><p>${startseite.footer()}</p></footer>
	</body>
</html>