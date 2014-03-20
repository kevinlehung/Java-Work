<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign-in Java Work</title>
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<body class='contrast-red sign-in contrast-background'>
<div id='wrapper'>
    <div class='application'>
        <div class='application-content'>
            <a href="sign_in.html"><div class='icon-heart'></div>
                <span>Java Work</span>
            </a>
        </div>
    </div>
    <div class='controls'>
        <div class='caret'></div>
        <div class='form-wrapper'>
            <h1 class='text-center'>Sign in</h1>
            <form:form accept-charset="UTF-8" action="${contextPath}/sec/security_check.jv" method="post" commandName="userSignInForm">
            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            	<div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
                <form:errors path="*" cssClass="help-block error"/>
                <div class='row-fluid'>
                    <div class='span12 icon-over-input'>
                        <form:input class="span12" id="email" name="email" placeholder="E-mail" value="" path="email"/>
                        <i class='icon-user muted'></i>
                    </div>
                </div>
                <div class='row-fluid'>
                    <div class='span12 icon-over-input'>
                        <form:password class="span12" id="password" name="password" placeholder="Password" value="" path="password"/>
                        <i class='icon-lock muted'></i>
                    </div>
                </div>
                <label class="checkbox" for="remember_me">
                	<!-- <input id="remember_me" name = "remember-me" value="1" type="checkbox"> -->
                	<form:checkbox id="remember_me" value="1" path="rememberMe" />
                    Remember me
                </label>
                <button class="btn btn-block" name="button" type="submit">Sign in</button>
            </form:form>

            
            <div class='text-center'>
                <hr class='hr-normal' />
                <a href="forgot_password.html">Forgot your password?</a>
            </div>
        </div>
    </div>
    <div class='login-action text-center'>
        <a href="${contextPath}/sec/sign_up.jv"><i class='icon-user'></i>
            New to Java Work?
            <strong>Sign up</strong>
        </a>
    </div>
</div>
</body>
</html>
