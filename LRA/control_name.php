<?php
$servername = 'localhost';
$username = 'root';
$password = '';
$dbname = 'data_base1';
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT car_color,car_model FROM cars";
$result = $conn->query($sql);
$conn->close();
function a1(){

$field0=$_POST['email'];
$field1=$_POST['pass'];
$conn = new mysqli($GLOBALS['servername'], $GLOBALS['username'], $GLOBALS['password'], $GLOBALS['dbname']);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT email,pass FROM login WHERE email='$field0' AND pass='$field1'";
$result = $conn->query($sql);
if ($result->num_rows > 0)
{
return true;
}else
return false;
}
if(a1())
{
if($result != null){
session_start();
$a = $result->fetch_all(MYSQLI_BOTH);
$_SESSION["p2"] = $a;
}
$rol0=$_POST['email'];
$rol1=$_POST['pass'];

$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql_role = "SELECT role FROM users WHERE email='$rol0' AND pass='$rol1' ;";
$role = $conn->query($sql_role);
$row_role = $role->fetch_assoc();
$conn->close();
if($row_role != null){
  if($row_role["role"] == 'user')
{
header('Location: http://localhost:8080/p2.php');
exit();}
}
if($result != null){
session_start();
$a = $result->fetch_all(MYSQLI_BOTH);
$_SESSION["p3"] = $a;
}
$rol0=$_POST['email'];
$rol1=$_POST['pass'];

$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql_role = "SELECT role FROM users WHERE email='$rol0' AND pass='$rol1' ;";
$role = $conn->query($sql_role);
$row_role = $role->fetch_assoc();
$conn->close();
if($row_role != null){
  if($row_role["role"] == 'admin')
{
header('Location: http://localhost:8080/p3.php');
exit();}
}
}
?>
