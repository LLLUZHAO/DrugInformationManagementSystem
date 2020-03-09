<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>库存管理人员</title>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#result").hide();
				$("#add").click(
						function() {
							acceptNo = $("#acceptNo").val();
							medName = $("#medName").val();
							medType = $("#medType").val();
							medCount = $("#medCount").val();
							useDate = $("#useDate").val();
							proName = $("#proName").val();
							if (acceptNo == "" || medName == ""
									|| medType == "" || medCount == ""
									|| useDate == "" || proName == "") {
								$("#result").text("不能为空！");
								$("#result").show();
								return;
							}
							if(isNaN(useDate)){
								$("#result").text("有效期错误！");
								$("#result").show();
								return;
								
							}
		
							$.post("InsertMedicineServlet", {
								acceptNo : acceptNo,
								medName : medName,
								medType : medType,
								medCount : medCount,
								useDate : useDate,
								proName : proName
							}, function(data) {
								if (data == "true") {
									$("#result").text("药品添加成功！");
								} else {
									$("#result").text("药品添加失败！");
								}
								$("#result").show();
							}, "text");
						});
				$("#patNo").focus(function() {
					$("#result").hide();
				});
				$("#pw").focus(function() {
					$("#patName").hide();
				});
				$("#patType").focus(function() {
					$("#patType").hide();
				});
			});
</script>
</head>
<body class="jumbotron">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="ordinaryAdministrator_inventoryManager.jsp">Home</a></li>
			<li role="presentation" class="active"><a href="ordinaryAdministrator_insertMedicine.jsp">增加药品</a></li>
			<li role="presentation"><a href="ordinaryAdministrator_addInventory.jsp">增加库存</a></li>
			<li role="presentation"><a href="ordinaryAdministrator_inventorySearch.jsp">库存查询</a></li>
		</ul>
		<p>
		<div class="col-sm-offset-3 col-sm-6 container panel panel-primary ">
			<div class="page-header"></div>
			<div class="form-horizontal">

				<div class="form-group">
					<label class="col-sm-2 control-label"> 批准文号 </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="acceptNo">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"> 药品名称 </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="medName">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"> 药品剂型 </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="medType">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"> 药品规格 </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="medCount">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"> 有效日期 </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="useDate">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"> 生产厂家 </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="proName">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-4">
						<button id="add" class="btn btn-default">提交</button>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-offset-1 col-sm-6 control-label" id="result"> 结果</label>
				</div>

			</div>
		</div>
	</div>
</body>
</html>