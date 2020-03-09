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
		$("#search_btn").click(function() {
			$.post("UserSearchServlet", {
				type : $("input[name='search_type']:checked").val(),
				keyword : $("input[name='keyword']").val()
			}, function(data) {
				$("#search_table").html(data);
			}, "text");
		});
	});
</script>
</head>
<body class="jumbotron">
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="ordinaryAdministrator_doctor.jsp">Home</a></li>
			<li role="presentation"><a href="ordinaryAdministrator_insertPatient.jsp">增加患者</a></li>
			<li role="presentation"><a href="ordinaryAdministrator_medicineSale.jsp">药品销售</a></li>
			<li role="presentation" class="active"><a href="ordinaryAdministrator_medicineSearch.jsp">药品查询</a></li>
		</ul>
		<div class="form-inline">
			<div class="form-group">
				<label> <input type="radio" name="search_type" checked="checked" value="medNo">
					药品编号
				</label><br> <label> <input type="radio" name="search_type" value="medName"> 药品名称
				</label>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">F</div>
					<input type="text" class="form-control" name="keyword" placeholder="Enter the keyword">
				</div>
			</div>
			<button id="search_btn" class="btn btn-primary">查询</button>
		</div>
		<div id="search_table"></div>
	</div>
</body>
</html>