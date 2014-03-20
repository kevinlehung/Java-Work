<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign-up Java Work</title>
    <script type="text/javascript">
    	setTimeout(function() {
    		window.location = "${contextPath}/u/jobs/1/list.jv";
    	}, 1000);
    </script>
     <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-red sign-up contrast-background' >
<div id='wrapper'>
    <div class='application'>
        <div class='application-content'>
            <a href="sign_in.html"><div class='icon-heart'></div>
                <span>Java Work</span>
            </a>
        </div>
    </div>
    <div class='controls'>
        <div class='caret'> </div>
        <div class='conten-wrapper'>
        	<br/>
            <div class='text-center'><h1><span class="text-contrast">Thanks for joining Java Work.</span> Your <br /> account has been created!</h1></div>
            <br />
            <div class='text-center'><h4><a class="text-contrast" href="#"><span class="underline">Start finding jobs from Java Work.</span></a></h4></div>
            <br />
            <br />
        </div>
    </div>
</div>
</body>
</html>
