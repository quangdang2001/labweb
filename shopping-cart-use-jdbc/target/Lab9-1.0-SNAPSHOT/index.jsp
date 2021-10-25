<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    
<h1>CD list</h1>
<table>
    <thead>
        <tr>
            <th>Description</th>
            <th class="right">Price</th>
            <th>&nbsp;</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items = "${sessionScope.products}">
        <tr>
            <td>${product.description}s</td>
            <td class="right">${product.price}</td>
            <td><form action="cart" method="post">
                    <input type="hidden" name="productCode" value="${product.code}">
                    <input type="submit" value="Add To Cart">
                </form></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
        
</body>
</html>