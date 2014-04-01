function loadCities(countryId, callback) {
	key = "cities:" + countryId;
	/**
	 * Get value from client cache first
	 */
	cachedCities = $("body").data(key);
	if (cachedCities) {
		callback(cachedCities);
	} else {
		$.getJSON(contextPath + "/loc/country/" + countryId + "/cities.jv", {
		}, function(cities) {
			/**
			 * Put to cache for using later.
			 */
			$("body").data(key, cities);
			callback(cities);
		});
	}
}

function loadSkills(workCategoryId, callback) {
	key = "skills:" + workCategoryId;
	/**
	 * Get value from client cache first
	 */
	cachedSkills = $("body").data(key);
	if (cachedSkills) {
		callback(cachedSkills);
	} else {
		$.getJSON(contextPath + "/skill/workCategory/" + workCategoryId + "/skills.jv", {
		}, function(skills) {
			/**
			 * Put to cache for using later.
			 */
			$("body").data(key, skills);
			callback(skills);
		});
	}
}