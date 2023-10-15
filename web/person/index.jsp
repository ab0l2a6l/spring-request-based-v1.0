<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: abolfazl.m
  Date: 10/15/2023
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PERSON</title>
    <jsp:include page="/WEB-INF/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/menu.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">PERSON</div>
        <div class="panel-body">
            <form action="/person/save">
                <input type="text" name="name" placeholder="Enter Name" class="form-control">
                <input type="text" name="family" placeholder="Enter family" class="form-control">
                <input type="submit" value="SAVE" class="btn btn-primary">
            </form>

            <table class="table table-bordered table-hover">
                <tr>
                    <td>ID</td>
                    <td>NAME</td>
                    <td>FAMILY</td>
                    <td>ACTION</td>
                    <td>ACTION</td>
                </tr>

                <form action="/person/update">
                    <c:forEach items="${requestScope.personList}" var="person">
                        <tr>
                            <td><input type="text" name="id" value="${person.id}" readonly class="form-control"></td>
                            <td><input type="text" name="name" value="${person.name}" class="form-control"></td>
                            <td><input type="text" name="family" value="${person.family}" class="form-control"></td>
                            <td><input type="submit" value="UPDATE" class="btn btn-primary"></td>
                            <td><input type="button" value="REMOVE" class="btn btn-danger"
                                       onclick="personRemove(${person.id})"></td>
                        </tr>
                    </c:forEach>
                </form>
            </table>
        </div>
    </div>
</div>
<script>
    function personRemove(id) {
        if (confirm('are you sure ? '))
            window.location = "/person/remove?id=" + id;
    }
</script>
</body>
</html>
