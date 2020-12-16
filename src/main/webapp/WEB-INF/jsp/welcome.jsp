<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        html body {
            background-color: black;
            color: white;
        }
        #navbarNav a {
            color: white;
        }
    </style>
    <meta charset="utf-8">
    <title>Nitflix Homepage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-sm navbar-light bg-dark">
    <div class="container-fluid">
    <a class="navbar-brand" href="/" style="color:red">Nitflix</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/movies">Catalogue</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/favourites">Favourites</a>
            </li>
            <li class="nav-item" >
                <a class="nav-link" href="/user/recommendations" >Recommendations</a>
            </li>

        </ul>
        <button type="button" class="btn btn-sm btn-danger d-flex">
            <a class="nav-link" onclick="document.forms['logoutForm'].submit()">Logout</a>
        </button>
    </div>
    </div>
</nav>
<div class="container" style="padding: 10px">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome to Nitflix, ${pageContext.request.userPrincipal.name}!</h2>
    </c:if>
    <p>Browse the catalogue to choose what to watch!</p>
    <a class="ui-button" href="/movies">Browse</a>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>