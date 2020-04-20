<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
</head>
<body>
    <h1>注册</h1>
    <form action="/spring-demo/user/register" method="post">
        用户名:<input type="text" id="username" name="username"><br><br>
        密&emsp;码:<input type="password" id="password" name="password"><br><br>
        <button type="submit">注册<button><a href="/spring-demo/loginPage">已有账号？快速登录</a>
    </form>
</body>
</html>
