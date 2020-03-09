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
<script>
$(document).ready(function() {
	$("#search").click(function() {
		medNo = $("#medNo").val();
		$.post("InventorySearchServlet", {
			medNo : medNo,
		}, function(data) {
			$("#result_table").html(data);
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
			<li role="presentation"><a href="ordinaryAdministrator_addInventory.jsp">增加库存</a></li>
			<li role="presentation" class="active"><a href="ordinaryAdministrator_inventorySearch.jsp">库存查询</a></li>
		</ul>
		<p>
		<div class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-1 control-label"> 药品编号 </label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="medNo" placeholder="药品编号">
				</div>
				<button class="btn btn-default" id="search">查询</button>
			</div>
		</div>
		<div id="result_table">
		
		</div>

	</div>


</body>
</html>