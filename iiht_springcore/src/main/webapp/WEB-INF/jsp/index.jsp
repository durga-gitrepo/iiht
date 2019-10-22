<%@ page language="java" contentType="text/html"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

<div class="panel panel-info">
    	<div class="panel-heading">
     	<div class="panel-title">Book Store</div>
		<div class="container">
	  	<div class="col-md-offset-1 col-md-10">
		   <input type="button" value="Go To Subject" onclick="window.location.href='subject/list'; return false;" class="btn btn-primary" />
		   <input type="button" value="Go To Book" onclick="window.location.href='book/list'; return false;" class="btn btn-primary" />
		    <br/><br/>
	   </div>
</div>
</body>
</html>
