<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post Java Job - Preview</title>
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-red '>
	<div class='row-fluid'>
		<div class='span12'>
			<div class='page-header'>
				<h1 class='pull-left'>
					<i class='icon-edit'></i> <span>Preview Your Post</span>
				</h1>
				<div class='pull-right'>
					<ul class='breadcrumb'>
						<li><a href="index.html"><i class='icon-bar-chart'></i> </a>
						</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li>Java Work</li>
						<li class='separator'><i class='icon-angle-right'></i></li>
						<li class='active'>Preview Your Post</li>
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
							<li class='active' data-target='#step2'><span class='step'>Preview</span>
							</li>
							<li data-target='#step3'><span class='step'>Done</span></li>
						</ul>
						<div class='actions'>
							<button class='btn btn-mini btn-prev'>
								<i class='icon-arrow-left'></i>Prev
							</button>
							<button class='btn btn-mini btn-success btn-next'
								data-last='Finish'>
								Next <i class='icon-arrow-right'></i>
							</button>
						</div>
					</div>
					<div class="step-content">
						<form:form accept-charset="UTF-8" action="${contextPath}/u/post_job/done.jv" class="form form-striped"
							method="post" style="margin-bottom: 0;" commandName="postJobForm">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<div class='box'>
							<div class="box-header">
								<div class="title">
									<h2>${postJobForm.title}</h2>
								</div>
								<div class="actions">
									<a class="btn box-collapse btn-mini btn-link" href="#"><i></i>
									</a>
								</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">
									<i class="icon-time"></i> Posted: ${createdDate} <br /> 
									<i class="icon-group"></i> Client Info: ${clientInfo} <br /> 
									<i class="icon-location-arrow"></i> Location: ${location}<br /> 
									<!-- <i class="icon-adjust"></i> Job: Fulltime <br /> --> 
									<i class="icon-money"></i> ${salaryType}: ${salary} <br /> 
									<i class="icon-smile"></i> Applied: 0
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
								<div class="row-fluid">${postJobForm.description}</div>
							</div>
						</div>
						<div class='box'>
							<div class="box-header">
								<div class="title">Desired skills</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">
								Tags: 
									<c:set var="skillCount" value="${fn:length(requiredSkills) }"/>
									<c:forEach items="${requiredSkills}" var="skill" varStatus="status" >
										<a href="javascript:;">${skill.name}</a><c:if test="${status.index <  skillCount - 1}">, </c:if>
									</c:forEach>
								</div>
								<div class="row-fluid">
									${postJobForm.customRequiredSkill}
								</div>
							</div>
							
						</div>
						<c:if test="${not empty postJobForm.otherOption}">
						<div class='box'>
							<div class="box-header">
								<div class="title">Other Options</div>
							</div>
							<div class="box-content">
								<div class="row-fluid">
									${postJobForm.otherOption}
								</div>
							</div>
						</div>
						</c:if>
						<div class='box'>
							<hr class="hr-normal">

							<div class="text-right">
								<a href="/" class="btn btn-danger btn-large">
									<i class="icon-remove"></i> Cancel
								</a>
								<button type="submit" class="btn btn-primary btn-large">
									<i class="icon-check"></i> Post Job
								</button>
							</div>
						</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
