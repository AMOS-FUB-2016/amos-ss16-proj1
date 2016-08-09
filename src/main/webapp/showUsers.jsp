<jsp:useBean id="userTest" class="de.fuberlin.chaostesting.UserTest"/>
<html>
	<h1>Users</h1>
	<table style = "border:1px solid grey; background-color: #F8F8F8">
		${userTest.getUsers()}
	</table>
	<p><%= new java.util.Date() %></p>
</html>