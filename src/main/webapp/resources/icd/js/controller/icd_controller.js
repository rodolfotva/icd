angular.module('icd').controller('IcdController', ['$scope', 'IcdService', function($scope, IcdService) {
	$scope.chapterBread = '';
	$scope.groupBread = '';
	$scope.menu = 'search';
	$scope.steps = 'chapter';
	$scope.searchResult = {};
	$scope.chapters = {};
	$scope.groups = {};
	$scope.categorys = {};
	

    $scope.fetchAllChapters = function(){
        IcdService.fetchAllChapters().then(
            function(data) {
            	$scope.chapters = data;
            },
            function(errResponse){
                console.log('Error while fetching Chapters');
            }
        );
    }
    
    $scope.fetchGroups = function(chapterId){
    	IcdService.fetchGroups(chapterId).then(
            function(data) {
            	$scope.groups = data;
            },
            function(errResponse){
                console.log('Error while fetching Groups');
            }
        );
    }
    
    $scope.fetchCategorys = function(categoryId){
    	IcdService.fetchCategorys(categoryId).then(
            function(data) {
            	$scope.categorys = data;
            },
            function(errResponse){
                console.log('Error while fetching Categorys');
            }
        );
    }

    $scope.makeSearch = function(icd, desc){
    	var key = null;
    	var value = null;
    	
    	if(icd == null) {
    		key = 'description';
        	value = desc;
    	} else {
    		key = 'icd';
        	value = icd;
    	}

    	IcdService.makeSearch(key, value).then(
            function(data) {
            	$scope.categorysSearch = data;
            },
            function(errResponse){
                console.log('Error while fetching Categorys');
            }
        );
    }

	
	$scope.menuChange = function(value) {
		$scope.cleanBread();
		$scope.steps = 'chapter';
		$scope.menu = value;
    };
	
	$scope.cleanBread = function() {
		$scope.chapterBread = '';
		$scope.groupBread = '';
	};
 
}]);