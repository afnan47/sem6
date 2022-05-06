<?php
require_once 'dbconnect.php';

$username=$password=$email=$mobile="";

if(isset($_POST['submit']))
{
	$username = trim($_POST['uname']);
	$password = trim($_POST['pass']);
	$email = trim($_POST['email']);
	$mobile = trim($_POST['mobile']);
		
	if($username!='' && $password!='' && $email!= '' && $mobile!='')
	{
		$sql = "insert into stud(username,password,email,mobile)values('$username','$password','$email','$mobile')";
		$query = mysqli_query($conn,$sql);


		if($query)
		{
			echo "<script>alert('successful')</script>";
		}else{
			echo "<script>alert('incorrect')</script>";
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
<title>Register form</title>
<link rel="stylesheet" href="style.css">
</head>
<body >

<form method="POST">
<h1 style="text-align:center">Registeration Form</h1>
<div class="cont1">
<label><b>Username</b></label><br>
<input type="text" name="uname" placeholder="enter username"><br>
<label><b>Password</b></label><br>
<input type="password" name="pass" placeholder="enter password"><br>
<label><b>Email</b></label><br>
<input type="email" name="email" placeholder="enter email"><br>
<label><b>Mobile</b></label><br>
<input type="text" name="mobile" placeholder="enter mobile"><br>

<input type="submit" name="submit" value="register"><br>
</div>
<div class="cont2">
<label>Already registered?<a href="login.php">login</a></label>
</div>
</form>
</body>
</html>
