<%@ page import="murach.business.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head><title>Thanks</title></head>
<body>
    <h2>Thanks for joining our list!</h2>
    <p>Here is the information that you entered:</p>
    <ul>
        <li>First name: <%= user.getFirstName() %></li>
        <li>Last name: <%= user.getLastName() %></li>
        <li>Email: <%= user.getEmail() %></li>
        <li>Date of Birth: <%= user.getDob() %></li>
    </ul>
</body>
</html>
