<jsp:useBean id="startseite" class="de.fuberlin.chaostesting.Startseite" />
<jsp:useBean id="userTest" class="de.fuberlin.chaostesting.UserTest" />
<!DOCTYPE html> 
<html>
	<head>
		<link rel="stylesheet" href="style.css" type="text/css" />
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
			<p>${userTest.newAdmin()}</p>
		</section>
		<footer><p>${startseite.footer()}</p></footer>
	</body>
</html>