<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post Java Job - Preview</title>
    <link href='${contextPath}/assets/stylesheets/account.css' media='all' rel='stylesheet' type='text/css' />
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
</head>
<body class='contrast-sea-blue'>
            <div class='span12'>
                <div class='row-fluid'>
                    <div class='span12'>
                        <div class='page-header'>
                            <h1 class='pull-left'>
                                <i class='icon-time'></i>
                                <span>Dashboard</span>
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
                                    <li>Java Work</li>
                                    <li class='separator'>
                                        <i class='icon-angle-right'></i>
                                    </li>
                                    <li class='active'>Dashboard</li>
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
</body>
</html>
