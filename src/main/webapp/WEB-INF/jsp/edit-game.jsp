<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />"/>
</head>
<body>
<%@ include file="menu.jsp"%>
<section class="container">
    <form action="/games/edit?id=${game.id}" method="post" class="form-action form-container">
        <label for="gameName">Name</label>
        <input type="text" id="gameName" name="gameName" value="${game.name}">

        <label for="gameDescription">Description : </label>
        <textarea id="gameDescription" name="gameDescription">${game.description}</textarea>

        <button>Add</button>
    </form>
</section>
</body>
</html>
