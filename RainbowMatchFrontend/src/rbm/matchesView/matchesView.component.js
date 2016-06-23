(function() {

    function MatchesViewController (HttpService){
        var vm = this;
        vm.users = function(){
            //TODO getusers from backend
            //wenn kei verbindig möglich, denn vom lokalstorage lade
            //DUMMY
            return [{
                userName : "Noah",
                profilePicture : "C:\Users\Noah Siegrist\Documents\GitHub\RainbowMatchFrontend\RainbowMatchFrontend\doc\storyboard.png",
                request : function(){
                    //todo request profile
                    HttpService.get("10.4.57.190:20080/backend/users/user", function(event){
                        return event;
                
                    });
                }
                }];
        };
            
        }
    }


    angular.module("rbm").component("matchesView", {
	   templateUrl : "rbm/matchesView/matchesView.html",
	   controller : MatchesViewController,
	   bindings : {}
    });

})();
