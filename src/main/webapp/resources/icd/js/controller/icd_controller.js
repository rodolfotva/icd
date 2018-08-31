angular.module('icd').controller('IcdController', ['$scope', 'IcdService', function($scope, IcdService) {
	$scope.chapterBread = '';
	$scope.groupBread = '';
	$scope.menu = 'search';
	$scope.steps = 'chapter';
	$scope.searchResult = {};
	$scope.chapters = {};
	$scope.groups = {};
	$scope.categorys = {};
	$scope.chapterId = '';
	$scope.categoryId = '';
	$scope.chapterObj;

    $scope.fetchAllChapters = function(){
        IcdService.fetchAllChapters().then(
            function(response) {
            	$scope.chapters = response.data;
            },
            function(errResponse){
                console.log('Error while fetching Chapters');
            }
        );
    }
    
    $scope.fetchCategorys = function(chapterObjId){
    	IcdService.fetchCategorys(chapterObjId).then(
    			function(response) {
    				$scope.categorys = response.data['categoryLst'];
    				$scope.chapterId = response.data['chapterObjId'];
    			},
    			function(errResponse){
    				console.log('Error while fetching Categorys');
    			}
    	);
    }

    $scope.fetchGroups = function(categoryId){
    	IcdService.fetchGroups(categoryId).then(
            function(response) {
            	$scope.groups = response.data['groupLst'];
				$scope.chapterId = response.data['chapterObjId'];
				$scope.categoryId = response.data['categoryId'];
            },
            function(errResponse){
                console.log('Error while fetching Groups');
            }
        );
    }
    

    $scope.makeSearch = function(icd, desc){
    	var key = null;
    	var value = null;
    	if(icd == null || icd == '') {
    		key = 'description';
        	value = desc;
    	} else {
    		key = 'icd';
        	value = icd;
    	}

    	IcdService.makeSearch(key, value).then(
            function(data) {
            	$scope.searchResult = {};
            	$scope.searchResult = data;
            	$scope.$apply();
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