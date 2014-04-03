var currentItem;

/**bind current Certification item to edit form*/
function bindCurrentCertification(certificationId){
	currentItem = certificationId;
	
	$("#certification-conferringOrganization").val($("#certification-conferringOrganization-"+ currentItem+" h5").text());
	
	$("#certification-professionalOrganization").val($("#certification-professionalCertificate-"+ currentItem).text());
	
	$("#certification-dateAwarded").val($("#certification-dateAwarded-"+ currentItem).text());
	
	$("#certification-certificateNumber").val($("#certification-certificateNumber-"+ currentItem).text());
	
	$("#certification-description").val($("#certification-description-"+ currentItem).text());
}

function updateUCertification() {
	$("#frm-UpdateUCertification").attr("action", "dashboard/" + currentItem + "/updateUCertification.jv");
	$("#frm-UpdateUCertification").submit();
}

function deleteUCertification() {
	var isDelete = confirm("Do you want to delete this Certification?");
	if(isDelete) {
		window.location.href="dashboard/" + currentItem + "/deleteUCertification.jv";
	}
}

/**bind current License item to edit form*/
function bindCurrentLicense(licenseId){
	currentItem = licenseId;
	
	$("#license-conferringOrganization").val($("#license-conferringOrganization-"+ currentItem+" h5").text());
	
	$("#license-professionalLicense").val($("#license-professionalLicense-"+ currentItem).text());
	
	$("#license-dateIssued").val($("#license-dateIssued-"+ currentItem).text());
	
	$("#license-licenseNumber").val($("#license-licenseNumber-"+ currentItem).text());
	
	$("#license-description").val($("#license-description-"+ currentItem).text());
}

function updateULicense() {
	$("#frm-UpdateULicense").attr("action", "dashboard/" + currentItem + "/updateULicense.jv");
	$("#frm-UpdateULicense").submit();
}

function deleteULicense() {
	var isDelete = confirm("Do you want to delete this License?");
	if(isDelete) {
		window.location.href="dashboard/" + currentItem + "/deleteULicense.jv";
	}
}

/**bind current Education item to edit form*/
function bindCurrentEducation(educationId){
	currentItem = educationId;
	
	$("#education-institutionName").val($("#education-institutionName-"+ currentItem+ " a h5").text());
	
	$("#education-degreeType").val($("#education-degreeType-"+ currentItem).text());
	
	$("#education-graduationStartDate").val($("#education-graduationStartDate-"+ currentItem).text());
	
	$("#education-graduationEndDate").val($("#education-graduationEndDate-"+ currentItem).text());
	
	$("#education-description").val($("#education-description-"+ currentItem).text());
}

function updateUEducation() {
	$("#frm-UpdateUEducation").attr("action", "dashboard/" + currentItem + "/updateUEducation.jv");
	$("#frm-UpdateUEducation").submit();
}

function deleteUEducation() {
	var isDelete = confirm("Do you want to delete this Education?");
	if(isDelete) {
		window.location.href="dashboard/" + currentItem + "/deleteUEducation.jv";
	}
}

/**bind current Employment item to edit form*/
function bindCurrentEmployment(employmentId){
	currentItem = employmentId;
	
	$("#employment-clientName").val($("#employment-clientName-"+ currentItem+ " a h5").text());
	
	$("#employment-positionHeld").val($("#employment-positionHeld-"+ currentItem).text());
	
	$("#employment-startDate").val($("#employment-startDate-"+ currentItem).text());
	
	$("#employment-endDate").val($("#employment-endDate-"+ currentItem).text());
	
	$("#employment-description").val($("#employment-description-"+ currentItem).text());
}

function updateUEmployment() {
	$("#frm-UpdateUEmployment").attr("action", "dashboard/" + currentItem + "/updateUEmployment.jv");
	$("#frm-UpdateUEmployment").submit();
}

function deleteUEmployment() {
	var isDelete = confirm("Do you want to delete this Employment?");
	if(isDelete) {
		window.location.href="dashboard/" + currentItem + "/deleteUEmployment.jv";
	}
}