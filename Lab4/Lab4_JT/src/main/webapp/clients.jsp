<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients List</title>
</head>
<body>
<h2>Clients</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.id}</td>
            <td>${client.name}</td>
            <td>${client.email}</td>
            <td>${client.phone}</td>
            <td>${client.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
