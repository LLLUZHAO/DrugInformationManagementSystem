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
</head>
<body class="jumbotron">
	<div class="page-header">
		<h3>
			<center>药品信息管理系统</center>
		</h3>
	</div>
	<div>
		<form class="form-horizontal" action="LoginServlet" method="post">
			<div class="form-group">
				<label for="inputUsername" class="col-sm-offset-3 col-sm-2 control-label"> 用户名 </label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="inputUsername" name="manNo" placeholder="用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-offset-3 col-sm-2 control-label"> 密码 </label>
				<div class="col-sm-2">
					<input type="password" class="form-control" id="inputPassword" name="pw" placeholder="密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-5 col-sm-10">
					<button type="submit" class="btn btn-default">login</button>
					<a class="btn btn-primary" href="register.jsp" role="button">register</a>
				</div>
			</div>
			<div class="form-group">
				<label for="OrdinaryUser" class="col-sm-offset-3 col-sm-2 control-label"> 普通用户 </label>
				<div class="col-sm-offset-5 col-sm-10">
					<a class="btn btn-primary" href="userSearch.jsp" role="button">进入查询</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>