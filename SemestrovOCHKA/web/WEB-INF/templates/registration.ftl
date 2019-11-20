<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Registration</h1>
<form name="loginForm" method="post" action="/registration" enctype="multipart/form-data">
    <p><input type="text" name="name" placeholder="Name" size="18" /></p>
    <p><input type="text" name="surname" placeholder="Surname" size="18" /></p>
    <p><input type="text" name="country" placeholder="Country" size="18" /></p>
    <p><input type="email" name="email" placeholder="Email" size="18" /></p>
    <p><input type="password" name="password" placeholder="Password" size="18" /></p>
    <p><input type="file" placeholder="Photo" id="photo" name="photo" size="18" accept="image/jpeg,image/png" /></p>
    <p><input type="submit" value="registration"></p>
</form>
<p>
<form>
    <h1>For all site</h1>
    <a href="http://localhost:8080/login">
        <input type="button" value="login">
    </a>


</form></p>


</body>
</html>