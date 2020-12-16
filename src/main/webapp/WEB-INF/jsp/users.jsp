<%@ page import="java.io.OptionalDataException" %>
<%@ page import="com.kate.notflixapp.domainClasses.Mysql.UserM" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
    <link rel="stylesheet" href="style.css">

</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>User Name</th>
    </tr>
    </thead>
    <tbody>
    <%
        int i = 1;
        List<UserM> list = (List) request.getAttribute("message");
    %>

    <%
        for (UserM u : list) {
    %>
    <tr>
        <td><%=i++%></td>
        <td><%=u.getUsername()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>