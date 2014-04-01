$(document).ready(
	function () {
		$('#countries').change(function(event) {
			$_cities = $("#cities");
			$_cities.find("option").remove();
			
			$_cities.append($('<option></option>').val("-1").html("Loading..."));
			
			var selectedCityId = $(this).val();
			loadCities(selectedCityId, populateCitiesDropdow);
		});
		
		$('#inputSelect').change(function(event) {
			$_skills = $("#inputSelectMulti");
			$_skills.find("option").remove();
			
			$_skills.append($('<option></option>').val("-1").html("Loading..."));
			
			var selectedSkillId = $(this).val();
			loadSkills(selectedSkillId, populateSkillsDropdow);
	    });
	}
);

function populateCitiesDropdow(cities) {
	$_cities = $("#cities");
	$_cities.find("option").remove();
	$_cities.append($('<option></option>').val("0").html("Select"));
	
	for (var i = 0; i < cities.length; i++) {
		$_cities.append($('<option></option>').val(cities[i].cityId).html(cities[i].cityName));
	}
}

function populateSkillsDropdow(skills) {
	$_skills = $("#inputSelectMulti");
	$_skills.find("option").remove();
	
	for (var i = 0; i < skills.length; i++) {
		$_skills.append($('<option></option>').val(skills[i].skillId).html(skills[i].skillName));
	}
}
