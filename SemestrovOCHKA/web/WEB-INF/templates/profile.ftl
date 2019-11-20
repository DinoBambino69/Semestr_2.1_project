<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>profile</h1>
<img src="${user.photo}" width="200" height="255" alt="Photo">
<#if user??> <p><h2>Welcome: ${user.name} ${user.surname}</h2></h></p>
    <h3>Your Country: ${user.country}</h3>
    <h3>Your Email: ${user.email}</h3>
</#if>

<p>
<form>
    <a href="http://localhost:8080/logout">
        <input type="button" value="logout">
    </a>


    <a href="http://localhost:8080/add">
        <input type="button" value="addPost">
    </a>
</form>
</p>

</body>
</html>