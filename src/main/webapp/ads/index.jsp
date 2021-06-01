<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 6/1/21
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Ads</title>
</head>
<body>
<h1>Here are all the adds:</h1>

<c:forEach var="ad" items="${ads}">
    <div class="ad">
        <h2>${ad.title}</h2>
        <p>User id: ${ad.userId}</p>
        <p>ad id: ${ad.id}</p>
        <p>description: ${ad.description}</p>

    </div>
</c:forEach>

</body>
</html>