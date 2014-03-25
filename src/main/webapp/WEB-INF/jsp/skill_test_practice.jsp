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
        <div class="row-fluid test-enable">
            <div class="span12 box" id="practice_question">
            	<h3 class="title text-red">Remaining Time: <strong>00:59</strong></h3>(Don't rush. There's no bonus for finishing early!)
                <h4 class="title text-primary">What is the decimal value of the hexadecimal number "FF"?</h4>
                <div class="box-content box-statistic choice">
                    <h4 class="muted">1024</h4>
                </div>
                <div class="box-content box-statistic choice">
                    <h4 class="muted">255</h4>
                </div>
                <div class="box-content box-statistic choice">
                    <h4 class="muted">256</h4>
                </div>
                <div class="box-content box-statistic choice">
                    <h4 class="muted">0</h4>
                </div>
            </div>
        </div>
    
</div>
</div>
</body>
</html>
