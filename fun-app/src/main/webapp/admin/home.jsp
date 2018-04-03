<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" />
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT" />
<title>趣事分享管理系统V1.0.0</title>
<script src="../admin/js/boot.js" type="text/javascript"></script>
<script src="../admin/js/core.js" type="text/javascript"></script>
<style type="text/css">
html,body {
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

.header {
	background: url(images/header.gif) repeat-x;
}

.header div {
	font-family: 'Trebuchet MS', Arial, sans-serif;
	font-size: 25px;
	line-height: 60px;
	padding-left: 10px;
	font-weight: bold;
	color: #333;
}

body .header .topNav {
	position: absolute;
	right: 8px;
	top: 10px;
	font-size: 12px;
	line-height: 25px;
}

.header .topNav a {
	text-decoration: none;
	color: #222;
	font-weight: normal;
	font-size: 12px;
	line-height: 25px;
	margin-left: 3px;
	margin-right: 3px;
}

.header .topNav a:hover {
	text-decoration: underline;
	color: Blue;
}

.mini-layout-region-south img {
	vertical-align: top;
}
</style>
</head>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/admin/";
%>
<body>
	<div class="mini-layout" style="width: 100%; height: 100%;">
		<div title="north" region="north" class="header"
			bodyStyle="overflow:hidden;" height="80" showHeader="false"
			showSplit="false">
			<div>趣事分享管理系统V1.0.0</div>

			<div class="topNav">
				<a href="home.jsp">首页</a>  | <a href="##">注销</a>
			</div>
		</div>
		<div showHeader="false" region="south"
			style="border: 0; text-align: center;" height="25" showSplit="false">
			Copyright © 趣事分享版权所有</div>
		<div region="west" title="系统模块" showHeader="true"
			bodyStyle="padding-left:1px;" showSplitIcon="true" width="230"
			minWidth="100" maxWidth="350">
			<ul id="demoTree" class="mini-tree" showTreeIcon="true"
				style="width: 100%; height: 100%;" enableHotTrack="true"
				onbeforeexpand="onBeforeExpand">
				<li><a href="welcome.html" target="main">欢迎页</a></li>

				<li><span expanded="true">版本统计</span>
					<ul>
						<li><a href="analysis/version.jsp" target="main">版本统计</a></li>
					</ul>
				</li>				
				<li><span expanded="false">模块访问统计</span>
					<ul>
						<li><a href="analysis/model.jsp" target="main">按天统计模块 </a></li>
						<li><a href="analysis/modelByMonth.jsp" target="main">按月统计模块访</a></li>
					</ul>
				</li>
				<li><span expanded="false">在线人数统计</span>
					<ul>
						<li><a href="analysis/onlinePersonList.html" target="main">在线人数统计</a></li>
					</ul>
				</li>		
		</div>
		
		<div title="center" region="center" style="border: 0;">
			<div id="mainTabs" class="mini-tabs" activeIndex="0"
				style="width: 100%; height: 100%;"
				onactivechanged="onTabsActiveChanged">
				<div title="欢迎页">
					<iframe onload="onIFrameLoad()" src="<%=basePath%>welcome.html"
						id="mainframe" frameborder="0" name="main"
						style="width: 100%; height: 100%;" border="0"></iframe>
				</div>
			</div>
		</div>


	</div>
</body>
</html>
<script type="text/javascript">
	mini.parse();
	function onBeforeExpand(e) {
		var tree = e.sender;
		var nowNode = e.node;
		var level = tree.getLevel(nowNode);

		var root = tree.getRootNode();
		tree.cascadeChild(root, function(node) {
			if (tree.isExpandedNode(node)) {
				var level2 = tree.getLevel(node);
				if (node != nowNode && !tree.isAncestor(node, nowNode)
						&& level == level2) {
					tree.collapseNode(node, true);
				}
			}
		});
	}
	//设置默认皮肤
	mini.Cookie.set('miniuiSkin', 'blue');
</script>