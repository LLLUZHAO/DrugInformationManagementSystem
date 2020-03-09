<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<table class="table  table-hover">
<tr>
<th>入库单号</th>
<th>入库数量</th>
<th>入库时间</th>
<th>终止时间</th>
<th>管理员编号</th>
<th>药品编号</th>
</tr>
	<%
		ArrayList<Object[]> resultList = (ArrayList<Object[]>) request
				.getAttribute("resultList");
		for (int i = 1; i < resultList.size(); i++) {
			Object[] object = resultList.get(i);
			out.println("<tr>");
			for (int j = 0; j < object.length; j++) {
				out.println("<th>" + String.valueOf(object[j]) + "</th>");
			}
			out.println("</tr>");
		}
	%>
</table>