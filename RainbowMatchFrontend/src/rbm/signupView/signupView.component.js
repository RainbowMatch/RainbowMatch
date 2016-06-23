(function() {

    function SignupViewController (){
        var vm = this;
        var repassword = false;
        vm.userRepassword = "";
        vm.user = {
            userName : "",
            userPassword : ""
        }
        vm.repassword = function(){
            if(vm.user.userPassword === vm.userRepassword){
                repassword = true;
            }
        }
        vm.signup = function(){
            if(repassword){
                localStorage.username = vm.user.username;
                window.location.href = "#home";
            }else{
                alert("password not the same!");
            }
            if(repassword){
            HttpService.post("10.4.57.190:20080/backend/users/user",vm.user,  function(event){
                if(event.id==null){
                    localStorage.username = vm.user.username;
                    window.location.href = "#home";
                    return false;
                }else{
                    alert("error");
                }
                
            });
                        }else{
                alert("password not the same!");
            }
        }
        
    }


    angular.module("rbm").component("signupView", {
	   templateUrl : "rbm/signupView/signupView.html",
	   controller : SignupViewController,
	   bindings : {}
    });

})();
