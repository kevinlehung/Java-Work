<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Try a Practice Question</title>
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
<div class='row-fluid'>
		<div><h3>SOFTWARE ENGINEERING CONCEPTS</h3></div>
        <div class='row-fluid'>
           	<div class="span12">
                   <div class="alert alert-warning">
                       <h4>
                           <i class="icon-exclamation-sign"></i>
                           Try a practice question.
                       </h4>
                       <p>
                       This practice question will <b>not count</b> toward your score. After the practice question, you start earning points for your answers!
                       </p>
                   </div>
			</div>
		</div>
		<form id="questionForm" action="${contextPath}/u/skill/${skill.skillId}/test/practice/complete.jv" method="post">
	        <div class="row-fluid test-enable">
	            <div class="span12 box" id="practice_question">
	            	<h3 class="title text-red">Remaining Time: <strong id="timeRemain"></strong></h3>(Don't rush. There's no bonus for finishing early!)
	                <h4 class="title text-primary" id="question${question.questionId}">${question.stem}</h4>
	                <c:forEach var="option" items="${question.options}">
	                	<div class="box-content box-statistic choice" id="${option.optionId}">
	                    	<h4 class="muted">${option.description}</h4>
	                	</div>
	                </c:forEach>
	            </div>
	            <input id="btn_finish" type="submit" class="btn btn-primary btn-large" value="Finish"/>
	        </div>
	        
	    	<input type="hidden" id="timeout" value="${timeout}" />
	    	<input type="hidden" id="isMultipleChoice" value="${question.isMultipleChoice}" />
	    	<input type="hidden" id="choice" name="choice"/>
			<input type="hidden" name="questionId" value="${question.questionId}" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    </form>
</div>
</div>
</body>
</html>
