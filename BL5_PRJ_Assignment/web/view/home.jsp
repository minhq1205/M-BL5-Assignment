<%-- 
    Document   : home
    Created on : Mar 20, 2023, 3:15:15 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <style>
            body{
                background: whitesmoke;
            }
            .timetable{
                padding: 100px;
            }
            .tieude{
                color:orange;
                font-weight: bold;
                font-size: 30px;
             
            }
            .intro{
                font-size :40px;
                color: green;

            }
            .logo
            {
                
                border-radius: 10px;
            }
            .header{
                text-align: center;
            }
            .tt{
                font-size: 20px;
            }


        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <div class="tieude">  FPT University Academic Portal </div>
        
        <img class="logo" src="https://upload.wikimedia.org/wikipedia/vi/1/1d/Logo_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.png" width="300px" > </div><br>
        <c:if test="${sessionScope.account ne null}">
            <div class="intro"> Hello ${sessionScope.account.displayname} </div><br><!-- comment -->
            <a class="tt"  href="timetable?lid=1&from=2023-02-20&to=2023-02-26">Access time table</a> <br>
            , click 
            <a href="logout">here</a> 
            to logout. <br>
            
        </c:if>
        <c:if test="${sessionScope.account eq null}">
            click 
            <a href="login">here</a> 
            to login.
        </c:if>    

    </body>
</html>
