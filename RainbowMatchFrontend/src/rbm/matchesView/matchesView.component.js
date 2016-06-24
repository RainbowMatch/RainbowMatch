(function() {

    function MatchesViewController (HttpService){
        var vm = this;
        vm.matches = [];
        vm.currentMatch = 0;

        vm.loadMatches = function() {
            console.log(RainbowMatch.baseUrl + "api/users/users");
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

        vm.nextMatch = function() {
          if(vm.currentMatch < vm.matches -1) {
            vm.currentMatch++;
          } else {
            vm.currentMatch = 0;
          }

        };


        vm.loadMatches();



    }


    angular.module("rbm").component("matchesView", {
	   templateUrl : "rbm/matchesView/matchesView.html",
	   controller : MatchesViewController,
	   bindings : {}
    });

})();
