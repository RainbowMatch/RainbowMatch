(function() {
    function LoginViewController (HttpService){
        var vm = this;
        vm.user = {
            userName : "",
            userPassword : ""
        };

        vm.login = function(){
            //##################################
            /*localStorage.userName = vm.user.userName;
            jQuery.mobile.navigate("#home");*/
            //##################################
            
            
            HttpService.post("http://k-keller.com:4080/Backend/api/users/login/",vm.user, function(event){

                console.log(event);
                if(event.id!=null){
                    localStorage.userName = vm.user.userName;
                    jQuery.mobile.navigate("#home");
                }
            });
        };
    }



    angular.module("rbm").component("loginView", {
        templateUrl : "rbm/loginView/loginView.html",
        controller : LoginViewController,
        bindings : {}
    });

})();