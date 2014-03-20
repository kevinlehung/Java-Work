<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reset password</title>
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-red forgot-password contrast-background'>
<div id='wrapper'>
    <div class='application'>
        <div class='application-content'>
            <a href="${contextPath}/sec/sign_in.jv"><div class='icon-heart'></div>
                <span>Java Work</span>
            </a>
        </div>
    </div>
    <div class='controls'>
        <div class='caret'></div>
        <div class='form-wrapper'>
            <h1 class='text-center'>Your password is reset</h1>
            <div class='text-center'>
                <hr class='hr-normal' />
                    New password is sent to your email address. Please check mailbox and sign-in with new password
            </div>
            <div class='text-center'>
                <hr class='hr-normal' />
                <a href="sign_in.html"><i class='icon-chevron-left'></i>
                    Sign-in with new password
                </a>
            </div>
        </div>
    </div>
    <div class='login-action text-center'>
        <a href="sign_up.html"><i class='icon-user'></i>
            New to Java Work?
            <strong>Sign up</strong>
        </a>
    </div>
</div>
</body>
</html>
