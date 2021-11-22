<%--
  Created by IntelliJ IDEA.
  User: vothao
  Date: 22/11/2021
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/save" method="get">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce <br>
    <input type="checkbox" name="condiment" value="Tomato">Tomato <br>
    <input type="checkbox" name="condiment" value="Mustard">Mustard <br>
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts <br>
    <hr>
    <input type="submit" value="Save">
  </form>
  </body>
</html>
