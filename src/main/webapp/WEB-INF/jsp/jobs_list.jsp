<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Opening Java Jobs</title>
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-red '>
	<div class='page-header'>
		<h1 class='pull-left'>
			<i class='icon-search'></i> <span>Jobs are opening.</span> <small>Submit
				your proposal today!</small>
		</h1>
	</div>
	<c:forEach items="${jobs}" var="job">
	<div class='row-fluid'>
		<div class='span12 box'>
			<div class='box-content'>
				<h4>
					<a href="${contextPath}/u/jobs/${job.jobId}/view.jv" class="text-contrast">${job.title }</a>
				</h4>
				<div class="row-fluid">
					<ul class="inline">
						<li><small>Salary: ${job.salary}</small></li>
						<li><small>|</small></li>
						<li><small>Job: Fulltime</small></li>
						<li><small>|</small></li>
						<li><small>Posted: ${job.createdDate}</small></li>
						<li><small>|</small></li>
						<li><small>Location: ${job.location}</small></li>
						<li><small>|</small></li>
						<li><small>Applied: 6</small></li>
					</ul>
				</div>
				<p>${job.description}</p>
			</div>
		</div>
	</div>
	</c:forEach>
	<div class='pagination pagination-centered'>
		<ul>
			<li><a href='#'> <i class='icon-chevron-left'></i>
			</a></li>
			<li><a href='#'>1</a></li>
			<li class='active'><a href='#'>2</a></li>
			<li><a href='#'>3</a></li>
			<li><a href='#'>4</a></li>
			<li><a href='#'>5</a></li>
			<li><a href='#'> <i class='icon-chevron-right'></i>
			</a></li>
		</ul>
	</div>
</body>
</html>
