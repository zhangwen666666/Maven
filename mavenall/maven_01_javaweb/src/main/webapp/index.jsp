<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2024/10/11
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/hello">点击跳转页面</a>
<a href="${pageContext.request.contextPath}/hello">点击跳转页面</a>
</body>
</html>
