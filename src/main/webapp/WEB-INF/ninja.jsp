<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
                crossorigin="anonymous">
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>

<a class="m-4" href="/dojos">Create a Dojo</a>

<form action="/jumpto" class="m-4">
    <select name="dojo">
        <c:forEach items="${dojos}" var="dojo"> 
            <option value="${dojo.id}">${dojo.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Jump to a Dojo"/>
</form>  

<hr>

<h1 class="m-4">Create a New Ninja</h1>
<form:form action="/ninjas" method="POST" modelAttribute="ninja" class="m-4">
    <p>
        <form:label path="dojo">Select Your Dojo:</form:label>
        <form:errors path="dojo"/>
        <form:select path="dojo">
            <c:forEach items="${dojos}" var="dojo"> 
                <option value="${dojo.id}">${dojo.name}</option>
            </c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="firstName">First Name:</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name:</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age:</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>
    <input type="submit" value="Create Ninja"/>
</form:form>   


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</html>