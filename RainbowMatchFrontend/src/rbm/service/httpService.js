angular.module("rbm").factory("HttpService", function($http){
    function _get(url,fullCallback) {
	$http.get(url).then(function(evt){
	    // '!=' used because should react the same if null
	    if(fullCallback != undefined) {
		fullCallback(evt);
	    }
	});
    }

    function _post(url,data,fullCallback) {
        $http.post(url,data, {
            headers : {
                "Access-Control-Request-Headers" : "X-Custom-Header"
            }
        }).then(function(evt){
            // '!=' used because should react the same if null
            if(fullCallback != undefined) {
            fullCallback(evt);
            }
        });
        
        
    }

    return {
	get:_get,
	post:_post
    };
});
