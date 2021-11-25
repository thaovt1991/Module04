<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

    <title>Settings mail</title>
</head>
<body>
<h1>Settings</h1>
<hr>
<form:form method="POST" action="home/info" modelAttribute="emailSettings">
    <table>
        <tr>
            <td><form:label path="languages">Langueges : </form:label></td>
            <td>
                <form:select path="languages">
                    <form:option value="English" />
                    <form:option value="Vietnamese" />
                    <form:option value="Japanese" />
                    <form:option value="Chinese" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="size">Page Size </form:label></td>
            <td>Show <span>
                <form:select path="size">
                    <form:option value="5" />
                    <form:option value="10" />
                    <form:option value="15" />
                    <form:option value="25" />
                    <form:option value="50"/>
                    <form:option value="100"/>
                </form:select>
                </span>
                email per page
            </td>
        </tr>
        <tr>
            <td><form:label path="spams_filter"> Spams filter</form:label></td>
            <td><form:checkbox path="spams_filter"/></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature : </form:label></td>
            <td><form:textarea path="signature" rows="5" cols="20"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update" style="color: green"/>
                <input type="button" value="Cancel" onclick='window.location.href="/home"'/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>