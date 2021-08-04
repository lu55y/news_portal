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
<body>

<!-- Navigation bar -->
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="index.jsp" class="nav-link px-2 link-secondary">Home</a></li>
            <li><a href="#" class="nav-link px-2 link-dark">About</a></li>
        </ul>
        <div class="col-md-3 text-end">
            <form action="controller" method="post">
                <a>
                    <input type ="hidden" name="command" value="authorization">
                    <button type="submit" class="btn btn-outline-primary me-2">Login</button>
                </a>
                <a>
                    <input type ="hidden" name="command" value="registration">
                    <button type="submit" class="btn btn-primary">Sign-up</button>
                </a>
            </form>
        </div>
    </header>
</div>

<h1>Hello Page on News Portal</h1>
<br></br>

</body>
</html>