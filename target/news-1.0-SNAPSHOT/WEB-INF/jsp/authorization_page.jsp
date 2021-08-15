<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

	<title>News Portal</title>
</head>
  </head>
  <body>
    <!-- Navigation bar -->
    
	<nav class="navbar">
	<div class="container">
    	<a class="navbar-brand" href="index.jsp">News Portal</a>
	</div>
	</nav>
	<br>
	<br>
	<br>
	
	<!-- Authorization form -->
	<form>
		<div class="mb-3">
    		<label for="exampleInputEmail1" class="form-label">Email address</label>
    		<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    		<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  		</div>
  		<div class="mb-3">
    		<label for="exampleInputPassword1" class="form-label">Password</label>
    		<input type="password" class="form-control" id="exampleInputPassword1">
  		</div>
  		<button type="submit" class="btn btn-primary">Submit</button>
  		<a href="/jsp/regPage" class="btn btn-secondary btn-lg disabled" tabindex="-1" role="button" aria-disabled="true">Registration</a>
	</form>
	
  </body>
</html>