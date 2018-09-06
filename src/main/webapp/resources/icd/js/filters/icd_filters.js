angular.module('icd').filter('searchDescFilter', function () {
	return function (input, query) {
		return input.replace(RegExp('('+ query + ')', 'gi'), '<span class="search-filter">$1</span>');
    }
});

angular.module('icd').filter('searchIcdFilter', function () {
	return function (input, query) {
		return input.replace(RegExp('('+ query + ')', 'gi'), '<span class="search-filter">$1</span>');
    }
});
