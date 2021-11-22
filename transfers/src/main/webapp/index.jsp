<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Convert</title>
</head>
<body>
<form action="/convert" method="get" name = "convert_currency">
  <div style="margin: 50px">
    USD:
    <input type="number" name="usd">
  </div>

  <div style="margin: 50px">
    Rate:
    <input type="number" readonly name="rate" value = "22800">
  </div>

  <div style="margin: 50px">
    <input type="submit" name="covert" value="Convert">
  </div>
</form>
<a href=""></a>
</body>
</html>