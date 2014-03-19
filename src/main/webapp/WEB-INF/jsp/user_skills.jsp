<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>Flatty - Flat administration template</title>
	<script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-sea-blue'>
<header>
    <div class='navbar'>
        <div class='navbar-inner'>
            <div class='container-fluid'>
                <a class='brand' href='index.html'>
                    <i class='icon-heart-empty'></i>
                    <span class='hidden-phone'>Flatty</span>
                </a>
                <a class='toggle-nav btn pull-left' href='#'>
                    <i class='icon-reorder'></i>
                </a>
                <ul class='nav pull-right'>
                    <li class='dropdown light only-icon'>
                        <a class='dropdown-toggle' data-toggle='dropdown' href='#'>
                            <i class='icon-adjust'></i>
                        </a>
                        <ul class='dropdown-menu color-settings'>
                            <li class='color-settings-body-color'>
                                <div class='color-title'>Body color</div>
                                <a data-change-to='assets/stylesheets/light-theme.css' href='#'>
                                    Light
                                    <small>(default)</small>
                                </a>
                                <a data-change-to='assets/stylesheets/dark-theme.css' href='#'>
                                    Dark
                                </a>
                                <a data-change-to='assets/stylesheets/dark-blue-theme.css' href='#'>
                                    Dark blue
                                </a>
                            </li>
                            <li class='divider'></li>
                            <li class='color-settings-contrast-color'>
                                <div class='color-title'>Contrast color</div>
                                <a href="#" data-change-to="contrast-red"><i class='icon-adjust text-red'></i>
                                    Red
                                    <small>(default)</small>
                                </a>
                                <a href="#" data-change-to="contrast-blue"><i class='icon-adjust text-blue'></i>
                                    Blue
                                </a>
                                <a href="#" data-change-to="contrast-orange"><i class='icon-adjust text-orange'></i>
                                    Orange
                                </a>
                                <a href="#" data-change-to="contrast-purple"><i class='icon-adjust text-purple'></i>
                                    Purple
                                </a>
                                <a href="#" data-change-to="contrast-green"><i class='icon-adjust text-green'></i>
                                    Green
                                </a>
                                <a href="#" data-change-to="contrast-muted"><i class='icon-adjust text-muted'></i>
                                    Muted
                                </a>
                                <a href="#" data-change-to="contrast-fb"><i class='icon-adjust text-fb'></i>
                                    Facebook
                                </a>
                                <a href="#" data-change-to="contrast-dark"><i class='icon-adjust text-dark'></i>
                                    Dark
                                </a>
                                <a href="#" data-change-to="contrast-pink"><i class='icon-adjust text-pink'></i>
                                    Pink
                                </a>
                                <a href="#" data-change-to="contrast-grass-green"><i class='icon-adjust text-grass-green'></i>
                                    Grass green
                                </a>
                                <a href="#" data-change-to="contrast-sea-blue"><i class='icon-adjust text-sea-blue'></i>
                                    Sea blue
                                </a>
                                <a href="#" data-change-to="contrast-banana"><i class='icon-adjust text-banana'></i>
                                    Banana
                                </a>
                                <a href="#" data-change-to="contrast-dark-orange"><i class='icon-adjust text-dark-orange'></i>
                                    Dark orange
                                </a>
                                <a href="#" data-change-to="contrast-brown"><i class='icon-adjust text-brown'></i>
                                    Brown
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class='dropdown medium only-icon widget'>
                        <a class='dropdown-toggle' data-toggle='dropdown' href='#'>
                            <i class='icon-rss'></i>
                            <div class='label'>5</div>
                        </a>
                        <ul class='dropdown-menu'>
                            <li>
                                <a href='#'>
                                    <div class='widget-body'>
                                        <div class='pull-left icon'>
                                            <i class='icon-user text-success'></i>
                                        </div>
                                        <div class='pull-left text'>
                                            John Doe signed up
                                            <small class='muted'>just now</small>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class='divider'></li>
                            <li>
                                <a href='#'>
                                    <div class='widget-body'>
                                        <div class='pull-left icon'>
                                            <i class='icon-inbox text-error'></i>
                                        </div>
                                        <div class='pull-left text'>
                                            New Order #002
                                            <small class='muted'>3 minutes ago</small>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class='divider'></li>
                            <li>
                                <a href='#'>
                                    <div class='widget-body'>
                                        <div class='pull-left icon'>
                                            <i class='icon-comment text-warning'></i>
                                        </div>
                                        <div class='pull-left text'>
                                            America Leannon commented Flatty with veeery long text.
                                            <small class='muted'>1 hour ago</small>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class='divider'></li>
                            <li>
                                <a href='#'>
                                    <div class='widget-body'>
                                        <div class='pull-left icon'>
                                            <i class='icon-user text-success'></i>
                                        </div>
                                        <div class='pull-left text'>
                                            Jane Doe signed up
                                            <small class='muted'>last week</small>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class='divider'></li>
                            <li>
                                <a href='#'>
                                    <div class='widget-body'>
                                        <div class='pull-left icon'>
                                            <i class='icon-inbox text-error'></i>
                                        </div>
                                        <div class='pull-left text'>
                                            New Order #001
                                            <small class='muted'>1 year ago</small>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class='widget-footer'>
                                <a href='#'>All notifications</a>
                            </li>
                        </ul>
                    </li>
                    <li class='dropdown dark user-menu'>
                        <a class='dropdown-toggle' data-toggle='dropdown' href='#'>
                            <img alt='Mila Kunis' height='23' src='assets/images/avatar.jpg' width='23' />
                            <span class='user-name hidden-phone'>Mila Kunis</span>
                            <b class='caret'></b>
                        </a>
                        <ul class='dropdown-menu'>
                            <li>
                                <a href='user_profile.html'>
                                    <i class='icon-user'></i>
                                    Profile
                                </a>
                            </li>
                            <li>
                                <a href='user_profile.html'>
                                    <i class='icon-cog'></i>
                                    Settings
                                </a>
                            </li>
                            <li class='divider'></li>
                            <li>
                                <a href='sign_in.html'>
                                    <i class='icon-signout'></i>
                                    Sign out
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <form accept-charset="UTF-8" action="search_results.html" class="navbar-search pull-right hidden-phone" method="get" /><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
                    <button class="btn btn-link icon-search" name="button" type="submit"></button>
                    <input autocomplete="off" class="search-query span2" id="q_header" name="q" placeholder="Search..." type="text" value="" />
                </form>
            </div>
        </div>
    </div>
