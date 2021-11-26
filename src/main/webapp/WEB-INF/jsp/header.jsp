<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="text/html; width=device-width, initial-scale=1">

    <!-- Page Stile CSS -->
    <link href="resources/css/custom_style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>News Portal</title>
</head>
<body>
<nav class="navbar">
    <div class="nav-container">
        <ul>
            <li class="nav-item">
                <a class="navbar-brand" href="Controller?command=GO_TO_MAIN_PAGE">Home</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="Controller?command=GO_TO_NEWS_PAGE">News</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="Controller?command=GO_TO_ABOUT_PAGE">About</a>
            </li>
            <c:if test="${userRole != null}">
                <li class="nav-item">
                    <a class="navbar-brand" href="Controller?command=GO_TO_OFFER_NEWS_PAGE">Offer news</a>
                </li>
            </c:if>
        </ul>
    </div>
    <div class="nav-user-items justify-content-end">
        <c:if test="${userRole == null}">
            <a class="btn btn-primary" style="margin: 5px" href="Controller?command=GO_TO_AUTHORIZATION_PAGE" role="button">Sing In</a>
        </c:if>
        <c:if test="${userRole == 'ADMIN'}">
            <a class="btn btn-primary" style="margin: 5px" href="Controller?command=GO_TO_ADMIN_PAGE" role="button">Administrator</a>
        </c:if>
        <c:if test="${userRole == 'USER'}">
            <a class="btn btn-primary" style="margin: 5px" href="Controller?command=GO_TO_USER_PAGE" role="button">User Page</a>
        </c:if>
        <c:if test="${userRole != null}">
            <a class="btn btn-primary" style="margin: 5px" href="Controller?command=LOG_OUT" role="button">Log Out</a>
        </c:if>
    </div>
</nav>
