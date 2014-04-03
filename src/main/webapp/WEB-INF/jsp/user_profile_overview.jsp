<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post Java Job - Preview</title>
    <link href='${contextPath}/assets/stylesheets/account.css' media='all' rel='stylesheet' type='text/css' />
    <script src='${contextPath}/assets/javascripts/account.js' type='text/javascript'></script>
    <script src='${contextPath}/assets/javascripts/javawork/user_profile_overview.js' type='text/javascript'></script>
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
			                        <a href="#" data-target="#my_modal" data-toggle="modal" data-id="my_id_value">Open Modal</a>
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
                                    <a id="add-certifications" data-toggle='modal' href='#add-certification-dialog' role='button' class="pull-right">
			                            <i class="icon-plus"></i>
			                            [Add Certification]
			                        </a>
			                        
                                </div>
                                <div class='content editable editable-empty'>
									<c:choose>
										<c:when test="${(empty uCertifications) && (fn:length(uCertifications) == 0)}">
 											Empty
 										</c:when>
 										<c:otherwise>
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<c:forEach items="#{uCertifications}" var="uCertification" varStatus="count">
												<c:if test="${uCertification.conferringOrganization!=null && uCertification.conferringOrganization!=''}">
												<tr>
													<td>
														<a id="certification-conferringOrganization-${uCertification.certificationId}" href='#update-certification-dialog' data-toggle='modal' role='button' onclick="bindCurrentCertification(${uCertification.certificationId});return false;">
															<h5><c:out value="${uCertification.conferringOrganization}"/></h5>
														</a>  
													</td>
												</tr>
												</c:if>
												
												<c:if test="${uCertification.professionalCertificate!=null && uCertification.professionalCertificate!=''}">
												<tr>
													<td id="certification-professionalCertificate-${uCertification.certificationId}"><c:out value="${uCertification.professionalCertificate}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uCertification.dateAwarded!=null && uCertification.dateAwarded!=''}">
												<tr>
													<td id="certification-dateAwarded-${uCertification.certificationId}"><c:out value="${uCertification.dateAwarded}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uCertification.certificateNumber!=null && uCertification.certificateNumber!=''}">
												<tr>
													<td id="certification-certificateNumber-${uCertification.certificationId}"><c:out value="${uCertification.certificateNumber}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uCertification.description!=null && uCertification.description!=''}">
												<tr>
													<td id="certification-description-${uCertification.certificationId}" ><c:out value="${uCertification.description}"/></td>
												</tr>
												</c:if>
											</c:forEach>
											</table>
										</c:otherwise>
									</c:choose>
                                </div>
                                <div class='modal hide fade' id='add-certification-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Certification</h3>
					                    Demonstrate your expertise by listing your certifications.
					                </div>
					                
					                <form:form accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUCertification.jv" method="post" commandName = "uCertificationForm">
					                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					                	<div class='modal-body'> 
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <form:input class="span12" id="conferringOrganization" placeholder="Conferring Organization" path="conferringOrganization"/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional Certificate</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' type='text' placeholder='Professional certificate' value='' path='professionalCertificate'/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Date Awarded/Received</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='dateAwarded'/>
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
					                                <form:input class='span12' placeholder='Certificate Number' type='text' value='' path='certificateNumber'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea class='span12' placeholder='Description' path="description"/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                	</div>
					                	<div class='modal-footer'>
					                    	<button class='btn' data-dismiss='modal'>Close</button>
					                    	<button class='btn btn-primary' type="submit">Save changes</button>
					                	</div>
					            	</form:form>
					            
					            </div>
					            
					            <div class='modal hide fade' id='update-certification-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Update Certification</h3>
					                    Demonstrate your expertise by listing your certifications.
					                </div>
									<form:form id='frm-UpdateUCertification' accept-charset="UTF-8" action="${contextPath}/u/dashboard/updateUCertification.jv" method="post" commandName = "uCertificationForm">
					                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					                	<div class='modal-body'> 
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <form:input class="span12" id="certification-conferringOrganization" placeholder="Conferring Organization" path="conferringOrganization"/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional Certificate</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' id="certification-professionalOrganization" type='text' placeholder='Professional certificate' value='' path='professionalCertificate'/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Date Awarded/Received</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input id="certification-dateAwarded" type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='dateAwarded'/>
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
					                                <form:input class='span12' id='certification-certificateNumber' placeholder='Certificate Number' type='text' value='' path='certificateNumber'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea class='span12' id='certification-description' placeholder='Description' path="description"/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                	</div>
					                	<div class='modal-footer'>
					                    	<button class='btn' data-dismiss='modal'>Close</button>
					                    	<button class='btn btn-primary' type="button" onclick='updateUCertification();return false;'>Save changes</button>
					                    	<button class='btn btn-danger' type="button" onclick='deleteUCertification();return false;'>Delete</button>
					                	</div>
					            	</form:form>
					            </div>
					            
                            </li>
                            <li class="deco">
                                <div class='icon sea-blue-background'>
                                    <i class='icon-check'></i>
                                </div>
                                <div class='title'>
                                    Licenses
                                    <a id="inplaceediting-pencil"  data-toggle='modal' href='#add-license-dialog' role='button' class="pull-right">
			                            <i class="icon-plus"></i>
			                            [Add License]
			                        </a>
                                </div>
                                <div class='content editable editable-empty'>
                                   <c:choose>
										<c:when test="${(empty uLicenses) && (fn:length(uLicenses) == 0)}">
 											Empty
 										</c:when>
 										<c:otherwise>
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<c:forEach items="#{uLicenses}" var="uLicense" varStatus="count">
												<c:if test="${uLicense.conferringOrganization!=null && uLicense.conferringOrganization!=''}">
												<tr>
													<td id='license-conferringOrganization-${uLicense.licenseId}'>
														<a href='#update-license-dialog' data-toggle='modal' role='button' onclick="bindCurrentLicense(${uLicense.licenseId});return false;">
															<h5><c:out value="${uLicense.conferringOrganization}"/></h5>
														</a>
													</td> 
												</tr>
												</c:if>
												
												<c:if test="${uLicense.professionalLicense!=null && uLicense.professionalLicense!=''}">
												<tr>
													<td id='license-professionalLicense-${uLicense.licenseId}'><c:out value="${uLicense.professionalLicense}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uLicense.dateIssued!=null && uLicense.dateIssued!=''}">
												<tr>
													<td id='license-dateIssued-${uLicense.licenseId}'><c:out value="${uLicense.dateIssued}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uLicense.licenseNumber!=null && uLicense.licenseNumber!=''}">
												<tr>
													<td id='license-licenseNumber-${uLicense.licenseId}'><c:out value="${uLicense.licenseNumber}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uLicense.description!=null && uLicense.description!=''}">
												<tr>
													<td id='license-description-${uLicense.licenseId}'>;<c:out value="${uLicense.description}"/></td>
												</tr>
												</c:if>
											</c:forEach>
											</table>
										</c:otherwise>
									</c:choose>
                                </div>
                                
                                <div class='modal hide fade' id='add-license-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>License</h3>
					                    Highlight your qualifications by listing relevant licenses you have acquired.
					                </div>
					                
									<form:form accept-charset="UTF-8" action="${contextPath}/u/dashboard/createULicense.jv" method="post" commandName = "uLicenseForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' type='text' placeholder='Conferring Organization' path='conferringOrganization'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional License or Membership</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' placeholder='Professional License or Membership' type='text' path='professionalLicense'/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Date Issued</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='dateIssued'/>
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
					                                <form:input class='span12' placeholder='License Number' type='text' path='licenseNumber'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea class='span12' placeholder='Description' path='description'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
										</div>
										<div class='modal-footer'>
											<button class='btn' data-dismiss='modal'>Close</button>
											<button class='btn btn-primary'>Save changes</button>
										</div>
									</form:form>
					            </div>
					            
					            <div class='modal hide fade' id='update-license-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Update License</h3>
					                    Highlight your qualifications by listing relevant licenses you have acquired.
					                </div>
					                
									<form:form id="frm-UpdateULicense" accept-charset="UTF-8" action="${contextPath}/u/dashboard/createULicense.jv" method="post" commandName = "uLicenseForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <form:input id='license-conferringOrganization' class='span12' type='text' placeholder='Conferring Organization' path='conferringOrganization'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional License or Membership</strong></label>
					                            <div class='controls'>
					                                <form:input id='license-professionalLicense' class='span12' placeholder='Professional License or Membership' type='text' path='professionalLicense'/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Date Issued</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input id='license-dateIssued' type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='dateIssued'/>
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
					                                <form:input id='license-licenseNumber' class='span12' placeholder='License Number' type='text' path='licenseNumber'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea id='license-description' class='span12' placeholder='Description' path='description'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
										</div>
										<div class='modal-footer'>
											<button class='btn' data-dismiss='modal'>Close</button>
											<button class='btn btn-primary' type="button" onclick='updateULicense();return false;'>Save changes</button>
											<button class='btn btn-danger' type="button" onclick='deleteULicense();return false;'>Delete</button>
										</div>
									</form:form>
					            </div>
                            </li>
                            <li class="deco">
                                <div class='icon sea-blue-background'>
                                    <i class='icon-book'></i>
                                </div>
                                <div class='title'>
                                    Education
                                    <a data-toggle='modal' href='#add-education-dialog' role='button'  class="pull-right">
			                            <i class="icon-plus"></i>
			                            [Add Education]
			                        </a>
                                </div>
                                <div class='content editable editable-empty'>
                                    <c:choose>
										<c:when test="${(empty uEducations) && (fn:length(uEducations) == 0)}">
 											Empty
 										</c:when>
 										<c:otherwise>
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<c:forEach items="#{uEducations}" var="uEducation" varStatus="count">
												<c:if test="${uEducation.institutionName!=null && uCertification.institutionName!=''}">
												<tr>
													<td id='education-institutionName-${uEducation.educationId}'>
														<a href='#update-education-dialog' data-toggle='modal' role='button' onclick="bindCurrentEducation(${uEducation.educationId});return false;">
															<h5><c:out value="${uEducation.institutionName}"/></h5>
														</a>
													</td>
												</tr>
												</c:if>
												
												<c:if test="${uEducation.degreeType!=null && uEducation.degreeType!=''}">
												<tr id='education-degreeType-${uEducation.educationId}'>
													<td><c:out value="${uEducation.degreeType}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uEducation.graduationStartDate!=null && uEducation.graduationStartDate!=''}">
												<tr>
													<td id='education-graduationStartDate-${uEducation.educationId}'><c:out value="${uEducation.graduationStartDate}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uEducation.graduationEndDate!=null && uEducation.graduationEndDate!=''}">
												<tr>
													<td id='education-graduationEndDate-${uEducation.educationId}'><c:out value="${uEducation.graduationEndDate}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uEducation.description!=null && uEducation.description!=''}">
												<tr>
													<td id='education-description-${uEducation.educationId}'><c:out value="${uEducation.description}"/></td>
												</tr>
												</c:if>
											</c:forEach>
											</table>
										</c:otherwise>
									</c:choose>
                                </div>

                                <div class='modal hide fade' id='add-education-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Education</h3>
					                    Specify your educational background to prospective clients.
					                </div>
									<form:form accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUEducation.jv" method="post" commandName = "uEducationForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Institution Name</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' type='text' placeholder='Institution Name' path='institutionName'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Name and Type of Degree</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' placeholder='Name and Type of Degree' type='text' path='degreeType'/>
					                            </div>
					                        </div>
					                        <!-- try later --------------- 
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
											-->
											<div class='control-group'>
					                            <label class='control-label'><strong>Graduation Start Date</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='graduationStartDate'/>
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Graduation End Date</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='graduationEndDate'/>
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
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
										</div>
										<div class='modal-footer'>
											<button class='btn' data-dismiss='modal'>Close</button>
											<button class='btn btn-primary'>Save changes</button>
										</div>
									</form:form>
								</div>
								
								<div class='modal hide fade' id='update-education-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Update Education</h3>
					                    Specify your educational background to prospective clients.
					                </div>
									<form:form id='frm-UpdateUEducation' accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUEducation.jv" method="post" commandName = "uEducationForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Institution Name</strong></label>
					                            <div class='controls'>
					                                <form:input id='education-institutionName' class='span12' type='text' placeholder='Institution Name' path='institutionName'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Name and Type of Degree</strong></label>
					                            <div class='controls'>
					                                <form:input id='education-degreeType' class='span12' placeholder='Name and Type of Degree' type='text' path='degreeType'/>
					                            </div>
					                        </div>
											<div class='control-group'>
					                            <label class='control-label'><strong>Graduation Start Date</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input id='education-graduationStartDate' type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='graduationStartDate'/>
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Graduation End Date</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input id='education-graduationEndDate' type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='graduationEndDate'/>
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <textarea id='education-description' class='span12' placeholder='Description'></textarea>
					                                <p class='help-block' />
					                            </div>
					                        </div>
										</div>
										<div class='modal-footer'>
											<button class='btn' data-dismiss='modal'>Close</button>
											<button class='btn btn-primary' type="button" onclick='updateUEducation();return false;'>Save changes</button>
											<button class='btn btn-danger' type="button" onclick='deleteUEducation();return false;'>Delete</button>
										</div>
									</form:form>
								</div>
                            </li>

                            <li class="deco">
                                <div class='icon sea-blue-background'>
                                    <i class='icon-star-empty'></i>
                                </div>
                                <div class='title'>
                                    Employment
                                    <a id="add-certifications" data-toggle='modal' href='#add-employment-dialog' role='button' class="pull-right">
			                            <i class="icon-plus"></i>
			                            [Add Employment]
			                        </a>
                                </div>
                                <div class='content editable editable-empty'>
                                     <c:choose>
										<c:when test="${(empty uEmployments) && (fn:length(uEmployments) == 0)}">
 											Empty
 										</c:when>
 										<c:otherwise>
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<c:forEach items="#{uEmployments}" var="uEmployment" varStatus="count">
												<c:if test="${uEmployment.clientName!=null && uEmployment.clientName!=''}">
												<tr>
													<td  id='employment-clientName-${uEmployment.employmentId}'>
														<a href='#update-employment-dialog' data-toggle='modal' role='button' onclick="bindCurrentEmployment(${uEmployment.employmentId});return false;">
															<h5><c:out value="${uEmployment.clientName}"/></h5>
														</a>
													</td>
												</tr>
												</c:if>
												
												<c:if test="${uEmployment.positionHeld!=null && uEmployment.positionHeld!=''}">
												<tr>
													<td id='employment-positionHeld-${uEmployment.employmentId}'><c:out value="${uEmployment.positionHeld}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uEmployment.startDate!=null && uEmployment.startDate!=''}">
												<tr>
													<td id='employment-startDate-${uEmployment.employmentId}'><c:out value="${uEmployment.startDate}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uEmployment.endDate!=null && uEmployment.endDate!=''}">
												<tr>
													<td id='employment-endDate-${uEmployment.employmentId}'><c:out value="${uEmployment.endDate}"/></td>
												</tr>
												</c:if>
												
												<c:if test="${uEmployment.description!=null && uEmployment.description!=''}">
												<tr>
													<td id='employment-description-${uEmployment.employmentId}'><c:out value="${uEmployment.description}"/></td>
												</tr>
												</c:if>
											</c:forEach>
											</table>
										</c:otherwise>
									</c:choose>
                                </div>
                                <div class='modal hide fade' id='add-employment-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Employment</h3>
					                    Showcase your work experience by listing prior relevant clients.
					                </div>
					                
					                <form:form accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUEmployment.jv" method="post" commandName = "uEmploymentForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					                	<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Client name</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' type='text' placeholder='Client name' path='clientName'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Position held</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' placeholder='Position held' type='text' path='positionHeld'/>
					                            </div>
					                        </div>
					                        <!-- Try later
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
											-->
											<div class='control-group'>
					                            <label class='control-label'><strong>Start Date</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='startDate'/>
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>End Date</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='endDate'/>
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea class='span12' placeholder='Description' path='description'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                	</div>
										<div class='modal-footer'>
											<button class='btn' data-dismiss='modal'>Close</button>
											<button class='btn btn-primary'>Save changes</button>
										</div>
									</form:form>
									
					            </div>
					            
					            <div class='modal hide fade' id='update-employment-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Update Employment</h3>
					                    Showcase your work experience by listing prior relevant clients.
					                </div>
					                
					                <form:form id='frm-UpdateUEmployment' accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUEmployment.jv" method="post" commandName = "uEmploymentForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					                	<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Client name</strong></label>
					                            <div class='controls'>
					                                <form:input id='employment-clientName' class='span12' type='text' placeholder='Client name' path='clientName'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Position held</strong></label>
					                            <div class='controls'>
					                                <form:input id='employment-positionHeld' class='span12' placeholder='Position held' type='text' path='positionHeld'/>
					                            </div>
					                        </div>
											<div class='control-group'>
					                            <label class='control-label'><strong>Start Date</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input id='employment-startDate' type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='startDate'/>
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>End Date</strong></label>
					                            <div class='controls'>
					                                <div id="datepicker" class="datepicker input-append">
								                        <form:input id='employment-endDate' type="text" placeholder="Select datepicker" data-format="MM/dd/yyyy" class="input-medium" path='endDate'/>
											            <span class="add-on">
											              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="icon-calendar"></i>
											            </span>
								                    </div>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea id='employment-description' class='span12' placeholder='Description' path='description'/>
					                                <p class='help-block' />
					                            </div>
					                        </div>
					                	</div>
										<div class='modal-footer'>
											<button class='btn' data-dismiss='modal'>Close</button>
											<button class='btn btn-primary' type="button" onclick='updateUEmployment();return false;'>Save changes</button>
											<button class='btn btn-danger' type="button" onclick='deleteUEmployment();return false;'>Delete</button>
										</div>
									</form:form>
									
					            </div>
                            </li>
                        </ol>
                    </div>
                </div>
            </div>
</body>
</html>
