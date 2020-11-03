<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>유저 리스트</title>
</head>

<body>
<div>${userList}</div>
    <table border="1">
        <thead>
            <tr>
                <th>번호</th>
                <th>token</th>
                <th>os타입</th>
                <th>푸시 상태</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.token}</td>
                    <td>${user.os_type}</td>
                    <td>${user.is_push}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>

</html>
