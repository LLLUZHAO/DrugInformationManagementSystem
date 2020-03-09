<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {
	$("#result").hide();
	$("#add").click(function() {
		
		manNo=$("#manNo").val();
		pw=$("#pw").val();
		authority=$("input[name='authority']:checked").val();
		if(manNo==""){
			$("#result").text("用户名不能为空！");
			$("#result").show();
			return;
		}
		if(pw==""){
			$("#result").text("密码不能为空！");
			$("#result").show();
			return;
		}
		$.post("InsertUserServlet", {
			manNo:manNo,
			pw:pw,
			authority:authority
		}, function(data) {
			if(data=="true"){
				$("#result").text("用户添加成功！");
			}else{
				$("#result").text("用户添加失败！");
			}
			$("#result").show();
		}, "text");
	});
	$("#manNo").focus(function(){
		$("#result").hide();
	});
	$("#pw").focus(function(){
		$("#insert_result").hide();
	});
});
</script>
<title>药品信息管理系统</title>
</head>
<body class="jumbotron">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="superAdministrator.jsp">Home</a></li>
			<li role="presentation"><a href="superAdministrator_lookUser.jsp">查看用户</a></li>
			<li role="presentation" class="active"><a href="superAdministrator_insertUser.jsp">添加用户</a></li>
			<li role="presentation"><a href="superAdministrator_deleteUser.jsp">删除用户</a></li>
			<li role="presentation"><a href="superAdministrator_optionSearch.jsp">用户操作查询</a></li>
		</ul>
		<p>
		<div class="form-horizontal">

			<div class="form-group">
				<label for="inputUsername" class="col-sm-1 control-label"> 用户名 </label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="manNo" name="manNo" placeholder="用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-1 control-label"> 密码 </label>
				<div class="col-sm-3">
					<input type="password" class="form-control" id="pw" name="pw" placeholder="密码">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label"> 权限 </label>
				<div class="col-sm-4">
					<div class="radio">
						<label> <input type="radio" name="authority" checked="checked" value=1> 医生
						</label> <label> <input type="radio" name="authority" value=2> 库存管理人员
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<button class="btn btn-default" id="add">添加</button>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-offset-1 col-sm-2 control-label" id="result"> 结果</label>
			</div>
		</div>
	</div>
</body>
</html>