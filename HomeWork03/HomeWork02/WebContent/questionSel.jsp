<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>题目展示</title>
</head>
<body>	
		<font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp计算器出题系统</font></br>
<!-- 	<font>${arrayQuestion }</font>
		<font>${arrayAnswer }</font> 
-->
		<form action = "judge.do" method = "post">
			<font>共 <%=request.getAttribute("questionNumer")%> 题,结果保留2位小数</font>
			<table>
				<c:forEach items="${arrayQuestion }" var="s" varStatus="status">
					<tr>
						<td>${s}</td>
						<td>
							<input style="width:50px;" type="text" name="answer${status.index}"></input> 
						</td>
					</tr>
				</c:forEach>
			</table>
			<input style="width:50px;" type="hidden" name="answerList" value="${arrayAnswer }"></input> </br>
			<input type="submit" value="提交答卷"></input>
		</form>
<!-- 	<table>
			<c:forEach items="${arrayAnswer }" var="s2">
				<tr><td>${s2}</td></tr>
			</c:forEach>
		</table> 
-->
</body>
</html>