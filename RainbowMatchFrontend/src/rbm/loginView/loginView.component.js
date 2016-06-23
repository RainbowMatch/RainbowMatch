(function () {

    function LoginViewController(HttpService) {
        var vm = this;
        vm.user = {
            userName : "",
            userPassword : ""
        };
        
        vm.login = function(){
            localStorage.username = vm.user.username;
            window.location.href = "#home";
            
            
            HttpService.post("10.4.57.190:20080/backend/users/login",vm.user,  function(event){
                if(event.id==null){
                    localStorage.username = vm.user.username;
                     window.location.href = "#home";
                    return false;
                }else{
                    alert("error");
                }
                
            });
        }
        
    }
    


    angular.module("rbm").component("loginView", {
	   templateUrl : "rbm/loginView/loginView.html",
	   controller : LoginViewController,
	   bindings : {}
    });

})();
