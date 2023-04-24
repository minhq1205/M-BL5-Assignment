<%-- 
    Document   : timetable
    Created on : Mar 10, 2023, 4:08:36 PM
    Author     : sonnt
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style type="text/css">
        
        
            table, th, td{
                border:1px solid #868585;
            }
            table{
                border-collapse:collapse;
                width:100%;
                
            }
            th, td{
                text-align:left;
                padding:10px;
            }
            head{
                padding: 50px;
            }

        </style>
        <head> <style>
                
            </style>
        <div class> Work Schedule </div><br>
        </head>
    <body>
        Lecturer: <input type="text" readonly="readonly" value="${requestScope.lecturer.name}"/>
        <form action="timetable" method="GET">
            <input type="hidden" name="lid" value="${param.lid}"/>
            From: <input type="date" name="from" value="${requestScope.from}"/>
            To: <input type="date" name="to" value="${requestScope.to}"/>

        </form>
        <table border="2px">
            <tr>
                <td></td>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td>${d} <br/>
                    <fmt:formatDate value="${d}" pattern="EEEE" />

                    </td>
                </c:forEach>
            <tr/>
            <c:forEach items="${requestScope.slots}" var="s">
                <tr>
                    <td>${s.slotTime}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.sessions}" var="ses">
                                <c:if test="${ses.slot.id eq s.id and ses.date eq d}">
                                    ${ses.group.name}-${ses.group.course.name} <br/>
                                    ${ses.room.name} 
                                    -
                                    <c:if test="${ses.status}">(attended)</c:if>
                                    <c:if test="${!ses.status}">
                                        <a href="att?id=${ses.id}">take attend</a>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                <tr/> 
            </c:forEach>

        </table>
    </body>
</html>
