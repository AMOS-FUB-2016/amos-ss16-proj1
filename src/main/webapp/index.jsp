<jsp:useBean id="startseite" class="de.fuberlin.chaostesting.Startseite" />
<!DOCTYPE html> 
<html>
	<head>
		<link rel="stylesheet" href="style.css" type="text/css" />
		<title>Startseite</title>	
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
			<h1>Startseite</h1>
			<p>${startseite.sayHello()}</p>
			<p><img src="logo.png" alt="Logo" width="250px" height="250px"  class="left"></p>
			<p>Der Testautomat ist ein System, welches mit gegebenem Code und gegebenen Daten einen Automaten zur Preisbestimmung von Verbindungen der DB simuliert.
Mit diesem sollen (vorgefertigte) Tests ausgeführt werden, welche reale Reiseanfragen simulieren.
Die Preise der Verbindungen sollen mit Preisen anderer Code- und Datenversionen verglichen werden.
Bei Preisveränderungen soll das System ein Hilfestellung zur Bewertung der Abweichungen geben.</p>
			<p  class="clear"></p>
		</section>
		<footer><p>${startseite.footer()}</p></footer>
	</body>
</html>