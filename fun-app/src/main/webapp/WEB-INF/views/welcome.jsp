<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fun</title>

<link rel="stylesheet" media="screen"
	href="resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" media="screen"
	href="resources/site/site.css" />

<script src="resources/bootstrap/js/jquery-2.0.3.js"></script>
<script src="resources/bootstrap/js/bootstrap.js"></script>
<script src="resources/site/site.js"></script>
<script src="resources/site/config.js"></script>

<script>
	$(function() {
		telemed.renderapi(config.api);
	});
</script>

</head>
<body>
	<div class="row">
		<div class="col-md-3">
			<nav style="position: fixed; top: 5px; width: 250px;">
				<ul class="list-group">
					<li class="list-group-item"><a href="api" class="active"
						href="/">用户组织相关</a>
						<ul class="nav">
							<li><a href="#deptpatientHD" class="active" href="/">用户组织相关</a>
							</li>
						</ul></li>
					<li class="list-group-item"><a href="lispacs" class="active"
						href="/">账号系统</a></li>
				</ul>
			</nav>
		</div>
		<div class="col-md-9">
			<article id="payload"></article>
		</div>
	</div>


</body>
</html>