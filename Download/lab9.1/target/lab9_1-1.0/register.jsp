<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<h1>Download registration</h1>

<p>To register for our downloads, enter your name and email
   address below. Then, click on the Submit button.</p>

<form action="download" method="post" enctype="multipart/form-data">
    <input type="hidden" name="action" value="registerUser">        
    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="<c:out value='${user.email}'/>" required><br>
    <label class="pad_top">First Name:</label>
    <input type="text" name="firstName" value="<c:out value='${user.firstName}'/>"required><br>
    <label class="pad_top">Last Name:</label>
    <input type="text" name="lastName" value="<c:out value='${user.lastName}'/>"required><br>
    <label>&nbsp;</label> <br>

    <br><br>

    <input type="submit" value="Register" class="margin_left">
</form>

</body>

</html>
