<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算题</title>
</head>
<body>
	<font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp计算器出题系统</font>
	<!-- 表单 -->
	<form action = "generate.do" method = "post">
		<table>
			 <tr>
			 	<td><font>题目数量</font></td>
			 	<td><input type="text" name="questionNum"></input></td>
			 </tr>
			 <tr>
			 	<td><font>数值范围</font></td>
			 	<td><input type="text" name="numDown"></input>~<input type="text" name="numUp"></input></td>
			 </tr>
			 <tr>
			 	<td><font>运算符数量</font></td>
			 	<td><input type="text" name="opNum"></input></td>
			 </tr>
			 <tr>
			 	<td><font>是否包含乘除法</font></td>
			 	<td><input type="checkbox" name="isCheck01"> </td>
			 </tr>
			 <tr>
			 	<td><font>是否包含括号</font></td>
			 	<td><input type="checkbox" name="isCheck02"></td>
			 </tr>
		</table>
		<input type="submit" value="提交"></input>
	</form>
</body>
</html>