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