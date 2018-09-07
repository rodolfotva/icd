angular.module('icd').factory('IcdService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_CHAPTER_URI = '/Icd/chapter/';
    var REST_SERVICE_CATEGORYS_URI = '/Icd/category/';
    var REST_SERVICE_GROUPS_URI = '/Icd/group/';
 
    var factory = {
        fetchAllChapters:fetchAllChapters,
        fetchGroups:fetchGroups,
        fetchCategorys:fetchCategorys,
        makeSearch:makeSearch
    };
 
    return factory;
 
    function fetchAllChapters() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_CHAPTER_URI).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while fetching Chapters');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchCategorys(chapterId) {
    	var deferred = $q.defer();
    	$http.get(REST_SERVICE_CATEGORYS_URI+chapterId).then(
    			function (response) {
    				deferred.resolve(response);
    			},
    			function(errResponse){
    				console.log('Error while fetching Categorys');
    				console.log(errResponse);
    				deferred.reject(errResponse);
    			}
    	);
    	return deferred.promise;
    }

    function fetchGroups(categoryId) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_GROUPS_URI+categoryId).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while fetching Groups');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    
    function makeSearch(key, value) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_GROUPS_URI+"/search/"+key+'/'+value).then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.log('Error while fetching Categorys');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
}]);