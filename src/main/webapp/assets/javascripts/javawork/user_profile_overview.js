var currentItem;

$(document).ready(function(){
	if ($("#invalidCreatedCertification").val()=="true") {
		$("#add-certification-dialog").modal("show");
	} else if ($("#invalidUpdatedCertification").val()=="true") {
		$("#update-certification-dialog").modal("show");
	} else if ($("#invalidCreatedEducation").val()=="true") {
		$("#add-education-dialog").modal("show");
	} else if ($("#invalidUpdatedEducation").val()=="true") {
		$("#update-education-dialog").modal("show");
	} else if ($("#invalidCreatedEmployment").val()=="true") {
		$("#add-employment-dialog").modal("show");
	} else if ($("#invalidUpdatedEmployment").val()=="true") {
		$("#update-employment-dialog").modal("show");
	} else if ($("#invalidCreatedLicense").val()=="true") {
		$("#add-license-dialog").modal("show");
	} else if ($("#invalidUpdatedLicense").val()=="true") {
		$("#update-license-dialog").modal("show");
	} else if ($("#invalidUpdatedOverview").val()=="true") {
		$("#update-profileOverview-dialog").modal("show");
	} else if ($("#invalidUpdatedServiceDescription").val()=="true") {
		$("#update-profileServiceDescription-dialog").modal("show");
	}
	
});

/** bind profile overview */
function bindProfileOverview() {
	$("#wysihtml5-textarea-overview").val($("#inplaceediting-about-me-content").text());

}

/** bind profile service description */
function bindProfileServiceDescription() {
	$("#wysihtml5-textarea-serviceDescription").val($("#inplaceediting-service-content").text());
}

/**bind current Certification item to edit form*/
function bindCurrentCertification(certificationId){
	currentItem = certificationId;
	var dateTemp;
	$("#certification-conferringOrganization").val($("#certification-conferringOrganization-" + currentItem + " a h5").text());
	
	$("#certification-professionalOrganization").val($("#certification-professionalCertificate-"+ currentItem).text());
	
	dateTemp = $("#certification-dateAwarded-"+ currentItem).text();
	if(dateTemp){
		$("#certification-dateAwarded").val(dateTemp.trim());
	}
	
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
	var dateTemp;
	
	$("#license-conferringOrganization").val($("#license-conferringOrganization-"+ currentItem+" a h5").text());
	
	$("#license-professionalLicense").val($("#license-professionalLicense-"+ currentItem).text());
	
	dateTemp = $("#license-dateIssued-"+ currentItem).text();
	if(dateTemp) {
		$("#license-dateIssued").val(dateTemp.trim());
	}
	
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
	var dateTemp;
	
	$("#education-institutionName").val($("#education-institutionName-"+ currentItem+ " a h5").text());
	
	$("#education-degreeType").val($("#education-degreeType-"+ currentItem).text());
	
	dateTemp = $("#education-graduationStartDate-"+ currentItem).text();
	if(dateTemp) {
		$("#education-graduationStartDate").val(dateTemp.trim());
	}
	
	dateTemp = $("#education-graduationEndDate-"+ currentItem).text();
	if(dateTemp) {
		$("#education-graduationEndDate").val(dateTemp.trim());
	}
	
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
	var dateTemp;
	
	$("#employment-clientName").val($("#employment-clientName-"+ currentItem+ " a h5").text());
	
	$("#employment-positionHeld").val($("#employment-positionHeld-"+ currentItem).text());
	
	dateTemp = $("#employment-startDate-"+ currentItem).text();
	if(dateTemp) {
		$("#employment-startDate").val(dateTemp.trim());
	}
	
	dateTemp = $("#employment-endDate-"+ currentItem).text();
	if(dateTemp) {
		$("#employment-endDate").val(dateTemp.trim());
	}
	
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