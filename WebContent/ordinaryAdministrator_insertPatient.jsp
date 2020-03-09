<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>医生</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#result").hide();
		$("#add").click(function() {
			patNo = $("#patNo").val();
			patName = $("#patName").val();
			patType = $("#patType").val();
			if (patNo == "") {
				$("#result").text("患者编号不能为空！");
				$("#result").show();
				return;
			}
			$.post("InsertPatientServlet", {
				patNo : patNo,
				patName : patName,
				patType : patType
			}, function(data) {
				if (data == "true") {
					$("#result").text("患者添加成功！");
				} else {
					$("#result").text("患者添加失败！");
				}
				$("#result").show();
			}, "text");
		});
		$("#patNo").focus(function() {
			$("#result").hide();
		});
		$("#pw").focus(function() {
			$("#result").hide();
		});
		$("#patType").focus(function() {
			$("#result").hide();
		});
	});
</script>
</head>
<body class="jumbotron">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="ordinaryAdministrator_doctor.jsp">Home</a></li>
			<li role="presentation" class="active"><a href="ordinaryAdministrator_insertPatient.jsp">增加患者</a></li>
			<li role="presentation"><a href="ordinaryAdministrator_medicineSale.jsp">药品销售</a></li>
		<li role="presentation"><a href="ordinaryAdministrator_medicineSearch.jsp">药品查询</a></li>
		</ul>
		<p>
		<div class="col-sm-offset-3 col-sm-6 container panel panel-primary ">
			<div class="page-header"></div>
			<div class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label"> 患者编号 </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="patNo" id="patNo">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"> 患者名称 </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="patName" id="patName">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="name">患者病情</label>
					<div class="col-sm-6">
						<textarea class="form-control" rows="8" name="patType" id="patType"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-4">
						<button id="add" class="btn btn-default">提交</button>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-offset-1 col-sm-4 control-label" id="result"> 结果</label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>