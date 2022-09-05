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
numbered of car : <?php 
if(isset($_SESSION['name_page'])){
	$regValue = $_SESSION['name_page'];
	foreach ($regValue as $row) {
		printf("%s,", $row["numbered_car"]);
	}
}	?></h4>
</body>
</html>
