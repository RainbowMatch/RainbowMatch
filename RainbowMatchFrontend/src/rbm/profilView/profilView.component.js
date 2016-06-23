(function() {

    function ProfilViewController (){
        var vm = this;
        var profilRepassword = "";
        var repassword = false;
        vm.userName = "User";
        vm.profil = {
            password : "",
            place : "hier",
            birthday : undefined,
            gender : 50,
            binary : false,
            sexuality : undefined,
            color : ""
        };
        vm.repassword = function(){
            repassword = vm.profil.password === vm.profilRepassword;
        }
        vm.save = function(){
            //TODO Backend conn
        }
    }


    angular.module("rbm").component("profilView", {
	   templateUrl : "rbm/profilView/profilView.html",
	   controller : ProfilViewController,
	   bindings : {}
    });

})();
