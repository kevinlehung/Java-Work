

$(function() {
	$("#practice_question .choice").click(
		function onChoiceSelected(event) {
			clearSelect();
			var curClass = $(this).attr("class");
			curClass = curClass.replace("choice", "green-background");
			$(this).attr("class", curClass);
			$(this).find(".muted").attr("class", "title");
			$("#choice").val($(this).attr("id"));
			//window.location = contextPath + "/u/skill/1/test/practice/complete.jv";
		}
	);
	
	$("#question .choice").click(
		function onChoiceSelected(event) {
			//window.location = contextPath + "/u/skill/1/test/question/complete.jv";
		}
	);
	
	$("#btn_finish").click(function() {
		if (confirm("Are you sure to finish this test")) {
			$('#questionForm').submit();
		}
		return false;
	});
}
);

function clearSelect() {
	if ($("#practice_question .green-background").length) {
		$("#practice_question .green-background .title").attr("class","muted");
		var curClass = $("#practice_question .green-background").attr("class");
		curClass = curClass.replace("green-background", "choice");
		$("#practice_question .green-background").attr("class", curClass);
	}
}

var mins;
var secs;
var currentSeconds = 0;
var currentMinutes = 0;

window.onload=function(){
	mins = document.getElementById("timeout").value;
	secs = mins * 60;
	setTimeout("Decrement()",1000);
};

function Decrement() {
	currentMinutes = Math.floor(secs / 60);
	if(currentMinutes <= 9) currentMinutes = "0" + currentMinutes;
	currentSeconds = secs-Math.round(currentMinutes *60);;
	if(currentSeconds <= 9) currentSeconds = "0" + currentSeconds;
	secs--;
	document.getElementById("timeRemain").innerHTML = currentMinutes + ":" + currentSeconds;
	if(secs !== -1) {
		setTimeout("Decrement()",1000);
	} else {
		alert('Timeout! Your test will be submitted.');
		$('#questionForm').submit();
	}
}