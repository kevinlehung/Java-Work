<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Skill Test: SOFTWARE ENGINEERING CONCEPTS</title>
		<link href='${contextPath}/assets/stylesheets/skill.css' media='all' rel='stylesheet' type='text/css' />
		<script src='${contextPath}/assets/javascripts/skill.js' type='text/javascript'></script>
	</head>
	<body class='contrast-sea-blue'>
		<div class='span12'>
			<div class='row-fluid'>
			    <div class='span12'>
			        <div class='page-header'>
			            <h1 class='pull-left'>
			                <i class='icon-list'></i>
			                <span>${skill.name}</span>
			            </h1>
			            <div class='pull-right'>
			                <ul class='breadcrumb'>
			                    <li>
			                        <a href="index.html"><i class='icon-bar-chart'></i>
			                        </a>
			                    </li>
			                    <li class='separator'>
			                        <i class='icon-angle-right'></i>
			                    </li>
			                    <li>
			                        Forms
			                    </li>
			                    <li class='separator'>
			                        <i class='icon-angle-right'></i>
			                    </li>
			                    <li class='active'>Form components</li>
			                </ul>
			            </div>
			        </div>
			    </div>
			</div>
			<c:if test="${not empty errorMsg}">
				<div>
					<font color="red">${errorMsg}</font>
				</div>
			</c:if>
			<div class='row-fluid'>
				<div><h3>SOFTWARE ENGINEERING CONCEPTS</h3></div>
				<c:if test="${not empty question}">
					<form id="questionForm" action="${contextPath}/u/skill/${skill.skillId}/test/question/complete.jv" method="post">
						<div class="row-fluid test-enable">
							<div class="span12 box" id="practice_question">
								<h3 class="title text-red">Remaining Time: <span style="font-weight: 900; font-style: normal;" id="timeRemain"></span></h3>(Don't rush. There's no bonus for finishing early!)
								<h4 class="title text-primary" id="question${question.questionId}">${question.stem}</h4>
								<c:forEach var="option" items="${question.options}">
									<div class="box-content box-statistic choice" id="${option.optionId}">
										<h4 class="muted">${option.description}</h4>
									</div>
								</c:forEach>
							</div>
							<hr class="hr-normal">
							<a id="btn_submit" class="btn btn-primary btn-large pull-right" data-toggle="modal" href="#confirmDialog">Submit</a>
							</div>
							<input type="hidden" id="timeout" value="${question.duration}" />
							<input type="hidden" id="isMultipleChoice" value="${question.isMultipleChoice}" />
							<input type="hidden" name="questionId" value="${question.questionId}" />
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				</c:if>
			</div>
		</div>	
		<div id="confirmDialog" class="modal hide fade" role="dialog"  tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">Confirm Message</h4>
					</div>
					<div class="modal-body">
						Are you sure to finish this question?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="submitTestQuestion(); return false;">Ok</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
