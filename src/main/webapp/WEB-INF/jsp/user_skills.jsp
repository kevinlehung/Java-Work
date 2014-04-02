<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-sea-blue'>
<div class='span12'>
<div class='row-fluid'>
    <div class='span12'>
        <div class='page-header'>
            <h1 class='pull-left'>
                <i class='icon-list'></i>
                <span>Skills and achievements</span>
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
    <div class='span8 box bordered-box blue-border'>
    	
	        <div class='box-header '>
				Your archivements
	        </div>
	        <div class="box-content">
	        <div class='row-fluid'>
           		<div class="span12">
        			
        		</div>
        	</div>
			<c:forEach var = "scoreUserBean" items = "${scoreUserBeans}" >
	        <div class='row-fluid'>
           		<div class="span12">
                   <div class="alert alert-success">
                       <h4>
                           <i class="icon-ok-sign"></i>
                           ${scoreUserBean.name}
                       </h4>
                       Score: ${scoreUserBean.maxScore } (Proficience)
                       <div class="clearfix"></div>
                       <a class="btn btn-success" href="${contextPath}/u/skill/${scoreUserBean.skillId}/test.jv">
                           <i class="icon-check"></i>
                           Re-test
                       </a>
                       
                   </div>
				</div>
			</div>
			</c:forEach>
			<div class='row-fluid'>
				<div class="span12">
                    <a class="btn btn-primary pull-right"  href='${contextPath}/u/skills/list.jv'>
                        <i class="icon-check"></i>
                        Take more test
                    </a>
				</div>
			</div>
		</div>
		<div class='row-fluid'>
			<div class='span12 box bordered-box blue-border box-nomargin'>
		        <div class='box-header '>
		                Your Skills
		                <a id="inplaceediting-skills-link" href="#" class="pull-right">
                            <i class="icon-pencil"></i>
                            [Edit]
                        </a>
		        </div>
		        <div class='box-content'>
		        	<a id="inplaceediting-skills" href="#" data-type="select2" data-original-title="Enter skills" class="editable editable-click">html, javascript</a>
		        </div>
		    </div>
		</div>
    </div>
    <div class='span4 box bordered-box blue-border box-nomargin'>
        <div class='box-header '>
            <div class='title'>
                Skill Test Trends
            </div>
        </div>
        <div class='box-content'>
        <ul style="margin-bottom:0;" class="unstyled">
        <li>
            <i class="icon-asterisk text-contrast"></i>
            Developers that have taken skill tests have a <b>3x higher chance of getting hired</b> than those who haven't.<br />
        </li>
        <li>&nbsp;</li>
        <li>
            <i class="icon-asterisk text-contrast"></i>
            Nearly <b>20,000 skill tests are taken</b> every month.<br />
        </li>
        <li>&nbsp;</li>
        <li>
            <i class="icon-asterisk text-contrast"></i>
            Over <b>76% of surveyed clients</b> are more likely to hire a <b>developers with tested skills</b> that are relevant to their job.
        </li>
    </ul>
            
        </div>
    </div>
</div>

</div>
</body>
</html>
