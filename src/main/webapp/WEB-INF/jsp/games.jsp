<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Jeux</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />"/>

</head>
<body>


<%@ include file="menu.jsp"%>

<section class="container">

<c:forEach items="${games}" var="game">
    <div class="game-card">
        <div class="game-name">
            <p>${game.name}</p>
            <p>${game.description}</p>
        </div>
        <form action="/deleteGame" method="post">
            <label for="gameId" class="none">Game Id </label>
            <input id="gameId" type="number" name="idGame" value="${game.id}" class="none">
            <button class="btn btn-delete">Supprimer</button><br />
        </form>
        <button class="btn btn-edit"><a href="${pageContext.request.contextPath}/games/edit?id=${game.id}" >Edit</a></button>
        <button class="btn btn-details">  <a href="${pageContext.request.contextPath}/games/details/${game.id}" >Détails</a></button>
    </div>
</c:forEach>

</section>

</body>
</html>
