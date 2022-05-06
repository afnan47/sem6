<?php
require_once 'dbconnect.php';


$username=$password="";

if(isset($_POST['submit']))
{
	$username = trim($_POST['uname']);
	$password = trim($_POST['pass']);
	
	if($username!='' && $password!='')
	{	
		$sql = "select * from stud where username='$username' and password='$password'";
		$query = mysqli_query($conn,$sql);
	
		$count = mysqli_num_rows($query);
	
		if($count == 1)
		{
			header("location:welcome.php");
		}else{
			echo "<script>alert('password or username is incorrect')</script>";
		}
	}else{
		echo "<script>alert('fields cannot be empty')</script>";

	}
}else{


}

 ?>



<!DOCTYPE html>
<html>
<head>
<title>Login form</title>
<link rel="stylesheet" href="style.css">
</head>
<body >
<form method="POST">
<h1 style="text-align:center">Login Form</h1>
<div class="cont1">
<label><b>Username</b></label><br>
<input type="text" name="uname" placeholder="enter username"><br>
<label><b>Password</b></label><br>
<input type="password" name="pass" placeholder="enter password"><br><br>
<input type="submit" name="submit" value="login" ><br><br>
</div>
<div class="cont2">
<label><a href="update.php">Forgot password</a></label><br>
<label>Not registered?<a href="register.php">register</a></label>
</div>
</form>
</body>
</html>
