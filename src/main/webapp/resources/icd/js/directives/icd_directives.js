angular.module('icd').directive('searchPage', function () {
    return {
        templateUrl: 'search',
		restrict: 'AE',
		link: function($scope, $element, $attrs, ctrl){
			$scope.search = function() {
				$scope.makeSearch($scope.icdSearch, $scope.descSearch);
			};
		}	
    };
});

angular.module('icd').directive('classificationPage', function () {
	return {
        templateUrl: 'classification',
		restrict: 'AE',
		controller: 'IcdController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.chapterGo = function() {
				$scope.cleanBread();
				$scope.steps = 'chapter';
				$scope.fetchAllChapters();
			};

			$scope.categoryGo = function(chapter) {
				$scope.cleanBread();
				$scope.chapterBread = chapter.id;
				$scope.steps = 'category';
				$scope.chapterObj = chapter;
				$scope.fetchCategorys(chapter.id);
			};

			$scope.groupGo = function(category) {
				$scope.groupBread = category.first + " - " + category.last;
				$scope.steps = 'group';
				$scope.fetchGroups(category.id);
		    };
		    
		}
    };
});

angular.module('icd').directive('donationPage', function () {
    return {
        templateUrl: 'donation'
    };
});

angular.module('icd').directive('chapterPage', function () {
	return {
        templateUrl: 'chapter',
		restrict: 'AE',
		controller: 'IcdController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.fetchAllChapters();
		}
    };
});

angular.module('icd').directive('groupPage', function () {
    return {
        templateUrl: 'group'
    };
});

angular.module('icd').directive('categoryPage', function () {
    return {
        templateUrl: 'category'
    };
});
