<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />"/>
</head>
<body>
<%@ include file="menu.jsp"%>

<section class="container-card">
    <h1><c:out value="${game.name}"/></h1>
    <p><c:out value="${game.description}"/></p>
</section>
</body>
</html>
