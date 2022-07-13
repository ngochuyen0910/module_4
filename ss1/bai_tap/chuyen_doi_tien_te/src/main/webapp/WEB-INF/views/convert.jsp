<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Convert</title>
</head>
<body>
<form method="post" action="">
    <label> USD : </label>
    <input type="text" name="usd" placeholder="USD"><br>
    <label>VND :</label>
    <input type="text" value="${result}"><br>
    <button type="submit"> chuyển đổi</button>
</form>
</body>
</html>
