<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
                crossorigin="anonymous">
<meta charset="UTF-8">
<title>Dojo ${dojo.name}</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>

<a href="/dojos">Create a Dojo</a> | <a href="/ninjas">Create a Ninja</a>
<hr>

<h1> ${dojo.name} Location: Ninjas </h1>
<div class="container">
<table class="m-2 table table-hover ">
    <tr class="table-info">
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
    </tr>
    <tbody>
        <c:forEach items="${ninjas}" var="ninja">
            <tr>
                <td>${ninja.firstName}</td>
                <td>${ninja.lastName}</td>
                <td>${ninja.age}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>

</body>
</html>