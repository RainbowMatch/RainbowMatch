(function() {

    function AprovedViewController (){
        var vm = this;

        vm.userName = "User";
        vm.users = ["Peter", "Patrick", "Zoe"];
        vm.loadaproved = function() {
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
        
    }


    angular.module("rbm").component("aprovedView", {
	   templateUrl : "rbm/aprovedView/aprovedView.html",
	   controller : AprovedViewController,
	   bindings : {}
    });

})();
