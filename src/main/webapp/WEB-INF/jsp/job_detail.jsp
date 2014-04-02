<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Job detail</title>
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-red '>
<div class='row-fluid' id='content-wrapper'>
<div class='span12'>
	<div class='row-fluid'>
		<div class='span12'>
			<div class='page-header'>
				<h1 class='pull-left'>
					<i class='icon-info'></i> <span>Job Details</span>
				</h1>
				<div class='pull-right'>
					<ul class='breadcrumb'>
						<li><a href="index.html"><i class='icon-bar-chart'></i> </a>
						</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li>Java Work</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li class='active'>Job Details</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class='row-fluid'>
		<div class='span12 box'>
			<div class='box-content box-padding'>
				<div class='fuelux'>
					<div class="step-content">
						<div class='box'>
							<div class="box-header">
								<div class="title">
									<h2>${title}</h2>
								</div>
								<div class="actions">
									<a class="btn box-collapse btn-mini btn-link" href="#"><i></i>
									</a>
								</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">
									<div class="pull-left">
										<i class="icon-time"></i> Posted: ${createdDate} <br /> 
									<i class="icon-group"></i> Company: ${company} <br /> 
									<i class="icon-location-arrow"></i> Location: ${location}<br /> 
									<i class="icon-adjust"></i> Job: ${jobType} <br /> 
									<i class="icon-money"></i> ${salaryType}: ${salary} <br /> 
									<i class="icon-smile"></i> Applied: ${appliedCount}
									</div>
									<div class="pull-right">
										<button class="btn btn-primary btn-large">
											<i class="icon-check"></i> Apply this job
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class='box'>
							<div class="box-header">
								<div class="title">Job Description</div>
								<div class="actions">
									<a class="btn box-collapse btn-mini btn-link" href="#"><i></i>
									</a>
								</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">${description}</div>
							</div>
						</div>
						<div class='box'>
							<div class="box-header">
								<div class="title">Desired skills</div>
								<div class="actions">
									<a class="btn box-collapse btn-mini btn-link" href="#"><i></i>
									</a>
								</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">
									<c:set var="skillCount" value="${fn:length(requiredSkills)}"/>
									<c:forEach items="${requiredSkills}" var="skill" varStatus="status" >
										<a href="javascript:;">${skill.name}</a><c:if test="${status.index <  skillCount - 1}">, </c:if>
									</c:forEach>
								</div>
								<div class="row-fluid">
									${customRequiredSkill}
								</div>
							</div>
						</div>
						<hr class="hr-normal">

						<div class="text-right">
							<button class="btn btn-primary btn-large">
								<i class="icon-check"></i> Apply this job
							</button>
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
