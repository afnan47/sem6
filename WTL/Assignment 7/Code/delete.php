<?php
require_once 'dbconnect.php';

$email=$pass1="";

if(isset($_POST['submit']))
{
	$email = trim($_POST['email']);
	$pass1 = trim($_POST['pass']);
	
		$sql = "delete from stud where password='$pass1' and email='$email'";
		$query = mysqli_query($conn,$sql);
		
		if($query)
		{
			echo "<script>alert('delete successfully')</script>";	
		}else{
			echo "<script>alert('unsuccessfull')</script>";
		}		
	
}else{


}

 ?>


<!DOCTYPE html>
<html>
<head>
<title>Update</title>
</head>
<body style="background-color:#9d869e;text-align:center">
<h1>Delete Account</h1>
<form method="POST">
<label><b>Email</b></label><br>
<input type="email" name="email" placeholder="enter email"><br><br>
<label><b>Password</b></label><br>
<input type="password" name="pass" placeholder="enter password"><br><br>
<input type="submit" name="submit" value="delete"><br><br>
<label><a href="login.php">back to login form</a></label><br>
</form>
</body>
</html>
