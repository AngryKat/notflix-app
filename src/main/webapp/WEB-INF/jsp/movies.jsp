
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        html body {
            background-color: black;
        }
        #navbarNav a {
            color: white;
        }
    </style>
    <title>Catalogue</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<script src="https://kit.fontawesome.com/10f7cb77fd.js" crossorigin="anonymous"></script>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <a class="navbar-brand" href="/" style="color:red">Nitflix</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active" >
                <a class="nav-link" href="/movies" >Catalogue</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user/favourites">Favourites</a>
            </li>
            <li class="nav-item" >
                <a class="nav-link" href="/user/recommendations" >Recommendations</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container" style="padding:10px">
    <div class="row">
            <c:forEach var="movie" items="${message}">
                <div class="col-lg-4 d-flex align-items-stretch">

                <form:form method="post"
                           action="/movies/like"
                           modelAttribute="likedMovie">

                        <div class="card text-white bg-dark" style="width: 18rem;">
                            <img src="http://localhost:8080/images/${movie.image_id}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">
                                    <form:input type="hidden" path="title" value="${movie.title}"/>
                                        ${movie.title}
                                </h5>
                                <h6 class="card-subtitle mb-2 text-muted">
                                    <form:input type="hidden" path="released" value="${movie.released}"/>
                                        ${movie.released}
                                </h6>
                                <p class="card-text">
                                    <form:input type="hidden" path="description" value="${movie.description}"/>
                                        ${movie.description}
                                </p>
                                <button
                                        class="btn btn-lg btn-danger btn-block"
                                        type="submit"
                                >
                                    Like <i class="fas fa-heart"></i>
                                </button>

                            </div>
                        </div>

                </form:form>
                </div>

            </c:forEach>

    </div>

</div>

</body>
</html>