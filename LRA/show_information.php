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
  <p> number of cars : <?php
if(isset($_SESSION['show_information'])){
	$regValue = $_SESSION['show_information'];
	foreach ($regValue as $row) {
		printf("%s,", $row["number_of_car"]);
	}
}	?></p>
    <a href='login.php'>
        <button style="min-width: 40px;min-height: 20px;">
            Back
        </button>
    </a>
</body>
</html>
