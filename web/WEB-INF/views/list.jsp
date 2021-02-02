<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>员工列表</title>
    <style type="text/css">
        .form-error-info{
            color:red;
        }
    </style>
</head>
<body>
<!--jsp的jstl方式实现国际化切换,这种方式只是在request域中起作用，如果其他页面不传locale参数，则又是使用默认的语言，而不能按照第一次访问站点时设置的语言优先显示
    需要在session级别去设置
-->
<fmt:setLocale value="${param.locale}"/>
<fmt:setBundle basename="i18n"/>
<a href="user/list?locale=zh_CN">中文</a><br>
<a href="user/list?locale=en_US">English</a><br>
<%--@elvariable id="user" type="com.suftz.ssmdemo.bean.User"--%>
<form:form action="user/save" method="post" modelAttribute="user">
<fmt:message key="i18n.name" />：<form:input path="name" /><form:errors path="name" class="form-error-info" /><br>

    <fmt:message key="i18n.age" />：<form:input path="age" /><form:errors path="age" class="form-error-info" /><br>

    <fmt:message key="i18n.email" />：<form:input path="email" /><form:errors path="email" class="form-error-info" /><br>

    <fmt:message key="i18n.address" />：<form:input path="address" /><form:errors path="address" class="form-error-info"/><br>

    <fmt:message key="i18n.department" />：<form:select path="dept.id" items="${departments}" itemLabel="name"  itemValue="id">
</form:select><form:errors path="dept.id" class="form-error-info" /><br>
<input type="submit" value="<fmt:message key="i18n.add" />">
</form:form>
<br>

<c:if test="${requestScope.users!=null&&requestScope.users.size()!=0}">
<table cellspacing="0" cellpadding="4" border="1px solid #eeeeee">
    <tr><td>id</td><td>姓名</td><td>年龄</td><td>邮箱</td><td>地址</td><td>部门</td><td colspan="2">操作</td></tr>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td>${user.uid}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>${user.dept}</td>
            <td><a href="user/delete?uid=${user.uid}" >删除</a></td>
            <td><a href="user/edit?uid=${user.uid}" >修改</a></td>

        </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>