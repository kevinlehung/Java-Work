$(document).ready(function() {
	$('#workCategory li').click(function() {
		var workCategoryId = $(this).attr('id');
		loadSkills(workCategoryId, populateSkillsIntoBox);
	});
});
function populateSkillsIntoBox(skills) {
	var html = "";
	var $_skills = $("#lA .box");
	var $_skillsHtml = "";
	for (var i = 0; i < skills.length; i++) {
		html = '<div class="text-contrast box-content"><i class="icon-exclamation-sign"></i>skillName<a class="btn btn-primary pull-right clearfix" href="contextPath/u/skill/skillId/test.jv"><i class="icon-check"></i>Take this test</a><div class="clearfix"></div></div>';
		html = html.replace("skillName", skills[i].skillName);
		html = html.replace("contextPath", contextPath);
		html = html.replace("skillId", skills[i].skillId);
		$_skillsHtml += html;
		
	}
	$_skills.html($_skillsHtml);
}
