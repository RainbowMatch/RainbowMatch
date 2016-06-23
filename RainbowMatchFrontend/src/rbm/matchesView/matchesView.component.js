(function() {

    function MatchesViewController (HttpService){
        var vm = this;
        var vm.matches = [];
        var vm.currentMatch = 0;
        
        vm.loadMatches = function() {
            HttpService.get(RainbowMatch.baseUrl + "api/users/users", function(data){
                for(var i in data.data) {
                    var usr = data.data[i]
                    HttpService.get(RainbowMatch.baseUrl + "api/profile/info/" + usr.userId, function(data){
                        usr.profile = data.data;
                        vm.matches.push(usr);
                    });
                }
            });
        };
        
        vm.requestApproval = function() {
        
        }
        
        vm.loadMatches();

            
     
    }


    angular.module("rbm").component("matchesView", {
	   templateUrl : "rbm/matchesView/matchesView.html",
	   controller : MatchesViewController,
	   bindings : {}
    });

})();
