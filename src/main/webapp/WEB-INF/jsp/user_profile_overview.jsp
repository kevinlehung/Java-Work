<%@ include file="/WEB-INF/jsp/include/taglibs_include.jsp" %>
<%@ include file="/WEB-INF/jsp/include/server_variables.jsp" %>
<%@ include file="/WEB-INF/jsp/include/js_variables.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post Java Job - Preview</title>
    <link href='${contextPath}/assets/stylesheets/account.css' media='all' rel='stylesheet' type='text/css' />
	<link href='${contextPath}/assets/stylesheets/javawork.css' rel='stylesheet' type='text/css' />
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
                                    <a id="inplaceediting123" data-toggle='modal' href='#update-profileOverview-dialog' role='button' onclick="bindProfileOverview();return false;" class="pull-right">
			                            <i class="icon-pencil"></i>
			                            [Edit]
			                        </a>
                                </div>
                                <c:choose>
                                	<c:when test="${(empty profile) || (empty profile.overview)}">
 										<div class='content' id='inplaceediting-about-me-content'>Empty</div>
 									</c:when>
 									<c:otherwise>
 										<div class='content' id='inplaceediting-about-me-content'><c:out value="${profile.overview}"/></div>
 									</c:otherwise>
                                </c:choose>
								<div class='modal hide fade' id='update-profileOverview-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>About Me</h3>
					                    Introduce yourself.
					                </div>
					                <input type="hidden" id="invalidUpdatedOverview" value="${invalidUpdatedOverview}" />
					                <form:form accept-charset="UTF-8" action="${contextPath}/u/dashboard/updateOverviewProfile.jv" method="post" commandName = "profileForm">
					                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<c:choose>
											<c:when test="${(not empty profile)}">
												<input type="hidden" id="profile-overview" path="overview" value="${profileForm.overview}"/>
											</c:when>
											<c:otherwise>
												<input type="hidden" id="profile-overview" path="overview" value="Empty"/>
											</c:otherwise>
										</c:choose>
					                	<div class='modal-body'> 
					                         <div class='control-group'>
					                            <div class='controls'>
					                             <form:hidden id="tempValidValue" path="serviceDescription" value="ValidValue"/>
					                             <form:textarea class="span14heightspan5" id="wysihtml5-textarea-overview" name="wysihtml5-textarea" path="overview"/>
					                            </div>
												<form:errors path="overview" cssClass="help-block error"/>
					                        </div>
					                    </div>
					                	<div class='modal-footer'>
					                    	<button class='btn' data-dismiss='modal'>Close</button>
					                    	<button class='btn btn-primary' type="submit">Save changes</button>
					                	</div>
					            	</form:form>
					            </div>
                            </li>
                            <li class="deco">
                                <div class='icon  sea-blue-background'>
                                    <i class='icon-globe'></i>
                                </div>
                                <div class='title'>
                                    Service Description
                                    <a id="inplaceediting123-service" data-toggle='modal' href='#update-profileServiceDescription-dialog' role='button' onclick="bindProfileServiceDescription();return false;" class="pull-right">
			                            <i class="icon-pencil"></i>
			                            [Edit]
			                        </a>

                                </div>
								<c:choose>
									<c:when test="${(empty profile) || (empty profile.serviceDescription)}">
 										<div class='content' id="inplaceediting-service-content">Empty</div>
 									</c:when>
 									<c:otherwise>
 										<div class='content' id="inplaceediting-service-content"><c:out value="${profile.serviceDescription}"/></div>
 									</c:otherwise>
                                </c:choose>
                                <div class='modal hide fade' id='update-profileServiceDescription-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Service Description</h3>
					                </div>
									<input type="hidden" id="invalidUpdatedServiceDescription" value="${invalidUpdatedServiceDescription}" />
					                <form:form accept-charset="UTF-8" action="${contextPath}/u/dashboard/updateServiceDescriptionProfile.jv" method="post" commandName = "profileForm">
					                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<c:choose>
											<c:when test="${(not empty profile)}">
												<input type="hidden" id="profile-serviceDescription" path="serviceDescription" value="${profileForm.serviceDescription}"/>
											</c:when>
											<c:otherwise>
												<input type="hidden" id="profile-serviceDescription" path="serviceDescription" value="Empty"/>
											</c:otherwise>
										</c:choose>
					                	<div class='modal-body'> 
					                         <div class='control-group'>
					                            <div class='controls'>
					                             <form:hidden id="tempValidValue" path="overview" value="ValidValue"/>
					                             <form:textarea class="span14heightspan5" id="wysihtml5-textarea-serviceDescription" name="wysihtml5-textarea" path="serviceDescription"/>
					                            </div>
												<form:errors path="serviceDescription" cssClass="help-block error"/>
					                        </div>
					                    </div>
					                	<div class='modal-footer'>
					                    	<button class='btn' data-dismiss='modal'>Close</button>
					                    	<button class='btn btn-primary' type="submit">Save changes</button>
					                	</div>
					            	</form:form>
					            
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
 											<table name='CertificationInfor'>
											<c:forEach items="#{uCertifications}" var="uCertification" varStatus="count">
												<c:if test="${uCertification.conferringOrganization!=null && uCertification.conferringOrganization!=''}">
													<tr>
														<td colspan="2">
														<a href='#update-certification-dialog' data-toggle='modal' role='button' onclick="bindCurrentCertification(${uCertification.certificationId});return false;">
															<div id="certification-conferringOrganization-${uCertification.certificationId}" class='mainitemfont'>${uCertification.conferringOrganization}</div>
														</a>
														</td>
													</tr>  
												</c:if>
												<c:if test="${uCertification.professionalCertificate!=null && uCertification.professionalCertificate!=''}">
													<tr>
														<td class='itemlabelfont'>Professional:</td>
														<td id="certification-professionalCertificate-${uCertification.certificationId}" class='itemvaluefont'>${uCertification.professionalCertificate}</td>
													</tr>
												</c:if>
												
												<c:if test="${uCertification.dateAwarded!=null && uCertification.dateAwarded!=''}">
													<tr>
														<td class='itemlabelfont'>Date Awarded:</td>
														<td id="certification-dateAwarded-${uCertification.certificationId}" class='itemvaluefont'><fmt:formatDate value="${uCertification.dateAwarded}" pattern="MM/dd/yyyy" /></td>
													</tr>
												</c:if>
												
												<c:if test="${uCertification.certificateNumber!=null && uCertification.certificateNumber!=''}">
													<tr>
														<td class='itemlabelfont'>Certificate Number:</td>
														<td id="certification-certificateNumber-${uCertification.certificationId}" class='itemvaluefont'>${uCertification.certificateNumber}</td>
													</tr>
												</c:if>
												
												<c:if test="${uCertification.description!=null && uCertification.description!=''}">
													<tr>
														<td class='itemlabelfont'>Description:</td>
														<td id="certification-description-${uCertification.certificationId}" class='itemvaluefont'>${uCertification.description}</td>
													</tr>
												</c:if>
												<tr><td>&nbsp;</td></tr>
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
					                
									<input type="hidden" id="invalidCreatedCertification" value="${invalidCreatedCertification}" />
					                <form:form id="frm-CreateUCertification" accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUCertification.jv" method="post" commandName = "uCertificationForm">
					                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					                	<div class='modal-body'> 
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <form:input class="span12" id="conferringOrganization" placeholder="Conferring Organization" data-rule-required="true" path="conferringOrganization"/>
					                            </div>
												<form:errors path="conferringOrganization" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional Certificate</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' type='text' placeholder='Professional certificate' value='' path='professionalCertificate'/>
					                            </div>
												<form:errors path="professionalCertificate" cssClass="help-block error"/>
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
													<form:errors path="dateAwarded" cssClass="help-block error"/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Certificate Number</strong> (optional)</label>
					                            <div class='controls'>
					                                <form:input class='span12' placeholder='Certificate Number' type='text' value='' path='certificateNumber'/>
					                            </div>
					                            <form:errors path="certificateNumber" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea class='span12' placeholder='Description' path="description"/>
					                            </div>
												<form:errors path="description" cssClass="help-block error"/>
					                        </div>
					                	</div>
					                	<div class='modal-footer'>
					                    	<button class='btn' data-dismiss='modal'>Close</button>
					                    	<button class='btn btn-primary' type="submit">Save changes</button>
					                	</div>
					            	</form:form>
					
					            </div>
								
								<input type="hidden" id="invalidUpdatedCertification" value="${invalidUpdatedCertification}" />
					            <div class='modal hide fade' id='update-certification-dialog' role='dialog' tabindex='-1'>
					                <div class='modal-header'>
					                    <button class='close' data-dismiss='modal' type='button'>&times;</button>
					                    <h3>Update Certification</h3>
					                    Demonstrate your expertise by listing your certifications.
					                </div>
									<form:form id='frm-UpdateUCertification' accept-charset="UTF-8" action="${contextPath}/u/dashboard/updateUCertification.jv" method="post" commandName = "uCertificationForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<input type="hidden" id="certification-uCertificationId" path="uCertificationId" value="${uCertificationForm.uCertificationId}"/>
					                	<div class='modal-body'> 
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <form:input class="span12" id="certification-conferringOrganization" placeholder="Conferring Organization" path="conferringOrganization"/>
					                            </div>
												<form:errors path="conferringOrganization" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional Certificate</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' id="certification-professionalOrganization" type='text' placeholder='Professional certificate' value='' path='professionalCertificate'/>
					                            </div>
												<form:errors path="professionalCertificate" cssClass="help-block error"/>
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
					                                <form:errors path="dateAwarded" cssClass="help-block error"/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Certificate Number</strong> (optional)</label>
					                            <div class='controls'>
					                                <form:input class='span12' id='certification-certificateNumber' placeholder='Certificate Number' type='text' value='' path='certificateNumber'/>
					                                
					                            </div>
					                            <form:errors path="certificateNumber" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea class='span12' id='certification-description' placeholder='Description' path="description"/>
					                            </div>
					                            <form:errors path="description" cssClass="help-block error"/>
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
											<table name='LicenseInfor'>
											<c:forEach items="#{uLicenses}" var="uLicense" varStatus="count">
												<c:if test="${uLicense.conferringOrganization!=null && uLicense.conferringOrganization!=''}">
												<tr>
													<td colspan="4">
														<a href='#update-license-dialog' data-toggle='modal' role='button' onclick="bindCurrentLicense(${uLicense.licenseId});return false;">
															<div id='license-conferringOrganization-${uLicense.licenseId}' class='mainitemfont'>${uLicense.conferringOrganization}</div>
														</a>
													</td> 
												</tr>
												</c:if>
												
												<c:if test="${uLicense.professionalLicense!=null && uLicense.professionalLicense!=''}">
												<tr>
													<td class='itemlabelfont'>Professional License:</td>
													<td id='license-professionalLicense-${uLicense.licenseId}' class='itemvaluefont'>${uLicense.professionalLicense}</td>
												</tr>
												</c:if>
												
												<c:if test="${uLicense.dateIssued!=null && uLicense.dateIssued!=''}">
												<tr>
													<td class='itemlabelfont'>Date Issued:</td>
													<td id='license-dateIssued-${uLicense.licenseId}' class='itemvaluefont'>
														<fmt:formatDate value="${uLicense.dateIssued}" pattern="MM/dd/yyyy" />
													</td>
												</tr>
												</c:if>
												
												<c:if test="${uLicense.licenseNumber!=null && uLicense.licenseNumber!=''}">
												<tr>
													<td class='itemlabelfont'>License Number:</td>
													<td id='license-licenseNumber-${uLicense.licenseId}' class='itemvaluefont'>${uLicense.licenseNumber}</td>
												</tr>
												</c:if>
												
												<c:if test="${uLicense.description!=null && uLicense.description!=''}">
												<tr>
													<td class='itemlabelfont'>Description:</td>
													<td id='license-description-${uLicense.licenseId}' class='itemvaluefont'>${uLicense.description}</td>
												</tr>
												<tr><td>&nbsp;</td></tr>
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
									<input type="hidden" id="invalidCreatedLicense" value="${invalidCreatedLicense}" />
									<form:form accept-charset="UTF-8" action="${contextPath}/u/dashboard/createULicense.jv" method="post" commandName = "uLicenseForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' type='text' placeholder='Conferring Organization' path='conferringOrganization'/>
					                            </div>
												<form:errors path="conferringOrganization" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional License or Membership</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' placeholder='Professional License or Membership' type='text' path='professionalLicense'/>
					                            </div>
												<form:errors path="professionalLicense" cssClass="help-block error"/>
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
												<form:errors path="dateIssued" cssClass="help-block error"/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>License Number</strong> (optional)</label>
					                            <div class='controls'>
					                                <form:input class='span12' placeholder='License Number' type='text' path='licenseNumber'/>
					                                <p class='help-block' />
					                            </div>
												<form:errors path="licenseNumber" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea class='span12' placeholder='Description' path='description'/>
					                            </div>
												<form:errors path="description" cssClass="help-block error"/>
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
									<input type="hidden" id="invalidUpdatedLicense" value="${invalidUpdatedLicense}" />
									<form:form id="frm-UpdateULicense" accept-charset="UTF-8" action="${contextPath}/u/dashboard/createULicense.jv" method="post" commandName = "uLicenseForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<input type="hidden" id="license-uLicenseId" path="uLicenseId" value="${uLicenseForm.uLicenseId}"/>
										<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Conferring Organization</strong></label>
					                            <div class='controls'>
					                                <form:input id='license-conferringOrganization' class='span12' type='text' placeholder='Conferring Organization' path='conferringOrganization'/>
					                            </div>
												<form:errors path="conferringOrganization" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Professional License or Membership</strong></label>
					                            <div class='controls'>
					                                <form:input id='license-professionalLicense' class='span12' placeholder='Professional License or Membership' type='text' path='professionalLicense'/>
					                            </div>
												<form:errors path="professionalLicense" cssClass="help-block error"/>
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
												<form:errors path="dateIssued" cssClass="help-block error"/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>License Number</strong> (optional)</label>
					                            <div class='controls'>
					                                <form:input id='license-licenseNumber' class='span12' placeholder='License Number' type='text' path='licenseNumber'/>
					                            </div>
												<form:errors path="licenseNumber" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea id='license-description' class='span12' placeholder='Description' path='description'/>
					                            </div>
												<form:errors path="description" cssClass="help-block error"/>
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
											<table name='EducationsInfor' width="100%">
											<c:forEach items="#{uEducations}" var="uEducation" varStatus="count">
												<c:if test="${uEducation.institutionName!=null && uCertification.institutionName!=''}">
												<tr>
													<td colspan="4">
														<a href='#update-education-dialog' data-toggle='modal' role='button' onclick="bindCurrentEducation(${uEducation.educationId});return false;">
															<div id='education-institutionName-${uEducation.educationId}' class='mainitemfont'>${uEducation.institutionName}</div>
														</a>
													</td>
												</tr>
												</c:if>
												
												<c:if test="${uEducation.degreeType!=null && uEducation.degreeType!=''}">
												<tr>
													<td class='itemlabelfont'>Degree Type:</td>
													<td id='education-degreeType-${uEducation.educationId}' class='itemvaluefont'>${uEducation.degreeType}</td>
												</tr>
												</c:if>
												
												<c:if test="${(uEducation.graduationStartDate!=null && uEducation.graduationStartDate!='') || (uEducation.graduationEndDate!=null && uEducation.graduationEndDate!='')}">
												<tr>
													<td class='itemlabelfont'>Graduation Start Date:</td>
													<td id='education-graduationStartDate-${uEducation.educationId}' class='itemvaluefont'>
														<c:if test="${uEducation.graduationStartDate!=null && uEducation.graduationStartDate!=''}">
														<fmt:formatDate value="${uEducation.graduationStartDate}" pattern="MM/dd/yyyy" />
														</c:if>
													</td>
													
													<td class='itemlabelfont'>Graduation End Date:</td>
													<td id='education-graduationEndDate-${uEducation.educationId}' class='itemvaluefont'>
														<c:if test="${uEducation.graduationEndDate!=null && uEducation.graduationEndDate!=''}">
														<fmt:formatDate value="${uEducation.graduationEndDate}" pattern="MM/dd/yyyy" />
														</c:if>
													</td>
												</tr>
												</c:if>
												
												<c:if test="${uEducation.description!=null && uEducation.description!=''}">
												<tr>
													<td class='itemlabelfont'>Description:</td>
													<td id='education-description-${uEducation.educationId}' class='itemvaluefont'>${uEducation.description}</td>
												</tr>
												<tr><td>&nbsp;</td></tr>
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
									<input type="hidden" id="invalidCreatedEducation" value="${invalidCreatedEducation}" />
									<form:form accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUEducation.jv" method="post" commandName = "uEducationForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Institution Name</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' type='text' placeholder='Institution Name' path='institutionName'/>
					                            </div>
												<form:errors path="institutionName" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Name and Type of Degree</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' placeholder='Name and Type of Degree' type='text' path='degreeType'/>
					                            </div>
												<form:errors path="degreeType" cssClass="help-block error"/>
					                            
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
													<form:errors path="graduationStartDate" cssClass="help-block error"/>
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
													<form:errors path="graduationEndDate" cssClass="help-block error"/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <textarea class='span12' placeholder='Description' path='description'></textarea>
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
									<input type="hidden" id="invalidUpdatedEducation" value="${invalidUpdatedEducation}" />
									<form:form id='frm-UpdateUEducation' accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUEducation.jv" method="post" commandName = "uEducationForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<input type="hidden" id="education-uEducationId" path="uEducationId" value="${uEducationForm.uEducationId}"/>
										<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Institution Name</strong></label>
					                            <div class='controls'>
					                                <form:input id='education-institutionName' class='span12' type='text' placeholder='Institution Name' path='institutionName'/>
					                            </div>
												<form:errors path="institutionName" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Name and Type of Degree</strong></label>
					                            <div class='controls'>
					                                <form:input id='education-degreeType' class='span12' placeholder='Name and Type of Degree' type='text' path='degreeType'/>
					                            </div>
												<form:errors path="degreeType" cssClass="help-block error"/>
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
													<form:errors path="graduationStartDate" cssClass="help-block error"/>
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
													<form:errors path="graduationEndDate" cssClass="help-block error"/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <textarea id='education-description' class='span12' placeholder='Description' path='desciption'></textarea>
					                                <p class='help-block' />
					                            </div>
												<form:errors path="description" cssClass="help-block error"/>
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
											<table name='EmploymentsInfor'>
											<c:forEach items="#{uEmployments}" var="uEmployment" varStatus="count">
												<c:if test="${uEmployment.clientName!=null && uEmployment.clientName!=''}">
												<tr>
													<td colspan="4">
														<a href='#update-employment-dialog' data-toggle='modal' role='button' onclick="bindCurrentEmployment(${uEmployment.employmentId});return false;">
															<div id='employment-clientName-${uEmployment.employmentId}' class='mainitemfont'>${uEmployment.clientName}</div>
														</a>
													</td>
												</tr>
												</c:if>
												
												<c:if test="${uEmployment.positionHeld!=null && uEmployment.positionHeld!=''}">
												<tr>
													<td class='itemlabelfont'>Position Held:</td>
													<td id='employment-positionHeld-${uEmployment.employmentId}' class='itemvaluefont'>${uEmployment.positionHeld}</td>
												</tr>
												</c:if>
												
												<c:if test="${(uEmployment.startDate!=null && uEmployment.startDate!='') || (uEmployment.endDate!=null && uEmployment.endDate!='')}">
												<tr>
													<td class='itemlabelfont'>Start Date:</td>
													<td id='employment-startDate-${uEmployment.employmentId}' class='itemvaluefont'>
														<c:if test="${uEmployment.startDate!=null && uEmployment.startDate!=''}">
														<fmt:formatDate value="${uEmployment.startDate}" pattern="MM/dd/yyyy" />
														</c:if>
													</td>
													
													<td class='itemlabelfont'>End Date:</td>
													<td id='employment-endDate-${uEmployment.employmentId}' class='itemvaluefont'>
														<c:if test="${uEmployment.endDate!=null && uEmployment.endDate!=''}">
														<fmt:formatDate value="${uEmployment.endDate}" pattern="MM/dd/yyyy" />
														</c:if>
													</td>
												</tr>
												</c:if>
												
												<c:if test="${uEmployment.description!=null && uEmployment.description!=''}">
												<tr>
													<td class='itemlabelfont'>Description:</td>
													<td id='employment-description-${uEmployment.employmentId}' class='itemvaluefont'>${uEmployment.description}</td>
												</tr>
												</c:if>
												
												<tr><td>&nbsp;</td></tr>
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
									<input type="hidden" id="invalidCreatedEmployment" value="${invalidCreatedEmployment}" />
					                <form:form accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUEmployment.jv" method="post" commandName = "uEmploymentForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					                	<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Client name</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' type='text' placeholder='Client name' path='clientName'/>
					                            </div>
												<form:errors path="clientName" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Position held</strong></label>
					                            <div class='controls'>
					                                <form:input class='span12' placeholder='Position held' type='text' path='positionHeld'/>
					                            </div>
												<form:errors path="positionHeld" cssClass="help-block error"/>
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
												<form:errors path="startDate" cssClass="help-block error"/>
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
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea class='span12' placeholder='Description' path='description'/>
					                            </div>
												<form:errors path="description" cssClass="help-block error"/>
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
									<input type="hidden" id="invalidUpdatedEmployment" value="${invalidUpdatedEmployment}" />
					                <form:form id='frm-UpdateUEmployment' accept-charset="UTF-8" action="${contextPath}/u/dashboard/createUEmployment.jv" method="post" commandName = "uEmploymentForm">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<input type="hidden" id="education-uEmploymentId" path="uEmploymentId" value="${uEmploymentForm.uEmploymentId}"/>
					                	<div class='modal-body'>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Client name</strong></label>
					                            <div class='controls'>
					                                <form:input id='employment-clientName' class='span12' type='text' placeholder='Client name' path='clientName'/>
					                            </div>
												<form:errors path="clientName" cssClass="help-block error"/>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Position held</strong></label>
					                            <div class='controls'>
					                                <form:input id='employment-positionHeld' class='span12' placeholder='Position held' type='text' path='positionHeld'/>
					                            </div>
												<form:errors path="positionHeld" cssClass="help-block error"/>
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
												<form:errors path="startDate" cssClass="help-block error"/>
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
												<form:errors path="endDate" cssClass="help-block error"/>
					                            </div>
					                        </div>
					                        <div class='control-group'>
					                            <label class='control-label'><strong>Description </strong>(optional)</label>
					                            <div class='controls'>
					                                <form:textarea id='employment-description' class='span12' placeholder='Description' path='description'/>
					                            </div>
												<form:errors path="description" cssClass="help-block error"/>
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
