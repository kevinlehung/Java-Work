<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>Overview</title>
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
                                <i class='icon-time'></i>
                                <span>Timeline</span>
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
                                    <li>Example pages</li>
                                    <li class='separator'>
                                        <i class='icon-angle-right'></i>
                                    </li>
                                    <li class='active'>Timeline</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class='row-fluid acc-overview'>
                    <div class='span12'>
                        <ol class='unstyled'>
                            <li class="deco">
                                <div class='icon sea-blue-background'>
                                    <i class='icon-smile'></i>
                                </div>
                                <div class='title'>
                                    About Me
                                    <a id="inplaceediting-about-me" href="#" class="pull-right">
			                            <i class="icon-pencil"></i>
			                            [Edit]
			                        </a>
                                </div>
                                <div class='content' id='inplaceediting-about-me-content' data-type="wysihtml5" data-original-title="About Me" data-toggle="manual">
                                    <p>
                                    I have over ten years experience in JAVA-related technologies in web-based programming, system design, technical troubleshooting, problem solving...
									</p>
									<p>
									I am able to perform all aspects of the development and release cycle, including front-end, back-end, database and system development.
									</p>
									<p>
										My technical skills:<br />
										+ Struts, JPA, Hibernate, Spring Data, Spring MVC,<br />
										+ Apache, Tomcat, JBoss.<br />
										+ JMS/ActiveMQ<br />
										+ Good at using CASE tools and frameworks ( such as CVS, SVN, JMeter, Ant, Maven, GIT)<br />
									</p>
									
                                </div>
                            </li>
                            <li class="deco">
                                <div class='icon  sea-blue-background'>
                                    <i class='icon-globe'></i>
                                </div>
                                <div class='title'>
                                    Service Description
                                    <a id="inplaceediting-service" href="#" class="pull-right">
			                            <i class="icon-pencil"></i>
			                            [Edit]
			                            
			                        </a>
                                </div>
                                <div class='content' id="inplaceediting-service-content"  data-type="wysihtml5" data-original-title="Service Description" data-toggle="manual">
                                    
                                </div>
                            </li>
                            <li class="deco">
                                <div class='icon sea-blue-background'>
                                    <i class='icon-certificate '></i>
                                </div>
                                <div class='title'>
                                    Certifications 
                                    <a id="add-certifications" data-toggle='modal' href='#add-certifications-dialog' role='button' class="pull-right">
			                            <i class="icon-plus"></i>
			                            [Add Certification]
			                        </a>
			                        
                                </div>
                                <div class='content editable editable-empty'>
                                    Empty
                                </div>
                                <div class='modal hide fade' id='add-certifications-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Certification</h3>
					                    Demonstrate your expertise by listing your certifications.
					                </div>
					                <div class='modal-body'>
					                    <form class='form' style='margin-bottom: 0;' />
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <input class='span12' type='text' placeholder='Conferring Organization'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional certificate</strong></label>
					                            <div class='controls'>
					                                <input class='span12' placeholder='Professional certificate' type='text' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Date Awarded/Received</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <input type="text" placeholder="Select datepicker" data-format="yyyy-MM-dd" class="input-medium">
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Certificate Number</strong> (optional)</label>
					                            <div class='controls'>
					                                <input class='span12' placeholder='Certificate Number' type='text' />
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <textarea class='span12' placeholder='Description'></textarea>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        
					                    </form>
					                </div>
					                <div class='modal-footer'>
					                    <button class='btn' data-dismiss='modal'>Close</button>
					                    <button class='btn btn-primary'>Save changes</button>
					                </div>
					            </div>
                            </li>
                            <li class="deco">
                                <div class='icon sea-blue-background'>
                                    <i class='icon-check'></i>
                                </div>
                                <div class='title'>
                                    Licenses
                                    <a id="inplaceediting-pencil"  data-toggle='modal' href='#add-licenses-dialog' role='button' class="pull-right">
			                            <i class="icon-plus"></i>
			                            [Add License]
			                        </a>
                                </div>
                                <div class='content editable editable-empty'>
                                    Empty
                                </div>
                                <div class='modal hide fade' id='add-licenses-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>License</h3>
					                    Highlight your qualifications by listing relevant licenses you have acquired.
					                </div>
					                <div class='modal-body'>
					                    <form class='form' style='margin-bottom: 0;' />
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <input class='span12' type='text' placeholder='Conferring Organization'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional License or Membership</strong></label>
					                            <div class='controls'>
					                                <input class='span12' placeholder='Professional License or Membership' type='text' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Date Issued</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <input type="text" placeholder="Select datepicker" data-format="yyyy-MM-dd" class="input-medium">
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>License Number</strong> (optional)</label>
					                            <div class='controls'>
					                                <input class='span12' placeholder='License Number' type='text' />
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <textarea class='span12' placeholder='Description'></textarea>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        
					                    </form>
					                </div>
					                <div class='modal-footer'>
					                    <button class='btn' data-dismiss='modal'>Close</button>
					                    <button class='btn btn-primary'>Save changes</button>
					                </div>
					            </div>
                            </li>
                            <li class="deco">
                                <div class='icon sea-blue-background'>
                                    <i class='icon-book'></i>
                                </div>
                                <div class='title'>
                                    Education
                                    <a data-toggle='modal' href='#add-educations-dialog' role='button'  class="pull-right">
			                            <i class="icon-plus"></i>
			                            [Add Education]
			                        </a>
                                </div>
                                <div class='content editable editable-empty'>
                                    Empty
                                </div>
                                <div class='modal hide fade' id='add-educations-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Education</h3>
					                    Specify your educational background to prospective clients.
					                </div>
					                <div class='modal-body'>
					                    <form class='form' style='margin-bottom: 0;' />
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Institution Name</strong></label>
					                            <div class='controls'>
					                                <input class='span12' type='text' placeholder='Institution Name'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Name and Type of Degree</strong></label>
					                            <div class='controls'>
					                                <input class='span12' placeholder='Name and Type of Degree' type='text' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
												<strong>Start - End Graduation Date</strong> (optional)
												<div>
													<div class='input-append'>
														<input class='input-medium daterange'
															placeholder='Start - End Graduation Date' type='text' /> 
														<span
															class='add-on' id='education-daterange'> <i
															class='icon-calendar'></i>
														</span>
													</div>
												</div>
											</div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <textarea class='span12' placeholder='Description'></textarea>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        
					                    </form>
					                </div>
					                <div class='modal-footer'>
					                    <button class='btn' data-dismiss='modal'>Close</button>
					                    <button class='btn btn-primary'>Save changes</button>
					                </div>
					            </div>
                            </li>
                            <li class="deco">
                                <div class='icon sea-blue-background'>
                                    <i class='icon-star-empty'></i>
                                </div>
                                <div class='title'>
                                    Employment
                                    <a id="add-certifications" data-toggle='modal' href='#add-employments-dialog' role='button' class="pull-right">
			                            <i class="icon-plus"></i>
			                            [Add Employment]
			                        </a>
                                </div>
                                <div class='content editable editable-empty'>
                                    Empty
                                </div>
                                <div class='modal hide fade' id='add-employments-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Employment</h3>
					                    Showcase your work experience by listing prior relevant clients.
					                </div>
					                <div class='modal-body'>
					                    <form class='form' style='margin-bottom: 0;' />
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Client name</strong></label>
					                            <div class='controls'>
					                                <input class='span12' type='text' placeholder='Client name'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Position held</strong></label>
					                            <div class='controls'>
					                                <input class='span12' placeholder='Position held' type='text' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
												<strong>Start - End Date</strong> (optional)
												<div>
													<div class='input-append'>
														<input class='input-medium daterange'
															placeholder='Start - End Date' type='text' /> 
														<span
															class='add-on' id='employment-daterange'> <i
															class='icon-calendar'></i>
														</span>
													</div>
												</div>
											</div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <textarea class='span12' placeholder='Description'></textarea>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        
					                    </form>
					                </div>
					                <div class='modal-footer'>
					                    <button class='btn' data-dismiss='modal'>Close</button>
					                    <button class='btn btn-primary'>Save changes</button>
					                </div>
					            </div>
                            </li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</div>
</body>
</html>