</header>
<div id='wrapper'>
<div id='main-nav-bg'></div>
<nav class='' id='main-nav'>
<div class='navigation'>
<div class='search'>
    <form accept-charset="UTF-8" action="search_results.html" method="get" /><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
        <div class='search-wrapper'>
            <input autocomplete="off" class="search-query" id="q" name="q" placeholder="Search..." type="text" value="" />
            <button class="btn btn-link icon-search" name="button" type="submit"></button>
        </div>
    </form>
</div>
<ul class='nav nav-stacked'>
<li class=''>
    <a href='index.html'>
        <i class=' icon-search'></i>
        <span>Search Jobs</span>
    </a>
</li>
<li class=''>
    <a href='${contextPath}/u/post_job.jv'>
        <i class=' icon-upload'></i>
        <span>Post a Job</span>
    </a>
</li>
<li class=''>
    <a href='${contextPath}/u/skill_test.jv'>
        <i class=' icon-tasks'></i>
        <span>Take a Skill Test</span>
    </a>
</li>
<li>
    <a class='dropdown-collapse' href='#'>
        <i class='icon-user'></i>
        <span>My Account</span>
        <i class='icon-angle-down angle-down'></i>
    </a>
    <ul class='nav nav-stacked' style='display:none'>
        <li class=''>
            <a href='profile.jsp'>
                <i class=' icon-dashboard'></i>
                <span>Overview</span>
            </a>
        </li>
        <li class=''>
            <a href='setting.jsp'>
                <i class=' icon-mail-reply'></i>
                <span>Jobs History</span>
            </a>
        </li>
        <li class=''>
            <a href='setting.jsp'>
                <i class='icon-lightbulb'></i>
                <span>Porfolio</span>
            </a>
        </li>
        <li class=''>
            <a href='setting.jsp'>
                <i class=' icon-ok'></i>
                <span>My Skills</span>
            </a>
        </li>
        <li class=''>
            <a href='setting.jsp'>
                <i class='icon-file'></i>
                <span>Resume/CV</span>
            </a>
        </li>
        <li class=''>
            <a href='setting.jsp'>
                <i class=' icon-envelope'></i>
                <span>Contact Info</span>
            </a>
        </li>
        <li class=''>
            <a href='${contextPath}/sec/sign_out.jv'>
                <i class='icon-signout'></i>
                <span>Signout</span>
            </a>
        </li>
    </ul>
</li>
<li class=''>
    <a href='faq.jsp'>
        <i class='icon-question'></i>
        <span>FAQ</span>
    </a>
</li>
</ul>
</div>
</nav>
<section id='content'>
    <div class='container-fluid'>
<div class='row-fluid' id='content-wrapper'>
<div class='span12'>
<div class='row-fluid'>
    <div class='span12'>
        <div class='page-header'>
            <h1 class='pull-left'>
                <i class='icon-list'></i>
                <span>Skills and archivements</span>
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
           	<div class='row-fluid'>
           		<div class="span12">
                   <div class="alert alert-success">
                       <h4>
                           <i class="icon-ok-sign"></i>
                           Java SE - Core Technologies
                       </h4>
                       Score: 600 (Proficience)
                       <div class="clearfix"></div>
                       <div class="btn btn-success">
                           <i class="icon-check"></i>
                           Re-test
                       </div>
                       
                   </div>
				</div>
			</div>
	
            <div class='row-fluid'>
				<div class="span12">
                   <div class="alert alert-success">
                       <h4>
                           <i class="icon-ok-sign"></i>
                           Html/CSS/Javascript
                       </h4>
                       Score: 800 (Expert)
                       <div class="clearfix"></div>
                       <div class="btn btn-success">
                           <i class="icon-check"></i>
                           Re-test
                       </div>
                   </div>
				</div>
			</div>
			<div class='row-fluid'>
				<div class="span12">
                    <div class="btn btn-primary pull-right">
                        <i class="icon-check"></i>
                        Take more test
                    </div>
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
</div>
    </div>
</section>
</div>
</body>
</html>
