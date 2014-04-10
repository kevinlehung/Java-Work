<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Skill Test: ${skill.name}</title>
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
			<div class='row-fluid'>
					<div><h3>SOFTWARE ENGINEERING CONCEPTS</h3></div>
			        <div class="row-fluid test-disable">
			            <div class="span12 box">
			            	<c:if test="${isCorrect}">
			                	<h3 class="title text-blue">Congratulations! Your answer is correct.</h3>
				            </c:if>
				            <c:if test="${!isCorrect}">
			                	<h3 class="title text-red">Sorry, Your answer is incorrect.</h3>
				            </c:if>
			            	<h4 class="title text-primary" id="question${question.questionId}">${question.stem}</h4>
			            	<c:forEach var="option" items="${question.options}">
			            		<c:choose>
				            		<c:when test="${option.isKey}">
				            			<div class="box-content box-statistic choice green-background">
					                   		<h4 class="title">${option.description}</h4>
					                   		<div class="text-success icon-ok align-right"></div>
					                   	</div>
				            		</c:when>
				            		<c:when test="${!option.isKey && option.isChoiced}">
				            			<div class="box-content box-statistic choice red-background">
					            			<h4 class="title">${option.description}</h4>
					                   		<div class="text-success icon-remove align-right"></div>
					                   	</div>
				            		</c:when>
				            		<c:otherwise>
				            			<div class="box-content box-statistic choice">
					                		<h4 class="muted">${option.description}</h4>
					                	</div>	
				            		</c:otherwise>
				               	</c:choose>
			               	</c:forEach>
			                <hr class="hr-normal">
			                <c:choose>
			                	<c:when test="${isCompletedTest}">
			                		<a class="btn btn-primary btn-large pull-right" href="${contextPath}/u/skills/list.jv">
						           		Finish Test <i class="icon-arrow-right"></i>
						           	</a>
			                	</c:when>
			                	<c:otherwise>
			                		<a class="btn btn-primary btn-large pull-right" href="${contextPath}/u/skill/${skill.skillId}/test/question.jv">
						           		Next Question <i class="icon-arrow-right"></i>
						           	</a>
			                	</c:otherwise>
			                </c:choose>
			            </div>
			        </div>
			    
			</div>
		</div>
	</body>
</html>
