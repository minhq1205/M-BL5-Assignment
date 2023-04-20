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
                background: url("https://wallpaperaccess.com/full/3525125.jpg");
                background-repeat: no-repeat;
                background-size: 100%;
                background-color: rgba(0, 0, 0, 0.5);
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
                font-size :30px;
                color: green;
                padding-left: 50px;
                font-weight: bold;
                color:white;
            }

            .header{
                text-align: center;
            }
            .tt{
                font-size: 20px;
            }
            .tieude{
                text-align: center;
                font-size: 40px;
                font-weight: bold;
                color:aliceblue;
            }


        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <div class="tieude">  Coffee Shop Management System </div>


        <c:if test="${sessionScope.account ne null}">
            <div class="intro"> Hello ${sessionScope.account.displayname} </div><br><!-- comment -->
            <a class="tt"  href="timetable?lid=1&from=2023-02-20&to=2023-02-26">Access work schedule</a> <br>
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
