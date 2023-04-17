<%-- 
    Document   : login
    Created on : Mar 19, 2023, 4:20:26 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <h1><div class="tieude">  Coffee Shop Management System </div></h1>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<script>
    function logout() {
        window.location.href = 'Logout';
    }
</script>
<style>
    body
    {
        margin: 0 auto; /* chỉnh lề giao diện tự động */
        background: url("https://wallpaperaccess.com/full/3525125.jpg");
        background-repeat: no-repeat;
        background-size: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        padding: 150px;


    }

    .tieude{
        text-align: center;
        font-size: 40px;
        color: aliceblue;
        padding-bottom: 20px;
        font-weight: bold;
        
        
    }
    .wrap
    {
        margin: 0 auto; /* chỉnh lề giao diện tự động */
        width: 1000px; /* phải đặt kích thước giao diện cho trang */
        background-color:lightblue;
    }


    .content
    {
        text-align:center;
        line-height: 40px;
        color: aliceblue;
        font-weight: bold;

    }

    .h1{
        text-align: center;
        font-size: 50px;
        color:white;
    }



</style>

<body>
<div class="my-div"></div>
    <div class="content">
        <form action="login" method="POST">
            Username <input type="text" name="username"/> <br/>
            Password <input type="password" name="password" /> <br/>
            <input type="submit" value="Login" />
        </form>
    </div>
</body>
</html>
