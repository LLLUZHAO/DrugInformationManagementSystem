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
$(document).ready(function() {
	$("#result").hide();
		$("#add").click(function() {
			medNo = $("#medNo").val();
			endDate = $("#endDate").val();
			addCount = $("#addCount").val();
			
			if(medNo==""||endDate==""||addCount==""){
			$("#result").text("不能为空!");
			$("#result").show();
			return;
			}
			if(isNaN(addCount)){
				$("#result").text("数量错误!");
				$("#result").show();
				return;
			}
			$.post("AddInventoryServlet", {
				medNo:medNo,
				endDate:endDate,
				addCount:addCount
			}, function(data) {
				if(data=="true"){
					$("#result").text("增加成功!");
					$("#result").show();
				}else{
					$("#result").text("增加失败!");
					$("#result").show();
				}
			}, "text");
		});
	});
</script>
</head>
<body class="jumbotron">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="ordinaryAdministrator_inventoryManager.jsp">Home</a></li>
			<li role="presentation"><a href="ordinaryAdministrator_insertMedicine.jsp">增加药品</a></li>
			<li role="presentation" class="active"><a href="ordinaryAdministrator_addInventory.jsp">增加库存</a></li>
			<li role="presentation"><a href="ordinaryAdministrator_inventorySearch.jsp">库存查询</a></li>
		</ul>
		<p>
		<div class="col-sm-offset-3 col-sm-6 container panel">
			<div class="page-header"></div>
			<div>
				<div class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 control-label"> 药品编号 </label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="medNo">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label"> 终止日期 </label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="endDate">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label"> 入库数量</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="addCount">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-4">
							<button id="add" class="btn btn-default">提交</button>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-offset-1 col-sm-2 control-label" id="result"> 结果</label>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>