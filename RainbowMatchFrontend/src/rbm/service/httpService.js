angular.module("rbm").factory("HttpService", function($http){
    function _get(url,callback,fullCallback) {
	$http.get(url).then(function(evt){
	    // '!=' used because should react the same if null
	    if(callback != undefined) {
		callback(evt.data);
	    }

	    if(callback != undefined) {
		fullCallback(evt);
	    }
	});
    }

    function _post(url,data,callback,fullCallback) {
	$http.post(url,data).then(function(evt){
	    // '!=' used because should react the same if null
	    if(callback != undefined) {
		callback(evt.data);
	    }

	    if(callback != undefined) {
		fullCallback(evt);
	    }
	});
    }

    return {
	get:_get,
	post:_post
    };
});
