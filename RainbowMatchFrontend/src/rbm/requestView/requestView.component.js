(function() {

    function RequestViewController (){
        var vm = this;
        
        vm.requestedUsers = function(){
            //TODO getusers from backend
            //wenn kei verbindig möglich, denn vom lokalstorage lade
            
            //DUMMY
            return [{
                userName : "Noah",
                profilePicture : "C:\Users\Noah Siegrist\Documents\GitHub\RainbowMatchFrontend\RainbowMatchFrontend\doc\storyboard.png",
                accept : function(){
                    //todo request profile
                    HttpService.get(string.concat(RainbowMatch.baseUrl, "/backend/api/match/requests/"), function(event){
                        return event;
                
                    });
                },
                delete : function(){
                    //todo request profile
                    HttpService.get(string.concat(RainbowMatch.baseUrl, "/backend/users/user"), function(event){
                        return event;
                
                    });
                }
                }];
        };
        
        
         vm.aptrovedUsers =  function(){
            //TODO getusers from backend
            //wenn kei verbindig möglich, denn vom lokalstorage lade
            //DUMMY
            return [{
                userName : "Noah",
                profilePicture : "C:\Users\Noah Siegrist\Documents\GitHub\RainbowMatchFrontend\RainbowMatchFrontend\doc\storyboard.png",
                request : function(){
                    //todo request profile
                    localStorage.viewedUser = "Noah";
                    jQuery.mobile.navigate("#approved");
                }
                
                }];
        };
    }


    angular.module("rbm").component("requestView", {
	   templateUrl : "rbm/requestView/requestView.html",
	   controller : RequestViewController,
	   bindings : {}
    });

})();
