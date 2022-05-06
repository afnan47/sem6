<?php
require_once 'dbconnect.php';

$username = $_POST['uname'];

$sql = "select * from stud where username='$username'";
$query = mysqli_query($conn,$sql);

$count = mysqli_num_rows($query);

if($count > 0)
{
	echo "<table><tr><th>Id</th><th>Username</th><th>Password</th><th>Email</th><th>Mobile</th></tr>";
	
	
		echo "<tr><td>".$row['id']."</td><td>".$row['username']."</td><td>".$row['password']."</td><td>".$row['email']."</td><td>".$row['mobile']."</td></tr>";
	

	echo "</table>";
}

 ?>
