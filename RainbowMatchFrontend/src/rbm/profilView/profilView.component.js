(function() {

    function ProfilViewController (HttpService){
        var vm = this;
        var profilRepassword = "";
        var repassword = false;
        vm.userName = "User";
        vm.nbg;
        HttpService.get(RainbowMatch.baseUrl + "api/profile/nbgender/all", function(dat) {
          if(dat.status === 200) {
            vm.nbg = dat.data;
          } else {
            vm.nbg = ["error"];
          }
        });


        vm.sor = [];
        HttpService.get(RainbowMatch.baseUrl + "api/profile/sorientation/all", function(dat) {
          if(dat.status === 200) {
            vm.sor = dat.data;
          } else {
            vm.sor = ["error"];
          }
        });

        vm.profil = {
            password : "",
            place : "hier",
            birthday : undefined,
            gender : 50,
            nonBinaryGender : false,
            nonBinaryGenderId : -1,
            sexualOrientationId : undefined,
            color : ""
        };
        vm.repassword = function(){
            repassword = vm.profil.password === vm.profilRepassword;
        }
        vm.save = function(){
            HttpService.post(RainbowMatch.baseUrl + "api/profile/update", {
              birthday : vm.profil.birthday,
              gender : vm.profil.gender /100,
              nonBinaryGender : vm.profil.nonBinaryGender,
              nonBinaryGenderId : vm.profil.nonBinaryGenderId,
              //sexualOrientationId : vm.profil.sexuality,
              //color : vm.profil.color,
              biography : "",
              profilePicture : ""

            }, function(dat){
              console.log(dat);
            });
        }
    }


    angular.module("rbm").component("profilView", {
	   templateUrl : "rbm/profilView/profilView.html",
	   controller : ProfilViewController,
	   bindings : {}
    });

})();
