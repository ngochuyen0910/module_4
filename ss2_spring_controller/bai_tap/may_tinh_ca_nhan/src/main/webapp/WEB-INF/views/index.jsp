<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form method="post" action="">
    <label> Number 1 : </label>
    <input type="text" name="number1" placeholder="number1" value="${number1}"><br>
    <label>Number 2 :</label>
    <input type="text" name="number2" placeholder="number2" value="${number2}" ><br>
    <button type="submit" name="calculator" value="Addition"> Addition(+)</button>
    <button type="submit" name="calculator" value="Subtraction"> Subtraction(-)</button>
    <button type="submit" name="calculator" value="Multiplication"> Multiplication(*)</button>
    <button type="submit" name="calculator" value="Division"> Division(/)</button>
</form>
<p>Result:${result}</p>

</body>
</html>
