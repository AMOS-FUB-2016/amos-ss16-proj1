<jsp:useBean id="startseite" class="de.fuberlin.chaostesting.Startseite" />
<!DOCTYPE html> 
<html>
	<head>
		<link rel="stylesheet" href="style.css" type="text/css" />
		<title>Chaos Testing - Test-Definition</title>	
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
			<h1>Test-Definition</h1>
			<h3>
				Eingabe der Test-Daten
			</h3>
			<form action="Definition" method="POST">
				Von: <input type="text" name="von"></input><br /><br />
				Nach: <input type="text" name="nach"></input><br /><br />
				Zeitpunkt: <input type="date" name="zeitpunkt" value="jjjj-mm-tt"></input><br /><br />
				Reisende:
				<select name="reisende" size="1">
					<option value="1">1 Reisender</option>
					<option value="2">2 Reisende</option>
					<option value="3">3 Reisende</option>
					<option value="4">4 Reisende</option>
					<option value="5">5 Reisende</option>
				</select><br /><br />
				Klasse 1: <input type="radio" name="klasse" value="1"></input><br />
				Klasse 2: <input type="radio" name="klasse" value="2"></input><br /><br />
				Angebot: <input type="checkbox" name="angebot" value="true"></input><br />
				<input type="hidden" name="angebot" value="false"></input>
				Sparpreis: <input type="checkbox" name="sparpreis" value="true"></input><br />
				<input type="hidden" name="sparpreis" value="false"></input>
				Flexpreis: <input type="checkbox" name="flexpreis" value="true"></input><br /><br />
				<input type="hidden" name="flexpreis" value="false"></input>
				<input type="submit" value="senden" name="Eintragen"></input><br />
			</form>
		</section>
		<footer><p>${startseite.footer()}</p></footer>
	</body>
</html>