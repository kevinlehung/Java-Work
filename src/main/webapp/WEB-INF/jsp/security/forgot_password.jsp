<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Forgot password</title>
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-red forgot-password contrast-background'>
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
            <h1 class='text-center'>Forgot password</h1>
            <form accept-charset="UTF-8" action="${contextPath}/reset_password.jv" method="get" /><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
                <div class='row-fluid'>
                    <div class='span12 icon-over-input'>
                        <input class="span12" id="email" name="email" placeholder="E-mail" type="text" value="" />
                        <i class='icon-user muted'></i>
                    </div>
                </div>
                <button class="btn btn-block" name="button" type="submit">Send me instructions</button>
            </form>
            <div class='text-center'>
                <hr class='hr-normal' />
                <a href="sign_in.html"><i class='icon-chevron-left'></i>
                    I already know my password
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
