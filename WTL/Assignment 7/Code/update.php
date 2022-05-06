<?php
require_once 'dbconnect.php';

$email=$pass1=$pass2="";

if(isset($_POST['submit']))
{
	$email = trim($_POST['email']);
	$pass1 = trim($_POST['pass']);
	$pass2 = trim($_POST['pass1']);

	if($pass1 == $pass2)
	{
		$sql = "update stud set password='$pass1' where email='$email'";
		$query = mysqli_query($conn,$sql);
		
		if($query)
		{
			echo "<script>alert('change successfully')</script>";	
		}else{
			echo "<script>alert('unsuccessfull')</script>";
		}		
	}else{
		echo "<script>alert('password are not same')</script>";	
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
<h1>Change password</h1>
<form method="POST">
<label><b>Email</b></label><br>
<input type="email" name="email" placeholder="enter email"><br><br>
<label><b>Password</b></label><br>
<input type="password" name="pass" placeholder="enter password"><br><br>
<label><b>Confirm password</b></label><br>
<input type="password" name="pass1" placeholder="enter password again"><br><br>
<input type="submit" name="submit" value="update"><br><br>
<label><a href="login.php">back to login form</a></label><br>
</form>
</body>
</html>
