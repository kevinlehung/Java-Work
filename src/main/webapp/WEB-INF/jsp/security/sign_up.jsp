<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign-up Java Work</title>
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-red sign-up contrast-background'>
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
            <h1 class='text-center'>Sign up</h1>
            <form:form accept-charset="UTF-8" action="${contextPath}/sec/sign_up.jv" method="post" commandName = "userSignUpForm"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class='row-fluid row-fluid control-group'>
                    <div class='span12 icon-over-input'>
                        <form:input class="span12" id="email" name="email" placeholder="E-mail" value="" data-rule-required="true" data-rule-email="true" path="email"/>
                        <i class='icon-user muted'></i>
                    </div>
                    <form:errors path="email" cssClass="help-block error"/>
                </div>
                <div class='row-fluid control-group'>
                    <div class='span12 icon-over-input'>
                        <form:password class="span12" id="password" name="password" placeholder="Password" value="" path="password"/>
                        <i class='icon-lock muted'></i>
                    </div>
                    <form:errors path="password"  cssClass="help-block error"/>
                </div>
                <div class='row-fluid control-group'>
                    <div class='span12 icon-over-input'>
                        <form:password class="span12" id="password_confirmation" name="confirmPassword" placeholder="Password confirmation" value="" path="confirmPassword"/>
                        <i class='icon-lock muted'></i>
                    </div>
                    <form:errors path="confirmPassword"  cssClass="help-block error"/>
                </div>
                
                <div class='control-group'>
	                <label class="radio inline">
	                    <form:radiobutton value="HIRE" name="purpose" path="purpose"/>
	                    I want to <b>Hire</b>
	                </label>
	                <label class="radio inline">
	                    <form:radiobutton value="WORK" name="purpose" path="purpose"/>
	                    I want to <b>Work</b>
	                </label>
	                <form:errors path="purpose"  cssClass="help-block error"/>
                </div>
                <div class='control-group'>
	                <label class="checkbox" for="agreement"><form:checkbox id="agreement" name="acceptAgreement" value="1" path="acceptAgreement" />
	                    I accept
	                    <a href="#" class="text-contrast">user agreements</a>
	                </label>
	                <form:errors path="acceptAgreement"  cssClass="help-block error"/>
                </div>
                <button class="btn btn-block" name="button" type="submit">Sign up</button>
            </form:form>
            <div class='text-center'>
                <hr class='hr-normal' />
                <a href="${contextPath}/sec/sign_in.jv"><i class='icon-chevron-left'></i>
                    Go back to sign in
                </a>
            </div>
        </div>
    </div>
    <div class='login-action text-center'>
        <a href="forgot_password.html"><i class='icon-lock'></i>
            Forgot your password?
        </a>
    </div>
</div>

</body>
</html>
