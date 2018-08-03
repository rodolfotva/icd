angular.module('icd').factory('IcdService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_CHAPTER_URI = 'http://localhost:8080/Icd/chapter/';
    var REST_SERVICE_GROUPS_URI = 'http://localhost:8080/Icd/groups/';
    var REST_SERVICE_CATEGORYS_URI = 'http://localhost:8080/Icd/category/';
 
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
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.log('Error while fetching Chapters');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchGroups(chapterId) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_GROUPS_URI+chapterId).then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.log('Error while fetching Groups');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function fetchCategorys(categoryId) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_CATEGORYS_URI+categoryId).then(
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
    
    function makeSearch(key, value) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_CATEGORYS_URI+key+'/'+value).then(
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