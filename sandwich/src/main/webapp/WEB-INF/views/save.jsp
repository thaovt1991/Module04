<%--
  Created by IntelliJ IDEA.
  User: vothao
  Date: 22/11/2021
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

</head>
<body>
<h1>Sanwich have :</h1>
<c:forEach items="${condiments}" var="condiment">
    <h2>${condiment}</h2>
</c:forEach>
</body>
</html>
