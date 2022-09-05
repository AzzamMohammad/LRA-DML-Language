<?php
$servername = 'localhost';
$username = 'root';
$password = '';
$dbname = 'lec5';
function a0(){

$field0=$_POST['email'];
$field1=$_POST['password'];
$conn = new mysqli($GLOBALS['servername'], $GLOBALS['username'], $GLOBALS['password'], $GLOBALS['dbname']);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT email,password FROM users WHERE email='$field0' AND password='$field1'";
$result = $conn->query($sql);
if ($result->num_rows > 0)
{
return true;
}else
return false;
}
if(a0())
{
if($result != null){
session_start();
$a = $result->fetch_all(MYSQLI_BOTH);
$_SESSION["page_user"] = $a;
}
$rol0=$_POST['email'];
$rol1=$_POST['password'];

$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql_role = "SELECT role FROM users WHERE email='$rol0' AND password='$rol1' ;";
$role = $conn->query($sql_role);
$row_role = $role->fetch_assoc();
$conn->close();
if($row_role != null){
  if($row_role["role"] == 'user')
{
header('Location: http://localhost:8080/page_user.php');
exit();}
}
if($result != null){
session_start();
$a = $result->fetch_all(MYSQLI_BOTH);
$_SESSION["page_admin"] = $a;
}
$rol0=$_POST['email'];
$rol1=$_POST['password'];

$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql_role = "SELECT role FROM users WHERE email='$rol0' AND password='$rol1' ;";
$role = $conn->query($sql_role);
$row_role = $role->fetch_assoc();
$conn->close();
if($row_role != null){
  if($row_role["role"] == 'admin')
{
header('Location: http://localhost:8080/page_admin.php');
exit();}
}
}
?>
