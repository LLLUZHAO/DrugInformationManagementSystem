<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>药品信息管理系统</title>
<script>
	$(document).ready(function() {
		$.post("LookUserServlet", {}, function(data) {
			$("#search_table").html(data);
		}, "text");
	});
</script>
</head>
<body class="jumbotron">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="superAdministrator.jsp">Home</a></li>
			<li role="presentation" class="active"><a href="superAdministrator_lookUser.jsp">查看用户</a></li>
			<li role="presentation"><a href="superAdministrator_insertUser.jsp">添加用户</a></li>
			<li role="presentation"><a href="superAdministrator_deleteUser.jsp">删除用户</a></li>
			<li role="presentation"><a href="superAdministrator_optionSearch.jsp">用户操作查询</a></li>
		</ul>
		<div id="search_table"></div>
	</div>
</body>
</html>