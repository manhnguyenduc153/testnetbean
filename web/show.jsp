<%-- 
    Document   : boat
    Created on : Sep 24, 2024, 5:24:17 PM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Choose an option to filter: 
        <select onchange="filterData(this)">
            <option value="0">All</option>
            <c:forEach items="${requestScope.depart}" var="c">
                <option value="${c.dname}" ${c.dname == dn ? 'selected' : ''} >${c.dname}</option>
            </c:forEach>
        </select>

        <table border="1px">
            <tr>
                <td>BoatID</td>
                <td>BoatName</td>
                <td>Seat</td>
                <td>Booked</td>
                <td>DepartPlace Name</td>
                <td>Ticket Type</td>
                <td>Is full?</td>
            </tr>

            <c:forEach items="${requestScope.boats}" var="b">
                <tr>
                    <td>${b.bid}</td>
                    <td>${b.bname}</td>
                    <td>${b.seat}</td>
                    <td>${b.booked}</td>
                    <td>${b.d.dname}</td>
                    <td>${b.t.tname}</td>
                    <td>${b.seat == b.booked ? 'X' : ''}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
    
    <script>
        function filterData(param){
            window.location = "show?dname=" + param.value;
        }
    </script>
</html>
