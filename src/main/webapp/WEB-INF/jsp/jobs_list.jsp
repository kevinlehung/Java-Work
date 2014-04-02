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
						<li><small>Job: ${job.jobType}</small></li>
						<li><small>|</small></li>
						<li><small>Posted: ${job.createdDate}</small></li>
						<li><small>|</small></li>
						<li><small>Location: ${job.location}</small></li>
						<li><small>|</small></li>
						<li><small>Applied: ${job.appliedCount}</small></li>
					</ul>
				</div>
				<p>${job.description}</p>
			</div>
		</div>
	</div>
	</c:forEach>
	<div class='pagination pagination-centered'>
		<ul>
		<c:url var="prevUrl" value="/u/jobs/${currentIndex - 1}/list.jv" />
		<c:url var="nextUrl" value="/u/jobs/${currentIndex + 1}/list.jv" />
			<c:choose>
				<c:when test="${currentIndex == 1}">
					<li class="disabled"><a href="#"><i class='icon-chevron-left'></i></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${prevUrl}"><i class='icon-chevron-left'></i></a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				<c:url var="pageUrl" value="/u/jobs/${i}/list.jv" />
				<c:choose>
					<c:when test="${i == currentIndex}">
						<li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${currentIndex == page.totalPages}">
					<li class="disabled"><a href="#"><i class='icon-chevron-right'></i></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${nextUrl}"><i class='icon-chevron-right'></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</body>
</html>
