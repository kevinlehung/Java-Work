<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post Java Job - Preview</title>
</head>
<body class='contrast-sea-blue'>
<div class='span12'>
<div class='row-fluid'>
    <div class='span12'>
        <div class='page-header'>
            <h1 class='pull-left'>
                <i class='icon-list'></i>
                <span>Java Skill Tests</span>
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
            	<h3 class="title text-red">Sorry, you ran out of time!</h3>
                <h4 class="title text-primary">What is the decimal value of the hexadecimal number "FF"?</h4>
                <div class="box-content box-statistic choice">
                    <h4 class="muted">1024</h4>
                </div>
                <div class="box-content box-statistic choice-correct">
                    <h4 class="muted text-success">255</h4><div class="text-success icon-ok align-right"></div>
                </div>
                
                <div class="box-content box-statistic choice">
                    <h4 class="muted">256</h4>
                </div>
                <div class="box-content box-statistic choice">
                    <h4 class="muted">0</h4>
                </div>
                <hr class="hr-normal">
                <a class="btn btn-primary btn-large pull-right" href="${contextPath}/u/skill/1/test/question.jv">
                        Next Question <i class="icon-arrow-right"></i>
                </a>
            </div>
        </div>
    
</div>
</div>
</body>
</html>
