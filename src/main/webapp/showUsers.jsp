<jsp:useBean id="startseite" class="de.fuberlin.chaostesting.Startseite" />
<jsp:useBean id="userTest" class="de.fuberlin.chaostesting.UserTest" />
<!DOCTYPE html> 
<html>
	<head>
		<link rel="stylesheet" href="style.css" type="text/css" />
		<title>Chaos Testing - Nutzer-Liste</title>
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
			<h1>Nutzer-Liste</h1>
				<table style = "border:1px solid grey; background-color: #F8F8F8">
					${userTest.getUsers()}
				</table>
				<p><%= new java.util.Date() %></p>
		</section>
		<footer><p>${startseite.footer()}</p></footer>
	</body>
</html>