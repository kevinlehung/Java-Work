var currentItem;

/**bind current Certification item to edit form*/
function bindCurrentCertification(certificationId){
	currentItem = certificationId;
	
	$("#uConferringOrganization").val($("#item-conferringOrganization-"+ certificationId+" h5").text());
	
	$("#uProfessionalOrganization").val($("#item-professionalCertificate-"+ certificationId).text());
	
	$("#uDateAwarded").val($("#item-dateAwarded-"+ certificationId).text());
	
	$("#uCertificateNumber").val($("#item-certificateNumber-"+ certificationId).text());
	
	$("#uDescription").val($("#item-description-"+ certificationId).text());
}

function updateUCertification() {
	alert("123");
	$("#UpdateUCertification").attr("action", "dashboard/" + currentItem + "/updateUCertification.jv");
	$("#UpdateUCertification").submit();
}

function deleteUCertification() {
	window.location.href="dashboard/" + currentItem + "/deleteUCertification.jv";
}