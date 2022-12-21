<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: soj
  Date: 30/11/2022
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />"/>
</head>
<body>
    <%@ include file="menu.jsp"%>


    <form action="/games/add" method="post" class="form-action form-container">
        <label for="gameName">Name</label>
        <input type="text" id="gameName" name="gameName">

        <label for="gameDescription">Description : </label>
        <textarea id="gameDescription" name="gameDescription"></textarea>

        <button>Add</button>
    </form>
</body>
</html>
