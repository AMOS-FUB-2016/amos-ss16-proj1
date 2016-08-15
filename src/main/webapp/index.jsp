<jsp:useBean id="startseite" class="de.fuberlin.chaostesting.Startseite"/>
<!DOCTYPE html> 
<html>
	<head>
		<title>Startseite</title>
	</head>
	<body>
		<h1>Startseite</h1>
		<p>${startseite.sayHello()}</p>
	
		<p>
		Testdefinition
		</p>
		<form action=Definition method="POST">
			Von: <input type="text" name="von"></input><br /><br />
			Nach: <input type="text" name="nach"></input><br /><br />
			Hinfahrt: <input type="date" name="hinfahrt" value="jjjj-mm-tt"></input><br /><br />
			Reisende:
			<select name="reisende" size="1">
				<option value="eins">1 Reisender</option>
				<option value="zwei">2 Reisende</option>
				<option value="drei">3 Reisende</option>
				<option value="vier">4 Reisende</option>
				<option value="fuenf">5 Reisende</option>
			</select><br /><br />
			Klasse 1: <input type="radio" name="klasse" value="eins"></input><br />
			Klasse 2: <input type="radio" name="klasse" value="zwei"></input><br /><br />
			Preis (Sollwert): <input type="text" name="preis" value="0"><br /><br />
			<input type="submit" value="senden" name="Eintragen"></input><br />
		</form>
	</body>
</html>