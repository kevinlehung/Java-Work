$(document).ready(
	function () {
		$('#countries').change(function(event) {
			$_cities = $("#cities")
			$_cities.find("option").remove();
			
			$_cities.append($('<option></option>').val("-1").html("Loading..."));
			
			var selectedCityId = $(this).val();
			loadCities(selectedCityId, populateCitiesDropdow);
	    });
	}
);

function populateCitiesDropdow(cities) {
	$_cities = $("#cities")
	$_cities.find("option").remove();
	$_cities.append($('<option></option>').val("0").html("Select"));
	
	for (i = 0; i < cities.length; i++) {
		$_cities.append($('<option></option>').val(cities[i].cityId).html(cities[i].cityName));
	}
}
