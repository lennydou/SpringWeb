<%--
  Created by IntelliJ IDEA.
  User: dyl
  Date: 6/13/15
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/login" method="post">
    <table>
      <tr>
        <td>Name</td>
        <td><input id="name" type="text" /></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input id="password" type="text" /></td>
      </tr>
    </table>
    <input type="submit" value="Submit" />
  </form>
</body>
</html>
