<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/9 0009
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>所有用户页面</title>
</head>

<body>
<h1>${xiaoxi}</h1>
<table  width="600" border="1" cellpadding="0" >
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>密码</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    <c:forEach var="S" items="${allStudents}"  >
        <form action="UpdateServlet" method="post">
            <tr>
                <td><input type="text" value="${S.id}" name="id" ></td>
                <td><input type="text" value="${S.name}" name="name"></td>
                <td><input type="text" value="${S.sex}" name="sex"></td>
                <td><input type="text" value="${S.pwd}" name="pwd"></td>
                <td><input type="text" value="${S.email}" name="email"></td>
                <td><a href="DeleteServlet?id=${S.id}">删除</a>  <input type="submit" value="更新"/></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>

