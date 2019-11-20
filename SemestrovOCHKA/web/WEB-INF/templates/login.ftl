<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#if ERROR??> ${ERROR}</#if>

<legend>Login</legend>
<div>
    <form name="loginForm" method="post" action="/login">
        <p>
            <label>Email</label> <input type="text" name="username"/>
        </p>
        </p>
        <label>Password</label> <input type="password" name="password"/>
        </p>
        <p>
            <label>Remember</label> <input type="checkbox" name="remember" value="on">
        </p>
        <input type="submit" value="login">
    </form>
</div>
<p>
    <a href="http://localhost:8080/registration">
        <input type="button" value="registration">
    </a></p>

<p>
    <a href="http://localhost:8080/add">
        <input type="button" value="addPost">
    </a>
</p>
</body>
</html>