<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>

<body>
<h4>
SIGN UP</h4>
<form action="c8.php" method="post">
<label for="0">enter your email</label>
<input type="email" name="email" required placeholder="@gamil.com" id="0">
<label for="1">enter your password</label>
<input type="password" name="password" placeholder="at lest 8 ch" id="1">
<label for="2">send</label>
<input type="submit" name="5" id="2">
</form>
<a href='forgot.php'>forgot the password</a>
</body>
</html>
