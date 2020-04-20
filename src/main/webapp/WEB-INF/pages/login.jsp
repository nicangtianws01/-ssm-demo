<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
</head>
<body>
    <h1>登录</h1>
    <form action="/spring-demo/user/login" method="post">
        用户名:<input type="text" id="username" name="username"><br><br>
        密&emsp;码:<input type="password" id="password" name="password"><br><br>
        <button type="submit">登录<button><a href="/spring-demo/registerPage">没有账号？快速注册</a>
    </form>
</body>
</html>
