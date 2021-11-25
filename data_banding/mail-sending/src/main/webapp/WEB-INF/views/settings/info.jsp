<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Information settings email</title>
</head>
<body>
<h2>Information settings email</h2>
<table>
    <tr>
        <td>Languages:</td>
        <td>${languages}</td>
    </tr>
    <tr>
        <td>Page Size </td>
        <td>${size}</td>
    </tr>
    <tr>
        <td>Spams filter : </td>
        <td>
            <c:if test="${!spams_filter == true}">No check</c:if>
            <c:if test="${spams_filter== true}">Checked</c:if>
        </td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${signature}</td>
    </tr>
</table>
</body>
</html>