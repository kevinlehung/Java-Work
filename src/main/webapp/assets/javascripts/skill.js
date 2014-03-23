$(function() {
	$("#practice_question .choice").click(
		function onChoiceSelected(event) {
			window.location = contextPath + "/u/skill/1/test/practice/complete.jv";
		}
	);
	
	$("#question .choice").click(
		function onChoiceSelected(event) {
			window.location = contextPath + "/u/skill/1/test/question/complete.jv";
		}
	);
}
);