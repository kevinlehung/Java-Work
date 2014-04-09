$(document).ready(function() {
	var isMultipleChoice = $("#isMultipleChoice").val() == 'true';
	var choices = new Array();
	$("#practice_question .choice").click(
		function onChoiceSelected(event) {
			if (!isMultipleChoice) {
				clearSelect();
				choices.length = 0;
			}
			var curClass = $(this).attr("class");
			curClass = curClass.replace("choice", "green-background");
			$(this).attr("class", curClass);
			$(this).find(".muted").attr("class", "title");
			if (jQuery.inArray($(this).attr("id"), choices) == -1) {
				choices.push($(this).attr("id"));
			}
		}
	);
	
	$("#question .choice").click(
		function onChoiceSelected(event) {
			//window.location = contextPath + "/u/skill/1/test/question/complete.jv";
		}
	);
	
	$("#questionForm").submit(function () {
		choices.forEach(appendChoices);
	});
	
	secs = document.getElementById("timeout").value;
	setTimeout("Decrement()", 1000);
}
);

var currentSeconds = 0;
var currentMinutes = 0;
var secs;

function clearSelect() {
	if ($("#practice_question .green-background").length) {
		$("#practice_question .green-background .title").attr("class","muted");
		var curClass = $("#practice_question .green-background").attr("class");
		curClass = curClass.replace("green-background", "choice");
		$("#practice_question .green-background").attr("class", curClass);
	}
}

function appendChoices(elem) {
	$("#questionForm").append($("<input>", {type: "hidden", name: "choices", value: elem}));
}

function Decrement() {
	currentMinutes = Math.floor(secs / 60);
	if(currentMinutes <= 9) currentMinutes = "0" + currentMinutes;
	currentSeconds = secs-Math.round(currentMinutes * 60);;
	if(currentSeconds <= 9) currentSeconds = "0" + currentSeconds;
	secs--;
	$("#timeRemain").text(currentMinutes + ":" + currentSeconds);
	if(secs !== -1) {
		setTimeout("Decrement()", 1000);
	} else {
		$('#questionForm').submit();
	}
}

function submitTestQuestion() {
	$("#questionForm").submit();
}
