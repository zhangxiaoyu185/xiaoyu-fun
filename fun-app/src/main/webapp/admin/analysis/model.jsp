<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<html>
	<head>
		<title>模块统计表</title>
		<link type="text/css" rel="stylesheet" href="../../admin/css/css.css" />
		<script src="../../admin/js/boot.js" type="text/javascript"></script>
		<script src="../../admin/js/renderer.js" type="text/javascript"></script>		
	</head>
	<body onload= "window_onload();">
		<h1>模块统计</h1>
		<input name="date" class="mini-datepicker" style="width:200px;"  showTime="true" onfocus="stat();" 
		value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>"/> <br>		
		<img id="url" src="" width=1000 height=550 border=0>		
	</body>
	<script type="text/javascript">
			function window_onload(){
				var d=new Date();
				var year=d.getFullYear();
				var month=d.getMonth()+1;
				if(month<10){
					month='0'+month;
				}
				var day=d.getDay();
				if(day<10){day='0'+day;}
				var str = year+"-"+month+"-"+day;
				$("input[name='date']").val(str);
				//alert(str);
				$.ajax({
					type : 'POST',
					url  :  bootPATH + "../analysis/daytime/{daytime}",
					data : {daytime:str},
					dataType : 'json'
				}).done(function(json, textStatus, jqXHR) {
					if (json.success) {
						var json1 = json.data; 
						//alert(json1);
						$("#url").attr("src",json1);
					}					  
				});
			}
			function stat(){
				var daytime=$("input[name='date']").val();
				//alert(daytime);
				$.ajax({
					type : 'POST',
					url  :  bootPATH + "../analysis/daytime/{daytime}",
					data : {daytime:daytime},
					dataType : 'json'
				}).done(function(json, textStatus, jqXHR) {
					if (json.success) {
						var json1 = json.data; 
						//alert(json1);
						$("#url").attr("src",json1);				
					} 						  
				});
			}
		</script>
</html>