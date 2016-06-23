angular.module("backendApp").factory("HttpService",function($http){
    function searchAllUsers(callback){
	get("/Backend/api/users/users",function(rtn){
    	    callback(rtn.data);
	})
    }

    function createUser(user, callback) {
	postSecure("/Backend/api/users/user",user, function() {
	    if(callback !== undefined){
		callback(rtn.data);
	    }
	});
    }

    function login(user, callback) {
	post("/Backend/api/users/login", user, function(rtn){
	    callback(rtn.data);
	});
    }

    function post(url, data, callback) {
	$http.post(url, data).then(callback);
    }

    function postSecure(url, data, callback) {
	$http.post(url, data).then(callback);
    }

    function get(url, callback) {
	$http.get(url).then(callback);
    }
    
    return {
	searchAllUsers : searchAllUsers,
	createUser : createUser,
	login : login
    };
});
