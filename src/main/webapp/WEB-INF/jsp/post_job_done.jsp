<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post Java Job - Done</title>
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-red '>
	<div class='row-fluid'>
		<div class='span12'>
			<div class='page-header'>
				<h1 class='pull-left'>
					<i class='icon-edit'></i> <span>Finish Posting</span>
				</h1>
				<div class='pull-right'>
					<ul class='breadcrumb'>
						<li><a href="index.html"><i class='icon-bar-chart'></i> </a>
						</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li>Java Work</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li class='active'>Finish Posting</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class='row-fluid'>
		<div class='span12 box'>
			<div class='box-content box-padding'>
				<div class='fuelux'>
					<div class='wizard'>
						<ul class='steps'>
							<li data-target='#step1'><span class='step'>Describe</span>
							</li>
							<li data-target='#step2'><span class='step'>Preview</span></li>
							<li class='active' data-target='#step3'><span class='step'>Done</span>
							</li>
						</ul>
					</div>
					<div class="step-content">
						<div class='box'>
							<div class="box-header">
								<div class="title">
									<h2>Front End Website Coding</h2>
								</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">
									Your post is done. You need to wait a couple of hours for
									reviewing by site admin.<br /> Please notice just jobs ralates
									to Java technology is allow here. The post violates this rule
									will be rejected. <br /> <br /> Thank you.
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
