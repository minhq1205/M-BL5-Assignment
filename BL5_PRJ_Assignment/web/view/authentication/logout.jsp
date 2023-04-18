<%-- 
    Document   : logout
    Created on : Feb 21, 2023, 2:11:31 PM
    Author     : sonnt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 name="out">Logout successful!</h1>
        <br/>
        You will be directed to /login after <span id="time"></span> seconds
        <style>
            body{
                margin: 0 auto; /* chỉnh lề giao diện tự động */
                background: url("https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg");
                background-repeat: no-repeat;
                background-size: 100%;
            }
             .content
    {
        text-align:center;
        line-height: 40px;
        color: aliceblue;
        font-weight: bold;

    }
            
        </style>
        <script> 
        var count =3;
        var time = document.getElementById('time');
        time.innerHTML = count;
        function counting()
        {
            count --;
            time.innerHTML = count;
            if(count <= 0 )
            {
                window.location.href = 'login';
            }
        }
        setInterval(counting,1000);
        
        </script>
    </body>
</html>
