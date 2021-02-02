<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>信息修改</title>
    <style type="text/css">
        .form-error-info{
            color:red;
        }
    </style>
</head>
<body>
<fmt:setLocale value="${param.locale}"/>
<fmt:setBundle basename="i18n"/>
<a href="user/edit?uid=${user.uid}&locale=zh_CN">中文</a><br>
<a href="user/edit?uid=${user.uid}&locale=en_US">English</a><br>
<%--@elvariable id="user" type="com.suftz.ssmdemo.bean.User"--%>
<form:form action="user/save" method="post" modelAttribute="user">
    <form:hidden path="uid"/>
    <fmt:message key="i18n.name" />：<form:input path="name" /><form:errors path="name" class="form-error-info" /><br>

    <fmt:message key="i18n.age" />：<form:input path="age" /><form:errors path="age" class="form-error-info" /><br>

    <fmt:message key="i18n.email" />：<form:input path="email" /><form:errors path="email" class="form-error-info" /><br>

    <fmt:message key="i18n.address" />：<form:input path="address" /><form:errors path="address" class="form-error-info"/><br>

    <fmt:message key="i18n.department" />：<form:select path="dept.id" items="${departments}" itemLabel="name"  itemValue="id">
</form:select><form:errors path="dept.id" class="form-error-info" /><br>
    <input type="submit" value="<fmt:message key="i18n.alter" />">
</form:form>
<br>
</body>
</html>