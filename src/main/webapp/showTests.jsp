<jsp:useBean id="startseite" class="de.fuberlin.chaostesting.Startseite" />
<jsp:useBean id="testTest" class="de.fuberlin.chaostesting.TestTest" />
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
			<h1>Test-Liste</h1>
				<table style = "border:1px solid grey; background-color: #F8F8F8">
					${testTest.getTests()}
				</table>
				<p><%= new java.util.Date() %></p>
		</section>
		<footer><p>${startseite.footer()}</p></footer>
	</body>
</html>